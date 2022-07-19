package io.kanro.compose.jetbrains.control

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toolingGraphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.JBThemeStyle
import io.kanro.compose.jetbrains.LocalIconTheme

@Composable
fun Icon(
    resource: String,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null
) {
    Icon(
        themedSvgResource(resource, LocalIconTheme.current), contentDescription, modifier,
        colorFilter = colorFilter,
    )
}

@Composable
fun Icon(
    bitmap: ImageBitmap,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null
) {
    val painter = remember(bitmap) { BitmapPainter(bitmap) }
    Icon(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        colorFilter = colorFilter,
    )
}

@Composable
fun Icon(
    imageVector: ImageVector,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null
) {
    Icon(
        painter = rememberVectorPainter(imageVector),
        contentDescription = contentDescription,
        modifier = modifier,
        colorFilter = colorFilter,
    )
}

@Composable
fun Icon(
    painter: Painter,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null
) {
    val semantics = if (contentDescription != null) {
        Modifier.semantics {
            this.contentDescription = contentDescription
            this.role = Role.Image
        }
    } else {
        Modifier
    }
    Box(
        modifier.toolingGraphicsLayer().defaultSizeFor(painter)
            .paint(
                painter,
                contentScale = ContentScale.None,
                colorFilter = colorFilter
            )
            .then(semantics)
    )
}

@Composable
fun themedSvgResource(resource: String, theme: JBThemeStyle = LocalIconTheme.current): Painter {
    var resource = resource
    if (theme == JBThemeStyle.DARK) {
        if (!resource.endsWith("_dark.svg")) {
            val dark = resource.replace(".svg", "_dark.svg")
            if (Thread.currentThread().contextClassLoader.getResource(dark) != null) {
                resource = dark
            }
        }
    } else {
        if (resource.endsWith("_dark.svg")) {
            val light = resource.replace("_dark.svg", ".svg")
            if (Thread.currentThread().contextClassLoader.getResource(light) != null) {
                resource = light
            }
        }
    }
    return painterResource(resource)
}

private fun Modifier.defaultSizeFor(painter: Painter) =
    this.then(
        if (painter.intrinsicSize == Size.Unspecified || painter.intrinsicSize.isInfinite()) {
            DefaultIconSizeModifier
        } else {
            Modifier
        }
    )

private fun Size.isInfinite() = width.isInfinite() && height.isInfinite()

private val DefaultIconSizeModifier = Modifier.size(16.dp)
