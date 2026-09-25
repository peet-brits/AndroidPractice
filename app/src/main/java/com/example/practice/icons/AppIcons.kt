package com.example.practice.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.practice.R

object AppIcons {
    val Add @Composable get() = ImageVector.vectorResource(R.drawable.ic_add)
    val ArrowBack @Composable get() = ImageVector.vectorResource(R.drawable.ic_arrow_back)
    val Call @Composable get() = ImageVector.vectorResource(R.drawable.ic_call)
    val Chat @Composable get() = ImageVector.vectorResource(R.drawable.ic_chat)
    val Edit @Composable get() = ImageVector.vectorResource(R.drawable.ic_edit)
    val Favourite @Composable get() = ImageVector.vectorResource(R.drawable.ic_favorite)
    val Home @Composable get() = ImageVector.vectorResource(R.drawable.ic_home)
    val Mail @Composable get() = ImageVector.vectorResource(R.drawable.ic_mail)
    val Menu @Composable get() = ImageVector.vectorResource(R.drawable.ic_menu)
    val Settings @Composable get() = ImageVector.vectorResource(R.drawable.ic_settings)
    val Share @Composable get() = ImageVector.vectorResource(R.drawable.ic_share)
}