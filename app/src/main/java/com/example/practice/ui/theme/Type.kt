package com.example.practice.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.practice.R

val BlackOpsOne = FontFamily(
    Font(resId = R.font.black_ops_one_regular),
)

val BitCountInk = FontFamily(
    Font(resId = R.font.bitcount_ink_variable_font),
)

val SpaceGrotesk = FontFamily(
    Font(resId = R.font.space_grotesk_variable_font),
)

val Yarndings12 = FontFamily(
    Font(resId = R.font.yarndings12_regular)
)

val AppTypography = Typography().run {
    copy(
        displayLarge = displayLarge.copy(fontFamily = BitCountInk),
        displayMedium = displayMedium.copy(fontFamily = BitCountInk),
        displaySmall = displaySmall.copy(fontFamily = BitCountInk),
        headlineLarge = headlineLarge.copy(fontFamily = BlackOpsOne),
        headlineMedium = headlineMedium.copy(fontFamily = BlackOpsOne),
        headlineSmall = headlineSmall.copy(fontFamily = BlackOpsOne),
        titleLarge = titleLarge.copy(fontFamily = SpaceGrotesk),
        titleMedium = titleMedium.copy(fontFamily = SpaceGrotesk),
        titleSmall = titleSmall.copy(fontFamily = SpaceGrotesk),
        bodyLarge = bodyLarge.copy(fontFamily = SpaceGrotesk),
        bodyMedium = bodyMedium.copy(fontFamily = SpaceGrotesk),
        bodySmall = bodySmall.copy(fontFamily = SpaceGrotesk),
        labelLarge = labelLarge.copy(fontFamily = SpaceGrotesk),
        labelMedium = labelMedium.copy(fontFamily = SpaceGrotesk),
        labelSmall = labelSmall.copy(fontFamily = SpaceGrotesk),
    )
}

/*
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
*/