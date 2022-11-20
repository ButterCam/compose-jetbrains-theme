package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.expui.theme.LightTheme

//"PopupMenu.actionMap": "javax.swing.plaf.basic.LazyActionMap@2f663c12",
//"PopupMenu.background": "#ffffff",
//"PopupMenu.border": "com.intellij.ide.ui.laf.darcula.ui.DarculaPopupMenuBorder@239ae2",
//"PopupMenu.borderCornerRadiusX": "16",
//"PopupMenu.borderCornerRadiusY": "16",
//"PopupMenu.borderInsets": "com.intellij.util.ui.JBInsets$JBInsetsUIResource[top=6,left=1,bottom=6,right=1]",
//"PopupMenu.consumeEventOnClose": "false",
//"PopupMenu.font": "javax.swing.plaf.FontUIResource[family=Inter,name=Inter,style=plain,size=13]",
//"PopupMenu.foreground": "#000000",
//"PopupMenu.leftBorderWith": "10",
//"PopupMenu.rightBorderWith": "0",
//"PopupMenu.selectedWindowInputMapBindings": "[Ljava.lang.Object;@49ddcb61",
//"PopupMenu.selectedWindowInputMapBindings.RightToLeft": "[Ljava.lang.Object;@162ed380",
//"PopupMenu.selectionBackground": "#cfdefc",
//"PopupMenu.selectionForeground": "#000000",
//"PopupMenu.translucentBackground": "#f2f2f2",
//"PopupMenuSeparator.height": "9",
//"PopupMenuSeparator.stripeIndent": "4",
//"PopupMenuSeparator.stripeWidth": "1",
//"PopupMenuSeparator.withToEdge": "10",
//"PopupMenuSeparatorUI": "com.intellij.ide.ui.laf.darcula.ui.DarculaMenuSeparatorUI",
class PopupMenuColors(
    background: Color = LightTheme.Colors.Grey13,
    foreground: Color = Color.Unspecified,
    selectionBackground: Color = Color.Unspecified,
    selectionForeground: Color = Color.Unspecified,
) {
    var background by mutableStateOf(background)
    var foreground by mutableStateOf(foreground)
    var selectionBackground by mutableStateOf(selectionBackground)
    var selectionForeground by mutableStateOf(selectionForeground)

    fun copy(
        background: Color = this.background,
        foreground: Color = this.foreground,
        selectionBackground: Color = this.selectionBackground,
        selectionForeground: Color = this.selectionForeground,
    ) = PopupMenuColors(
        background,
        foreground,
        selectionBackground,
        selectionForeground,
    )
}