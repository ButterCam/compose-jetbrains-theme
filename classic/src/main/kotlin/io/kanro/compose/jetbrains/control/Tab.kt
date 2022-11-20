package io.kanro.compose.jetbrains.control

import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.JBTheme

object TabIndication : Indication {
    private class TabIndicationInstance(
        private val isHover: State<Boolean>,
        private val hoverColor: Color,
    ) : IndicationInstance {
        override fun ContentDrawScope.drawIndication() {
            if (isHover.value) {
                drawRect(hoverColor, Offset.Zero, size)
            }
            drawContent()
        }
    }

    @Composable
    override fun rememberUpdatedInstance(interactionSource: InteractionSource): IndicationInstance {
        val isHover = interactionSource.collectIsHoveredAsState()
        val hoverColor = JBTheme.tabColors.hover

        return remember(JBTheme.tabColors, interactionSource) {
            TabIndicationInstance(
                isHover,
                hoverColor,
            )
        }
    }
}

@Composable
fun Tab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable BoxScope.() -> Unit
) {
    val selectionColor = JBTheme.tabColors.selection
    Box(
        modifier
            .hoverable(interactionSource)
            .height(28.dp)
            .run {
                if (selected) {
                    background(JBTheme.tabColors.bgSelected)
                } else {
                    this
                }
            }
            .drawWithContent {
                drawContent()
                if (selected) {
                    val height = 3.dp.toPx()
                    drawRect(
                        selectionColor,
                        Offset(0f, size.height - height),
                        Size(size.width, height)
                    )
                }
            }.selectable(
                selected = selected,
                onClick = onClick,
                enabled = enabled,
                role = Role.Tab,
                interactionSource = interactionSource,
                indication = TabIndication
            ),
        propagateMinConstraints = true,
        contentAlignment = Alignment.Center,
        content = content
    )
}
