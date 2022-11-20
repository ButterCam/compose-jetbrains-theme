package io.kanro.compose.jetbrains.icons.jbicons.actions

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.icons.jbicons.ActionsGroup

internal val ActionsGroup.Checkmark: ImageVector
    get() {
        if (_checkmark != null) {
            return _checkmark!!
        }
        _checkmark = Builder(name = "Checkmark", defaultWidth = 14.0.dp, defaultHeight = 14.0.dp,
                viewportWidth = 14.0f, viewportHeight = 14.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(5.625f, 8.4267f)
                lineTo(9.5566f, 2.9336f)
                curveTo(9.5566f, 2.9336f, 10.1737f, 2.3242f, 10.8612f, 2.8242f)
                curveTo(11.4433f, 3.3867f, 10.998f, 4.0938f, 10.998f, 4.0938f)
                lineTo(6.3183f, 10.6445f)
                curveTo(6.3183f, 10.6445f, 5.9941f, 11.0f, 5.5839f, 11.0f)
                curveTo(5.1737f, 11.0f, 4.873f, 10.6445f, 4.873f, 10.6445f)
                lineTo(2.9394f, 7.7461f)
                curveTo(2.9394f, 7.7461f, 2.5683f, 6.9805f, 3.2558f, 6.4609f)
                curveTo(4.0605f, 6.0781f, 4.5605f, 6.8394f, 4.5605f, 6.8394f)
                lineTo(5.625f, 8.4267f)
                close()
            }
        }
        .build()
        return _checkmark!!
    }

private var _checkmark: ImageVector? = null
