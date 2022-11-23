package io.kanro.compose.jetbrains.expui.theme

import androidx.compose.foundation.LocalContextMenuRepresentation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.kanro.compose.jetbrains.expui.control.ActionButtonColors
import io.kanro.compose.jetbrains.expui.control.ButtonColors
import io.kanro.compose.jetbrains.expui.control.CheckBoxColors
import io.kanro.compose.jetbrains.expui.control.ComboBoxColors
import io.kanro.compose.jetbrains.expui.control.ContextMenuColors
import io.kanro.compose.jetbrains.expui.control.DropdownMenuColors
import io.kanro.compose.jetbrains.expui.control.JbContextMenuRepresentation
import io.kanro.compose.jetbrains.expui.control.LinkColors
import io.kanro.compose.jetbrains.expui.control.LocalActionButtonColors
import io.kanro.compose.jetbrains.expui.control.LocalCheckBoxColors
import io.kanro.compose.jetbrains.expui.control.LocalCloseableTabColors
import io.kanro.compose.jetbrains.expui.control.LocalComboBoxColors
import io.kanro.compose.jetbrains.expui.control.LocalContextMenuColors
import io.kanro.compose.jetbrains.expui.control.LocalDropdownMenuColors
import io.kanro.compose.jetbrains.expui.control.LocalLinkColors
import io.kanro.compose.jetbrains.expui.control.LocalOutlineButtonColors
import io.kanro.compose.jetbrains.expui.control.LocalPrimaryButtonColors
import io.kanro.compose.jetbrains.expui.control.LocalProgressBarColors
import io.kanro.compose.jetbrains.expui.control.LocalRadioButtonColors
import io.kanro.compose.jetbrains.expui.control.LocalSegmentedButtonColors
import io.kanro.compose.jetbrains.expui.control.LocalTabColors
import io.kanro.compose.jetbrains.expui.control.LocalTextFieldColors
import io.kanro.compose.jetbrains.expui.control.LocalToolBarActionButtonColors
import io.kanro.compose.jetbrains.expui.control.LocalToolTipColors
import io.kanro.compose.jetbrains.expui.control.ProgressBarColors
import io.kanro.compose.jetbrains.expui.control.RadioButtonColors
import io.kanro.compose.jetbrains.expui.control.SegmentedButtonColors
import io.kanro.compose.jetbrains.expui.control.TabColors
import io.kanro.compose.jetbrains.expui.control.TextFieldColors
import io.kanro.compose.jetbrains.expui.control.ToolBarActionButtonColors
import io.kanro.compose.jetbrains.expui.control.ToolTipColors
import io.kanro.compose.jetbrains.expui.style.AreaColors
import io.kanro.compose.jetbrains.expui.style.LocalAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalDisabledAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalErrorAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalErrorInactiveAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalFocusAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalHoverAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalInactiveAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalPressedAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalSelectionAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalSelectionInactiveAreaColors
import io.kanro.compose.jetbrains.expui.style.LocalTextStyle
import io.kanro.compose.jetbrains.expui.window.LocalMainToolBarColors
import io.kanro.compose.jetbrains.expui.window.LocalWindowsCloseWindowButtonColors
import io.kanro.compose.jetbrains.expui.window.MainToolBarColors

object LightTheme : Theme {
    val Grey1 = Color(0xFF000000)
    val Grey2 = Color(0xFF27282E)
    val Grey3 = Color(0xFF383A42)
    val Grey4 = Color(0xFF494B57)
    val Grey5 = Color(0xFF5A5D6B)
    val Grey6 = Color(0xFF6C707E)
    val Grey7 = Color(0xFF818594)
    val Grey8 = Color(0xFFA8ADBD)
    val Grey9 = Color(0xFFC9CCD6)
    val Grey10 = Color(0xFFDFE1E5)
    val Grey11 = Color(0xFFEBECF0)
    val Grey12 = Color(0xFFF7F8FA)
    val Grey13 = Color(0xFFFFFFFF)

