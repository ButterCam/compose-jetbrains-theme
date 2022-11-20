package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.expui.theme.LightTheme

//"ToolTip.border": "javax.swing.plaf.BorderUIResource$EmptyBorderUIResource@17681914",
//"ToolTip.font": "javax.swing.plaf.FontUIResource[family=Inter,name=Inter,style=plain,size=13]",
//"ToolTipManager.enableToolTipMode": "allWindows",
//"ToolTipUI": "com.apple.laf.AquaToolTipUI",

//"ToolTip.Actions.background": "#f7f8fa",
//"ToolTip.Actions.infoForeground": "#818594",
//"ToolTip.background": "#27282e",
//"ToolTip.borderColor": "#27282e",
//"ToolTip.foreground": "#ffffff",
//"ToolTip.infoForeground": "#a8adbd",
//"ToolTip.linkForeground": "#88adf7",
//"ToolTip.separatorColor": "#ebecf0",
//"ToolTip.shortcutForeground": "#a8adbd",
class ToolTipColors(
    background: Color = LightTheme.Colors.Grey13,
    foreground: Color = LightTheme.Colors.Grey1,
    borderColor: Color = Color.Unspecified,
    infoForeground: Color = Color.Unspecified,
    linkForeground: Color = Color.Unspecified,
    separatorColor: Color = Color.Unspecified,
    shortcutForeground: Color = Color.Unspecified,
    actionsBackground: Color = Color.Unspecified,
    actionsInfoForeground: Color = Color.Unspecified,
) {
    var background by mutableStateOf(background)
    var foreground by mutableStateOf(foreground)
    var borderColor by mutableStateOf(borderColor)
    var infoForeground by mutableStateOf(infoForeground)
    var linkForeground by mutableStateOf(linkForeground)
    var separatorColor by mutableStateOf(separatorColor)
    var shortcutForeground by mutableStateOf(shortcutForeground)
    var actionsBackground by mutableStateOf(actionsBackground)
    var actionsInfoForeground by mutableStateOf(actionsInfoForeground)

    fun copy(
        background: Color = this.background,
        foreground: Color = this.foreground,
        borderColor: Color = this.borderColor,
        infoForeground: Color = this.infoForeground,
        linkForeground: Color = this.linkForeground,
        separatorColor: Color = this.separatorColor,
        shortcutForeground: Color = this.shortcutForeground,
        actionsBackground: Color = this.actionsBackground,
        actionsInfoForeground: Color = this.actionsInfoForeground,
    ) = ToolTipColors(
        background,
        foreground,
        borderColor,
        infoForeground,
        linkForeground,
        separatorColor,
        shortcutForeground,
        actionsBackground,
        actionsInfoForeground
    )
}