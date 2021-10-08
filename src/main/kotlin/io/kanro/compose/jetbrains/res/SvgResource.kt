package io.kanro.compose.jetbrains.res

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import io.kanro.compose.jetbrains.JBIconTheme
import io.kanro.compose.jetbrains.LocalIconTheme

@Composable
fun themedSvgResource(resource: String, theme: JBIconTheme = LocalIconTheme.current): Painter {
    var resource = resource
    if (theme == JBIconTheme.DARK) {
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