    val Blue1 = Color(0xFF243D70)
    val Blue2 = Color(0xFF29498A)
    val Blue3 = Color(0xFF2E55A3)
    val Blue4 = Color(0xFF315FBD)
    val Blue5 = Color(0xFF3369D6)
    val Blue6 = Color(0xFF3573F0)
    val Blue7 = Color(0xFF407BF2)
    val Blue8 = Color(0xFF588CF3)
    val Blue9 = Color(0xFF709CF5)
    val Blue10 = Color(0xFF88ADF7)
    val Blue11 = Color(0xFFA0BDF8)
    val Blue12 = Color(0xFFB7CEFA)
    val Blue13 = Color(0xFFCFDEFC)
    val Blue14 = Color(0xFFE7EFFD)
    val Blue15 = Color(0xFFF5F8FE)

    val Green1 = Color(0xFF283829)
    val Green2 = Color(0xFF375239)
    val Green3 = Color(0xFF456B47)
    val Green4 = Color(0xFF508453)
    val Green5 = Color(0xFF599E5E)
    val Green6 = Color(0xFF5FB865)
    val Green7 = Color(0xFF7FC784)
    val Green8 = Color(0xFFA5D9A8)
    val Green9 = Color(0xFFC1E5C3)
    val Green10 = Color(0xFFDFF2E0)
    val Green11 = Color(0xFFF2FCF3)

    val Yellow1 = Color(0xFF7D5020)
    val Yellow2 = Color(0xFF96662A)
    val Yellow3 = Color(0xFFB07D35)
    val Yellow4 = Color(0xFFC99540)
    val Yellow5 = Color(0xFFE3AE4D)
    val Yellow6 = Color(0xFFFCC75B)
    val Yellow7 = Color(0xFFFACE70)
    val Yellow8 = Color(0xFFFCDB8D)
    val Yellow9 = Color(0xFFFFE7AB)
    val Yellow10 = Color(0xFFFFF0C7)
    val Yellow11 = Color(0xFFFFF8E3)

    val Red1 = Color(0xFF633333)
    val Red2 = Color(0xFF7D3C3C)
    val Red3 = Color(0xFF964444)
    val Red4 = Color(0xFFB04A4A)
    val Red5 = Color(0xFFC94F4F)
    val Red6 = Color(0xFFE35252)
    val Red7 = Color(0xFFEB7171)
    val Red8 = Color(0xFFF29191)
    val Red9 = Color(0xFFFAB4B4)
    val Red10 = Color(0xFFFCDBD4)
    val Red11 = Color(0xFFE8E8E8)
    val Red12 = Color(0xFFF5F5F5)
    val ErrorForeground = Color(0XFFD92B2B)

    val Orange1 = Color(0xFF7A4627)
    val Orange2 = Color(0xFF96572D)
    val Orange3 = Color(0xFFAD6531)
    val Orange4 = Color(0xFFC47233)
    val Orange5 = Color(0xFFDB8035)
    val Orange6 = Color(0xFFF28C35)
    val Orange7 = Color(0xFFFAA058)
    val Orange8 = Color(0xFFF7B47C)
    val Orange9 = Color(0xFFFACEAA)
    val Orange10 = Color(0xFFFCEDD4)
    val Orange11 = Color(0xFFFFF4EB)

    override val isDark: Boolean = false

    val NormalAreaColors = AreaColors(
        text = Grey1,
        foreground = Color.Unspecified,
        startBackground = Grey12,
        endBackground = Grey12,
        startBorderColor = Grey11,
        endBorderColor = Grey11,
        focusColor = Blue6,
    )

    val InactiveAreaColors = NormalAreaColors.copy(
        text = Grey8
    )

    val ErrorAreaColors = NormalAreaColors.copy(
        text = ErrorForeground
    )

    val ErrorInactiveAreaColors = ErrorAreaColors

    val DisabledAreaColors = NormalAreaColors.copy(
        text = Grey8,
        foreground = Grey8,
        startBackground = Grey13,
        endBackground = Grey13,
        startBorderColor = Grey10,
        endBorderColor = Grey10
    )

    val HoverAreaColors = NormalAreaColors.copy(
        startBackground = Blue14,
        endBackground = Blue14,
    )

    val PressedAreaColors = NormalAreaColors.copy(
        startBackground = Grey10,
        endBackground = Grey10,
    )

    val FocusAreaColors = NormalAreaColors.copy()

    val SelectionAreaColors = NormalAreaColors.copy(
        startBackground = Blue13,
        endBackground = Blue13,
    )

    val SelectionInactiveAreaColors = NormalAreaColors.copy(
        startBackground = Grey10,
        endBackground = Grey10,
    )

