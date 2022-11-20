package io.kanro.compose.jetbrains.control

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
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
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.input.pointer.changedToDownIgnoreConsumed
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import io.kanro.compose.jetbrains.JBTheme

@Stable
interface ButtonStyle {
    @Composable
    fun borderBrush(enabled: Boolean): State<Brush>

    @Composable
    fun backgroundBrush(enabled: Boolean): State<Brush>

    @Composable
    fun contentColor(enabled: Boolean): State<Color>

    @Composable
    fun focusingColor(enabled: Boolean, interactionSource: InteractionSource): State<Color>
}

private data class DefaultButtonStyle(
    private val borderBrush: Brush,
    private val backgroundBrush: Brush,
    private val contentColor: Color,
    private val disableBorderBrush: Brush,
    private val disableBackgroundBrush: Brush,
    private val disabledContentColor: Color,
    private val focusingColor: Color
) : ButtonStyle {
    @Composable
    override fun borderBrush(enabled: Boolean): State<Brush> {
        return rememberUpdatedState(if (enabled) borderBrush else disableBorderBrush)
    }

    @Composable
    override fun backgroundBrush(enabled: Boolean): State<Brush> {
        return rememberUpdatedState(if (enabled) backgroundBrush else disableBackgroundBrush)
    }

    @Composable
    override fun contentColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) contentColor else disabledContentColor)
    }

    @Composable
    override fun focusingColor(enabled: Boolean, interactionSource: InteractionSource): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()
        return rememberUpdatedState(if (enabled && focused) focusingColor else Color.Transparent)
    }
}

object ButtonDefaults {
    private val ButtonHorizontalPadding = 14.dp
    private val ButtonVerticalPadding = 3.dp

    val ContentPadding = PaddingValues(
        start = ButtonHorizontalPadding,
        top = ButtonVerticalPadding,
        end = ButtonHorizontalPadding,
        bottom = ButtonVerticalPadding
    )

    val MinWidth = 72.dp

    val MinHeight = 24.dp

    val IconSize = 16.dp

    val IconSpacing = 8.dp

    @Composable
    fun buttonStyle(
        borderBrush: Brush = Brush.verticalGradient(
            listOf(
                JBTheme.buttonColors.borderDefaultStart,
                JBTheme.buttonColors.borderDefaultEnd
            )
        ),
        backgroundBrush: Brush = Brush.verticalGradient(
            listOf(
                JBTheme.buttonColors.defaultStart,
                JBTheme.buttonColors.defaultEnd
            )
        ),
        contentColor: Color = JBTheme.contentColorFor(JBTheme.buttonColors.defaultEnd),
        disableBorderBrush: Brush = SolidColor(JBTheme.buttonColors.borderDisabled),
        disableBackgroundBrush: Brush = SolidColor(JBTheme.buttonColors.bgDisabled),
        disabledContentColor: Color = JBTheme.textColors.disabled,
        focusingColor: Color = JBTheme.focusColors.default,
    ): ButtonStyle = DefaultButtonStyle(
        borderBrush,
        backgroundBrush,
        contentColor,
        disableBorderBrush,
        disableBackgroundBrush,
        disabledContentColor,
        focusingColor
    )

    @Composable
    fun outlineButtonStyle(
        borderBrush: Brush = SolidColor(JBTheme.buttonColors.border),
        backgroundBrush: Brush = SolidColor(JBTheme.buttonColors.bg),
        contentColor: Color = JBTheme.contentColorFor(JBTheme.buttonColors.bg),
        disableBorderBrush: Brush = SolidColor(JBTheme.buttonColors.borderDisabled),
        disableBackgroundBrush: Brush = SolidColor(JBTheme.buttonColors.bgDisabled),
        disabledContentColor: Color = JBTheme.textColors.disabled,
        focusingColor: Color = JBTheme.focusColors.default,
    ): ButtonStyle = DefaultButtonStyle(
        borderBrush,
        backgroundBrush,
        contentColor,
        disableBorderBrush,
        disableBackgroundBrush,
        disabledContentColor,
        focusingColor
    )
}

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(3.dp),
    borderWidth: Dp = 1.dp,
    style: ButtonStyle = ButtonDefaults.buttonStyle(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    val focusRequester = remember { FocusRequester() }

    Box(
        modifier
            .then(
                if (borderWidth.isSpecified) Modifier.border(
                    borderWidth,
                    style.borderBrush(enabled).value,
                    shape
                ) else Modifier
            )
            .background(
                brush = style.backgroundBrush(enabled).value,
                shape = shape
            )
            .focusRequester(focusRequester)
            .focusable(enabled, interactionSource)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = onClick
            )
            .pointerInput("Fo") {
                this.awaitPointerEventScope {
                    var event: PointerEvent
                    do {
                        event = awaitPointerEvent()
                        if (event.changes.any { it.changedToDownIgnoreConsumed() }) {
                            focusRequester.requestFocus()
                        }
                    } while (true)
                }
            }
            .buttonIndicator(style.focusingColor(enabled, interactionSource).value, shape, 2.dp, 5.dp),
        propagateMinConstraints = true
    ) {
        val contentColor by style.contentColor(enabled)
        CompositionLocalProvider(
            LocalContentAlpha provides contentColor.alpha,
            LocalContentColor provides contentColor
        ) {
            ProvideTextStyle(JBTheme.typography.defaultBold) {
                Row(
                    Modifier
                        .defaultMinSize(
                            minWidth = ButtonDefaults.MinWidth,
                            minHeight = ButtonDefaults.MinHeight
                        )
                        .padding(contentPadding),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = content
                )
            }
        }
    }
}

private fun Modifier.buttonIndicator(color: Color, shape: Shape, width: Dp, cornerRadius: Dp): Modifier {
    if (color.alpha == 0f) return this
    return drawBehind {
        val controlOutline = shape.createOutline(size, layoutDirection, this)
        val highlightOutline = RoundRect(controlOutline.bounds.inflate(width.toPx()), CornerRadius(cornerRadius.toPx()))
        val highlightPath = Path().apply {
            this.fillType = PathFillType.EvenOdd
            addRoundRect(highlightOutline)
            addOutline(controlOutline)
            close()
        }

        drawPath(highlightPath, color)
    }
}

@Composable
fun OutlineButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(3.dp),
    borderWidth: Dp = 1.dp,
    style: ButtonStyle = ButtonDefaults.outlineButtonStyle(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) = Button(onClick, modifier, enabled, interactionSource, shape, borderWidth, style, contentPadding, content)
