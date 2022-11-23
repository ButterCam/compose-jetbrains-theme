package io.kanro.compose.jetbrains.expui.window

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.rememberWindowState
import io.kanro.compose.jetbrains.expui.DesktopPlatform
import io.kanro.compose.jetbrains.expui.theme.LightTheme
import io.kanro.compose.jetbrains.expui.theme.Theme
import javax.swing.JFrame

val LocalWindow = compositionLocalOf<JFrame> {
    error("CompositionLocal LocalWindow not provided")
}

@Composable
fun JBWindow(
    onCloseRequest: () -> Unit,
    state: WindowState = rememberWindowState(),
    visible: Boolean = true,
    title: String = "",
    showTitle: Boolean = true,
    theme: Theme = LightTheme,
    icon: Painter? = painterResource("icons/compose.svg"),
    resizable: Boolean = true,
    enabled: Boolean = true,
    focusable: Boolean = true,
    alwaysOnTop: Boolean = false,
    onPreviewKeyEvent: (KeyEvent) -> Boolean = { false },
    onKeyEvent: (KeyEvent) -> Boolean = { false },
    mainToolBar: (@Composable MainToolBarScope.() -> Unit)? = null,
    content: @Composable FrameWindowScope.() -> Unit,
) {
    when (DesktopPlatform.Current) {
        DesktopPlatform.Linux -> JBWindowOnLinux(
            onCloseRequest,
            state,
            visible,
            title,
            theme,
            resizable,
            enabled,
            focusable,
            alwaysOnTop,
            onPreviewKeyEvent,
            onKeyEvent,
            mainToolBar,
            content
        )

        DesktopPlatform.Windows -> JBWindowOnWindows(
            onCloseRequest,
            state,
            visible,
            title,
            showTitle,
            theme,
            icon,
            resizable,
            enabled,
            focusable,
            alwaysOnTop,
            onPreviewKeyEvent,
            onKeyEvent,
            mainToolBar,
            content
        )

        DesktopPlatform.MacOS -> JBWindowOnMacOS(
            onCloseRequest,
            state,
            visible,
            title,
            showTitle,
            theme,
            resizable,
            enabled,
            focusable,
            alwaysOnTop,
            onPreviewKeyEvent,
            onKeyEvent,
            mainToolBar,
            content
        )

        DesktopPlatform.Unknown -> TODO()
    }
}
