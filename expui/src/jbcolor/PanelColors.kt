package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

//"Panel.background": "#f7f8fa",
//"Panel.font": "javax.swing.plaf.FontUIResource[family=Inter,name=Inter,style=plain,size=13]",
//"Panel.foreground": "#000000",
//"Panel.mouseShortcutBackground": "#f5f5f5",
//"Panel.opaque": "true",
class PanelColors(
    background: Color = Color.Unspecified,
    foreground: Color = Color.Unspecified,
) {
    var background by mutableStateOf(background)
    var foreground by mutableStateOf(foreground)

    fun copy(
        background: Color = this.background,
        foreground: Color = this.foreground,
    ) = PanelColors(
        background,
        foreground,
    )
}