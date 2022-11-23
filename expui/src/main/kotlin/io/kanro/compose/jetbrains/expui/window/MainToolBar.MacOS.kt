package io.kanro.compose.jetbrains.expui.window

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import io.kanro.compose.jetbrains.expui.control.LocalContentActivated
import io.kanro.compose.jetbrains.expui.style.areaBackground

@Composable
internal fun FrameWindowScope.MainToolBarOnMacOS(
    title: String,
    showTitle: Boolean,
    isFullScreen: Boolean,
    colors: MainToolBarColors = LocalMainToolBarColors.current,
    content: (@Composable MainToolBarScope.() -> Unit)?,
) {
    colors.provideArea(LocalContentActivated.current) {
        Layout(
            content = {
                with(MainToolBarScopeInstance) {
                    if (isFullScreen) {
                        Spacer(Modifier.width(80.dp).mainToolBarItem(Alignment.Start, true))
                    }
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
