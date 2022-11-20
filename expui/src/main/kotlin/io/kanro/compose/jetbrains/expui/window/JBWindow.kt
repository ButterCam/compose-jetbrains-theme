package io.kanro.compose.jetbrains.expui.window

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.KeyEvent
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
    theme: Theme = LightTheme,
    icon: Painter? = null,
    resizable: Boolean = true,
    enabled: Boolean = true,
    focusable: Boolean = true,
    alwaysOnTop: Boolean = false,
    onPreviewKeyEvent: (KeyEvent) -> Boolean = { false },
    onKeyEvent: (KeyEvent) -> Boolean = { false },
    mainToolBar: (@Composable BoxScope.(Boolean) -> Unit)? = null,
    content: @Composable FrameWindowScope.() -> Unit,
) {
    when (DesktopPlatform.Current) {
        DesktopPlatform.Linux -> TODO()
        DesktopPlatform.Windows -> TODO()
        DesktopPlatform.MacOS -> JBWindowOnMacOS(
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

        DesktopPlatform.Unknown -> TODO()
    }
}
