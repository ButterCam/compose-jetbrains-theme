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

internal val ActionsGroup.CheckmarkIndeterminate: ImageVector
    get() {
        if (_checkmarkIndeterminate != null) {
            return _checkmarkIndeterminate!!
        }
        _checkmarkIndeterminate = Builder(name = "CheckmarkIndeterminate", defaultWidth = 14.0.dp,
                defaultHeight = 14.0.dp, viewportWidth = 14.0f, viewportHeight = 14.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(3.7402f, 5.73f)
                lineTo(10.1402f, 5.73f)
                arcTo(1.0f, 1.0f, 0.0f, false, true, 11.1402f, 6.73f)
                lineTo(11.1402f, 7.23f)
                arcTo(1.0f, 1.0f, 0.0f, false, true, 10.1402f, 8.23f)
                lineTo(3.7402f, 8.23f)
                arcTo(1.0f, 1.0f, 0.0f, false, true, 2.7402f, 7.23f)
                lineTo(2.7402f, 6.73f)
                arcTo(1.0f, 1.0f, 0.0f, false, true, 3.7402f, 5.73f)
                close()
            }
        }
        .build()
        return _checkmarkIndeterminate!!
    }

private var _checkmarkIndeterminate: ImageVector? = null
