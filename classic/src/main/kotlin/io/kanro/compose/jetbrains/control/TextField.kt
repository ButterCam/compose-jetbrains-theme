package io.kanro.compose.jetbrains.control

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import io.kanro.compose.jetbrains.JBTheme
import kotlin.math.max
import kotlin.math.roundToInt

@Stable
interface TextFieldStyle {
    @Composable
    fun textColor(enabled: Boolean, isError: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun backgroundColor(enabled: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun placeholderColor(enabled: Boolean): State<Color>

    @Composable
    fun borderColor(enabled: Boolean, isError: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun indicatorColor(isError: Boolean, interactionSource: InteractionSource): State<Color>

    @Composable
    fun cursorColor(isError: Boolean): State<Color>
}

private data class DefaultTextFieldStyle(
    private val textColor: Color,
    private val disabledTextColor: Color,
    private val errorTextColor: Color,
    private val backgroundColor: Color,
    private val disabledBackgroundColor: Color,
    private val placeholderColor: Color,
    private val disabledPlaceholderColor: Color,
    private val borderColor: Color,
    private val disabledBorderColor: Color,
    private val errorBorderColor: Color,
    private val focusedBorderColor: Color,
    private val indicatorColor: Color,
    private val errorIndicatorColor: Color,
    private val cursorColor: Color,
    private val errorCursorColor: Color,
) : TextFieldStyle {
    @Composable
    override fun textColor(enabled: Boolean, isError: Boolean, interactionSource: InteractionSource): State<Color> {
        return rememberUpdatedState(
            when {
                !enabled -> disabledTextColor
                isError -> errorTextColor
                else -> textColor
            }
        )
    }

    @Composable
    override fun backgroundColor(enabled: Boolean, interactionSource: InteractionSource): State<Color> {
        return rememberUpdatedState(if (enabled) backgroundColor else disabledBackgroundColor)
    }

    @Composable
    override fun placeholderColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) placeholderColor else disabledPlaceholderColor)
    }

    @Composable
    override fun borderColor(enabled: Boolean, isError: Boolean, interactionSource: InteractionSource): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            !enabled -> disabledBorderColor
            isError -> errorBorderColor
            focused -> focusedBorderColor
            else -> borderColor
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    override fun indicatorColor(
        isError: Boolean,
        interactionSource: InteractionSource,
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        val targetValue = when {
            isError -> errorIndicatorColor
            focused -> indicatorColor
            else -> Color.Transparent
        }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    override fun cursorColor(isError: Boolean): State<Color> {
        return rememberUpdatedState(if (isError) errorCursorColor else cursorColor)
    }
}

@Composable
fun TextField(
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
    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = value)) }
    val textFieldValue = textFieldValueState.copy(text = value)

    TextField(
        enabled = enabled,
        readOnly = readOnly,
        value = textFieldValue,
        onValueChange = {
            textFieldValueState = it
            if (value != it.text) {
                onValueChange(it.text)
            }
        },
        modifier = modifier,
        singleLine = singleLine,
        textStyle = textStyle,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = shape,
        style = style
    )
}

@Composable
fun TextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
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
    val textColor = textStyle.color.takeOrElse {
        style.textColor(enabled, isError, interactionSource).value
    }.takeOrElse {
        LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
    }
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))

    val transformedText = remember(value.annotatedString, visualTransformation) {
        visualTransformation.filter(value.annotatedString)
    }.text

    val decoratedPlaceholder: @Composable ((Modifier) -> Unit)? =
        if (placeholder != null && transformedText.isEmpty()) {
            @Composable { _ ->
                Box {
                    Decoration(
                        contentColor = style.placeholderColor(enabled).value,
                        content = placeholder,
                        typography = JBTheme.typography.default
                    )
                }
            }
        } else null

    TextFieldLayout(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        textStyle = mergedTextStyle,
        singleLine = singleLine,
        maxLines = maxLines,
        visualTransformation = visualTransformation,
        interactionSource = interactionSource,
        decoratedPlaceholder = decoratedPlaceholder,
        leading = leadingIcon,
        trailing = trailingIcon,
        borderWidth = 1.dp,
        borderColor = style.borderColor(enabled, isError, interactionSource).value,
        indicatorWidth = 2.dp,
        indicatorColor = style.indicatorColor(isError, interactionSource).value,
        shape = shape,
        backgroundColor = style.backgroundColor(enabled, interactionSource).value,
        cursorColor = style.cursorColor(isError).value
    )
}

