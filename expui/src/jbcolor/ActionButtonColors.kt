package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.expui.theme.LightTheme

class ActionButtonColors(
    hoverBackground: Color = LightTheme.Colors.Grey11,
    hoverBorderColor: Color = LightTheme.Colors.Grey11,
    pressedBackground: Color = LightTheme.Colors.Grey10,
    pressedBorderColor: Color = LightTheme.Colors.Grey10,
    focusedBorderColor: Color = LightTheme.Colors.Blue7,
    hoverSeparatorColor: Color = LightTheme.Colors.Grey8,
) {
    var hoverBackground by mutableStateOf(hoverBackground)
    var hoverBorderColor by mutableStateOf(hoverBorderColor)
    var pressedBackground by mutableStateOf(pressedBackground)
    var pressedBorderColor by mutableStateOf(pressedBorderColor)
    var focusedBorderColor by mutableStateOf(focusedBorderColor)
    var hoverSeparatorColor by mutableStateOf(hoverSeparatorColor)

    fun copy(
        hoverBackground: Color = this.hoverBackground,
        hoverBorderColor: Color = this.hoverBorderColor,
        pressedBackground: Color = this.pressedBackground,
        pressedBorderColor: Color = this.pressedBorderColor,
        focusedBorderColor: Color = this.focusedBorderColor,
        hoverSeparatorColor: Color = this.hoverSeparatorColor,
    ) = ActionButtonColors(
        hoverBackground,
        hoverBorderColor,
        pressedBackground,
        pressedBorderColor,
        focusedBorderColor,
        hoverSeparatorColor
    )
}