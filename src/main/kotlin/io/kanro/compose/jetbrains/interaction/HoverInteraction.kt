package io.kanro.compose.jetbrains.interaction

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerMoveFilter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

interface HoverInteraction : Interaction {
    object Enter : HoverInteraction

    object Exit : HoverInteraction
}

@Composable
fun InteractionSource.collectIsHoverAsState(): State<Boolean> {
    val isHover = remember { mutableStateOf(false) }
    LaunchedEffect(this) {
        var hover = false
        interactions.collect { interaction ->
            when (interaction) {
                is HoverInteraction.Enter -> hover = true
                is HoverInteraction.Exit -> hover = false
            }
            isHover.value = hover
        }
    }
    return isHover
}

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.hoverable(
    coroutineScope: CoroutineScope,
    interactionSource: MutableInteractionSource,
    enable: Boolean = true
): Modifier {
    if (!enable) return this
    return pointerMoveFilter(
        onEnter = {
            coroutineScope.launch {
                interactionSource.emit(HoverInteraction.Enter)
            }
            false
        },
        onExit = {
            coroutineScope.launch {
                interactionSource.emit(HoverInteraction.Exit)
            }
            false
        }
    )
}
