package io.kanro.compose.jetbrains.control

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun EmbeddedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RectangleShape,
    style: TextFieldStyle = TextFieldDefaults.textFieldStyle(),
) {
    TextField(
        value,
        onValueChange,
        modifier.embeddedTextFieldIndicator(style.indicatorColor(isError, interactionSource).value, shape, 2.dp),
        enabled,
        readOnly,
        textStyle,
        placeholder,
        leadingIcon,
        trailingIcon,
        isError,
        visualTransformation,
        keyboardOptions,
        keyboardActions,
        singleLine,
        maxLines,
        interactionSource,
        shape,
        InnerStyle(style)
    )
}

private class InnerStyle(val style: TextFieldStyle) : TextFieldStyle {
    @Composable
    override fun textColor(enabled: Boolean, isError: Boolean, interactionSource: InteractionSource): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        return if (focused) style.textColor(
            enabled,
            isError,
            interactionSource
        ) else rememberUpdatedState(Color.Unspecified)
    }

    @Composable
    override fun backgroundColor(enabled: Boolean, interactionSource: InteractionSource): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        return if (focused) style.backgroundColor(
            enabled,
            interactionSource
        ) else rememberUpdatedState(Color.Transparent)
    }

    @Composable
    override fun placeholderColor(enabled: Boolean): State<Color> {
        return style.placeholderColor(enabled)
    }

    @Composable
    override fun borderColor(enabled: Boolean, isError: Boolean, interactionSource: InteractionSource): State<Color> {
        return rememberUpdatedState(Color.Transparent)
    }

    @Composable
    override fun indicatorColor(isError: Boolean, interactionSource: InteractionSource): State<Color> {
        return rememberUpdatedState(Color.Transparent)
    }

    @Composable
    override fun cursorColor(isError: Boolean): State<Color> {
        return style.cursorColor(isError)
    }
}

private fun Modifier.embeddedTextFieldIndicator(color: Color, shape: Shape, width: Dp): Modifier {
    if (color.alpha == 0f) return this
    return drawBehind {
        val controlOutline = shape.createOutline(size, layoutDirection, this)
        val highlightPath = Path().apply {
            this.fillType = PathFillType.EvenOdd
            addOutline(controlOutline)
            addRect(controlOutline.bounds.deflate(width.toPx()))
            close()
        }
        drawPath(highlightPath, color)
    }
}
