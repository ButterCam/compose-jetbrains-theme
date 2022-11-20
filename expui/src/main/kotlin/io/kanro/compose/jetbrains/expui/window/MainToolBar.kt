package io.kanro.compose.jetbrains.expui.window

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import io.kanro.compose.jetbrains.expui.control.ActionButtonColors
import io.kanro.compose.jetbrains.expui.control.LocalActionButtonColors
import io.kanro.compose.jetbrains.expui.style.AreaColors
import io.kanro.compose.jetbrains.expui.style.AreaProvider
import io.kanro.compose.jetbrains.expui.style.InactiveAreaProvider
import io.kanro.compose.jetbrains.expui.style.LocalAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalInactiveAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalNormalAreaColors
import io.kanro.compose.jetbrains.expui.theme.LightTheme
import io.kanro.compose.jetbrains.expui.theme.LocalIsDarkTheme

data class MainToolBarColors(
    val isDark: Boolean,
    override val normalAreaColors: AreaColors,
    override val inactiveAreaColors: AreaColors,
    val actionButtonColors: ActionButtonColors,
) : AreaProvider, InactiveAreaProvider {
    @Composable
    fun provideArea(isActive: Boolean, content: @Composable () -> Unit) {
        val currentColors = if (isActive) normalAreaColors else inactiveAreaColors
        CompositionLocalProvider(
            LocalAreaColors provides currentColors,
            LocalNormalAreaColors provides normalAreaColors,
            LocalInactiveAreaColors provides inactiveAreaColors,
            LocalActionButtonColors provides actionButtonColors,
            LocalIsDarkTheme provides isDark,
            content = content
        )
    }
}

val LocalMainToolBarColors = compositionLocalOf {
    LightTheme.MainToolBarColors
}