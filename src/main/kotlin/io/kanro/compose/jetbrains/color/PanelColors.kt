package io.kanro.compose.jetbrains.color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class PanelColors(
    border: Color,
    bgContent: Color,
    bgDialog: Color,
) {
    var border by mutableStateOf(border)
    var bgContent by mutableStateOf(bgContent)
    var bgDialog by mutableStateOf(bgDialog)

    fun copy(
        border: Color = this.border,
        bgContent: Color = this.bgContent,
        bgDialog: Color = this.bgDialog,
    ): PanelColors {
        return PanelColors(border, bgContent, bgDialog)
    }
}

fun lightPanelColors(): PanelColors {
    return PanelColors(
        Color(0xFFD1D1D1),
        Color.White,
        Color(0xFFF2F2F2),
    )
}

fun darkPanelColors(): PanelColors {
    return PanelColors(
        Color(0xFF323232),
        Color(0xFF3C3F41),
        Color(0xFF3C3F41),
    )
}

val LocalPanelColors = staticCompositionLocalOf { lightPanelColors() }
