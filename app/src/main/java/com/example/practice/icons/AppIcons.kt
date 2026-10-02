package com.example.practice.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.practice.R

object AppIcons {
    val Check @Composable get() = ImageVector.vectorResource(R.drawable.ic_check)
    val CheckCircle @Composable get() = ImageVector.vectorResource(R.drawable.ic_check_circle)
    val MoreHoriz @Composable get() = ImageVector.vectorResource(R.drawable.ic_more_horiz)
    val MoreVert @Composable get() = ImageVector.vectorResource(R.drawable.ic_more_vert)
}