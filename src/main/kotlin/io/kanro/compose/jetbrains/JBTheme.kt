package io.kanro.compose.jetbrains

import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
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
import io.kanro.compose.jetbrains.control.LocalContentAlpha
import io.kanro.compose.jetbrains.control.LocalContentColor
import io.kanro.compose.jetbrains.control.ProvideTextStyle

@Composable
fun JBTheme(
    buttonColors: ButtonColors = JBTheme.buttonColors,
    fieldColors: FieldColors = JBTheme.fieldColors,
    focusColors: FocusColors = JBTheme.focusColors,
    panelColors: PanelColors = JBTheme.panelColors,
    textColors: TextColors = JBTheme.textColors,
    toolBarColors: ToolBarColors = JBTheme.toolBarColors,
    progressColors: ProgressColors = JBTheme.progressColors,
    scrollColors: ScrollColors = JBTheme.scrollColors,
    tabColors: TabColors = JBTheme.tabColors,
    selectionColors: SelectionColors = JBTheme.selectionColors,
    checkBoxColors: CheckBoxColors = JBTheme.checkBoxColors,
    iconColors: IconColors = JBTheme.iconColors,
    typography: JBTypography = JBTheme.typography,
    iconTheme: JBIconTheme = JBTheme.iconTheme,
    selectionScope: @Composable (@Composable () -> Unit) -> Unit = LocalSelectionScope.current,
    content: @Composable () -> Unit
) {
    val rememberedButtonColors = remember { buttonColors.copy() }
    val rememberedFieldColors = remember { fieldColors.copy() }
    val rememberedFocusColors = remember { focusColors.copy() }
    val rememberedPanelColors = remember { panelColors.copy() }
    val rememberedTextColors = remember { textColors.copy() }
    val rememberedToolBarColors = remember { toolBarColors.copy() }
    val rememberedProgressColors = remember { progressColors.copy() }
    val rememberedScrollColors = remember { scrollColors.copy() }
    val rememberedTabColors = remember { tabColors.copy() }
    val rememberedSelectionColors = remember { selectionColors.copy() }
    val rememberedCheckBoxColors = remember { checkBoxColors.copy() }
    val rememberedIconColors = remember { iconColors.copy() }
    CompositionLocalProvider(
        LocalButtonColors provides rememberedButtonColors,
        LocalFieldColors provides rememberedFieldColors,
        LocalFocusColors provides rememberedFocusColors,
        LocalPanelColors provides rememberedPanelColors,
        LocalTextColors provides rememberedTextColors,
        LocalToolBarColors provides rememberedToolBarColors,
        LocalProgressColors provides rememberedProgressColors,
        LocalScrollColors provides rememberedScrollColors,
        LocalTabColors provides rememberedTabColors,
        LocalSelectionColors provides rememberedSelectionColors,
        LocalCheckBoxColors provides rememberedCheckBoxColors,
        LocalIconColors provides rememberedIconColors,
        LocalTypography provides typography,
        LocalIconTheme provides iconTheme,
        LocalSelectionScope provides selectionScope,
        LocalScrollbarStyle provides rememberedScrollColors.style()
    ) {
        ProvideTextStyle(value = typography.default, content = content)
    }
}

object JBTheme {
    val buttonColors: ButtonColors
        @Composable
        @ReadOnlyComposable
        get() = LocalButtonColors.current

    val fieldColors: FieldColors
        @Composable
        @ReadOnlyComposable
        get() = LocalFieldColors.current

    val focusColors: FocusColors
        @Composable
        @ReadOnlyComposable
        get() = LocalFocusColors.current

    val panelColors: PanelColors
        @Composable
        @ReadOnlyComposable
        get() = LocalPanelColors.current

    val textColors: TextColors
        @Composable
        @ReadOnlyComposable
        get() = LocalTextColors.current

    val toolBarColors: ToolBarColors
        @Composable
        @ReadOnlyComposable
        get() = LocalToolBarColors.current

    val progressColors: ProgressColors
        @Composable
        @ReadOnlyComposable
        get() = LocalProgressColors.current

    val scrollColors: ScrollColors
        @Composable
        @ReadOnlyComposable
        get() = LocalScrollColors.current

    val tabColors: TabColors
        @Composable
        @ReadOnlyComposable
        get() = LocalTabColors.current

    val selectionColors: SelectionColors
        @Composable
        @ReadOnlyComposable
        get() = LocalSelectionColors.current

    val checkBoxColors: CheckBoxColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCheckBoxColors.current

    val iconColors: IconColors
        @Composable
        @ReadOnlyComposable
        get() = LocalIconColors.current

    val typography: JBTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val iconTheme: JBIconTheme
        @Composable
        @ReadOnlyComposable
        get() = LocalIconTheme.current
}

enum class JBIconTheme {
    LIGHT, DARK
}

val LocalIconTheme = compositionLocalOf { JBIconTheme.LIGHT }

val LocalSelectionScope = compositionLocalOf<@Composable (@Composable () -> Unit) -> Unit> {
    {
        CompositionLocalProvider(
            LocalIconTheme provides JBIconTheme.DARK,
            LocalTextColors provides JBTheme.textColors.copy(
                infoInput = Color.White
            ),
            LocalContentColor provides Color.White,
            LocalContentAlpha provides 1.0f,
            content = it
        )
    }
}

@Composable
fun SelectionScope(selected: Boolean, block: @Composable () -> Unit) {
    if (selected) {
        LocalSelectionScope.current(block)
    } else {
        block()
    }
}
