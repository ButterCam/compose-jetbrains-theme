package io.kanro.compose.jetbrains.color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class TextColors(
    default: Color,
    disabled: Color,
    white: Color,
    link: Color,
    infoPanel: Color,
    infoInput: Color,
    error: Color,
    success: Color,
) {
    var default by mutableStateOf(default)
    var disabled by mutableStateOf(disabled)
    var white by mutableStateOf(white)
    var link by mutableStateOf(link)
    var infoPanel by mutableStateOf(infoPanel)
    var infoInput by mutableStateOf(infoInput)
    var error by mutableStateOf(error)
    var success by mutableStateOf(success)

    fun copy(
        default: Color = this.default,
        disabled: Color = this.disabled,
        white: Color = this.white,
        link: Color = this.link,
        infoPanel: Color = this.infoPanel,
        infoInput: Color = this.infoInput,
        error: Color = this.error,
        success: Color = this.success,
    ): TextColors {
        return TextColors(default, disabled, white, link, infoPanel, infoInput, error, success)
    }
}

fun lightTextColors(): TextColors {
    return TextColors(
        Color.Black,
        Color(0xFF8C8C8C),
        Color.White,
        Color(0xFF2470B3),
        Color(0xFF808080),
        Color(0xFF999999),
        Color(0xFFC7222D),
        Color(0xFF368746),
    )
}

fun darkTextColors(): TextColors {
    return TextColors(
        Color(0xFFBBBBBB),
        Color(0xFF777777),
        Color(0xFFFEFEFE),
        Color(0xFF589DF6),
        Color(0xFF8C8C8C),
        Color(0xFF787878),
        Color(0xFFFF5261),
        Color(0xFF50A661),
    )
}

val LocalTextColors = staticCompositionLocalOf { lightTextColors() }
