package io.kanro.compose.jetbrains.color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class ToggleColors(
    bg: Color,
    off: Color,
    on: Color,
) {
    var bg by mutableStateOf(bg)
    var off by mutableStateOf(off)
    var on by mutableStateOf(on)
}
