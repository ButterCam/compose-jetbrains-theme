package io.kanro.compose.jetbrains.expui.window

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.FrameWindowScope

@Composable
internal fun FrameWindowScope.MainToolBarOnLinux(
    colors: MainToolBarColors = LocalMainToolBarColors.current,
    content: (@Composable MainToolBarScope.() -> Unit)?,
) {
    BasicMainToolBar(colors, content)
}