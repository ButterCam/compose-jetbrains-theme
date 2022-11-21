package io.kanro.compose.jetbrains.expui.window

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.expui.control.Label
import io.kanro.compose.jetbrains.expui.control.LocalContentActivated
import io.kanro.compose.jetbrains.expui.style.areaBackground
import kotlin.math.max

@Composable
internal fun MainToolBarOnMacOS(
    title: String,
    isFullScreen: Boolean,
    colors: MainToolBarColors = LocalMainToolBarColors.current,
    content: (@Composable MainToolBarScope.() -> Unit)?,
) {
    colors.provideArea(LocalContentActivated.current) {
        Layout(
            content = {
                content?.invoke(MainToolBarScopeInstance) ?: MainToolBarScopeInstance.MainToolBarTitleOnMacOS(
                    title
                )
            }, modifier = Modifier.fillMaxWidth().height(40.dp).areaBackground(), measurePolicy = if (isFullScreen) {
                MacOSFullscreenMainToolBarMeasurePolicy
            } else {
                MacOSDefaultMainToolBarMeasurePolicy
            }
        )
    }
}

@Composable
internal fun MainToolBarScope.MainToolBarTitleOnMacOS(title: String) {
    Label(
        title, Modifier.horizontalAlignment(Alignment.CenterHorizontally)
    )
}

class MacOSMainToolBarMeasurePolicy(private val windowButtonsWidth: Dp) : MeasurePolicy {
    override fun MeasureScope.measure(measurables: List<Measurable>, constraints: Constraints): MeasureResult {
        if (measurables.isEmpty()) {
            return layout(
                constraints.minWidth, constraints.minHeight
            ) {}
        }

        val contentConstraints = constraints.copy(minWidth = 0, minHeight = 0)
        val placeables = arrayOfNulls<Placeable>(measurables.size)
        var boxWidth = constraints.minWidth
        var boxHeight = constraints.minHeight
        measurables.forEachIndexed { index, measurable ->
            val placeable = measurable.measure(contentConstraints)
            placeables[index] = placeable
            boxWidth = max(boxWidth, placeable.width)
            boxHeight = max(boxHeight, placeable.height)
        }

        return layout(boxWidth, boxHeight) {
            measurables.forEachIndexed { index, measurable ->
                placeInMainToolBar(
                    placeables[index], measurable, layoutDirection, boxWidth, boxHeight, windowButtonsWidth.roundToPx()
                )
            }
        }
    }
}

internal val MacOSFullscreenMainToolBarMeasurePolicy: MeasurePolicy = MacOSMainToolBarMeasurePolicy(0.dp)

internal val MacOSDefaultMainToolBarMeasurePolicy: MeasurePolicy = MacOSMainToolBarMeasurePolicy(80.dp)

private fun Placeable.PlacementScope.placeInMainToolBar(
    placeable: Placeable?,
    measurable: Measurable,
    layoutDirection: LayoutDirection,
    boxWidth: Int,
    boxHeight: Int,
    windowButtonsWidth: Int,
) {
    placeable ?: return
    when (val childAlignment = measurable.horizontalAlignment) {
        Alignment.Start -> {
            val x = childAlignment.align(
                placeable.width, boxWidth - windowButtonsWidth, layoutDirection
            ) + windowButtonsWidth
            val y = Alignment.CenterVertically.align(placeable.height, boxHeight)
            placeable.place(x, y)
        }

        else -> {
            val x = childAlignment.align(
                placeable.width, boxWidth, layoutDirection
            )
            val y = Alignment.CenterVertically.align(placeable.height, boxHeight)
            placeable.place(x, y)
        }
    }
}

private val Measurable.mainToolBarChildData: MainToolBarChildData?
    get() = parentData as? MainToolBarChildData
private val Measurable.horizontalAlignment: Alignment.Horizontal
    get() = mainToolBarChildData?.horizontalAlignment ?: Alignment.CenterHorizontally
