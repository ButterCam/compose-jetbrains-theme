package io.kanro.compose.jetbrains.color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class SelectionColors(
    active: Color,
    inactive: Color,
    hover: Color,
    lightActive: Color,
    lightInactive: Color,
    completionPopup: Color,
) {
    var active by mutableStateOf(active)
    var inactive by mutableStateOf(inactive)
    var hover by mutableStateOf(hover)
    var lightActive by mutableStateOf(lightActive)
    var lightInactive by mutableStateOf(lightInactive)
    var completionPopup by mutableStateOf(completionPopup)

    fun copy(
        active: Color = this.active,
        inactive: Color = this.inactive,
        hover: Color = this.hover,
        lightActive: Color = this.lightActive,
        lightInactive: Color = this.lightInactive,
        completionPopup: Color = this.completionPopup,
    ): SelectionColors {
        return SelectionColors(active, inactive, hover, lightActive, lightInactive, completionPopup)
    }
}

fun lightSelectionColors(): SelectionColors {
    return SelectionColors(
        Color(0xFF2675BF),
        Color(0xFFD5D5D5),
        Color(0xFFEDF5FC),
        Color(0xFFEDF6FE),
        Color(0xFFF5F5F5),
        Color(0xFFC5DFFC),
    )
}

fun darkSelectionColors(): SelectionColors {
    return SelectionColors(
        Color(0xFF2F65CA),
        Color(0xFF0D293E),
        Color(0xFF464A4D),
        Color(0xFF464A4D),
        Color(0xFF35383B),
        Color(0xFF113A5C),
    )
}

val LocalSelectionColors = staticCompositionLocalOf { lightSelectionColors() }
