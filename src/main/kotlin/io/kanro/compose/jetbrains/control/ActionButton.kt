package io.kanro.compose.jetbrains.control

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.JBTheme
import io.kanro.compose.jetbrains.interaction.collectIsHoverAsState
import io.kanro.compose.jetbrains.interaction.hoverable

object ActionButtonIndication : Indication {
    private class ActionButtonIndicationInstance(
        private val shape: Shape,
        private val isHover: State<Boolean>,
        private val isPressed: State<Boolean>,
        private val hoverColor: Color,
        private val pressedColor: Color,
    ) : IndicationInstance {
        override fun ContentDrawScope.drawIndication() {
            when {
                isPressed.value -> {
                    val outline = shape.createOutline(size, layoutDirection, this)
                    drawOutline(outline, pressedColor)
                }
                isHover.value -> {
                    val outline = shape.createOutline(size, layoutDirection, this)
                    drawOutline(outline, hoverColor)
                }
            }
            drawContent()
        }
    }

    @Composable
    override fun rememberUpdatedInstance(interactionSource: InteractionSource): IndicationInstance {
        val shape = remember { RoundedCornerShape(3.dp) }
        val isPressed = interactionSource.collectIsPressedAsState()
        val isHover = interactionSource.collectIsHoverAsState()
        val hoverColor = JBTheme.toolBarColors.buttonHover
        val pressedColor = JBTheme.toolBarColors.buttonPressed
        return remember(interactionSource) {
            ActionButtonIndicationInstance(
                shape,
                isHover,
                isPressed,
                hoverColor,
                pressedColor
            )
        }
    }
}

object ActionButtonDefaults {
    private val ButtonHorizontalPadding = 3.dp
    private val ButtonVerticalPadding = 3.dp

    val MinWidth = 22.dp

    val MinHeight = 22.dp

    val IconSize = 16.dp

    val ContentPadding = PaddingValues(
        start = ButtonHorizontalPadding,
        top = ButtonVerticalPadding,
        end = ButtonHorizontalPadding,
        bottom = ButtonVerticalPadding
    )
}

@Composable
fun ActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    background: Color = Color.Transparent,
    indication: Indication? = ActionButtonIndication,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(3.dp),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ActionButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    Box(
        modifier
            .then(if (border != null) Modifier.border(border, shape) else Modifier)
            .background(
                color = background,
                shape = shape
            )
            .clip(shape)
            .clickable(
                interactionSource = interactionSource,
                indication = indication,
                enabled = enabled,
                onClick = onClick
            )
            .hoverable(rememberCoroutineScope(), interactionSource, enabled),
        propagateMinConstraints = true
    ) {
        CompositionLocalProvider(
            LocalContentColor provides (if (!enabled) JBTheme.iconColors.disabled else LocalContentColor.current)
        ) {
            Row(
                Modifier
                    .defaultMinSize(
                        minWidth = ActionButtonDefaults.MinWidth,
                        minHeight = ActionButtonDefaults.MinHeight
                    )
                    .padding(contentPadding),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                content = content
            )
        }
    }
}
