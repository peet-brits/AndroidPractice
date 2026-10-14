package com.example.practice.advanced

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.PracticeTheme

@Composable
fun IntrinsicBox(intrinsicSize: IntrinsicSize) {
    Column(
        modifier = Modifier
            .width(intrinsicSize)
            .border(width = 2.dp, color = Color.Red)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun IntrinsicBoxPreview() {
    PracticeTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text("Box - IntrinsicSize.Max (no content = no size)")
            IntrinsicBox(IntrinsicSize.Max)
            Text("Box - IntrinsicSize.Min")
            IntrinsicBox(IntrinsicSize.Min)
        }
    }
}

@Composable
fun IntrinsicText(intrinsicSize: IntrinsicSize, repeat: Int, text: String = "Hello ") {
    Column(
        modifier = Modifier
            .width(intrinsicSize)
            .border(width = 2.dp, color = Color.Red)
    ) {
        Text(text.repeat(repeat))
    }
}

@Preview(showBackground = true)
@Composable
private fun IntrinsicTextPreview() {
    PracticeTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text("Text - IntrinsicSize.Max")
            IntrinsicText(IntrinsicSize.Max, 7)
            IntrinsicText(IntrinsicSize.Max, 14)
            Text("Text - IntrinsicSize.Min")
            IntrinsicText(IntrinsicSize.Min, 3)
            IntrinsicText(IntrinsicSize.Min, 12, "a")
            IntrinsicText(IntrinsicSize.Min, 4, "a ")
        }
    }
}

@Composable
fun IntrinsicColumn(
    intrinsicSize: IntrinsicSize,
    repeat: Int,
    text1: String = "This is my text",
    text2: String = "a ",
) {
    Column(
        modifier = Modifier
            .width(intrinsicSize)
            .border(width = 2.dp, color = Color.Red)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text1, modifier = Modifier.weight(1f))
            Checkbox(checked = true, onCheckedChange = {})
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text2.repeat(repeat), modifier = Modifier.weight(1f))
            Checkbox(checked = true, onCheckedChange = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun IntrinsicColumnPreview() {
    PracticeTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text("Column.IntrinsicSize.Max")
            IntrinsicColumn(IntrinsicSize.Max, 3)
            IntrinsicColumn(IntrinsicSize.Max, 50)
            Text("Column.IntrinsicSize.Min")
            IntrinsicColumn(IntrinsicSize.Min, 3, text1 = "c", text2 = "d ")
            IntrinsicColumn(IntrinsicSize.Min, 5)
            IntrinsicColumn(IntrinsicSize.Min, 20, text2 = "b")
        }
    }
}

/*
@Composable
fun IntrinsicRow(intrinsicSize: IntrinsicSize, repeat: Int) {
    Row(
        modifier = Modifier
            .width(intrinsicSize)
            .border(width = 2.dp, color = Color.Red)
    ) {
        Text("a ".repeat(repeat)) //, modifier = Modifier.weight(1f)
        Checkbox(checked = true, onCheckedChange = {})
    }
}

@Preview(showBackground = true)
@Composable
private fun IntrinsicRowPreview() {
    PracticeTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text("Row.IntrinsicSize.Max")
            IntrinsicRow(IntrinsicSize.Max, 10)
            IntrinsicRow(IntrinsicSize.Max, 40)
            Text("Row.IntrinsicSize.Min")
            IntrinsicRow(IntrinsicSize.Min, 1)
            IntrinsicRow(IntrinsicSize.Min, 7)
        }
    }
}
*/