    val MainToolBarColors = MainToolBarColors(
        isDark = true,
        normalAreaColors = AreaColors(
            text = Grey13,
            foreground = Color.Unspecified,
            startBackground = Grey2,
            endBackground = Grey2,
            startBorderColor = Grey1,
            endBorderColor = Grey1,
            focusColor = Blue6,
        ),
        inactiveAreaColors = AreaColors(
            text = Grey13,
            foreground = Color.Unspecified,
            startBackground = Grey3,
            endBackground = Grey3,
            startBorderColor = Grey1,
            endBorderColor = Grey1,
            focusColor = Blue6,
        ),
        actionButtonColors = ActionButtonColors(
            normalAreaColors = AreaColors(
                text = Grey13,
                foreground = Color.Unspecified,
                startBackground = Color.Unspecified,
                endBackground = Color.Unspecified,
                startBorderColor = Color.Unspecified,
                endBorderColor = Color.Unspecified,
                focusColor = Blue6,
            ),
            hoverAreaColors = AreaColors(
                text = Grey13,
                foreground = Color.Unspecified,
                startBackground = Grey1,
                endBackground = Grey1,
                startBorderColor = Color.Unspecified,
                endBorderColor = Color.Unspecified,
                focusColor = Blue6,
            ),
            pressedAreaColors = AreaColors(
                text = Grey13,
                foreground = Color.Unspecified,
                startBackground = Grey1,
                endBackground = Grey1,
                startBorderColor = Color.Unspecified,
                endBorderColor = Color.Unspecified,
                focusColor = Blue6,
            ),
            disabledAreaColors = AreaColors(
                text = Grey13,
                foreground = Grey6,
                startBackground = Color.Unspecified,
                endBackground = Color.Unspecified,
                startBorderColor = Color.Unspecified,
                endBorderColor = Color.Unspecified,
                focusColor = Blue6,
            ),
        )
    )

    val WindowsCloseWindowButtonColors = ActionButtonColors(
        normalAreaColors = AreaColors(
            text = Grey13,
            foreground = Color.Unspecified,
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
            startBorderColor = Color.Unspecified,
            endBorderColor = Color.Unspecified,
            focusColor = Blue6,
        ),
        hoverAreaColors = AreaColors(
            text = Grey13,
            foreground = Color.Unspecified,
            startBackground = Red6,
            endBackground = Red6,
            startBorderColor = Color.Unspecified,
            endBorderColor = Color.Unspecified,
            focusColor = Red6,
        ),
        pressedAreaColors = AreaColors(
            text = Grey13,
            foreground = Color.Unspecified,
            startBackground = Red6,
            endBackground = Red6,
            startBorderColor = Color.Unspecified,
            endBorderColor = Color.Unspecified,
            focusColor = Red6,
        ),
        disabledAreaColors = AreaColors(
            text = Grey13,
            foreground = Grey6,
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
            startBorderColor = Color.Unspecified,
            endBorderColor = Color.Unspecified,
            focusColor = Blue6,
        ),
    )

    val ActionButtonColors = ActionButtonColors(
        normalAreaColors = NormalAreaColors.copy(
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        ),
        hoverAreaColors = HoverAreaColors.copy(
            startBackground = Grey11,
            endBackground = Grey11,
        ),
        pressedAreaColors = PressedAreaColors.copy(
            startBackground = Grey10,
            endBackground = Grey10,
        ),
        disabledAreaColors = DisabledAreaColors.copy(
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        )
    )

    val CheckBoxColors = CheckBoxColors(
        normalAreaColors = NormalAreaColors.copy(
            foreground = Grey13,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Grey8,
            endBorderColor = Grey8,
        ),
        selectionAreaColors = SelectionAreaColors.copy(
            foreground = Grey13,
            startBackground = Blue6,
            endBackground = Blue6,
            startBorderColor = Blue6,
            endBorderColor = Blue6,
        ),
        focusAreaColors = FocusAreaColors.copy(
            foreground = Grey13,
            startBackground = Blue6,
            endBackground = Blue6,
            startBorderColor = Grey13,
            endBorderColor = Grey13,
        ),
        disabledAreaColors = DisabledAreaColors.copy(
            foreground = Grey8,
            startBackground = Grey12,
            endBackground = Grey12,
            startBorderColor = Grey10,
            endBorderColor = Grey10,
        )
    )

