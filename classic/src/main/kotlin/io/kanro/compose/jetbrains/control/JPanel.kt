package io.kanro.compose.jetbrains.control

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.JBTheme

@Composable
fun JPanel(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(modifier.background(JBTheme.panelColors.bgDialog)) {
        content()
    }
}

@Composable
fun JPanelBorder(modifier: Modifier = Modifier) {
    Spacer(modifier.background(JBTheme.panelColors.border))
}

fun Modifier.jBorder(all: Dp = 0.dp, color: Color): Modifier {
    return jBorder(all, all, all, all, color)
}

fun Modifier.jBorder(
    horizontal: Dp = 0.dp,
    vertical: Dp = 0.dp,
    color: Color,
): Modifier {
    return jBorder(horizontal, horizontal, vertical, vertical, color)
}

fun Modifier.jBorder(
    start: Dp = 0.dp,
    end: Dp = 0.dp,
    top: Dp = 0.dp,
    bottom: Dp = 0.dp,
    color: Color,
): Modifier {
    return drawWithCache {
        onDrawWithContent {
            drawContent()
            var rect = Rect(Offset.Zero, size)

            if (start.roundToPx() > 0) {
                drawRect(color, rect.topLeft, Size(start.toPx(), rect.height))
                rect = Rect(rect.left + start.roundToPx(), rect.top, rect.right, rect.bottom)
            }

            if (end.roundToPx() > 0) {
                drawRect(color, Offset(rect.right - end.toPx(), rect.top), Size(end.toPx(), rect.height))
                rect = Rect(rect.left, rect.top, rect.right - end.roundToPx(), rect.bottom)
            }

            if (top.roundToPx() > 0) {
                drawRect(color, rect.topLeft, Size(rect.width, top.toPx()))
                rect = Rect(rect.left, rect.top + top.roundToPx(), rect.right, rect.bottom)
            }

            if (bottom.roundToPx() > 0) {
                drawRect(color, Offset(rect.left, rect.bottom - bottom.toPx()), Size(rect.width, bottom.toPx()))
            }
        }
    }
}
