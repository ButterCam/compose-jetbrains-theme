package io.kanro.compose.jetbrains.expui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf

val LocalIsDarkTheme = compositionLocalOf { false }

interface Theme {
    val isDark: Boolean

    @Composable
    fun provide(content: @Composable () -> Unit)
}