    val RadioButtonColors = RadioButtonColors(
        normalAreaColors = NormalAreaColors.copy(
            foreground = Grey13,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Grey8,
            endBorderColor = Grey8,
        ),
        selectionAreaColors = SelectionAreaColors.copy(
            foreground = Grey13,
            startBackground = Blue6,
            endBackground = Blue6,
            startBorderColor = Blue6,
            endBorderColor = Blue6,
        ),
        focusAreaColors = FocusAreaColors.copy(
            foreground = Grey13,
            startBackground = Blue6,
            endBackground = Blue6,
            startBorderColor = Grey13,
            endBorderColor = Grey13,
        ),
        disabledAreaColors = DisabledAreaColors.copy(
            foreground = Grey8,
            startBackground = Grey12,
            endBackground = Grey12,
            startBorderColor = Grey10,
            endBorderColor = Grey10,
        )
    )

    val PrimaryButtonColors = ButtonColors(
        normalAreaColors = NormalAreaColors.copy(
            text = Grey13,
            startBackground = Blue6,
            endBackground = Blue6,
            startBorderColor = Blue6,
            endBorderColor = Blue6,
        ),
        focusAreaColors = FocusAreaColors.copy(
            text = Grey13,
            startBackground = Blue6,
            endBackground = Blue6,
            startBorderColor = Grey13,
            endBorderColor = Grey13,
        ),
        disabledAreaColors = DisabledAreaColors.copy(
            text = Grey8,
            startBackground = Grey12,
            endBackground = Grey12,
            startBorderColor = Grey10,
            endBorderColor = Grey10,
        )
    )

    val OutlineButtonColors = ButtonColors(
        normalAreaColors = NormalAreaColors.copy(
            text = Grey1,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Grey8,
            endBorderColor = Grey8,
        ),
        focusAreaColors = FocusAreaColors.copy(
            text = Grey1,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Grey13,
            endBorderColor = Grey13,
        ),
        disabledAreaColors = DisabledAreaColors.copy(
            text = Grey8,
            startBackground = Grey12,
            endBackground = Grey12,
            startBorderColor = Grey10,
            endBorderColor = Grey10,
        )
    )

    val LinkColors = LinkColors(
        normalAreaColors = NormalAreaColors.copy(
            text = Blue4,
        ),
        hoverAreaColors = HoverAreaColors.copy(
            text = Blue4,
        ),
        pressedAreaColors = PressedAreaColors.copy(
            text = Blue4,
        ),
        focusAreaColors = FocusAreaColors.copy(
            text = Blue4,
        ),
        disabledAreaColors = NormalAreaColors.copy(
            text = Grey8,
        ),
        visitedAreaColors = NormalAreaColors.copy(
            text = Blue2,
        )
    )

    val SegmentedButtonColors = SegmentedButtonColors(
        normalAreaColors = NormalAreaColors.copy(
            text = Grey1,
            startBackground = Grey12,
            endBackground = Grey12,
            startBorderColor = Grey8,
            endBorderColor = Grey8,
        ),
        focusAreaColors = FocusAreaColors.copy(
            text = Grey1,
            startBackground = Grey12,
            endBackground = Grey12,
            startBorderColor = Grey13,
            endBorderColor = Grey13,
        ),
        itemNormalAreaColors = NormalAreaColors.copy(
            text = Grey1,
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
            startBorderColor = Color.Unspecified,
            endBorderColor = Color.Unspecified,
        ),
        itemHoverAreaColors = HoverAreaColors.copy(
            text = Grey1,
            startBackground = Grey11,
            endBackground = Grey11,
            startBorderColor = Color.Unspecified,
            endBorderColor = Color.Unspecified,
        ),
        itemPressedAreaColors = PressedAreaColors.copy(
            text = Grey1,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Color.Unspecified,
            endBorderColor = Color.Unspecified,
        ),
        itemSelectionAreaColors = SelectionAreaColors.copy(
            text = Grey1,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Grey8,
            endBorderColor = Grey8,
        ),
        itemSelectedFocusAreaColors = SelectionAreaColors.copy(
            text = Grey1,
            startBackground = Blue13,
            endBackground = Blue13,
            startBorderColor = Grey13,
            endBorderColor = Grey13,
        )
    )

