package io.kanro.compose.jetbrains.expui.window

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.expui.control.Label
import io.kanro.compose.jetbrains.expui.control.LocalContentActivated
import io.kanro.compose.jetbrains.expui.style.areaBackground

@Composable
internal fun MainToolBarOnMacOS(
    title: String,
    isFullScreen: Boolean,
    colors: MainToolBarColors = LocalMainToolBarColors.current,
    content: (@Composable BoxScope.(Boolean) -> Unit)?,
) {
    colors.provideArea(LocalContentActivated.current) {
        Box(Modifier.fillMaxWidth().height(40.dp).areaBackground()) {
            Box(Modifier.fillMaxSize().composed {
                if (isFullScreen) {
                    this
                } else {
                    this.padding(start = 80.dp)
                }
            }) {
                content?.invoke(this, isFullScreen) ?: MainToolBarTitleOnMacOS(title, isFullScreen)
            }
        }
    }
}

@Composable
internal fun BoxScope.MainToolBarTitleOnMacOS(title: String, isFullScreen: Boolean) {
    Label(title, Modifier.align(Alignment.Center).composed {
        if (isFullScreen) {
            this
        } else {
            this.offset(x = (-40).dp)
        }
    })
}