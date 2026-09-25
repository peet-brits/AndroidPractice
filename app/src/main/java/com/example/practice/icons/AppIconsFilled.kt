package com.example.practice.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.practice.R

object AppIconsFilled {
    val Chat @Composable get() = ImageVector.vectorResource(R.drawable.ic_chat_filled)
    val Home @Composable get() = ImageVector.vectorResource(R.drawable.ic_home_filled)
    val Settings @Composable get() = ImageVector.vectorResource(R.drawable.ic_settings_filled)
}