package io.kanro.compose.jetbrains

import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.color.ButtonColors
import io.kanro.compose.jetbrains.color.CheckBoxColors
import io.kanro.compose.jetbrains.color.FieldColors
import io.kanro.compose.jetbrains.color.FocusColors
import io.kanro.compose.jetbrains.color.IconColors
import io.kanro.compose.jetbrains.color.LocalButtonColors
import io.kanro.compose.jetbrains.color.LocalCheckBoxColors
import io.kanro.compose.jetbrains.color.LocalFieldColors
import io.kanro.compose.jetbrains.color.LocalFocusColors
import io.kanro.compose.jetbrains.color.LocalIconColors
import io.kanro.compose.jetbrains.color.LocalPanelColors
import io.kanro.compose.jetbrains.color.LocalProgressColors
import io.kanro.compose.jetbrains.color.LocalScrollColors
import io.kanro.compose.jetbrains.color.LocalSelectionColors
import io.kanro.compose.jetbrains.color.LocalTabColors
import io.kanro.compose.jetbrains.color.LocalTextColors
import io.kanro.compose.jetbrains.color.LocalToolBarColors
import io.kanro.compose.jetbrains.color.PanelColors
import io.kanro.compose.jetbrains.color.ProgressColors
import io.kanro.compose.jetbrains.color.ScrollColors
import io.kanro.compose.jetbrains.color.SelectionColors
import io.kanro.compose.jetbrains.color.TabColors
import io.kanro.compose.jetbrains.color.TextColors
import io.kanro.compose.jetbrains.color.ToolBarColors
import io.kanro.compose.jetbrains.color.darkButtonColors
import io.kanro.compose.jetbrains.color.darkCheckBoxColors
import io.kanro.compose.jetbrains.color.darkFieldColors
import io.kanro.compose.jetbrains.color.darkFocusColors
import io.kanro.compose.jetbrains.color.darkIconColors
import io.kanro.compose.jetbrains.color.darkPanelColors
import io.kanro.compose.jetbrains.color.darkProgressColors
import io.kanro.compose.jetbrains.color.darkScrollColors
import io.kanro.compose.jetbrains.color.darkSelectionColors
import io.kanro.compose.jetbrains.color.darkTabColors
import io.kanro.compose.jetbrains.color.darkTextColors
import io.kanro.compose.jetbrains.color.darkToolBarColors
import io.kanro.compose.jetbrains.color.lightButtonColors
import io.kanro.compose.jetbrains.color.lightCheckBoxColors
import io.kanro.compose.jetbrains.color.lightFieldColors
import io.kanro.compose.jetbrains.color.lightFocusColors
import io.kanro.compose.jetbrains.color.lightIconColors
import io.kanro.compose.jetbrains.color.lightPanelColors
import io.kanro.compose.jetbrains.color.lightProgressColors
import io.kanro.compose.jetbrains.color.lightScrollColors
import io.kanro.compose.jetbrains.color.lightSelectionColors
import io.kanro.compose.jetbrains.color.lightTabColors
import io.kanro.compose.jetbrains.color.lightTextColors
import io.kanro.compose.jetbrains.color.lightToolBarColors
import io.kanro.compose.jetbrains.control.LocalContentColor
import io.kanro.compose.jetbrains.control.ProvideTextStyle
import io.kanro.compose.jetbrains.control.darkSelectionScope
import io.kanro.compose.jetbrains.control.lightSelectionScope

@Composable
fun JBTheme(style: JBThemeStyle, content: @Composable () -> Unit) {
    JBTheme(
        style = style,
        buttonColors = if (style == JBThemeStyle.LIGHT) lightButtonColors() else darkButtonColors(),
        fieldColors = if (style == JBThemeStyle.LIGHT) lightFieldColors() else darkFieldColors(),
        focusColors = if (style == JBThemeStyle.LIGHT) lightFocusColors() else darkFocusColors(),
        panelColors = if (style == JBThemeStyle.LIGHT) lightPanelColors() else darkPanelColors(),
        textColors = if (style == JBThemeStyle.LIGHT) lightTextColors() else darkTextColors(),
        toolBarColors = if (style == JBThemeStyle.LIGHT) lightToolBarColors() else darkToolBarColors(),
        progressColors = if (style == JBThemeStyle.LIGHT) lightProgressColors() else darkProgressColors(),
        scrollColors = if (style == JBThemeStyle.LIGHT) lightScrollColors() else darkScrollColors(),
        tabColors = if (style == JBThemeStyle.LIGHT) lightTabColors() else darkTabColors(),
        selectionColors = if (style == JBThemeStyle.LIGHT) lightSelectionColors() else darkSelectionColors(),
        checkBoxColors = if (style == JBThemeStyle.LIGHT) lightCheckBoxColors() else darkCheckBoxColors(),
        iconColors = if (style == JBThemeStyle.LIGHT) lightIconColors() else darkIconColors(),
        typography = JBTypography(),
        iconTheme = if (style == JBThemeStyle.LIGHT) JBThemeStyle.LIGHT else JBThemeStyle.DARK,
        selectionScope = if (style == JBThemeStyle.LIGHT) lightSelectionScope else darkSelectionScope,
        content = content
    )
}