@Composable
internal fun TextFieldLayout(
    modifier: Modifier,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    enabled: Boolean,
    readOnly: Boolean,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    textStyle: TextStyle,
    singleLine: Boolean,
    maxLines: Int = Int.MAX_VALUE,
    visualTransformation: VisualTransformation,
    interactionSource: MutableInteractionSource,
    decoratedPlaceholder: @Composable ((Modifier) -> Unit)?,
    leading: @Composable (() -> Unit)?,
    trailing: @Composable (() -> Unit)?,
    borderWidth: Dp,
    borderColor: Color,
    indicatorWidth: Dp,
    indicatorColor: Color,
    cursorColor: Color,
    backgroundColor: Color,
    shape: Shape,
) {
    BasicTextField(
        value = value,
        modifier = Modifier
            .defaultMinSize(
                minWidth = TextFieldDefaults.MinWidth,
                minHeight = TextFieldDefaults.MinHeight
            )
            .background(backgroundColor, shape)
            .then(modifier),
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        cursorBrush = SolidColor(cursorColor),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        interactionSource = interactionSource,
        singleLine = singleLine,
        maxLines = maxLines,
        decorationBox = @Composable { coreTextField ->
            // places leading icon, input field, label, placeholder, trailing icon
            IconsWithTextFieldLayout(
                textField = coreTextField,
                leading = leading,
                trailing = trailing,
                singleLine = singleLine,
                placeholder = decoratedPlaceholder,
                shape = shape,
                borderWidth = borderWidth,
                borderColor = borderColor,
                indicatorWidth = indicatorWidth,
                indicatorColor = indicatorColor,
            )
        }
    )
}

private fun Modifier.textFieldIndicator(color: Color, shape: Shape, width: Dp, cornerRadius: Dp): Modifier {
    if (color.alpha == 0f) return this
    return drawBehind {
        val controlOutline = shape.createOutline(size, layoutDirection, this)
        val highlightOutline = RoundRect(controlOutline.bounds.inflate(width.toPx()), CornerRadius(cornerRadius.toPx()))
        val highlightPath = Path().apply {
            this.fillType = PathFillType.EvenOdd
            addRoundRect(highlightOutline)
            addOutline(controlOutline)
            close()
        }
        drawPath(highlightPath, color)
    }
}

