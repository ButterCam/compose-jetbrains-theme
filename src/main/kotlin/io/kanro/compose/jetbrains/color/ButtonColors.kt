package io.kanro.compose.jetbrains.color

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import io.kanro.compose.jetbrains.JBTheme

class ButtonColors(
    bg: Color,
    border: Color,
    borderRegularFocused: Color,
    defaultStart: Color,
    defaultEnd: Color,
    borderDefaultStart: Color,
    borderDefaultEnd: Color,
    borderDefaultFocused: Color,
    bgDisabled: Color,
    borderDisabled: Color,
) {
    var bg by mutableStateOf(bg)
    var border by mutableStateOf(border)
    var borderRegularFocused by mutableStateOf(borderRegularFocused)
    var defaultStart by mutableStateOf(defaultStart)
    var defaultEnd by mutableStateOf(defaultEnd)
    var borderDefaultStart by mutableStateOf(borderDefaultStart)
    var borderDefaultEnd by mutableStateOf(borderDefaultEnd)
    var borderDefaultFocused by mutableStateOf(borderDefaultFocused)
    var bgDisabled by mutableStateOf(bgDisabled)
    var borderDisabled by mutableStateOf(borderDisabled)

    fun copy(
        bg: Color = this.bg,
        border: Color = this.border,
        borderRegularFocused: Color = this.borderRegularFocused,
        defaultStart: Color = this.defaultStart,
        defaultEnd: Color = this.defaultEnd,
        borderDefaultStart: Color = this.borderDefaultStart,
        borderDefaultEnd: Color = this.borderDefaultEnd,
        borderDefaultFocused: Color = this.borderDefaultFocused,
        disabled: Color = this.bgDisabled,
        borderDisabled: Color = this.borderDisabled,
    ): ButtonColors {
        return ButtonColors(
            bg,
            border,
            borderRegularFocused,
            defaultStart,
            defaultEnd,
            borderDefaultStart,
            borderDefaultEnd,
            borderDefaultFocused,
            disabled,
            borderDisabled
        )
    }

    @Composable
    private fun bgStartColor(enable: Boolean, default: Boolean): State<Color> {
        val targetValue = when {
            !enable -> bgDisabled
            default -> defaultStart
            else -> bg
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    private fun bgEndColor(enable: Boolean, default: Boolean): State<Color> {
        val targetValue = when {
            !enable -> bgDisabled
            default -> defaultStart
            else -> bg
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    fun bgBrush(enable: Boolean, default: Boolean): State<Brush> {
        val start by bgStartColor(enable, default)
        val end by bgEndColor(enable, default)
        val targetValue = if (start == end) {
            SolidColor(start)
        } else {
            Brush.linearGradient(listOf(start, end))
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    private fun borderStartColor(enable: Boolean, default: Boolean, focused: Boolean): State<Color> {
        val targetValue = when {
            !enable -> borderDisabled
            default && focused -> borderDefaultFocused
            default -> borderDefaultStart
            focused -> borderRegularFocused
            else -> border
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    private fun borderEndColor(enable: Boolean, default: Boolean, focused: Boolean): State<Color> {
        val targetValue = when {
            !enable -> borderDisabled
            default && focused -> borderDefaultFocused
            default -> borderDefaultEnd
            focused -> borderRegularFocused
            else -> border
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    fun borderBrush(enable: Boolean, default: Boolean, interactionSource: InteractionSource): State<Brush> {
        val focused by interactionSource.collectIsFocusedAsState()
        val start by borderStartColor(enable, default, focused)
        val end by borderEndColor(enable, default, focused)
        val targetValue = if (start == end) {
            SolidColor(start)
        } else {
            Brush.linearGradient(listOf(start, end))
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    fun textColor(enable: Boolean, default: Boolean): State<Color> {
        val start by bgStartColor(enable, default)
        val targetValue = if ((start.green + start.blue + start.red) / 3.0 > 0.6) {
            JBTheme.textColors.default
        } else {
            JBTheme.textColors.white
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    fun focusingColor(enable: Boolean, interactionSource: InteractionSource): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()
        val targetValue = when {
            !enable -> Color.Transparent
            focused -> JBTheme.focusColors.default
            else -> Color.Transparent
        }
        return rememberUpdatedState(targetValue)
    }
}

fun lightButtonColors(): ButtonColors {
    return ButtonColors(
        Color.White,
        Color(0xFFC4C4C4),
        Color(0xFF87AFDA),
        Color(0xFF528CC7), Color(0xFF4989CC),
        Color(0xFF487EB8), Color(0xFF346DAD),
        Color(0xFFA8CEF6),
        Color(0xFFF2F2F2),
        Color(0xFFCFCFCF),
    )
}

fun darkButtonColors(): ButtonColors {
    return ButtonColors(
        Color(0xFF4C5052),
        Color(0xFF5E6060),
        Color(0xFF456A90),
        Color(0xFF365880), Color(0xFF365880),
        Color(0xFF4C708C), Color(0xFF4C708C),
        Color(0xFF537699),
        Color(0xFF3C3F41),
        Color(0xFF646464),
    )
}

val LocalButtonColors = staticCompositionLocalOf { lightButtonColors() }
