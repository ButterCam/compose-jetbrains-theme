package io.kanro.compose.jetbrains.color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class ProgressColors(
    progress: Color,
    bg: Color,
) {
    var progress by mutableStateOf(progress)
    var bg by mutableStateOf(bg)

    fun copy(
        progress: Color = this.progress,
        bg: Color = this.bg,
    ): ProgressColors {
        return ProgressColors(progress, bg)
    }
}

fun lightProgressColors(): ProgressColors {
    return ProgressColors(
        Color(0xFF1E82E6),
        Color(0xFFD5D5D5),
    )
}

fun darkProgressColors(): ProgressColors {
    return ProgressColors(
        Color(0xFFA0A0A0),
        Color(0xFF555555),
    )
}

val LocalProgressColors = staticCompositionLocalOf { lightProgressColors() }
