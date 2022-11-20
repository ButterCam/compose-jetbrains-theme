package io.kanro.compose.jetbrains.expui.control

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.expui.style.AreaColors
import io.kanro.compose.jetbrains.expui.style.AreaProvider
import io.kanro.compose.jetbrains.expui.style.DisabledAreaProvider
import io.kanro.compose.jetbrains.expui.style.FocusAreaProvider
import io.kanro.compose.jetbrains.expui.style.LocalAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalDisabledAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalFocusAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalNormalAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalSelectionAreaColors
import io.kanro.compose.jetbrains.expui.style.SelectionAreaProvider
import io.kanro.compose.jetbrains.expui.theme.LightTheme

class RadioButtonColors(
    override val normalAreaColors: AreaColors,
    override val selectionAreaColors: AreaColors,
    override val focusAreaColors: AreaColors,
    override val disabledAreaColors: AreaColors,
) : AreaProvider, SelectionAreaProvider, FocusAreaProvider, DisabledAreaProvider {
    @Composable
    fun provideArea(enabled: Boolean, focused: Boolean, selected: Boolean, content: @Composable () -> Unit) {
        val currentColors = when {
            !enabled -> disabledAreaColors
            focused -> focusAreaColors
            selected -> selectionAreaColors
            else -> normalAreaColors
        }

        CompositionLocalProvider(
            LocalAreaColors provides currentColors,
            LocalNormalAreaColors provides normalAreaColors,
            LocalSelectionAreaColors provides selectionAreaColors,
            LocalFocusAreaColors provides focusAreaColors,
            LocalDisabledAreaColors provides disabledAreaColors,
            content = content
        )
    }
}

val LocalRadioButtonColors = compositionLocalOf {
    LightTheme.RadioButtonColors
}

@Composable
fun RadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: RadioButtonColors = LocalRadioButtonColors.current,
    content: @Composable RowScope.() -> Unit = {},
) {
    val isFocused = interactionSource.collectIsFocusedAsState()
    colors.provideArea(enabled, isFocused.value, selected) {
        Row(
            modifier = modifier.selectable(
                selected = selected,
                enabled = enabled,
                onClick = onClick,
                interactionSource = interactionSource,
                indication = null,
                role = Role.RadioButton
            ), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            RadioButtonImpl(isFocused.value, selected)
            content()
        }
    }
}

@Composable
private fun RadioButtonImpl(
    isFocused: Boolean,
    selected: Boolean,
) {
    val colors = LocalAreaColors.current
    Canvas(Modifier.wrapContentSize(Alignment.Center).requiredSize(15.dp)) {
        if (isFocused) {
            drawCircle(
                colors.focusColor,
                radius = 9.5.dp.toPx(),
            )
        }
        drawCircle(
            colors.startBorderColor,
            radius = 7.5.dp.toPx(),
        )
        drawCircle(
            colors.startBackground,
            radius = 6.5.dp.toPx(),
        )
        if (selected) {
            drawCircle(
                colors.foreground,
                radius = 2.5.dp.toPx(),
            )
        }
    }
}