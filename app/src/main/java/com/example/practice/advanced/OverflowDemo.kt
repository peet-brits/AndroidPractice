package com.example.practice.advanced

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.advanced.solution.OverflowLayoutSolutionDemo
import com.example.practice.ui.theme.PracticeTheme

@Composable
fun OverflowDemo(modifier: Modifier = Modifier) {
    var isOverflowing by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
    ) {
        OverflowLayoutDemo(
            modifier = Modifier
                .fillMaxWidth(),
            isOverflowing = isOverflowing,
            onOverflowClick = { isOverflowing = !isOverflowing }
        )
        HorizontalDivider(thickness = 2.dp)
        OverflowLayoutSolutionDemo()
        HorizontalDivider(thickness = 2.dp)
    }
}

@Preview(showBackground = true)
@Composable
private fun OverflowDemoPreview() {
    PracticeTheme {
        OverflowDemo()
    }
}