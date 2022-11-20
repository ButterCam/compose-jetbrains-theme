package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.expui.theme.LightTheme

//"Component.borderColor": "#c9ccd6",
//"Component.disabledBorderColor": "#dfe1e5",
//"Component.errorFocusColor": "#eb7171",
//"Component.focusColor": "#3573f0",
//"Component.focusedBorderColor": "#ffffff",
//"Component.focusWidth": "2",
//"Component.hoverIconColor": "#7f8b91",
//"Component.iconColor": "#7f8b91",
//"Component.inactiveErrorFocusColor": "#fcd4d4",
//"Component.inactiveWarningFocusColor": "#ffe7ab",
//"Component.infoForeground": "#818594",
//"Component.warningFocusColor": "#fcc75b",
class ComponentColors(
    borderColor: Color = LightTheme.Colors.Grey9,
    disabledBorderColor: Color = Color.Unspecified,
    errorFocusColor: Color = LightTheme.Colors.Red7,
    focusColor: Color = Color.Unspecified,
    focusedBorderColor: Color = LightTheme.Colors.Grey13,
    inactiveErrorFocusColor: Color = LightTheme.Colors.Red10,
    inactiveWarningFocusColor: Color = LightTheme.Colors.Yellow9,
    infoForeground: Color = Color.Unspecified,
    warningFocusColor: Color = LightTheme.Colors.Yellow6,
) {
    var borderColor by mutableStateOf(borderColor)
    var disabledBorderColor by mutableStateOf(disabledBorderColor)
    var errorFocusColor by mutableStateOf(errorFocusColor)
    var focusColor by mutableStateOf(focusColor)
    var focusedBorderColor by mutableStateOf(focusedBorderColor)
    var inactiveErrorFocusColor by mutableStateOf(inactiveErrorFocusColor)
    var inactiveWarningFocusColor by mutableStateOf(inactiveWarningFocusColor)
    var infoForeground by mutableStateOf(infoForeground)
    var warningFocusColor by mutableStateOf(warningFocusColor)

    fun copy(
        borderColor: Color = this.borderColor,
        disabledBorderColor: Color = this.disabledBorderColor,
        errorFocusColor: Color = this.errorFocusColor,
        focusColor: Color = this.focusColor,
        focusedBorderColor: Color = this.focusedBorderColor,
        inactiveErrorFocusColor: Color = this.inactiveErrorFocusColor,
        inactiveWarningFocusColor: Color = this.inactiveWarningFocusColor,
        infoForeground: Color = this.infoForeground,
        warningFocusColor: Color = this.warningFocusColor,
    ) = ComponentColors(
        borderColor,
        disabledBorderColor,
        errorFocusColor,
        focusColor,
        focusedBorderColor,
        inactiveErrorFocusColor,
        inactiveWarningFocusColor,
        infoForeground,
        warningFocusColor
    )
}