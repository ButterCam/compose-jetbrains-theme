package io.kanro.compose.jetbrains.expui.style

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.isUnspecified
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.expui.theme.LightTheme

/**
 * Color definition for an area which has background and foreground.
 */
data class AreaColors(
    /**
     * Text foreground color.
     */
    val text: Color,
    /**
     * Overriding the foreground colour for some components that have their own colour like [Icon][io.kanro.compose.jetbrains.expui.control.Icon].
     */
    val foreground: Color,
    val startBackground: Color,
    val endBackground: Color,
    val startBorderColor: Color,
    val endBorderColor: Color,
    val focusColor: Color,
)

@Composable
fun Modifier.areaBackground(areaColors: AreaColors = LocalAreaColors.current, shape: Shape = RectangleShape): Modifier {
    return background(areaColors, shape)
}

fun Modifier.background(areaColors: AreaColors, shape: Shape = RectangleShape): Modifier {
    if (areaColors.startBackground.isUnspecified) {
        return this
    }
    if (areaColors.endBackground.isUnspecified || areaColors.startBackground == areaColors.endBackground) {
        return this.background(areaColors.startBackground)
    }
    return this.background(Brush.linearGradient(listOf(areaColors.startBackground, areaColors.endBackground)))
}

@Composable
fun Modifier.areaBorder(
    areaColors: AreaColors = LocalAreaColors.current,
    width: Dp = 1.dp,
    shape: Shape = RectangleShape,
): Modifier {
    return border(areaColors, width, shape)
}

fun Modifier.border(areaColors: AreaColors, width: Dp = 1.dp, shape: Shape = RectangleShape): Modifier {
    if (areaColors.startBorderColor.isUnspecified) {
        return this
    }
    if (areaColors.endBorderColor.isUnspecified || areaColors.startBorderColor == areaColors.endBorderColor) {
        return this.border(width, areaColors.startBorderColor, shape)
    }
    return this.border(width, Brush.linearGradient(listOf(areaColors.startBackground, areaColors.endBackground)), shape)
}

@Composable
fun Modifier.areaFocusBorder(
    focused: Boolean,
    areaColors: AreaColors = LocalAreaColors.current,
    width: Dp = 2.dp,
    shape: Shape = RectangleShape,
): Modifier {
    return focusBorder(focused, areaColors, width, shape)
}

fun Modifier.focusBorder(
    focused: Boolean,
    areaColors: AreaColors,
    width: Dp = 2.dp,
    shape: Shape = RectangleShape,
): Modifier {
    if (!focused) return this
    if (areaColors.focusColor.isUnspecified) {
        return this
    }
    return this.outerBorder(width, areaColors.focusColor, shape)
}

val LocalAreaColors = compositionLocalOf {
    LightTheme.NormalAreaColors
}

val LocalNormalAreaColors = compositionLocalOf {
    LightTheme.NormalAreaColors
}

val LocalInactiveAreaColors = compositionLocalOf {
    LightTheme.InactiveAreaColors
}

val LocalErrorAreaColors = compositionLocalOf {
    LightTheme.NormalAreaColors
}

val LocalErrorInactiveAreaColors = compositionLocalOf {
    LightTheme.ErrorInactiveAreaColors
}

val LocalDisabledAreaColors = compositionLocalOf {
    LightTheme.DisabledAreaColors
}

val LocalHoverAreaColors = compositionLocalOf {
    LightTheme.HoverAreaColors
}

val LocalPressedAreaColors = compositionLocalOf {
    LightTheme.PressedAreaColors
}

val LocalFocusAreaColors = compositionLocalOf {
    LightTheme.FocusAreaColors
}

val LocalSelectionAreaColors = compositionLocalOf {
    LightTheme.SelectionAreaColors
}

val LocalSelectionInactiveAreaColors = compositionLocalOf {
    LightTheme.SelectionInactiveAreaColors
}