package io.kanro.compose.jetbrains.control

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import io.kanro.compose.jetbrains.JBTheme

val LocalContentColor = compositionLocalOf { Color.Unspecified }

@Composable
fun JBTheme.contentColorFor(backgroundColor: Color): Color {
    return if ((backgroundColor.green + backgroundColor.blue + backgroundColor.red) / 3.0 > 0.6) {
        textColors.default
    } else {
        textColors.white
    }
}
