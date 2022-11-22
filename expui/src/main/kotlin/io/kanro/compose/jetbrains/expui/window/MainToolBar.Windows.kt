package io.kanro.compose.jetbrains.expui.window

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import io.kanro.compose.jetbrains.expui.control.ActionButton
import io.kanro.compose.jetbrains.expui.control.Icon
import io.kanro.compose.jetbrains.expui.control.LocalActionButtonColors
import io.kanro.compose.jetbrains.expui.control.LocalContentActivated
import io.kanro.compose.jetbrains.expui.style.areaBackground
import io.kanro.compose.jetbrains.expui.theme.LightTheme

@Composable
internal fun FrameWindowScope.MainToolBarOnWindows(
    icon: Painter?,
    windowState: WindowState,
    onCloseRequest: () -> Unit,
    title: String,
    showTitle: Boolean,
    colors: MainToolBarColors = LocalMainToolBarColors.current,
    content: (@Composable MainToolBarScope.() -> Unit)?,
) {
    colors.provideArea(LocalContentActivated.current) {
        Layout(
            content = {
                with(MainToolBarScopeInstance) {
                    if (icon != null) {
                        Box(
                            modifier = Modifier.size(40.dp).mainToolBarItem(Alignment.Start, true),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(icon)
                        }
                    }
                    WindowsSystemButtons(windowState, onCloseRequest)
                    if (showTitle) {
                        MainToolBarTitle(title)
                    }
                    content?.invoke(this)
                }
            },
            modifier = Modifier.fillMaxWidth().height(40.dp).areaBackground(),
            measurePolicy = rememberMainToolBarMeasurePolicy(window)
        )
    }
}

val LocalWindowsCloseWindowButtonColors = compositionLocalOf {
    LightTheme.WindowsCloseWindowButtonColors
}

@Composable
private fun MainToolBarScope.WindowsSystemButtons(windowState: WindowState, onCloseRequest: () -> Unit) {
    val active = LocalContentActivated.current
    CompositionLocalProvider(
        LocalActionButtonColors provides LocalWindowsCloseWindowButtonColors.current
    ) {
        ActionButton(
            { onCloseRequest() },
            Modifier.focusProperties { canFocus = false }.size(40.dp).mainToolBarItem(Alignment.End),
            shape = RectangleShape
        ) {
            if (active) {
                Icon("icons/windows/closeActive.svg")
            } else {
                Icon("icons/windows/closeInactive.svg")
            }
        }
    }
    ActionButton(
        {
            windowState.placement = when (windowState.placement) {
                WindowPlacement.Floating -> WindowPlacement.Maximized
                WindowPlacement.Maximized -> WindowPlacement.Floating
                WindowPlacement.Fullscreen -> WindowPlacement.Fullscreen
            }
        },
        Modifier.focusProperties { canFocus = false }.size(40.dp).mainToolBarItem(Alignment.End),
        shape = RectangleShape
    ) {
        if (windowState.placement == WindowPlacement.Floating) {
            if (active) {
                Icon("icons/windows/maximize.svg")
            } else {
                Icon("icons/windows/maximizeInactive.svg")
            }
        } else {
            if (active) {
                Icon("icons/windows/restore.svg")
            } else {
                Icon("icons/windows/restoreInactive.svg")
            }
        }
    }
    ActionButton(
        { windowState.isMinimized = true },
        Modifier.focusProperties { canFocus = false }.size(40.dp).mainToolBarItem(Alignment.End),
        shape = RectangleShape
    ) {
        if (active) {
            Icon("icons/windows/minimize.svg")
        } else {
            Icon("icons/windows/minimizeInactive.svg")
        }
    }
}
