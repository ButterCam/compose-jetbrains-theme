package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.expui.theme.LightTheme

//"MainToolbar.Icon.borderInsets": "com.intellij.util.ui.JBInsets$JBInsetsUIResource[top=10,left=10,bottom=10,right=10]",
//"MainToolbar.Dropdown.borderInsets": "com.intellij.util.ui.JBInsets$JBInsetsUIResource[top=3,left=8,bottom=3,right=4]",

//"MainToolbar.background": "#27282e",
//"MainToolbar.Dropdown.background": "#27282e",
//"MainToolbar.Dropdown.foreground": "#ebecf0",
//"MainToolbar.Dropdown.hoverBackground": "#000000",
//"MainToolbar.Dropdown.pressedBackground": "#000000",
//"MainToolbar.Icon.background": "#27282e",
//"MainToolbar.Icon.hoverBackground": "#000000",
//"MainToolbar.Icon.pressedBackground": "#000000",
//"MainToolbar.inactiveBackground": "#383a42",
class MainToolBarColors(
    background: Color = LightTheme.Colors.Grey2,
    dropdownBackground: Color = LightTheme.Colors.Grey2,
    dropdownForeground: Color = LightTheme.Colors.Grey11,
    dropdownHoverBackground: Color = LightTheme.Colors.Grey1,
    dropdownPressedBackground: Color = LightTheme.Colors.Grey1,
    iconBackground: Color = LightTheme.Colors.Grey2,
    iconHoverBackground: Color = LightTheme.Colors.Grey1,
    iconPressedBackground: Color = LightTheme.Colors.Grey1,
    inactiveBackground: Color = LightTheme.Colors.Grey3,
) {
    var background by mutableStateOf(background)
    var dropdownBackground by mutableStateOf(dropdownBackground)
    var dropdownForeground by mutableStateOf(dropdownForeground)
    var dropdownHoverBackground by mutableStateOf(dropdownHoverBackground)
    var dropdownPressedBackground by mutableStateOf(dropdownPressedBackground)
    var iconBackground by mutableStateOf(iconBackground)
    var iconHoverBackground by mutableStateOf(iconHoverBackground)
    var iconPressedBackground by mutableStateOf(iconPressedBackground)
    var inactiveBackground by mutableStateOf(inactiveBackground)

    fun copy(
        background: Color = this.background,
        inactiveBackground: Color = this.inactiveBackground,
        dropdownBackground: Color = this.dropdownBackground,
        dropdownForeground: Color = this.dropdownForeground,
        dropdownHoverBackground: Color = this.dropdownHoverBackground,
        dropdownPressedBackground: Color = this.dropdownPressedBackground,
        iconBackground: Color = this.iconBackground,
        iconHoverBackground: Color = this.iconHoverBackground,
        iconPressedBackground: Color = this.iconPressedBackground,
    ) = MainToolBarColors(
        background,
        inactiveBackground,
        dropdownBackground,
        dropdownForeground,
        dropdownHoverBackground,
        dropdownPressedBackground,
        iconBackground,
        iconHoverBackground,
        iconPressedBackground,
    )
}