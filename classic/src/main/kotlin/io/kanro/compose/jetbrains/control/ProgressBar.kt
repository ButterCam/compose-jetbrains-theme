package io.kanro.compose.jetbrains.control

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.JBTheme

@Composable
fun ProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
) {
    val bgColor = JBTheme.progressColors.bg
    val progressColor = JBTheme.progressColors.progress
    Canvas(
        modifier
            .progressSemantics(progress)
            .size(200.dp, 4.dp)
            .focusable()
    ) {
        val strokeWidth = size.height
        val length = size.width

        drawLine(
            bgColor,
            Offset(0f, strokeWidth / 2f),
            Offset(length, strokeWidth / 2f),
            strokeWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            progressColor,
            Offset(0f, strokeWidth / 2f),
            Offset(length * progress, strokeWidth / 2f),
            strokeWidth,
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun ProgressBar(
    modifier: Modifier = Modifier,
) {
    val transition = rememberInfiniteTransition()
    val currentOffset by transition.animateFloat(
        0f,
        1f,
        infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
            }
        )
    )
    val progressColor = JBTheme.progressColors.progress

    Canvas(
        modifier
            .progressSemantics()
            .size(200.dp, 4.dp)
            .focusable()
    ) {
        val strokeWidth = size.height
        val length = size.width
        val offset = currentOffset * 80f
        val brush = Brush.linearGradient(
            listOf(
                Color(0x00FFFFFF), Color(0x7FFFFFFF), Color(0x00FFFFFF)
            ),
            start = Offset(offset, 0f),
            end = Offset(offset + 80f, 0f),
            tileMode = TileMode.Repeated
        )
        drawLine(
            progressColor,
            Offset(0f, strokeWidth / 2f),
            Offset(length, strokeWidth / 2f),
            strokeWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            brush,
            Offset(0f, strokeWidth / 2f),
            Offset(length, strokeWidth / 2f),
            strokeWidth,
            cap = StrokeCap.Round
        )
    }
}
