package io.kanro.compose.jetbrains

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

class JBTypography(
    val h0: TextStyle,
    val h1: TextStyle,
    val h2: TextStyle,
    val h2Bold: TextStyle,
    val h3: TextStyle,
    val h3Bold: TextStyle,
    val default: TextStyle,
    val defaultBold: TextStyle,
    val defaultUnderlined: TextStyle,
    val paragraph: TextStyle,
    val medium: TextStyle,
    val mediumBold: TextStyle,
    val small: TextStyle,
    val smallUnderlined: TextStyle,
) {
    constructor(
        defaultFontFamily: FontFamily = FontFamily.Default,
        h0: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 25.sp
        ),
        h1: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp
        ),
        h2: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
        ),
        h2Bold: TextStyle = h2.copy(fontWeight = FontWeight.Medium),
        h3: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 20.sp
        ),
        h3Bold: TextStyle = h3.copy(fontWeight = FontWeight.Medium),
        default: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.5.sp,
            lineHeight = 15.sp
        ),
        defaultBold: TextStyle = default.copy(fontWeight = FontWeight.Medium),
        defaultUnderlined: TextStyle = default.copy(textDecoration = TextDecoration.Underline),
        paragraph: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
            lineHeight = 19.sp
        ),
        medium: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 15.sp
        ),
        mediumBold: TextStyle = medium.copy(fontWeight = FontWeight.Medium),
        small: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 11.sp,
            lineHeight = 14.sp
        ),
        smallUnderlined: TextStyle = small.copy(textDecoration = TextDecoration.Underline),
    ) : this(
        h0.withDefaultFontFamily(defaultFontFamily),
        h1.withDefaultFontFamily(defaultFontFamily),
        h2.withDefaultFontFamily(defaultFontFamily),
        h2Bold.withDefaultFontFamily(defaultFontFamily),
        h3.withDefaultFontFamily(defaultFontFamily),
        h3Bold.withDefaultFontFamily(defaultFontFamily),
        default.withDefaultFontFamily(defaultFontFamily),
        defaultBold.withDefaultFontFamily(defaultFontFamily),
        defaultUnderlined.withDefaultFontFamily(defaultFontFamily),
        paragraph.withDefaultFontFamily(defaultFontFamily),
        medium.withDefaultFontFamily(defaultFontFamily),
        mediumBold.withDefaultFontFamily(defaultFontFamily),
        small.withDefaultFontFamily(defaultFontFamily),
        smallUnderlined.withDefaultFontFamily(defaultFontFamily)
    )

    companion object {
        private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
            return if (fontFamily != null) this else copy(fontFamily = default)
        }
    }
}

val LocalTypography = compositionLocalOf { JBTypography() }
