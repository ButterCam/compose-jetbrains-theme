package io.kanro.compose.jetbrains.color

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class TabColors(
    selection: Color,
    focus: Color,
    selectionInactive: Color,
    hover: Color,
    selectionDisabled: Color,
    bgSelected: Color,
) {
    var selection by mutableStateOf(selection)
    var focus by mutableStateOf(focus)
    var selectionInactive by mutableStateOf(selectionInactive)
    var hover by mutableStateOf(hover)
    var selectionDisabled by mutableStateOf(selectionDisabled)
    var bgSelected by mutableStateOf(bgSelected)

    fun copy(
        selection: Color = this.selection,
        focus: Color = this.focus,
        selectionInactive: Color = this.selectionInactive,
        hover: Color = this.hover,
        selectionDisabled: Color = this.selectionDisabled,
        bgSelected: Color = this.bgSelected,
    ): TabColors {
        return TabColors(selection, focus, selectionInactive, hover, selectionDisabled, bgSelected)
    }
}

fun lightTabColors(): TabColors {
    return TabColors(
        Color(0xFF4083C9),
        Color(0xFFDAE4ED),
        Color(0xFF9CA7B8),
        Color(0x19000000),
        Color(0xFFABABAB),
        Color(0xFFFFFFFF),
    )
}

fun darkTabColors(): TabColors {
    return TabColors(
        Color(0xFF4A88C7),
        Color(0xFF3D4B5C),
        Color(0xFF747A80),
        Color(0xFF2E3133),
        Color(0xFF595959),
        Color(0xFF4E5254),
    )
}

val LocalTabColors = staticCompositionLocalOf { lightTabColors() }
