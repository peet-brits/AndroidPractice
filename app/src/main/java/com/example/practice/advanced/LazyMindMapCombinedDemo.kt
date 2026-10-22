package com.example.practice.advanced

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice.ui.theme.PracticeTheme

@Composable
fun LazyMindMapCombinedDemo(modifier: Modifier = Modifier) {
    LazyMindMapDemo(modifier)
}

@Preview(showBackground = true)
@Composable
private fun LazyMindMapCombinedDemoPreview() {
    PracticeTheme {
        LazyMindMapCombinedDemo()
    }
}