package io.kanro.compose.jetbrains.expui.window

import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.platform.InspectorInfo
import androidx.compose.ui.platform.InspectorValueInfo
import androidx.compose.ui.platform.NoInspectorInfo
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.offset
import io.kanro.compose.jetbrains.expui.control.ActionButtonColors
import io.kanro.compose.jetbrains.expui.control.Label
import io.kanro.compose.jetbrains.expui.control.LocalActionButtonColors
import io.kanro.compose.jetbrains.expui.style.AreaColors
import io.kanro.compose.jetbrains.expui.style.AreaProvider
import io.kanro.compose.jetbrains.expui.style.InactiveAreaProvider
import io.kanro.compose.jetbrains.expui.style.LocalAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalInactiveAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalNormalAreaColors
import io.kanro.compose.jetbrains.expui.theme.LightTheme
import io.kanro.compose.jetbrains.expui.theme.LocalIsDarkTheme
import io.kanro.compose.jetbrains.expui.util.CustomWindowDecorationAccessing
import java.awt.Rectangle
import java.awt.Shape
import java.awt.Window
import kotlin.math.max

data class MainToolBarColors(
    val isDark: Boolean,
    override val normalAreaColors: AreaColors,
    override val inactiveAreaColors: AreaColors,
    val actionButtonColors: ActionButtonColors,
) : AreaProvider, InactiveAreaProvider {
    @Composable
    fun provideArea(isActive: Boolean, content: @Composable () -> Unit) {
        val currentColors = if (isActive) normalAreaColors else inactiveAreaColors
        CompositionLocalProvider(
            LocalAreaColors provides currentColors,
            LocalNormalAreaColors provides normalAreaColors,
            LocalInactiveAreaColors provides inactiveAreaColors,
            LocalActionButtonColors provides actionButtonColors,
            LocalIsDarkTheme provides isDark,
            content = content
        )
    }
}

val LocalMainToolBarColors = compositionLocalOf {
    LightTheme.MainToolBarColors
}

@LayoutScopeMarker
@Immutable
interface MainToolBarScope {
    @Stable
    fun Modifier.mainToolBarItem(
        alignment: Alignment.Horizontal,
        draggableArea: Boolean = false,
    ): Modifier
}

internal object MainToolBarScopeInstance : MainToolBarScope {
    override fun Modifier.mainToolBarItem(alignment: Alignment.Horizontal, draggableArea: Boolean): Modifier {
        return this.then(
            MainToolBarChildData(
                horizontalAlignment = alignment,
                draggableArea = draggableArea,
                inspectorInfo = debugInspectorInfo {
                    name = "mainToolBarItem"
                    properties["alignment"] = alignment
                    properties["draggableArea"] = draggableArea
                }
            )
        )
    }
}

internal class MainToolBarChildData(
    var horizontalAlignment: Alignment.Horizontal,
    var draggableArea: Boolean,
    inspectorInfo: InspectorInfo.() -> Unit = NoInspectorInfo,
) : ParentDataModifier, InspectorValueInfo(inspectorInfo) {
    override fun Density.modifyParentData(parentData: Any?): Any {
        return this@MainToolBarChildData
    }

    fun spotRule(): Int {
        return if (draggableArea) 0 else 1
    }
}

