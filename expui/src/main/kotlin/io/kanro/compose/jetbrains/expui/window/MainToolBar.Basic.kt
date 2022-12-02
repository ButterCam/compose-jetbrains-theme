package io.kanro.compose.jetbrains.expui.window

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import io.kanro.compose.jetbrains.expui.control.LocalContentActivated
import io.kanro.compose.jetbrains.expui.style.areaBackground

@Composable
fun FrameWindowScope.BasicMainToolBar(
    colors: MainToolBarColors = LocalMainToolBarColors.current,
    content: (@Composable MainToolBarScope.() -> Unit)?,
) {
    colors.provideArea(LocalContentActivated.current) {
        Layout(
            content = {
                with(MainToolBarScopeInstance) {
                    content?.invoke(this)
                }
            },
            modifier = Modifier.fillMaxWidth().height(40.dp).areaBackground(),
            measurePolicy = rememberMainToolBarMeasurePolicy(window)
        )
    }
}