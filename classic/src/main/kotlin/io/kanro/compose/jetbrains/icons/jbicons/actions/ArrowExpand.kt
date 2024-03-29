package io.kanro.compose.jetbrains.icons.jbicons.actions

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.icons.jbicons.ActionsGroup

internal val ActionsGroup.ArrowExpand: ImageVector
    get() {
        if (_arrowExpand != null) {
            return _arrowExpand!!
        }
        _arrowExpand = Builder(
            name = "ArrowExpand", defaultWidth = 16.0.dp,
            defaultHeight =
            16.0.dp,
            viewportWidth = 16.0f, viewportHeight = 16.0f
        ).apply {
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF6E6E6E)),
                strokeLineWidth = 2.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveTo(6.0f, 13.0f)
                lineTo(11.0f, 8.0f)
                lineTo(6.0f, 3.0f)
            }
        }
            .build()
        return _arrowExpand!!
    }

private var _arrowExpand: ImageVector? = null
