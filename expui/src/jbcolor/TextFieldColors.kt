package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.expui.theme.LightTheme

//"TextField.margin": "com.intellij.util.ui.JBInsets$JBInsetsUIResource[top=0,left=0,bottom=0,right=0]",
//"TextField.border": "com.intellij.ide.ui.laf.darcula.ui.DarculaTextBorder@2f5a8b3d",
//"TextField.focusInputMap": "javax.swing.plaf.InputMapUIResource@74317add",
//"TextField.font": "javax.swing.plaf.FontUIResource[family=Inter,name=Inter,style=plain,size=13]",

//"TextField.background": "#ffffff",
//"TextField.borderColor": "#ebecf0",
//"TextField.caretBlinkRate": "500",
//"TextField.caretForeground": "#000000",
//"TextField.darkShadow": "#000000",
//"TextField.disabledBackground": "#ffffff",
//"TextField.foreground": "#000000",
//"TextField.highlight": "#ffffff",
//"TextField.inactiveBackground": "#ffffff",
//"TextField.inactiveForeground": "#a8adbd",
//"TextField.light": "#0749d9",
//"TextField.selectionBackground": "#cfdefc",
//"TextField.selectionForeground": "#000000",
//"TextField.shadow": "#000000",
class TextFieldColors(
    background: Color = LightTheme.Colors.Grey13,
    borderColor: Color = Color.Unspecified,
    caretForeground: Color = Color.Unspecified,
    darkShadow: Color = Color.Unspecified,
    disabledBackground: Color = Color.Unspecified,
    foreground: Color = Color.Unspecified,
    highlight: Color = Color.Unspecified,
    inactiveBackground: Color = Color.Unspecified,
    inactiveForeground: Color = Color.Unspecified,
    light: Color = Color.Unspecified,
    selectionBackground: Color = Color.Unspecified,
    selectionForeground: Color = Color.Unspecified,
    shadow: Color = Color.Unspecified,
) {
    var background by mutableStateOf(background)
    var borderColor by mutableStateOf(borderColor)
    var caretForeground by mutableStateOf(caretForeground)
    var darkShadow by mutableStateOf(darkShadow)
    var disabledBackground by mutableStateOf(disabledBackground)
    var foreground by mutableStateOf(foreground)
    var highlight by mutableStateOf(highlight)
    var inactiveBackground by mutableStateOf(inactiveBackground)
    var inactiveForeground by mutableStateOf(inactiveForeground)
    var light by mutableStateOf(light)
    var selectionBackground by mutableStateOf(selectionBackground)
    var selectionForeground by mutableStateOf(selectionForeground)
    var shadow by mutableStateOf(shadow)

    fun copy(
        background: Color = this.background,
        borderColor: Color = this.borderColor,
        caretForeground: Color = this.caretForeground,
        darkShadow: Color = this.darkShadow,
        disabledBackground: Color = this.disabledBackground,
        foreground: Color = this.foreground,
        highlight: Color = this.highlight,
        inactiveBackground: Color = this.inactiveBackground,
        inactiveForeground: Color = this.inactiveForeground,
        light: Color = this.light,
        selectionBackground: Color = this.selectionBackground,
        selectionForeground: Color = this.selectionForeground,
        shadow: Color = this.shadow,
    ) = TextFieldColors(
        background,
        borderColor,
        caretForeground,
        darkShadow,
        disabledBackground,
        foreground,
        highlight,
        inactiveBackground,
        inactiveForeground,
        light,
        selectionBackground,
        selectionForeground,
        shadow
    )
}