package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.expui.theme.LightTheme

//"ComboBox.actionMap": "javax.swing.plaf.basic.LazyActionMap@546fdf3",
//"ComboBox.ancestorInputMap": "javax.swing.plaf.InputMapUIResource@1ecfe9c3",
//"ComboBox.ArrowButton.background": "#ffffff",
//"ComboBox.ArrowButton.disabledIconColor": "#ababab",
//"ComboBox.ArrowButton.iconColor": "#6e6e6e",
//"ComboBox.ArrowButton.nonEditableBackground": "#ffffff",
//"ComboBox.background": "#ffffff",
//"ComboBox.buttonBackground": "#ffffff",
//"ComboBox.buttonDarkShadow": "#000000",
//"ComboBox.buttonHighlight": "#ffffff",
//"ComboBox.buttonShadow": "#000000",
//"ComboBox.disabledBackground": "#f7f8fa",
//"ComboBox.disabledForeground": "#a8adbd",
//"ComboBox.font": "javax.swing.plaf.FontUIResource[family=Inter,name=Inter,style=plain,size=13]",
//"ComboBox.foreground": "#000000",
//"ComboBox.isEnterSelectablePopup": "false",
//"ComboBox.modifiedItemForeground": "#005ad9",
//"ComboBox.noActionOnKeyNavigation": "false",
//"ComboBox.nonEditableBackground": "#ffffff",
//"ComboBox.padding": "com.intellij.util.ui.JBInsets$JBInsetsUIResource[top=1,left=6,bottom=1,right=6]",
//"ComboBox.selectionBackground": "#cfdefc",
//"ComboBox.selectionForeground": "#000000",
//"ComboBox.timeFactor": "1000",
//"ComboBox.togglePopup.textAndMnemonic": "togglePopup",
//"ComboBoxButton.background": "#f7f8fa",
class ComboBoxColors(
    background: Color = LightTheme.Colors.Grey13,
    foreground: Color = Color.Unspecified,

    disabledBackground: Color = LightTheme.Colors.Grey12,
    disabledForeground: Color = Color.Unspecified,

    selectionBackground: Color = Color.Unspecified,
    selectionForeground: Color = Color.Unspecified,

    arrowButtonBackground: Color = LightTheme.Colors.Grey13,
    arrowButtonNonEditableBackground: Color = LightTheme.Colors.Grey13,
) {
    var background by mutableStateOf(background)
    var foreground by mutableStateOf(foreground)

    var disabledBackground by mutableStateOf(disabledBackground)
    var disabledForeground by mutableStateOf(disabledForeground)

    var selectionBackground by mutableStateOf(selectionBackground)
    var selectionForeground by mutableStateOf(selectionForeground)

    var arrowButtonBackground by mutableStateOf(arrowButtonBackground)
    var arrowButtonNonEditableBackground by mutableStateOf(arrowButtonNonEditableBackground)

    fun copy(
        background: Color = this.background,
        foreground: Color = this.foreground,

        disabledBackground: Color = this.disabledBackground,
        disabledForeground: Color = this.disabledForeground,

        selectionBackground: Color = this.selectionBackground,
        selectionForeground: Color = this.selectionForeground,

        arrowButtonBackground: Color = this.arrowButtonBackground,
        arrowButtonNonEditableBackground: Color = this.arrowButtonNonEditableBackground,
    ) = ComboBoxColors(
        background,
        foreground,

        disabledBackground,
        disabledForeground,

        selectionBackground,
        selectionForeground,

        arrowButtonBackground,
        arrowButtonNonEditableBackground,
    )
}