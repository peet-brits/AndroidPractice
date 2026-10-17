package com.example.practice.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.practice.R

val blackOpsOne = FontFamily(
    Font(resId = R.font.black_ops_one_regular),
)

val bitCountInk = FontFamily(
    Font(resId = R.font.bitcount_ink_variable_font),
)

val spaceGrotesk = FontFamily(
    Font(resId = R.font.space_grotesk_variable_font),
)

val yarndings12 = FontFamily(
    Font(resId = R.font.yarndings12_regular)
)

val typography = Typography().run {
    copy(
        //bodyLarge = Typography().bodyMedium - duplicate a value.
        displayLarge = displayLarge.copy(fontFamily = bitCountInk),
        displayMedium = displayMedium.copy(fontFamily = bitCountInk),
        displaySmall = displaySmall.copy(fontFamily = bitCountInk),
        headlineLarge = headlineLarge.copy(fontFamily = blackOpsOne),
        headlineMedium = headlineMedium.copy(fontFamily = blackOpsOne),
        headlineSmall = headlineSmall.copy(fontFamily = blackOpsOne),
        titleLarge = titleLarge.copy(fontFamily = spaceGrotesk),
        titleMedium = titleMedium.copy(fontFamily = spaceGrotesk),
        titleSmall = titleSmall.copy(fontFamily = spaceGrotesk),
        bodyLarge = bodyLarge.copy(fontFamily = spaceGrotesk),
        bodyMedium = bodyMedium.copy(fontFamily = spaceGrotesk),
        bodySmall = bodySmall.copy(fontFamily = spaceGrotesk),
        labelLarge = labelLarge.copy(fontFamily = spaceGrotesk),
        labelMedium = labelMedium.copy(fontFamily = spaceGrotesk),
        labelSmall = labelSmall.copy(fontFamily = spaceGrotesk),
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