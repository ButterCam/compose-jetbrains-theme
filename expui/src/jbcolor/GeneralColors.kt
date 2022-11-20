package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.expui.theme.LightTheme

//foreground = [0,0,0]
//background = [247,248,250]
//borderColor = [235,236,240]
//
//disabledBackground = [255,255,255]
//disabledBorderColor = [223,225,229]
//disabledForeground = [168,173,189]
//disabledText = [168,173,189]
//
//inactiveBackground = [255,255,255]
//inactiveForeground = [168,173,189]
//inactiveUnderlineColor = [168,173,189]
//
//acceleratorForeground = [129,133,148]
//acceleratorSelectionForeground = [129,133,148]
//
//caretForeground = [0,0,0]
//
//focusColor = [53,115,240]
//hoverBackground = [231,239,253]
//infoForeground = [129,133,148]
//lightSelectionBackground = [207,222,252]
//modifiedItemForeground = [0,90,217]
//separatorColor = [235,236,240]
//separatorForeground = [129,133,148]
//shortcutForeground = [129,133,148]
//textForeground = [0,0,0]
//textBackground = [255,255,255]
//underlineColor = [53,115,240]
//
//selectedForeground = [0,0,0]
//selectionBackground = [207,222,252]
//selectionBackgroundInactive = [213,213,213]
//selectionForeground = [0,0,0]
//selectionForegroundInactive = [0,0,0]
//selectionInactiveBackground = [223,225,229]
//selectionInactiveForeground = [0,0,0]
class GeneralColors(
    foreground: Color = Color.Black,
    background: Color = LightTheme.Colors.Grey12,
    borderColor: Color = LightTheme.Colors.Grey11,

    disabledBackground: Color = Color.White,
    disabledBorderColor: Color = LightTheme.Colors.Grey10,
    disabledForeground: Color = LightTheme.Colors.Grey8,
    disabledText: Color = LightTheme.Colors.Grey8,

    inactiveBackground: Color = disabledBackground,
    inactiveForeground: Color = disabledText,
    inactiveUnderlineColor: Color = disabledText,

    acceleratorForeground: Color = LightTheme.Colors.Grey7,
    acceleratorSelectionForeground: Color = LightTheme.Colors.Grey7,

    caretForeground: Color = foreground,

    focusColor: Color = LightTheme.Colors.Blue6,
    hoverBackground: Color = LightTheme.Colors.Blue14,
    infoForeground: Color = LightTheme.Colors.Grey7,
    lightSelectionBackground: Color = LightTheme.Colors.Blue13,
    modifiedItemForeground: Color = Color(0x0000A9D9),
    separatorColor: Color = LightTheme.Colors.Grey11,
    separatorForeground: Color = LightTheme.Colors.Grey7,
    shortcutForeground: Color = LightTheme.Colors.Grey7,
    textForeground: Color = foreground,
    textBackground: Color = background,
    underlineColor: Color = LightTheme.Colors.Blue6,

    selectedForeground: Color = foreground,
    selectionBackground: Color = LightTheme.Colors.Blue13,
    selectionBackgroundInactive: Color = Color(0xFFD5D5D5),
    selectionForeground: Color = LightTheme.Colors.Grey1,
    selectionForegroundInactive: Color = selectionForeground,
    selectionInactiveBackground: Color = LightTheme.Colors.Grey10,
    selectionInactiveForeground: Color = LightTheme.Colors.Grey1,
) {
    var foreground by mutableStateOf(foreground)
    var background by mutableStateOf(background)
    var borderColor by mutableStateOf(borderColor)

    var disabledBackground by mutableStateOf(disabledBackground)
    var disabledBorderColor by mutableStateOf(disabledBorderColor)
    var disabledForeground by mutableStateOf(disabledForeground)
    var disabledText by mutableStateOf(disabledText)

    var inactiveBackground by mutableStateOf(inactiveBackground)
    var inactiveForeground by mutableStateOf(inactiveForeground)
    var inactiveUnderlineColor by mutableStateOf(inactiveUnderlineColor)

    var acceleratorForeground by mutableStateOf(acceleratorForeground)
    var acceleratorSelectionForeground by mutableStateOf(acceleratorSelectionForeground)

    var caretForeground by mutableStateOf(caretForeground)

    var focusColor by mutableStateOf(focusColor)
    var hoverBackground by mutableStateOf(hoverBackground)
    var infoForeground by mutableStateOf(infoForeground)
    var lightSelectionBackground by mutableStateOf(lightSelectionBackground)
    var modifiedItemForeground by mutableStateOf(modifiedItemForeground)
    var separatorColor by mutableStateOf(separatorColor)
    var separatorForeground by mutableStateOf(separatorForeground)
    var shortcutForeground by mutableStateOf(shortcutForeground)
    var textForeground by mutableStateOf(textForeground)
    var textBackground by mutableStateOf(textBackground)
    var underlineColor by mutableStateOf(underlineColor)

    var selectedForeground by mutableStateOf(selectedForeground)
    var selectionBackground by mutableStateOf(selectionBackground)
    var selectionBackgroundInactive by mutableStateOf(selectionBackgroundInactive)
    var selectionForeground by mutableStateOf(selectionForeground)
    var selectionForegroundInactive by mutableStateOf(selectionForegroundInactive)
    var selectionInactiveBackground by mutableStateOf(selectionInactiveBackground)
    var selectionInactiveForeground by mutableStateOf(selectionInactiveForeground)

    fun copy(
        foreground: Color = this.foreground,
        background: Color = this.background,
        borderColor: Color = this.borderColor,

        disabledBackground: Color = this.disabledBackground,
        disabledBorderColor: Color = this.disabledBorderColor,
        disabledForeground: Color = this.disabledForeground,
        disabledText: Color = this.disabledText,

        inactiveBackground: Color = this.inactiveBackground,
        inactiveForeground: Color = this.inactiveForeground,
        inactiveUnderlineColor: Color = this.inactiveUnderlineColor,

        acceleratorForeground: Color = this.acceleratorForeground,
        acceleratorSelectionForeground: Color = this.acceleratorSelectionForeground,

        caretForeground: Color = this.caretForeground,

        focusColor: Color = this.focusColor,
        hoverBackground: Color = this.hoverBackground,
        infoForeground: Color = this.infoForeground,
        lightSelectionBackground: Color = this.lightSelectionBackground,
        modifiedItemForeground: Color = this.modifiedItemForeground,
        separatorColor: Color = this.separatorColor,
        separatorForeground: Color = this.separatorForeground,
        shortcutForeground: Color = this.shortcutForeground,
        textForeground: Color = this.textForeground,
        textBackground: Color = this.textBackground,
        underlineColor: Color = this.underlineColor,

        selectedForeground: Color = this.selectedForeground,
        selectionBackground: Color = this.selectionBackground,
        selectionBackgroundInactive: Color = this.selectionBackgroundInactive,
        selectionForeground: Color = this.selectionForeground,
        selectionForegroundInactive: Color = this.selectionForegroundInactive,
        selectionInactiveBackground: Color = this.selectionInactiveBackground,
        selectionInactiveForeground: Color = this.selectionInactiveForeground,
    ) = GeneralColors(
        foreground,
        background,
        borderColor,

        disabledBackground,
        disabledBorderColor,
        disabledForeground,
        disabledText,

        inactiveBackground,
        inactiveForeground,
        inactiveUnderlineColor,

        acceleratorForeground,
        acceleratorSelectionForeground,

        caretForeground,

        focusColor,
        hoverBackground,
        infoForeground,
        lightSelectionBackground,
        modifiedItemForeground,
        separatorColor,
        separatorForeground,
        shortcutForeground,
        textForeground,
        textBackground,
        underlineColor,

        selectedForeground,
        selectionBackground,
        selectionBackgroundInactive,
        selectionForeground,
        selectionForegroundInactive,
        selectionInactiveBackground,
        selectionInactiveForeground
    )
}