@Composable
fun JBDraculaTheme(content: @Composable () -> Unit) {
    JBTheme(
        style = JBThemeStyle.DARK,
        buttonColors = darkButtonColors(),
        fieldColors = darkFieldColors(),
        focusColors = darkFocusColors(),
        panelColors = darkPanelColors(),
        textColors = darkTextColors(),
        toolBarColors = darkToolBarColors(),
        progressColors = darkProgressColors(),
        scrollColors = darkScrollColors(),
        tabColors = darkTabColors(),
        selectionColors = darkSelectionColors(),
        checkBoxColors = darkCheckBoxColors(),
        iconColors = darkIconColors(),
        typography = JBTypography(),
        iconTheme = JBThemeStyle.DARK,
        selectionScope = darkSelectionScope,
        content = content
    )
}

@Composable
fun JBLightTheme(content: @Composable () -> Unit) {
    JBTheme(content = content)
}

@Composable
fun JBTheme(
    style: JBThemeStyle = JBThemeStyle.LIGHT,
    buttonColors: ButtonColors = lightButtonColors(),
    fieldColors: FieldColors = lightFieldColors(),
    focusColors: FocusColors = lightFocusColors(),
    panelColors: PanelColors = lightPanelColors(),
    textColors: TextColors = lightTextColors(),
    toolBarColors: ToolBarColors = lightToolBarColors(),
    progressColors: ProgressColors = lightProgressColors(),
    scrollColors: ScrollColors = lightScrollColors(),
    tabColors: TabColors = lightTabColors(),
    selectionColors: SelectionColors = lightSelectionColors(),
    checkBoxColors: CheckBoxColors = lightCheckBoxColors(),
    iconColors: IconColors = lightIconColors(),
    typography: JBTypography = JBTypography(),
    iconTheme: JBThemeStyle = JBThemeStyle.LIGHT,
    selectionScope: @Composable () -> Array<ProvidedValue<out Any>> = lightSelectionScope,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalThemeStyle provides style,
        LocalButtonColors provides buttonColors,
        LocalFieldColors provides fieldColors,
        LocalFocusColors provides focusColors,
        LocalPanelColors provides panelColors,
        LocalTextColors provides textColors,
        LocalToolBarColors provides toolBarColors,
        LocalProgressColors provides progressColors,
        LocalScrollColors provides scrollColors,
        LocalTabColors provides tabColors,
        LocalSelectionColors provides selectionColors,
        LocalCheckBoxColors provides checkBoxColors,
        LocalIconColors provides iconColors,
        LocalTypography provides typography,
        LocalIconTheme provides iconTheme,
        LocalContentColor provides Color.Unspecified,
        LocalSelectionScope provides selectionScope,
        LocalScrollbarStyle provides scrollColors.style()
    ) {
        ProvideTextStyle(value = typography.default, content = content)
    }
}

object JBTheme {
    val style: JBThemeStyle
        @Composable @ReadOnlyComposable get() = LocalThemeStyle.current

    val buttonColors: ButtonColors
        @Composable @ReadOnlyComposable get() = LocalButtonColors.current

    val fieldColors: FieldColors
        @Composable @ReadOnlyComposable get() = LocalFieldColors.current

    val focusColors: FocusColors
        @Composable @ReadOnlyComposable get() = LocalFocusColors.current

    val panelColors: PanelColors
        @Composable @ReadOnlyComposable get() = LocalPanelColors.current

    val textColors: TextColors
        @Composable @ReadOnlyComposable get() = LocalTextColors.current

    val toolBarColors: ToolBarColors
        @Composable @ReadOnlyComposable get() = LocalToolBarColors.current

    val progressColors: ProgressColors
        @Composable @ReadOnlyComposable get() = LocalProgressColors.current

    val scrollColors: ScrollColors
        @Composable @ReadOnlyComposable get() = LocalScrollColors.current

    val tabColors: TabColors
        @Composable @ReadOnlyComposable get() = LocalTabColors.current

    val selectionColors: SelectionColors
        @Composable @ReadOnlyComposable get() = LocalSelectionColors.current

    val checkBoxColors: CheckBoxColors
        @Composable @ReadOnlyComposable get() = LocalCheckBoxColors.current

    val iconColors: IconColors
        @Composable @ReadOnlyComposable get() = LocalIconColors.current

    val typography: JBTypography
        @Composable @ReadOnlyComposable get() = LocalTypography.current

    val iconTheme: JBThemeStyle
        @Composable @ReadOnlyComposable get() = LocalIconTheme.current
}

enum class JBThemeStyle {
    LIGHT, DARK
}

val LocalThemeStyle = compositionLocalOf { JBThemeStyle.LIGHT }

val LocalIconTheme = compositionLocalOf { JBThemeStyle.LIGHT }

val LocalSelectionScope = compositionLocalOf<@Composable () -> Array<ProvidedValue<out Any>>> {
    lightSelectionScope
}