    val ToolTipColors = ToolTipColors(
        isDark = true,
        normalAreaColors = NormalAreaColors.copy(
            text = Grey13,
            startBackground = Grey1,
            endBackground = Grey1,
            startBorderColor = Grey1,
            endBorderColor = Grey1,
        )
    )

    val TextFieldColors = TextFieldColors(
        normalAreaColors = NormalAreaColors.copy(
            text = Grey1,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Grey8,
            endBorderColor = Grey8,
        ),
        focusAreaColors = FocusAreaColors.copy(
            text = Grey1,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Grey13,
            endBorderColor = Grey13,
        ),
        disabledAreaColors = DisabledAreaColors.copy(
            text = Grey8,
            startBackground = Grey12,
            endBackground = Grey12,
            startBorderColor = Grey10,
            endBorderColor = Grey10,
        ),
        errorAreaColors = ErrorAreaColors.copy(
            text = Grey1,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Red6,
            endBorderColor = Red6,
            focusColor = Red6,
        ),
        errorFocusAreaColors = ErrorAreaColors.copy(
            text = Grey1,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Grey13,
            endBorderColor = Grey13,
            focusColor = Red6,
        )
    )

    val DropdownMenuColors = DropdownMenuColors(
        normalAreaColors = NormalAreaColors.copy(
            text = Grey1,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Grey8,
            endBorderColor = Grey8,
        ),
        hoverAreaColors = HoverAreaColors.copy(
            text = Grey1,
            startBackground = Blue13,
            endBackground = Blue13,
            startBorderColor = Blue13,
            endBorderColor = Blue13,
        ),
        pressedAreaColors = PressedAreaColors.copy(
            text = Grey1,
            startBackground = Blue13,
            endBackground = Blue13,
            startBorderColor = Blue13,
            endBorderColor = Blue13,
        ),
        focusAreaColors = FocusAreaColors.copy(
            text = Grey1,
            startBackground = Blue13,
            endBackground = Blue13,
            startBorderColor = Blue13,
            endBorderColor = Blue13,
        ),
    )

    val ComboBoxColors = ComboBoxColors(
        normalAreaColors = NormalAreaColors.copy(
            text = Grey1,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Grey8,
            endBorderColor = Grey8,
        ),
        focusAreaColors = FocusAreaColors.copy(
            text = Grey1,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Grey13,
            endBorderColor = Grey13,
        ),
        disabledAreaColors = DisabledAreaColors.copy(
            text = Grey8,
            startBackground = Grey12,
            endBackground = Grey12,
            startBorderColor = Grey10,
            endBorderColor = Grey10,
        ),
        dropdownMenuColors = DropdownMenuColors
    )

    val ContextMenuColors = ContextMenuColors(
        normalAreaColors = NormalAreaColors.copy(
            text = Grey1,
            startBackground = Grey13,
            endBackground = Grey13,
            startBorderColor = Grey8,
            endBorderColor = Grey8,
        ),
        hoverAreaColors = HoverAreaColors.copy(
            text = Grey1,
            startBackground = Blue13,
            endBackground = Blue13,
            startBorderColor = Blue13,
            endBorderColor = Blue13,
        ),
        pressedAreaColors = PressedAreaColors.copy(
            text = Grey1,
            startBackground = Blue13,
            endBackground = Blue13,
            startBorderColor = Blue13,
            endBorderColor = Blue13,
        ),
        focusAreaColors = FocusAreaColors.copy(
            text = Grey1,
            startBackground = Blue13,
            endBackground = Blue13,
            startBorderColor = Blue13,
            endBorderColor = Blue13,
        ),
    )

    val ToolBarActionButtonColors = ToolBarActionButtonColors(
        normalAreaColors = NormalAreaColors.copy(
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        ),
        hoverAreaColors = HoverAreaColors.copy(
            startBackground = Grey10,
            endBackground = Grey10,
        ),
        pressedAreaColors = PressedAreaColors.copy(
            startBackground = Grey10,
            endBackground = Grey10,
        ),
        disabledAreaColors = DisabledAreaColors.copy(
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        ),
        inactiveAreaColors = NormalAreaColors.copy(
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        ),
        selectionAreaColors = SelectionAreaColors.copy(
            foreground = Grey13,
            startBackground = Blue6,
            endBackground = Blue6,
        ),
        inactiveSelectionAreaColors = SelectionInactiveAreaColors.copy(
            startBackground = Grey10,
            endBackground = Grey10,
        )
    )

