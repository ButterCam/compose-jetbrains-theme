package io.kanro.compose.jetbrains.expui.window

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.rememberWindowState
import io.kanro.compose.jetbrains.expui.control.LocalContentActivated
import io.kanro.compose.jetbrains.expui.style.LocalAreaColors
import io.kanro.compose.jetbrains.expui.style.areaBackground
import io.kanro.compose.jetbrains.expui.theme.LightTheme
import io.kanro.compose.jetbrains.expui.theme.Theme


@Composable
internal fun JBWindowOnLinux(
    onCloseRequest: () -> Unit,
    state: WindowState = rememberWindowState(),
    visible: Boolean = true,
    title: String = "",
    showTitle: Boolean = true,
    theme: Theme = LightTheme,
    resizable: Boolean = true,
    enabled: Boolean = true,
    focusable: Boolean = true,
    alwaysOnTop: Boolean = false,
    onPreviewKeyEvent: (KeyEvent) -> Boolean = { false },
    onKeyEvent: (KeyEvent) -> Boolean = { false },
    mainToolBar: (@Composable MainToolBarScope.() -> Unit)?,
    content: @Composable FrameWindowScope.() -> Unit,
) {
    Window(
        onCloseRequest,
        state,
        visible,
        title,
        null,
        false,
        false,
        resizable,
        enabled,
        focusable,
        alwaysOnTop,
        onPreviewKeyEvent,
        onKeyEvent
    ) {
        LaunchedEffect(Unit, theme) {
            val rootPane = window.rootPane
            rootPane.putClientProperty("xawt.mwm_decor_title", false)
        }
        theme.provide {
            Column(Modifier.fillMaxSize()) {
                CompositionLocalProvider(
                    LocalWindow provides window, LocalContentActivated provides LocalWindowInfo.current.isWindowFocused
                ) {
                    val isFullscreen by rememberWindowIsFullscreen()
                    MainToolBarOnMacOS(title, showTitle, isFullscreen, content = mainToolBar)
                    Spacer(Modifier.fillMaxWidth().height(1.dp).background(LocalAreaColors.current.startBorderColor))
                    Box(Modifier.fillMaxSize().areaBackground()) {
                        content()
                    }
                }
            }
        }
    }
}