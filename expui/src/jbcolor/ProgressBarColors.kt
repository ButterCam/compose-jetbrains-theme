package io.kanro.compose.jetbrains.expui.jbcolor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.expui.theme.LightTheme

//"ProgressBar.repaintInterval": "50",
//"ProgressBar.repaintInterval": "50",
//"ProgressBar.border": "com.intellij.ide.ui.laf.darcula.ui.DarculaProgressBarBorder@48598615",
//"ProgressBar.font": "javax.swing.plaf.FontUIResource[family=Inter,name=Inter,style=plain,size=13]",
//"ProgressBar.horizontalSize": "com.intellij.util.ui.JBDimension$JBDimensionUIResource[width=146,height=12]",
//"ProgressBar.cellSpacing": "0",
//"ProgressBar.cellLength": "1",
//"ProgressBar.cycleTime": "800",
//"ProgressBar.cycleTime": "800",
//"ProgressBar.verticalSize": "com.intellij.util.ui.JBDimension$JBDimensionUIResource[width=12,height=146]",

//"ProgressBar.background": "#f7f8fa",
//"ProgressBar.failedColor": "#d64f4f",
//"ProgressBar.failedEndColor": "#fb8f89",
//"ProgressBar.foreground": "#000000",
//"ProgressBar.indeterminateEndColor": "#3573f0",
//"ProgressBar.indeterminateStartColor": "#a0bdf8",
//"ProgressBar.passedColor": "#34b171",
//"ProgressBar.passedEndColor": "#7ee8a5",
//"ProgressBar.progressColor": "#3573f0",
//"ProgressBar.selectionBackground": "#cfdefc",
//"ProgressBar.selectionForeground": "#000000",
//"ProgressBar.trackColor": "#dfe1e5",
class ProgressBarColors(
    background: Color = Color.Unspecified,
    foreground: Color = Color.Unspecified,
    indeterminateEndColor: Color = LightTheme.Colors.Blue6,
    indeterminateStartColor: Color = LightTheme.Colors.Blue11,
    progressColor: Color = LightTheme.Colors.Blue6,
    selectionBackground: Color = Color.Unspecified,
    selectionForeground: Color = Color.Unspecified,
    trackColor: Color = LightTheme.Colors.Grey10,
) {
    var background by mutableStateOf(background)
    var foreground by mutableStateOf(foreground)
    var indeterminateEndColor by mutableStateOf(indeterminateEndColor)
    var indeterminateStartColor by mutableStateOf(indeterminateStartColor)
    var progressColor by mutableStateOf(progressColor)
    var selectionBackground by mutableStateOf(selectionBackground)
    var selectionForeground by mutableStateOf(selectionForeground)
    var trackColor by mutableStateOf(trackColor)

    fun copy(
        background: Color = this.background,
        foreground: Color = this.foreground,
        indeterminateEndColor: Color = this.indeterminateEndColor,
        indeterminateStartColor: Color = this.indeterminateStartColor,
        progressColor: Color = this.progressColor,
        selectionBackground: Color = this.selectionBackground,
        selectionForeground: Color = this.selectionForeground,
        trackColor: Color = this.trackColor,
    ) = ProgressBarColors(
        background,
        foreground,
        indeterminateEndColor,
        indeterminateStartColor,
        progressColor,
        selectionBackground,
        selectionForeground,
        trackColor
    )
}