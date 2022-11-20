package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.expui.theme.LightTheme

//"Button.border": "com.intellij.ide.ui.laf.darcula.ui.DarculaButtonPainter@66d9ade5",
//"Button.actionMap": "javax.swing.plaf.basic.LazyActionMap@71367d17",
//"Button.arc": "6",
//"Button.focusInputMap": "javax.swing.plaf.InputMapUIResource@3e124a92",
//"Button.font": "javax.swing.plaf.FontUIResource[family=Inter,name=Inter,style=plain,size=13]",
//"Button.margin": "com.intellij.util.ui.JBInsets$JBInsetsUIResource[top=0,left=2,bottom=0,right=2]",
//"Button.paintShadow": "true",
//"Button.textIconGap": "4",
//"Button.textShiftOffset": "0",
//"Button.shadowWidth": "1",
//"Button.opaque": "false",
//"Button.defaultButtonFollowsFocus": "false",

//"Button.background": "#f7f8fa",
//"Button.darcula.disabledText.shadow": "#ffffff",
//"Button.darkShadow": "#000000",
//"Button.disabledBorderColor": "#dfe1e5",
//"Button.disabledText": "#a8adbd",
//"Button.endBackground": "#ffffff",
//"Button.endBorderColor": "#c9ccd6",
//"Button.focusedBorderColor": "#ffffff",
//"Button.foreground": "#000000",
//"Button.highlight": "#ffffff",
//"Button.light": "#0749d9",
//"Button.select": "#ff6666",
//"Button.shadow": "#000000",
//"Button.shadowColor": "#a6a6a6",
//"Button.startBackground": "#ffffff",
//"Button.startBorderColor": "#c9ccd6",
//"Button.default.endBackground": "#3573f0",
//"Button.default.endBorderColor": "#3573f0",
//"Button.default.focusedBorderColor": "#ffffff",
//"Button.default.foreground": "#ffffff",
//"Button.default.shadowColor": "#a6a6a6",
//"Button.default.startBackground": "#3573f0",
//"Button.default.startBorderColor": "#3573f0",
class ButtonColors(
    background: Color = LightTheme.Colors.Grey13,
    disabledBorderColor: Color = Color.Unspecified,
    disabledText: Color = Color.Unspecified,
    endBackground: Color = Color.Unspecified,
    endBorderColor: Color = LightTheme.Colors.Grey9,
    focusedBorderColor: Color = LightTheme.Colors.Grey13,
    foreground: Color = Color.Unspecified,
    startBackground: Color = Color.Unspecified,
    startBorderColor: Color = LightTheme.Colors.Grey9,
    defaultEndBackground: Color = LightTheme.Colors.Blue6,
    defaultEndBorderColor: Color = LightTheme.Colors.Blue6,
    defaultFocusedBorderColor: Color = LightTheme.Colors.Grey13,
    defaultForeground: Color = LightTheme.Colors.Grey13,
    defaultStartBackground: Color = LightTheme.Colors.Blue6,
    defaultStartBorderColor: Color = LightTheme.Colors.Blue6,
) {
    var background by mutableStateOf(background)
    var disabledBorderColor by mutableStateOf(disabledBorderColor)
    var disabledText by mutableStateOf(disabledText)
    var endBackground by mutableStateOf(endBackground)
    var endBorderColor by mutableStateOf(endBorderColor)
    var focusedBorderColor by mutableStateOf(focusedBorderColor)
    var foreground by mutableStateOf(foreground)
    var startBackground by mutableStateOf(startBackground)
    var startBorderColor by mutableStateOf(startBorderColor)
    var defaultEndBackground by mutableStateOf(defaultEndBackground)
    var defaultEndBorderColor by mutableStateOf(defaultEndBorderColor)
    var defaultFocusedBorderColor by mutableStateOf(defaultFocusedBorderColor)
    var defaultForeground by mutableStateOf(defaultForeground)
    var defaultStartBackground by mutableStateOf(defaultStartBackground)
    var defaultStartBorderColor by mutableStateOf(defaultStartBorderColor)

    fun copy(
        background: Color = this.background,
        disabledBorderColor: Color = this.disabledBorderColor,
        disabledText: Color = this.disabledText,
        endBackground: Color = this.endBackground,
        endBorderColor: Color = this.endBorderColor,
        focusedBorderColor: Color = this.focusedBorderColor,
        foreground: Color = this.foreground,
        startBackground: Color = this.startBackground,
        startBorderColor: Color = this.startBorderColor,
        defaultEndBackground: Color = this.defaultEndBackground,
        defaultEndBorderColor: Color = this.defaultEndBorderColor,
        defaultFocusedBorderColor: Color = this.defaultFocusedBorderColor,
        defaultForeground: Color = this.defaultForeground,
        defaultStartBackground: Color = this.defaultStartBackground,
        defaultStartBorderColor: Color = this.defaultStartBorderColor,
    ) = ButtonColors(
        background,
        disabledBorderColor,
        disabledText,
        endBackground,
        endBorderColor,
        focusedBorderColor,
        foreground,
        startBackground,
        startBorderColor,
        defaultEndBackground,
        defaultEndBorderColor,
        defaultFocusedBorderColor,
        defaultForeground,
        defaultStartBackground,
        defaultStartBorderColor
    )
}