@Composable
private fun IconsWithTextFieldLayout(
    textField: @Composable () -> Unit,
    placeholder: @Composable ((Modifier) -> Unit)?,
    leading: @Composable (() -> Unit)?,
    trailing: @Composable (() -> Unit)?,
    singleLine: Boolean,
    shape: Shape,
    borderWidth: Dp,
    borderColor: Color,
    indicatorWidth: Dp,
    indicatorColor: Color,
) {
    Layout(
        content = {
            Box(
                Modifier
                    .layoutId("border")
                    .border(
                        width = borderWidth,
                        color = borderColor,
                        shape = shape
                    )
                    .textFieldIndicator(
                        width = indicatorWidth,
                        color = indicatorColor,
                        shape = shape,
                        cornerRadius = 4.dp
                    )
            )

            if (leading != null) {
                Box(
                    modifier = Modifier.layoutId(LeadingId).then(IconDefaultSizeModifier)
                        .padding(start = HorizontalIconPadding),
                    contentAlignment = Alignment.Center
                ) {
                    leading()
                }
            }
            if (trailing != null) {
                Box(
                    modifier = Modifier.layoutId(TrailingId).then(IconDefaultSizeModifier)
                        .padding(end = HorizontalIconPadding),
                    contentAlignment = Alignment.Center
                ) {
                    trailing()
                }
            }
            val padding = Modifier.padding(
                start = HorizontalTextFieldPadding,
                end = HorizontalTextFieldPadding
            )
            if (placeholder != null) {
                placeholder(Modifier.layoutId(PlaceholderId).then(padding))
            }

            Box(
                modifier = Modifier.layoutId(TextFieldId).then(padding),
                propagateMinConstraints = true
            ) {
                textField()
            }
        }
    ) { measurables, incomingConstraints ->
        // used to calculate the constraints for measuring elements that will be placed in a row
        var occupiedSpaceHorizontally = 0
        val bottomPadding = VerticalTextFieldPadding.roundToPx()

        // measure leading icon
        val constraints =
            incomingConstraints.copy(minWidth = 0, minHeight = 0)
        val leadingPlaceable = measurables.find { it.layoutId == LeadingId }?.measure(constraints)
        occupiedSpaceHorizontally += widthOrZero(
            leadingPlaceable
        )

        // measure trailing icon
        val trailingPlaceable = measurables.find { it.layoutId == TrailingId }
            ?.measure(constraints.offset(horizontal = -occupiedSpaceHorizontally))
        occupiedSpaceHorizontally += widthOrZero(
            trailingPlaceable
        )

        // measure label
        constraints.offset(
            horizontal = -occupiedSpaceHorizontally,
            vertical = -bottomPadding
        )

        // measure text field
        // on top we offset either by default padding or by label's half height if its too big
        // minWidth must not be set to 0 due to how foundation TextField treats zero minWidth
        val topPadding = bottomPadding
        val textConstraints = incomingConstraints.offset(
            horizontal = -occupiedSpaceHorizontally,
            vertical = -bottomPadding - topPadding
        ).copy(minHeight = 0)
        val textFieldPlaceable =
            measurables.first { it.layoutId == TextFieldId }.measure(textConstraints)

        // measure placeholder
        val placeholderConstraints = textConstraints.copy(minWidth = 0)
        val placeholderPlaceable =
            measurables.find { it.layoutId == PlaceholderId }?.measure(placeholderConstraints)

        val width =
            calculateWidth(
                leadingPlaceable,
                trailingPlaceable,
                textFieldPlaceable,
                placeholderPlaceable,
                incomingConstraints
            )
        val height =
            calculateHeight(
                leadingPlaceable,
                trailingPlaceable,
                textFieldPlaceable,
                placeholderPlaceable,
                incomingConstraints,
                density
            )

        val borderPlaceable = measurables.first { it.layoutId == "border" }.measure(
            Constraints(
                minWidth = if (width != Constraints.Infinity) width else 0,
                maxWidth = width,
                minHeight = if (height != Constraints.Infinity) height else 0,
                maxHeight = height
            )
        )
        layout(width, height) {
            place(
                height,
                width,
                leadingPlaceable,
                trailingPlaceable,
                textFieldPlaceable,
                placeholderPlaceable,
                borderPlaceable,
                singleLine,
                density
            )
        }
    }
}

private fun calculateWidth(
    leadingPlaceable: Placeable?,
    trailingPlaceable: Placeable?,
    textFieldPlaceable: Placeable,
    placeholderPlaceable: Placeable?,
    constraints: Constraints,
): Int {
    val middleSection = maxOf(
        textFieldPlaceable.width,
        widthOrZero(placeholderPlaceable)
    )
    val wrappedWidth =
        widthOrZero(leadingPlaceable) + middleSection + widthOrZero(
            trailingPlaceable
        )
    return max(wrappedWidth, constraints.minWidth)
}

private fun calculateHeight(
    leadingPlaceable: Placeable?,
    trailingPlaceable: Placeable?,
    textFieldPlaceable: Placeable,
    placeholderPlaceable: Placeable?,
    constraints: Constraints,
    density: Float,
): Int {
    // middle section is defined as a height of the text field or placeholder ( whichever is
    // taller) plus 16.dp or half height of the label if it is taller, given that the label
    // is vertically centered to the top edge of the resulting text field's container
    val inputFieldHeight = max(
        textFieldPlaceable.height,
        heightOrZero(placeholderPlaceable)
    )
    val topBottomPadding = VerticalTextFieldPadding.value * density
    val middleSectionHeight = inputFieldHeight + topBottomPadding + topBottomPadding
    return max(
        constraints.minHeight,
        maxOf(
            heightOrZero(leadingPlaceable),
            heightOrZero(trailingPlaceable),
            middleSectionHeight.roundToInt()
        )
    )
}

