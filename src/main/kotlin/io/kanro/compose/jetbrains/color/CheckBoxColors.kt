package io.kanro.compose.jetbrains.color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class CheckBoxColors(
    bg: Color,
    bgSelected: Color,
    bgDisabled: Color,
    border: Color,
    borderSelected: Color,
    borderFocused: Color,
    borderDisabled: Color,
) {
    var bg by mutableStateOf(bg)
    var bgSelected by mutableStateOf(bgSelected)
    var bgDisabled by mutableStateOf(bgDisabled)
    var border by mutableStateOf(border)
    var borderSelected by mutableStateOf(borderSelected)
    var borderFocused by mutableStateOf(borderFocused)
    var borderDisabled by mutableStateOf(borderDisabled)

    fun copy(
        bg: Color = this.bg,
        bgSelected: Color = this.bgSelected,
        bgDisabled: Color = this.bgDisabled,
        border: Color = this.border,
        borderSelected: Color = this.borderSelected,
        borderFocused: Color = this.borderFocused,
        borderDisabled: Color = this.borderDisabled,
    ): CheckBoxColors {
        return CheckBoxColors(
            bg,
            bgSelected,
            bgDisabled,
            border,
            borderSelected,
            borderFocused,
            borderDisabled
        )
    }
}

fun lightCheckBoxColors(): CheckBoxColors {
    return CheckBoxColors(
        Color.White,
        Color(0xFF4F9EE3),
        Color(0xFFF2F2F2),
        Color(0xFFB0B0B0),
        Color(0xFF4B97D9),
        Color(0xFF7B9FC7),
        Color(0xFFBDBDBD),
    )
}

fun darkCheckBoxColors(): CheckBoxColors {
    return CheckBoxColors(
        Color(0xFF43494A),
        Color(0xFF43494A),
        Color(0xFF3C3F41),
        Color(0xFF6B6B6B),
        Color(0xFF4C708C),
        Color(0xFF43698E),
        Color(0xFF545556),
    )
}

val LocalCheckBoxColors = staticCompositionLocalOf { lightCheckBoxColors() }
