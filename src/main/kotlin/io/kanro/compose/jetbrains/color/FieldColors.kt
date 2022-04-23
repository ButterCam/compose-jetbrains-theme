package io.kanro.compose.jetbrains.color

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.JBTheme

class FieldColors(
    bg: Color,
    border: Color,
    borderFocused: Color,
    comboboxButton: Color,
    bgDisabled: Color,
    borderDisabled: Color,
    borderError: Color,
) {
    var bg by mutableStateOf(bg)
    var border by mutableStateOf(border)
    var borderFocused by mutableStateOf(borderFocused)
    var comboboxButton by mutableStateOf(comboboxButton)
    var bgDisabled by mutableStateOf(bgDisabled)
    var borderDisabled by mutableStateOf(borderDisabled)
    var borderError by mutableStateOf(borderError)

    fun copy(
        bg: Color = this.bg,
        border: Color = this.border,
        borderFocused: Color = this.borderFocused,
        comboboxButton: Color = this.comboboxButton,
        bgDisabled: Color = this.bgDisabled,
        borderDisabled: Color = this.borderDisabled,
        borderError: Color = this.borderError,
    ): FieldColors {
        return FieldColors(bg, border, borderFocused, comboboxButton, bgDisabled, borderDisabled, borderError)
    }

    @Composable
    fun bgColor(enable: Boolean): State<Color> {
        return rememberUpdatedState(if (enable) bg else bgDisabled)
    }

    @Composable
    fun borderColor(enable: Boolean, error: Boolean, interactionSource: InteractionSource): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()
        val targetValue = when {
            !enable -> borderDisabled
            error -> borderError
            focused -> borderFocused
            else -> border
        }
        return if (enable) {
            animateColorAsState(targetValue, tween(durationMillis = AnimationDuration))
        } else {
            rememberUpdatedState(targetValue)
        }
    }

    @Composable
    fun focusingColor(enable: Boolean, error: Boolean, interactionSource: InteractionSource): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()
        val targetValue = when {
            !enable -> Color.Transparent
            error -> JBTheme.focusColors.error
            focused -> JBTheme.focusColors.default
            else -> Color.Transparent
        }
        return rememberUpdatedState(targetValue)
    }

    companion object {
        internal const val AnimationDuration = 150
    }
}

fun lightFieldColors(): FieldColors {
    return FieldColors(
        Color.White,
        Color(0xFFC4C4C4),
        Color(0xFF87AFDA),
        Color(0xFFFAFAFA),
        Color(0xFFF2F2F2),
        Color(0xFFCFCFCF),
        Color(0xFFCE3845),
    )
}

fun darkFieldColors(): FieldColors {
    return FieldColors(
        Color(0xFF4C5052),
        Color(0xFF5E6060),
        Color(0xFF456A90),
        Color(0xFF3C3F41),
        Color(0xFF3C3F41),
        Color(0xFF646464),
        Color(0xFF73454B),
    )
}

val LocalFieldColors = staticCompositionLocalOf { lightFieldColors() }
