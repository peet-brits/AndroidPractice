package com.example.practice.advanced

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.icons.AppIcons
import com.example.practice.ui.theme.PracticeTheme

@Composable
fun OverflowLayout(
    isOverflowing: Boolean,
    modifier: Modifier = Modifier,
    mainContent: @Composable () -> Unit,
    overflowContent: @Composable () -> Unit,
) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Max)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            mainContent()
            Icon(
                imageVector = if (isOverflowing) AppIcons.KeyboardArrowUp else AppIcons.KeyboardArrowDown,
                contentDescription = if (isOverflowing) "Up" else "Down",
            )
        }
        if (isOverflowing) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Yellow)
            ) {
                overflowContent()
            }
        }
    }
}

@Composable
fun OverflowLayoutDemo(
    isOverflowing: Boolean,
    modifier: Modifier = Modifier
) {
    OverflowLayout(
        isOverflowing,
        modifier = modifier,
        mainContent = {
            Text("Main content")
        },
        overflowContent = {
            Text("Overflow content secret")
        },
    )
}

@Preview(showBackground = true, widthDp = 250)
@Composable
private fun OverflowLayoutPreview() {
    val isOverflowing by remember { mutableStateOf(false) }
    PracticeTheme {
        Column {
            OverflowLayoutDemo(isOverflowing)
            HorizontalDivider(thickness = 2.dp)
            OverflowLayoutDemo(!isOverflowing)
        }
    }
}