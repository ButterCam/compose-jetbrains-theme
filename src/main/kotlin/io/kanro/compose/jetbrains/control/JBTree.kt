package io.kanro.compose.jetbrains.control

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.JBTheme
import io.kanro.compose.jetbrains.SelectionScope
import io.kanro.compose.jetbrains.interaction.hoverable

@Composable
fun JBTreeItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    JBTreeBasicItem(modifier, selected, onClick) {
        Box(Modifier.padding(start = 16.dp)) {
            content()
        }
    }
}

@Composable
fun JBTreeItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    expanded: Boolean,
    expanding: (Boolean) -> Unit,
    content: @Composable () -> Unit,
    children: @Composable () -> Unit,
) {
    JBTreeBasicItem(
        modifier, selected, onClick = onClick,
        onDoubleClick = {
            expanding(!expanded)
            onClick()
        }
    ) {
        Row {
            Icon(
                resource = "jetbrains/AllIcons/actions/arrowExpand.svg",
                modifier = Modifier.size(16.dp).clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    expanding(!expanded)
                    onClick()
                }.graphicsLayer(rotationZ = if (expanded) 90f else 0f).align(Alignment.CenterVertically)
            )
            Box {
                content()
            }
        }
    }
    if (expanded) {
        CompositionLocalProvider(
            LocalTreeLevel provides LocalTreeLevel.current + 1,
            content = children
        )
    }
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
internal fun JBTreeBasicItem(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onClick: () -> Unit,
    onDoubleClick: (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit
) {
    val padding = 7 + (LocalTreeLevel.current - 1) * 18
    Box(
        Modifier.combinedClickable(
            interactionSource,
            indication = ListItemHoverIndication,
            onDoubleClick = onDoubleClick,
            onClick = onClick
        ).then(modifier)
            .height(20.dp)
            .run {
                if (selected) {
                    background(color = JBTheme.selectionColors.active)
                } else {
                    this
                }
            }.hoverable(rememberCoroutineScope(), interactionSource),
    ) {
        SelectionScope(selected) {
            Box(Modifier.padding(start = padding.dp)) {
                content()
            }
        }
    }
}

@Composable
fun JBTreeList(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        content()
    }
}

val LocalTreeLevel: ProvidableCompositionLocal<Int> = compositionLocalOf {
    1
}
