package io.kanro.compose.jetbrains.control

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import io.kanro.compose.jetbrains.JBTheme
import io.kanro.compose.jetbrains.JBThemeStyle
import io.kanro.compose.jetbrains.LocalIconTheme
import io.kanro.compose.jetbrains.LocalSelectionScope
import io.kanro.compose.jetbrains.color.LocalTextColors

val emptySelectionScope = emptyArray<ProvidedValue<out Any>>()

val lightSelectionScope: @Composable () -> Array<ProvidedValue<out Any>> = {
    arrayOf(
        LocalIconTheme provides JBThemeStyle.DARK,
        LocalTextColors provides JBTheme.textColors.copy(
            infoInput = Color.White
        ),
        LocalContentColor provides Color.White,
        LocalContentAlpha provides 1.0f,
        LocalContextMenuRepresentation provides JBContextMenuRepresentation(
            JBTheme.panelColors.bgContent, JBTheme.panelColors.border
        )
    )
}

val darkSelectionScope: @Composable () -> Array<ProvidedValue<out Any>> = {
    arrayOf(
        LocalIconTheme provides JBThemeStyle.DARK,
        LocalTextColors provides JBTheme.textColors.copy(
            infoInput = Color.White
        ),
        LocalContentColor provides Color.White,
        LocalContentAlpha provides 1.0f,
        LocalContextMenuRepresentation provides JBContextMenuRepresentation(
            JBTheme.panelColors.bgContent, JBTheme.panelColors.border
        )
    )
}

@Composable
fun SelectionScope(selected: Boolean, block: @Composable () -> Unit) {
    CompositionLocalProvider(* if (selected) LocalSelectionScope.current() else emptySelectionScope) {
        block()
    }
}

@Composable
fun SelectionRow(
    selected: Boolean,
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    role: Role? = null,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit,
) {
    SelectionScope(selected) {
        val selectedColor = JBTheme.selectionColors.active
        Row(
            modifier = modifier.background(color = JBTheme.panelColors.bgContent).selectable(
                selected = selected,
                interactionSource = interactionSource,
                indication = ListItemHoverIndication,
                onClick = onClick,
                role = role
            ).drawWithContent {
                if (selected) {
                    drawRect(selectedColor, size = size)
                }
                drawContent()
            },
            horizontalArrangement = horizontalArrangement, verticalAlignment = verticalAlignment, content = content
        )
    }
}
