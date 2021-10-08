package io.kanro.compose.jetbrains.control

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.JBTheme

@Composable
fun JBToolBar(orientation: Orientation, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalToolBarOrientation provides orientation,
    ) {
        when (orientation) {
            Orientation.Vertical -> JBToolBarColumn(modifier.width(28.dp), content)
            Orientation.Horizontal -> JBToolBarRow(modifier.height(28.dp), content)
        }
    }
}

@Composable
private fun JBToolBarColumn(modifier: Modifier, content: @Composable () -> Unit) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        content()
    }
}

@Composable
private fun JBToolBarRow(modifier: Modifier, content: @Composable () -> Unit) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        content()
    }
}

val LocalToolBarOrientation = compositionLocalOf { Orientation.Horizontal }

@Composable
fun ToolBarSeparator(modifier: Modifier = Modifier, color: Color = JBTheme.toolBarColors.iconSplitBorder) {
    val orientation = LocalToolBarOrientation.current
    Spacer(
        modifier = modifier.run {
            when (orientation) {
                Orientation.Vertical -> size(20.dp, 1.dp)
                Orientation.Horizontal -> size(1.dp, 20.dp)
            }
        }.background(color)
    )
}
