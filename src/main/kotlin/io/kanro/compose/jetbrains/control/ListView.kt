package io.kanro.compose.jetbrains.control

import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import io.kanro.compose.jetbrains.JBTheme
import io.kanro.compose.jetbrains.interaction.collectIsHoverAsState

object ListItemHoverIndication : Indication {
    private class CallIndicationInstance(
        private val isHover: State<Boolean>,
        private val hoverColor: Color,
    ) : IndicationInstance {
        override fun ContentDrawScope.drawIndication() {
            when {
                isHover.value -> {
                    drawRect(hoverColor, size = size)
                }
            }
            drawContent()
        }
    }

    @Composable
    override fun rememberUpdatedInstance(interactionSource: InteractionSource): IndicationInstance {
        val isHover = interactionSource.collectIsHoverAsState()
        val hoverColor = JBTheme.selectionColors.hover
        return remember(interactionSource) {
            CallIndicationInstance(
                isHover,
                hoverColor,
            )
        }
    }
}