private fun Placeable.PlacementScope.place(
    height: Int,
    width: Int,
    leadingPlaceable: Placeable?,
    trailingPlaceable: Placeable?,
    textFieldPlaceable: Placeable,
    placeholderPlaceable: Placeable?,
    borderPlaceable: Placeable,
    singleLine: Boolean,
    density: Float,
) {
    val topBottomPadding = (VerticalTextFieldPadding.value * density).roundToInt()

    // placed center vertically and to the start edge horizontally
    leadingPlaceable?.placeRelative(
        0,
        Alignment.CenterVertically.align(leadingPlaceable.height, height)
    )

    // placed center vertically and to the end edge horizontally
    trailingPlaceable?.placeRelative(
        width - trailingPlaceable.width,
        Alignment.CenterVertically.align(trailingPlaceable.height, height)
    )

    // placed center vertically and after the leading icon horizontally if single line text field
    // placed to the top with padding for multi line text field
    val textVerticalPosition = if (singleLine) {
        Alignment.CenterVertically.align(textFieldPlaceable.height, height)
    } else {
        topBottomPadding
    }
    textFieldPlaceable.placeRelative(widthOrZero(leadingPlaceable), textVerticalPosition)

    // placed similar to the input text above
    placeholderPlaceable?.let {
        val placeholderVerticalPosition = if (singleLine) {
            Alignment.CenterVertically.align(it.height, height)
        } else {
            topBottomPadding
        }
        it.placeRelative(widthOrZero(leadingPlaceable), placeholderVerticalPosition)
    }

    // place border
    borderPlaceable.place(IntOffset.Zero)
}

@Composable
internal fun Decoration(
    contentColor: Color,
    typography: TextStyle? = null,
    contentAlpha: Float? = null,
    content: @Composable () -> Unit,
) {
    val colorAndEmphasis: @Composable () -> Unit = @Composable {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            if (contentAlpha != null) {
                CompositionLocalProvider(
                    LocalContentAlpha provides contentAlpha,
                    content = content
                )
            } else {
                CompositionLocalProvider(
                    LocalContentAlpha provides contentColor.alpha,
                    content = content
                )
            }
        }
    }
    if (typography != null) ProvideTextStyle(typography, colorAndEmphasis) else colorAndEmphasis()
}

object TextFieldDefaults {
    val MinHeight = 24.dp

    val MinWidth = 64.dp

    @Composable
    fun textFieldStyle(
        textColor: Color = JBTheme.textColors.default,
        disabledTextColor: Color = JBTheme.textColors.disabled,
        errorTextColor: Color = JBTheme.textColors.error,
        backgroundColor: Color = JBTheme.fieldColors.bg,
        disabledBackgroundColor: Color = JBTheme.fieldColors.bgDisabled,
        placeholderColor: Color = JBTheme.textColors.infoInput,
        disabledPlaceholderColor: Color = JBTheme.textColors.infoInput,
        borderColor: Color = JBTheme.fieldColors.border,
        disabledBorderColor: Color = JBTheme.fieldColors.borderDisabled,
        errorBorderColor: Color = JBTheme.fieldColors.borderError,
        focusedBorderColor: Color = JBTheme.fieldColors.borderFocused,
        indicatorColor: Color = JBTheme.focusColors.default,
        errorIndicatorColor: Color = JBTheme.focusColors.error,
        cursorColor: Color = JBTheme.textColors.default,
        errorCursorColor: Color = JBTheme.textColors.error,
    ): TextFieldStyle = DefaultTextFieldStyle(
        textColor,
        disabledTextColor,
        errorTextColor,
        backgroundColor,
        disabledBackgroundColor,
        placeholderColor,
        disabledPlaceholderColor,
        borderColor,
        disabledBorderColor,
        errorBorderColor,
        focusedBorderColor,
        indicatorColor,
        errorIndicatorColor,
        cursorColor,
        errorCursorColor
    )
}

internal fun widthOrZero(placeable: Placeable?) = placeable?.width ?: 0
internal fun heightOrZero(placeable: Placeable?) = placeable?.height ?: 0

internal val HorizontalTextFieldPadding = 6.dp
internal val VerticalTextFieldPadding = 3.dp
internal val HorizontalIconPadding = 6.dp

internal val IconDefaultSizeModifier = Modifier.defaultMinSize(16.dp, 16.dp)

private const val PlaceholderId = "Placeholder"
private const val TextFieldId = "TextField"
private const val LeadingId = "Leading"
private const val TrailingId = "Trailing"
