package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

//"ScrollBar.foreground": "#000000",
//"ScrollBar.hoverThumbBorderColor": "#595959",
//"ScrollBar.hoverThumbColor": "#737373",
//"ScrollBar.hoverTrackColor": "#808080",
//"ScrollBar.thumb": "#ffffff",
//"ScrollBar.thumbBorderColor": "#595959",
//"ScrollBar.thumbColor": "#737373",
//"ScrollBar.thumbDarkShadow": "#000000",
//"ScrollBar.thumbHighlight": "#ffffff",
//"ScrollBar.thumbShadow": "#000000",
class ScrollBarColors(
    foreground: Color,
    hoverThumbBorderColor: Color,
    hoverThumbColor: Color,
    hoverTrackColor: Color,
    thumb: Color,
    thumbBorderColor: Color,
    thumbColor: Color,
    thumbDarkShadow: Color,
    thumbHighlight: Color,
    thumbShadow: Color,
) {
    var foreground by mutableStateOf(foreground)
    var hoverThumbBorderColor by mutableStateOf(hoverThumbBorderColor)
    var hoverThumbColor by mutableStateOf(hoverThumbColor)
    var hoverTrackColor by mutableStateOf(hoverTrackColor)
    var thumb by mutableStateOf(thumb)
    var thumbBorderColor by mutableStateOf(thumbBorderColor)
    var thumbColor by mutableStateOf(thumbColor)
    var thumbDarkShadow by mutableStateOf(thumbDarkShadow)
    var thumbHighlight by mutableStateOf(thumbHighlight)
    var thumbShadow by mutableStateOf(thumbShadow)

    fun copy(
        foreground: Color = this.foreground,
        hoverThumbBorderColor: Color = this.hoverThumbBorderColor,
        hoverThumbColor: Color = this.hoverThumbColor,
        hoverTrackColor: Color = this.hoverTrackColor,
        thumb: Color = this.thumb,
        thumbBorderColor: Color = this.thumbBorderColor,
        thumbColor: Color = this.thumbColor,
        thumbDarkShadow: Color = this.thumbDarkShadow,
        thumbHighlight: Color = this.thumbHighlight,
        thumbShadow: Color = this.thumbShadow,
    ) = ScrollBarColors(
        foreground,
        hoverThumbBorderColor,
        hoverThumbColor,
        hoverTrackColor,
        thumb,
        thumbBorderColor,
        thumbColor,
        thumbDarkShadow,
        thumbHighlight,
        thumbShadow,
    )
}