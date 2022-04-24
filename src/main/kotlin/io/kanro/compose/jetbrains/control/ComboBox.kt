package io.kanro.compose.jetbrains.control

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.JBIconTheme
import io.kanro.compose.jetbrains.LocalIconTheme
import io.kanro.compose.jetbrains.icons.JBIcons
import io.kanro.compose.jetbrains.icons.jbicons.General
import io.kanro.compose.jetbrains.icons.jbicons.general.ButtonDropTriangle
import io.kanro.compose.jetbrains.icons.jbicons.general.ButtonDropTriangleDark

@Composable
fun <T> DropdownList(
    items: List<T>,
    value: T,
    onValueChange: ((T) -> Unit)? = null,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRender: (T) -> String = { it.toString() },
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: TextFieldStyle = TextFieldDefaults.textFieldStyle()
) {
    val shape = RoundedCornerShape(3.dp)
    val focusRequester = remember { FocusRequester() }
    val coroutineScope = rememberCoroutineScope()
    val expanded = remember { mutableStateOf(false) }

    Box(
        modifier.border(1.dp, style.borderColor(enabled, false, interactionSource).value, shape)
            .height(24.dp)
            .background(style.backgroundColor(enabled, interactionSource).value)
            .focusable(enabled, interactionSource)
            .focusRequester(focusRequester)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = {
                    expanded.value = true
                    focusRequester.requestFocus()
                }
            )
            .comboBoxIndicator(style.indicatorColor(false, interactionSource).value, shape, 2.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(Modifier.width(6.dp))
            Text(
                valueRender(value),
                Modifier.defaultMinSize(50.dp),
                color = style.textColor(enabled, false, interactionSource).value
            )
            Spacer(Modifier.width(1.dp).fillMaxHeight())
            Box(Modifier.size(22.dp), contentAlignment = Alignment.Center) {
                val isDarkTheme = LocalIconTheme.current == JBIconTheme.DARK
                Icon(
                    imageVector = if(isDarkTheme)
                        JBIcons.General.ButtonDropTriangleDark
                    else JBIcons.General.ButtonDropTriangle
                )
            }
        }

        DropdownMenu(
            expanded.value,
            offset = DpOffset(0.dp, 4.dp),
            onDismissRequest = {
                expanded.value = false
            }
        ) {
            items.forEach {
                DropdownMenuItem(
                    modifier = Modifier.defaultMinSize(79.dp, 21.dp),
                    onClick = {
                        expanded.value = false
                        onValueChange?.invoke(it)
                    },
                    enabled = enabled
                ) {
                    Text(valueRender(it), Modifier.padding(horizontal = 6.dp))
                }
            }
        }
    }
}

private fun Modifier.comboBoxIndicator(color: Color, shape: Shape, width: Dp): Modifier {
    if (color.alpha == 0f) return this
    return drawBehind {
        val controlOutline = shape.createOutline(size, layoutDirection, this)
        val highlightPath = Path().apply {
            this.fillType = PathFillType.EvenOdd
            addOutline(controlOutline)
            val borderRect = controlOutline.bounds.inflate(width.toPx())
            addRoundRect(RoundRect(borderRect, 4.dp.toPx(), 4.dp.toPx()))
            close()
        }
        drawPath(highlightPath, color)
    }
}
