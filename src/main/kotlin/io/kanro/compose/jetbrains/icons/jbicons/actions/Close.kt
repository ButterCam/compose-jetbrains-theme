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

internal val ActionsGroup.Close: ImageVector
    get() {
        if (_close != null) {
            return _close!!
        }
        _close = Builder(name = "Close", defaultWidth = 16.0.dp, defaultHeight = 16.0.dp,
                viewportWidth = 16.0f, viewportHeight = 16.0f).apply {
            path(fill = SolidColor(Color(0xFF7F8B91)), stroke = null, fillAlpha = 0.5f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(7.9949f, 8.7051f)
                lineTo(4.8541f, 11.8541f)
                lineTo(4.147f, 11.147f)
                lineTo(7.2949f, 8.0051f)
                lineTo(4.147f, 4.8571f)
                lineTo(4.8541f, 4.15f)
                lineTo(8.002f, 7.298f)
                lineTo(11.144f, 4.15f)
                lineTo(11.8511f, 4.8571f)
                lineTo(8.702f, 7.998f)
                lineTo(11.8511f, 11.147f)
                lineTo(11.144f, 11.8541f)
                lineTo(7.9949f, 8.7051f)
                close()
            }
        }
        .build()
        return _close!!
    }

private var _close: ImageVector? = null
