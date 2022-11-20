package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.expui.theme.LightTheme

//"Borders.color": "#ebecf0",
//"Borders.ContrastBorderColor": "#ebecf0",
class BorderColors(
    color: Color = LightTheme.Colors.Grey11, contrastColor: Color = LightTheme.Colors.Grey11,
) {
    var color by mutableStateOf(color)
    var contrastColor by mutableStateOf(contrastColor)

    fun copy(
        color: Color = this.color, contrastColor: Color = this.contrastColor,
    ) = BorderColors(
        color, contrastColor
    )
}