package io.kanro.compose.jetbrains.expui.window

import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.platform.InspectorInfo
import androidx.compose.ui.platform.InspectorValueInfo
import androidx.compose.ui.platform.NoInspectorInfo
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Density
import io.kanro.compose.jetbrains.expui.control.ActionButtonColors
import io.kanro.compose.jetbrains.expui.control.LocalActionButtonColors
import io.kanro.compose.jetbrains.expui.style.AreaColors
import io.kanro.compose.jetbrains.expui.style.AreaProvider
import io.kanro.compose.jetbrains.expui.style.InactiveAreaProvider
import io.kanro.compose.jetbrains.expui.style.LocalAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalInactiveAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalNormalAreaColors
import io.kanro.compose.jetbrains.expui.theme.LightTheme
import io.kanro.compose.jetbrains.expui.theme.LocalIsDarkTheme

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
    fun Modifier.horizontalAlignment(alignment: Alignment.Horizontal): Modifier
}

internal object MainToolBarScopeInstance : MainToolBarScope {
    override fun Modifier.horizontalAlignment(horizontalAlignment: Alignment.Horizontal): Modifier {
        return this.then(
            MainToolBarChildData(
                horizontalAlignment = horizontalAlignment,
                inspectorInfo = debugInspectorInfo {
                    name = "horizontalAlignment"
                    value = horizontalAlignment
                })
        )
    }
}

internal class MainToolBarChildData(
    var horizontalAlignment: Alignment.Horizontal,
    inspectorInfo: InspectorInfo.() -> Unit = NoInspectorInfo,
) : ParentDataModifier, InspectorValueInfo(inspectorInfo) {
    override fun Density.modifyParentData(parentData: Any?): Any {
        return this@MainToolBarChildData
    }
}