package io.kanro.compose.jetbrains.control

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.triStateToggleable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.JBTheme
import io.kanro.compose.jetbrains.icons.JBIcons
import io.kanro.compose.jetbrains.icons.jbicons.Actions
import io.kanro.compose.jetbrains.icons.jbicons.actions.Checkmark
import io.kanro.compose.jetbrains.icons.jbicons.actions.CheckmarkIndeterminate

@Composable
fun CheckBox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    TriStateCheckbox(
        state = ToggleableState(checked),
        onClick = if (onCheckedChange != null) {
            { onCheckedChange(!checked) }
        } else null,
        interactionSource = interactionSource,
        enabled = enabled,
        modifier = modifier
    )
}

@Composable
fun TriStateCheckbox(
    state: ToggleableState,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val toggleableModifier =
        if (onClick != null) {
            Modifier.triStateToggleable(
                state = state,
                onClick = onClick,
                enabled = enabled,
                role = Role.Checkbox,
                interactionSource = interactionSource,
                indication = null
            )
        } else {
            Modifier
        }

    CheckboxImpl(
        enabled = enabled,
        value = state,
        modifier = modifier
            .then(toggleableModifier),
    )
}

@Composable
private fun CheckboxImpl(
    enabled: Boolean,
    value: ToggleableState,
    modifier: Modifier
) {
    val icon = when (value) {
        ToggleableState.On -> rememberVectorPainter(JBIcons.Actions.Checkmark)
        ToggleableState.Indeterminate -> rememberVectorPainter(JBIcons.Actions.CheckmarkIndeterminate)
        else -> null
    }
    val iconFilter = if (!enabled) {
        ColorFilter.tint(JBTheme.iconColors.disabled, BlendMode.DstIn)
    } else null

    val bg = if (enabled) {
        when (value) {
            ToggleableState.On, ToggleableState.Indeterminate -> JBTheme.checkBoxColors.bgSelected
            ToggleableState.Off -> JBTheme.checkBoxColors.bg
        }
    } else JBTheme.checkBoxColors.bgDisabled

    val border = if (enabled) {
        when (value) {
            ToggleableState.On, ToggleableState.Indeterminate -> JBTheme.checkBoxColors.borderSelected
            ToggleableState.Off -> JBTheme.checkBoxColors.border
        }
    } else JBTheme.checkBoxColors.borderDisabled

    Canvas(modifier.wrapContentSize(Alignment.Center).requiredSize(14.dp)) {
        drawRoundRect(border, cornerRadius = CornerRadius(2.dp.toPx()))
        drawRoundRect(
            bg,
            size = Size(12.dp.toPx(), 12.dp.toPx()),
            topLeft = Offset(1.dp.toPx(), 1.dp.toPx()),
            cornerRadius = CornerRadius(1.dp.toPx())
        )
        if (icon != null) {
            with(icon) {
                14.dp.toPx()
                draw(Size(14.dp.toPx(), 14.dp.toPx()), colorFilter = iconFilter)
            }
        }
    }
}
