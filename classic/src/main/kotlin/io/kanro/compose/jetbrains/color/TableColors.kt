package io.kanro.compose.jetbrains.color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class TableColors(
    bg: Color,
    headerBorder: Color,
    outerBorder: Color,
) {
    var bg by mutableStateOf(bg)
    var headerBorder by mutableStateOf(headerBorder)
    var outerBorder by mutableStateOf(outerBorder)
}