internal class MainToolBarMeasurePolicy(private val window: Window) : MeasurePolicy {
    override fun MeasureScope.measure(measurables: List<Measurable>, constraints: Constraints): MeasureResult {
        if (measurables.isEmpty()) {
            return layout(
                constraints.minWidth, constraints.minHeight
            ) {
                CustomWindowDecorationAccessing.setCustomDecorationEnabled(window, true)
                CustomWindowDecorationAccessing.setCustomDecorationTitleBarHeight(
                    window,
                    constraints.minHeight.toDp().value.toInt()
                )
            }
        }

        var occupiedSpaceHorizontally = 0
        var maxSpaceVertically = constraints.minHeight
        val contentConstraints = constraints.copy(minWidth = 0, minHeight = 0)
        val measuredPlaceable = mutableListOf<Pair<Measurable, Placeable>>()

        for (it in measurables) {
            val placeable = it.measure(contentConstraints.offset(horizontal = -occupiedSpaceHorizontally))
            if (constraints.maxWidth < occupiedSpaceHorizontally + placeable.width) {
                break
            }
            occupiedSpaceHorizontally += placeable.width
            maxSpaceVertically = max(maxSpaceVertically, placeable.height)
            measuredPlaceable += it to placeable
        }

        val boxWidth = maxOf(constraints.minWidth, occupiedSpaceHorizontally)
        val boxHeight = maxSpaceVertically

        return layout(boxWidth, boxHeight) {
            val placeableGroups = measuredPlaceable.groupBy { (measurable, _) ->
                (measurable.parentData as? MainToolBarChildData)?.horizontalAlignment ?: Alignment.CenterHorizontally
            }
            val spots = mutableMapOf<Shape, Int>()

            var headUsedSpace = 0
            var trailerUsedSpace = 0

            placeableGroups[Alignment.Start]?.forEach { (measurable, placeable) ->
                val spotRule = (measurable.parentData as? MainToolBarChildData)?.spotRule() ?: 1
                val x = headUsedSpace
                val y = Alignment.CenterVertically.align(placeable.height, boxHeight)
                placeable.placeRelative(x, y)
                headUsedSpace += placeable.width
                spots[PxToDpRectangle(x, y, placeable.width, placeable.height)] = spotRule
            }
            placeableGroups[Alignment.End]?.forEach { (measurable, placeable) ->
                val spotRule = (measurable.parentData as? MainToolBarChildData)?.spotRule() ?: 1
                val x = boxWidth - placeable.width - trailerUsedSpace
                val y = Alignment.CenterVertically.align(placeable.height, boxHeight)
                placeable.placeRelative(x, y)
                trailerUsedSpace += placeable.width
                spots[PxToDpRectangle(x, y, placeable.width, placeable.height)] = spotRule
            }

            val centerPlaceable = placeableGroups[Alignment.CenterHorizontally] ?: listOf()

            val requiredCenterSpace = centerPlaceable.sumOf { it.second.width }
            val minX = headUsedSpace
            val maxX = boxWidth - trailerUsedSpace - requiredCenterSpace
            var centerX = (boxWidth - requiredCenterSpace) / 2

            if (minX <= maxX) {
                if (centerX > maxX) {
                    centerX = maxX
                }
                if (centerX < minX) {
                    centerX = minX
                }

                centerPlaceable.forEach { (measurable, placeable) ->
                    val spotRule = (measurable.parentData as? MainToolBarChildData)?.spotRule() ?: 1
                    val x = centerX
                    val y = Alignment.CenterVertically.align(placeable.height, boxHeight)
                    placeable.placeRelative(x, y)
                    centerX += placeable.width
                    spots[PxToDpRectangle(x, y, placeable.width, placeable.height)] = spotRule
                }
            }

            CustomWindowDecorationAccessing.setCustomDecorationEnabled(window, true)
            CustomWindowDecorationAccessing.setCustomDecorationTitleBarHeight(window, boxHeight.toDp().value.toInt())
            CustomWindowDecorationAccessing.setCustomDecorationHitTestSpotsMethod(window, spots)
        }
    }
}

internal fun Density.PxToDpRectangle(x: Int, y: Int, width: Int, height: Int): Rectangle {
    return Rectangle(
        x.toDp().value.toInt(), y.toDp().value.toInt(), width.toDp().value.toInt(), height.toDp().value.toInt()
    )
}

@Composable
internal fun rememberMainToolBarMeasurePolicy(window: Window): MeasurePolicy {
    return remember(window) { MainToolBarMeasurePolicy(window) }
}

@Composable
fun MainToolBarScope.MainToolBarTitle(title: String) {
    Label(title, Modifier.mainToolBarItem(Alignment.CenterHorizontally, true), maxLines = 1)
}
