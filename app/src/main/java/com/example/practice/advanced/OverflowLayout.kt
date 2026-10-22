package com.example.practice.advanced

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMaxOfOrNull
import com.example.practice.icons.AppIcons
import com.example.practice.ui.theme.PracticeTheme

@Composable
fun OverflowLayout(
    isOverflowing: Boolean,
    modifier: Modifier = Modifier,
    mainContent: @Composable () -> Unit,
    overflowContent: @Composable () -> Unit,
) {
    SubcomposeLayout(
        modifier = modifier
    ) { constraints ->
        val mainMeasurables = subcompose("main_content", mainContent)
        val mainPlaceableLists = mainMeasurables.map {
            it.measure(constraints.copy(minWidth = 0, minHeight = 0))
        }

        val overflowPlaceableList = if (isOverflowing) {
            val overflowMeasurables = subcompose("overflow_content", overflowContent)
            overflowMeasurables.map {
                it.measure(constraints.copy(minWidth = 0, minHeight = 0))
            }
        } else
            emptyList()

        val mainWidth = mainPlaceableLists.fastMaxOfOrNull { it.width } ?: 0
        val mainHeight = mainPlaceableLists.fastMaxOfOrNull { it.height } ?: 0
        val overflowWidth = overflowPlaceableList.fastMaxOfOrNull { it.width } ?: 0
        val overflowHeight = overflowPlaceableList.fastMaxOfOrNull { it.height } ?: 0

        val width = maxOf(mainWidth, overflowWidth)
        val height = mainHeight + overflowHeight

        layout(width, height) {
            mainPlaceableLists.fastForEach { placeable ->
                placeable.place(0, 0)
            }
            overflowPlaceableList.fastForEach { placeable ->
                placeable.place(0, mainHeight)
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
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text("Main content")
                Icon(
                    imageVector = if (isOverflowing) AppIcons.KeyboardArrowUp else AppIcons.KeyboardArrowDown,
                    contentDescription = if (isOverflowing) "Up" else "Down",
                )
            }
        },
        overflowContent = {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Yellow),
                text = "Overflow content secret"
            )
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