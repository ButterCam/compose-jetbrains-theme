package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.expui.theme.LightTheme

//"SegmentedButton.focusedSelectedButtonColor": "#cfdefc",
//"SegmentedButton.selectedButtonColor": "#ffffff",
//"SegmentedButton.selectedEndBorderColor": "#c9ccd6",
//"SegmentedButton.selectedStartBorderColor": "#c9ccd6",
class SegmentedButtonColors(
    focusedSelectedButtonColor: Color = LightTheme.Colors.Blue13,
    selectedButtonColor: Color = LightTheme.Colors.Grey13,
    selectedEndBorderColor: Color = LightTheme.Colors.Grey9,
    selectedStartBorderColor: Color = LightTheme.Colors.Grey9,
) {
    var focusedSelectedButtonColor by mutableStateOf(focusedSelectedButtonColor)
    var selectedButtonColor by mutableStateOf(selectedButtonColor)
    var selectedEndBorderColor by mutableStateOf(selectedEndBorderColor)
    var selectedStartBorderColor by mutableStateOf(selectedStartBorderColor)

    fun copy(
        focusedSelectedButtonColor: Color = this.focusedSelectedButtonColor,
        selectedButtonColor: Color = this.selectedButtonColor,
        selectedEndBorderColor: Color = this.selectedEndBorderColor,
        selectedStartBorderColor: Color = this.selectedStartBorderColor,
    ) = SegmentedButtonColors(
        focusedSelectedButtonColor,
        selectedButtonColor,
        selectedEndBorderColor,
        selectedStartBorderColor
    )
}