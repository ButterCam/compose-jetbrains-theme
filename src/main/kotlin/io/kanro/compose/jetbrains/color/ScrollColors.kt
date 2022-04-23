package io.kanro.compose.jetbrains.color

import androidx.compose.foundation.ScrollbarStyle
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class ScrollColors(
    bg: Color,
) {
    var bg by mutableStateOf(bg)

    fun copy(
        bg: Color = this.bg,
    ): ScrollColors {
        return ScrollColors(bg)
    }

    fun style(): ScrollbarStyle {
        return ScrollbarStyle(
            minimalHeight = 30.dp,
            thickness = 7.dp,
            shape = CircleShape,
            hoverDurationMillis = 0,
            unhoverColor = bg,
            hoverColor = bg
        )
    }
}

fun lightScrollColors(): ScrollColors {
    return ScrollColors(
        Color(0xFFC9C9C9),
    )
}

fun darkScrollColors(): ScrollColors {
    return ScrollColors(
        Color(0xFF494949)
    )
}

val LocalScrollColors = staticCompositionLocalOf { lightScrollColors() }
