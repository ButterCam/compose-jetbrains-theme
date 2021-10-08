package io.kanro.compose.jetbrains.color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class FocusColors(
    default: Color,
    error: Color,
    warning: Color,
    warningInactive: Color,
) {
    var default by mutableStateOf(default)
    var error by mutableStateOf(error)
    var warning by mutableStateOf(warning)
    var warningInactive by mutableStateOf(warningInactive)

    fun copy(
        default: Color = this.default,
        error: Color = this.error,
        warning: Color = this.warning,
        warningInactive: Color = this.warningInactive,
    ): FocusColors {
        return FocusColors(default, error, warning, warningInactive)
    }
}

fun lightFocusColors(): FocusColors {
    return FocusColors(
        Color(0xFF97C3F3),
        Color(0xFFE53E4D),
        Color(0xFFE1A336),
        Color(0xFFEAD2A1),
    )
}

val LocalFocusColors = staticCompositionLocalOf { lightFocusColors() }
