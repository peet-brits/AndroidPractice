package com.example.practice.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.PracticeTheme

@Composable
fun DemoScreen() {
    Text(
        modifier = Modifier
            .clip(RoundedCornerShape(
                topStart = 48.dp,
                topEnd = 48.dp
            ))
            .background(Color.Red)
            //.clip(TriangleShape)
            .clip(BasicStarShape(stretch = 50f))
            //.clip(CalculatedStarShape(points = 6))
            .background(Color.Green)
        ,
        text = baconIpsum,
    )
}

@Preview(showBackground = true)
@Composable
private fun DemoScreenPreview() {
    PracticeTheme {
        DemoScreen()
    }
}