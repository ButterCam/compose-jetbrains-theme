package io.kanro.compose.jetbrains.color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class IconColors(
    selected: Color,
    disabled: Color,
) {
    var selected by mutableStateOf(selected)
    var disabled by mutableStateOf(disabled)

    fun copy(
        selected: Color = this.selected,
        disabled: Color = this.disabled,
    ): IconColors {
        return IconColors(
            selected,
            disabled,
        )
    }
}

fun lightIconColors(): IconColors {
    return IconColors(
        Color.White,
        Color(0xFFABABAB),
    )
}

// TODO

val LocalIconColors = staticCompositionLocalOf { lightIconColors() }