    val ProgressBarColors = ProgressBarColors(
        normalAreaColors = NormalAreaColors.copy(
            foreground = Blue6,
            startBackground = Grey10,
            endBackground = Grey10,
        ),
        indeterminateAreaColors = NormalAreaColors.copy(
            foreground = Blue6,
            startBackground = Blue6,
            endBackground = Blue11,
        ),
    )

    val TabColors = TabColors(
        normalAreaColors = NormalAreaColors.copy(
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        ),
        hoverAreaColors = HoverAreaColors.copy(
            startBackground = Grey11,
            endBackground = Grey11,
        ),
        pressedAreaColors = PressedAreaColors.copy(
            startBackground = Grey11,
            endBackground = Grey11,
        ),
        inactiveAreaColors = NormalAreaColors.copy(
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        ),
        selectionAreaColors = SelectionAreaColors.copy(
            focusColor = Blue8,
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        ),
        inactiveSelectionAreaColors = SelectionInactiveAreaColors.copy(
            focusColor = Grey8,
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        )
    )

    val CloseableTabColors = TabColors(
        normalAreaColors = NormalAreaColors.copy(
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        ),
        hoverAreaColors = HoverAreaColors.copy(
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        ),
        pressedAreaColors = PressedAreaColors.copy(
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        ),
        inactiveAreaColors = NormalAreaColors.copy(
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        ),
        selectionAreaColors = SelectionAreaColors.copy(
            focusColor = Blue8,
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        ),
        inactiveSelectionAreaColors = SelectionInactiveAreaColors.copy(
            focusColor = Grey8,
            startBackground = Color.Unspecified,
            endBackground = Color.Unspecified,
        )
    )

    val DefaultTextStyle = TextStyle(
        fontFamily = Fonts.Inter, fontSize = 13.sp, fontWeight = FontWeight.Normal, color = Color.Unspecified
    )

    val BoldTextStyle = DefaultTextStyle.copy(fontWeight = FontWeight.Medium)

    @Composable
    override fun provide(content: @Composable () -> Unit) {
        CompositionLocalProvider(
            LocalIsDarkTheme provides isDark,
            LocalAreaColors provides NormalAreaColors,
            LocalInactiveAreaColors provides InactiveAreaColors,
            LocalErrorAreaColors provides ErrorAreaColors,
            LocalErrorInactiveAreaColors provides ErrorInactiveAreaColors,
            LocalDisabledAreaColors provides DisabledAreaColors,
            LocalHoverAreaColors provides HoverAreaColors,
            LocalPressedAreaColors provides PressedAreaColors,
            LocalFocusAreaColors provides FocusAreaColors,
            LocalSelectionAreaColors provides SelectionAreaColors,
            LocalSelectionInactiveAreaColors provides SelectionInactiveAreaColors,
            LocalMainToolBarColors provides MainToolBarColors,
            LocalActionButtonColors provides ActionButtonColors,
            LocalCheckBoxColors provides CheckBoxColors,
            LocalRadioButtonColors provides RadioButtonColors,
            LocalPrimaryButtonColors provides PrimaryButtonColors,
            LocalOutlineButtonColors provides OutlineButtonColors,
            LocalLinkColors provides LinkColors,
            LocalSegmentedButtonColors provides SegmentedButtonColors,
            LocalToolTipColors provides ToolTipColors,
            LocalTextFieldColors provides TextFieldColors,
            LocalDropdownMenuColors provides DropdownMenuColors,
            LocalComboBoxColors provides ComboBoxColors,
            LocalContextMenuColors provides ContextMenuColors,
            LocalToolBarActionButtonColors provides ToolBarActionButtonColors,
            LocalProgressBarColors provides ProgressBarColors,
            LocalTabColors provides TabColors,
            LocalCloseableTabColors provides CloseableTabColors,
            LocalWindowsCloseWindowButtonColors provides WindowsCloseWindowButtonColors,
            LocalContextMenuRepresentation provides JbContextMenuRepresentation(ContextMenuColors),
            LocalTextStyle provides DefaultTextStyle,
            content = content,
        )
    }
}

@Composable
fun LightTheme(content: @Composable () -> Unit) {
    LightTheme.provide(content)
}
