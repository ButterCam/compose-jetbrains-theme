package io.kanro.compose.jetbrains.expui.control

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.expui.style.AreaColors
import io.kanro.compose.jetbrains.expui.style.AreaProvider
import io.kanro.compose.jetbrains.expui.style.DisabledAreaProvider
import io.kanro.compose.jetbrains.expui.style.HoverAreaProvider
import io.kanro.compose.jetbrains.expui.style.LocalAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalDisabledAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalHoverAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalNormalAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalPressedAreaColors
import io.kanro.compose.jetbrains.expui.style.PressedAreaProvider
import io.kanro.compose.jetbrains.expui.style.areaBackground
import io.kanro.compose.jetbrains.expui.theme.LightTheme

class ActionButtonColors(
    override val normalAreaColors: AreaColors,
    override val hoverAreaColors: AreaColors,
    override val pressedAreaColors: AreaColors,
    override val disabledAreaColors: AreaColors,
) : AreaProvider, HoverAreaProvider, PressedAreaProvider, DisabledAreaProvider {
    @Composable
    fun provideArea(enabled: Boolean, content: @Composable () -> Unit) {
        CompositionLocalProvider(
            LocalAreaColors provides if (enabled) normalAreaColors else disabledAreaColors,
            LocalNormalAreaColors provides normalAreaColors,
            LocalDisabledAreaColors provides disabledAreaColors,
            LocalHoverAreaColors provides hoverAreaColors,
            LocalPressedAreaColors provides pressedAreaColors,
            content = content
        )
    }
}

val LocalActionButtonColors = compositionLocalOf {
    LightTheme.ActionButtonColors
}

@Composable
fun ActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(6.dp),
    indication: Indication? = HoverOrPressedIndication(shape),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: ActionButtonColors = LocalActionButtonColors.current,
    content: @Composable BoxScope.() -> Unit,
) {
    colors.provideArea(enabled) {
        Box(
            modifier.areaBackground(shape = shape).clickable(
                interactionSource = interactionSource,
                indication = indication,
                enabled = enabled,
                onClick = onClick,
                role = Role.Button
            ),
            propagateMinConstraints = true
        ) {
            content()
        }
    }
}
