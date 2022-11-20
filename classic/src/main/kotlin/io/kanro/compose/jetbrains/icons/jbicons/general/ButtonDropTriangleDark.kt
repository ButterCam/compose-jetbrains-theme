package io.kanro.compose.jetbrains.icons.jbicons.general

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import io.kanro.compose.jetbrains.icons.jbicons.GeneralGroup

internal val GeneralGroup.ButtonDropTriangleDark: ImageVector
    get() {
        if (_buttonDropTriangleDark != null) {
            return _buttonDropTriangleDark!!
        }
        _buttonDropTriangleDark = Builder(name = "ButtonDropTriangleDark", defaultWidth = 8.0.dp,
                defaultHeight = 4.0.dp, viewportWidth = 8.0f, viewportHeight = 4.0f).apply {
            path(fill = SolidColor(Color(0xFFAFB1B3)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(4.0f, 4.0f)
                lineToRelative(4.0f, -4.0f)
                lineToRelative(-8.0f, -0.0f)
                close()
            }
        }
        .build()
        return _buttonDropTriangleDark!!
    }

private var _buttonDropTriangleDark: ImageVector? = null
