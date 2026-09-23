package com.example.practice.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.practice.R

object AppIcons {
    val ArrowBack
    @Composable get() = ImageVector.vectorResource(R.drawable.ic_arrow_back)

    val Favourite
    @Composable get() = ImageVector.vectorResource(R.drawable.ic_favorite)

    val Edit
    @Composable get() = ImageVector.vectorResource(R.drawable.ic_edit)

    val Share
    @Composable get() = ImageVector.vectorResource(R.drawable.ic_share)

    val Mail
    @Composable get() = ImageVector.vectorResource(R.drawable.ic_mail)

    val Call
    @Composable get() = ImageVector.vectorResource(R.drawable.ic_call)
}