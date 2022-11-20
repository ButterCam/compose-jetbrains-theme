package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.expui.theme.LightTheme

//"ToolWindow.background": "#f7f8fa",
//"ToolWindow.Button.DragAndDrop.buttonDropBackground": "#cfdefc",
//"ToolWindow.Button.DragAndDrop.stripeBackground": "#f7f8fa",
//"ToolWindow.Button.hoverBackground": "#ebecf0",
//"ToolWindow.Button.selectedBackground": "#3573f0",
//"ToolWindow.Button.selectedForeground": "#ffffff",
//"ToolWindow.Header.background": "#f7f8fa",
//"ToolWindow.Header.font.size.offset": "0",
//"ToolWindow.Header.inactiveBackground": "#f7f8fa",
//"ToolWindow.HeaderCloseButton.background": "#f7f8fa",
//"ToolWindow.HeaderTab.hoverBackground": "#ebecf0",
//"ToolWindow.HeaderTab.hoverInactiveBackground": "#ebecf0",
//"ToolWindow.HeaderTab.inactiveUnderlineColor": "#a8adbd",
//"ToolWindow.HeaderTab.leftRightInsets": "com.intellij.util.ui.JBInsets$JBInsetsUIResource[top=0,left=12,bottom=0,right=12]",
//"ToolWindow.HeaderTab.selectedBackground": "#d0d4d8",
//"ToolWindow.HeaderTab.selectedInactiveBackground": "#d9d9d9",
//"ToolWindow.HeaderTab.underlineColor": "#3573f0",
//"ToolWindow.HeaderTab.underlinedTabForeground": "#000000",
//"ToolWindow.HeaderTab.underlinedTabInactiveForeground": "#000000",
class ToolWindowColors(
    background: Color = LightTheme.Colors.Grey12,
    buttonDragAndDropButtonDropBackground: Color = LightTheme.Colors.Blue13,
    buttonDragAndDropStripeBackground: Color = LightTheme.Colors.Grey12,
    buttonHoverBackground: Color = Color.Unspecified,
    buttonSelectedBackground: Color = Color.Unspecified,
    buttonSelectedForeground: Color = Color.Unspecified,
    headerBackground: Color = Color.Unspecified,
    headerInactiveBackground: Color = LightTheme.Colors.Grey12,
    headerCloseButtonBackground: Color = Color.Unspecified,
    headerTabHoverBackground: Color = LightTheme.Colors.Grey11,
    headerTabHoverInactiveBackground: Color = LightTheme.Colors.Grey11,
    headerTabInactiveUnderlineColor: Color = Color.Unspecified,
    headerTabSelectedBackground: Color = Color.Unspecified,
    headerTabSelectedInactiveBackground: Color = Color.Unspecified,
    headerTabUnderlineColor: Color = Color.Unspecified,
    headerTabUnderlinedTabForeground: Color = Color.Unspecified,
    headerTabUnderlinedTabInactiveForeground: Color = Color.Unspecified,
) {
    var background by mutableStateOf(background)
    var buttonDragAndDropButtonDropBackground by mutableStateOf(buttonDragAndDropButtonDropBackground)
    var buttonDragAndDropStripeBackground by mutableStateOf(buttonDragAndDropStripeBackground)
    var buttonHoverBackground by mutableStateOf(buttonHoverBackground)
    var buttonSelectedBackground by mutableStateOf(buttonSelectedBackground)
    var buttonSelectedForeground by mutableStateOf(buttonSelectedForeground)
    var headerBackground by mutableStateOf(headerBackground)
    var headerInactiveBackground by mutableStateOf(headerInactiveBackground)
    var headerCloseButtonBackground by mutableStateOf(headerCloseButtonBackground)
    var headerTabHoverBackground by mutableStateOf(headerTabHoverBackground)
    var headerTabHoverInactiveBackground by mutableStateOf(headerTabHoverInactiveBackground)
    var headerTabInactiveUnderlineColor by mutableStateOf(headerTabInactiveUnderlineColor)
    var headerTabSelectedBackground by mutableStateOf(headerTabSelectedBackground)
    var headerTabSelectedInactiveBackground by mutableStateOf(headerTabSelectedInactiveBackground)
    var headerTabUnderlineColor by mutableStateOf(headerTabUnderlineColor)
    var headerTabUnderlinedTabForeground by mutableStateOf(headerTabUnderlinedTabForeground)
    var headerTabUnderlinedTabInactiveForeground by mutableStateOf(headerTabUnderlinedTabInactiveForeground)

    fun copy(
        background: Color = this.background,
        buttonDragAndDropButtonDropBackground: Color = this.buttonDragAndDropButtonDropBackground,
        buttonDragAndDropStripeBackground: Color = this.buttonDragAndDropStripeBackground,
        buttonHoverBackground: Color = this.buttonHoverBackground,
        buttonSelectedBackground: Color = this.buttonSelectedBackground,
        buttonSelectedForeground: Color = this.buttonSelectedForeground,
        headerBackground: Color = this.headerBackground,
        headerInactiveBackground: Color = this.headerInactiveBackground,
        headerCloseButtonBackground: Color = this.headerCloseButtonBackground,
        headerTabHoverBackground: Color = this.headerTabHoverBackground,
        headerTabHoverInactiveBackground: Color = this.headerTabHoverInactiveBackground,
        headerTabInactiveUnderlineColor: Color = this.headerTabInactiveUnderlineColor,
        headerTabSelectedBackground: Color = this.headerTabSelectedBackground,
        headerTabSelectedInactiveBackground: Color = this.headerTabSelectedInactiveBackground,
        headerTabUnderlineColor: Color = this.headerTabUnderlineColor,
        headerTabUnderlinedTabForeground: Color = this.headerTabUnderlinedTabForeground,
        headerTabUnderlinedTabInactiveForeground: Color = this.headerTabUnderlinedTabInactiveForeground,
    ) = ToolWindowColors(
        background,
        buttonDragAndDropButtonDropBackground,
        buttonDragAndDropStripeBackground,
        buttonHoverBackground,
        buttonSelectedBackground,
        buttonSelectedForeground,
        headerBackground,
        headerInactiveBackground,
        headerCloseButtonBackground,
        headerTabHoverBackground,
        headerTabHoverInactiveBackground,
        headerTabInactiveUnderlineColor,
        headerTabSelectedBackground,
        headerTabSelectedInactiveBackground,
        headerTabUnderlineColor,
        headerTabUnderlinedTabForeground,
        headerTabUnderlinedTabInactiveForeground
    )
}