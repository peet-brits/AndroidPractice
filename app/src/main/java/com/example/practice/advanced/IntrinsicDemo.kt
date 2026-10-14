package com.example.practice.advanced

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
fun IntrinsicColumn(intrinsicSize: IntrinsicSize, repeat: Int) {
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
            Text("This is my text", modifier = Modifier.weight(1f))
            Checkbox(checked = true, onCheckedChange = {})
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text("a ".repeat(repeat), modifier = Modifier.weight(1f))
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
            IntrinsicColumn(IntrinsicSize.Min, 1)
            IntrinsicColumn(IntrinsicSize.Min, 5)
        }
    }
}

@Composable
fun IntrinsicRow(intrinsicSize: IntrinsicSize, repeat: Int) {
    Row(
        modifier = Modifier
            .width(intrinsicSize)
            .border(width = 2.dp, color = Color.Red)
    ) {
        Text("a ".repeat(repeat)) //, modifier = Modifier.weight(1f))
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
            Text("Column.IntrinsicSize.Min")
            IntrinsicRow(IntrinsicSize.Min, 1)
            IntrinsicRow(IntrinsicSize.Min, 7)
        }
    }
}