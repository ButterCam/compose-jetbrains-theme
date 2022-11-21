package io.kanro.compose.jetbrains.expui.style

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle
import io.kanro.compose.jetbrains.expui.theme.LightTheme

val LocalTextStyle = compositionLocalOf<TextStyle> {
    LightTheme.DefaultTextStyle
}
