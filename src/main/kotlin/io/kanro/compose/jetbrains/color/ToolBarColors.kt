package io.kanro.compose.jetbrains.color

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class ToolBarColors(
    buttonPressed: Color,
    buttonHover: Color,
    iconSplitBorder: Color,
) {
    var buttonPressed by mutableStateOf(buttonPressed)
    var buttonHover by mutableStateOf(buttonHover)
    var iconSplitBorder by mutableStateOf(iconSplitBorder)

    fun copy(
        buttonPressed: Color = this.buttonPressed,
        buttonHover: Color = this.buttonHover,
        iconSplitBorder: Color = this.iconSplitBorder,
    ): ToolBarColors {
        return ToolBarColors(buttonPressed, buttonHover, iconSplitBorder)
    }

    @Composable
    fun actionIconBgColor(interactionSource: InteractionSource): State<Color> {
        val pressed by interactionSource.collectIsPressedAsState()
        val hover by interactionSource.collectIsHoveredAsState()
        val targetValue = when {
            pressed -> buttonPressed
            hover -> buttonHover
            else -> Color.Transparent
        }
        return rememberUpdatedState(targetValue)
    }
}

fun lightToolBarColors(): ToolBarColors {
    return ToolBarColors(
        Color(0xFFCFCFCF),
        Color(0xFFDFDFDF),
        Color(0xFFB3B3B3),
    )
}

fun darkToolbarColors(): ToolBarColors {
    return ToolBarColors(
        Color(0xFF5C6164),
        Color(0xFF4C5052),
        Color(0xFF6B6B6B),
    )
}

val LocalToolBarColors = staticCompositionLocalOf { lightToolBarColors() }
