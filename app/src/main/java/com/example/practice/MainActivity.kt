package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.PracticeTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ColumnDividerDemo(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ColumnDivider(
    modifier: Modifier = Modifier,
    values: Map<String, Int>,
    dividerPosition: Int,
) {
    val entries = values.entries.toList()
    val dividerIndex = entries.indexOfFirst { (_, number) ->
        dividerPosition <= number
    }

    LazyColumn(
        modifier = modifier
            .background(Color.Blue),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        contentPadding = PaddingValues(vertical = 6.dp),
    ) {
        itemsIndexed(entries) { index, (item, number) ->
            Box {
                ItemDivider(
                    isDividerBefore = index == dividerIndex,
                    isDividerAfter = index == entries.lastIndex && dividerIndex == -1
                )
                Text(
                    text = "$item = $number",
                    modifier = Modifier.background(Color.Red)
                )
            }
        }
    }
}

@Composable
private fun BoxScope.ItemDivider(
    isDividerBefore: Boolean,
    isDividerAfter: Boolean,
) {
    if (isDividerBefore) {
        HorizontalDivider(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .offset(y = (-4).dp),
            thickness = 2.dp
        )
    }

    if (isDividerAfter) {
        HorizontalDivider(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 4.dp)
                .offset(y = 4.dp),
            thickness = 2.dp
        )
    }
}

@Composable
fun ColumnDivider2(
    modifier: Modifier = Modifier,
    d1: Boolean,
    t1: Boolean,
    d2: Boolean,
    t2: Boolean,
    d3: Boolean,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Blue),
        contentPadding = PaddingValues(vertical = 2.dp),
    ) {
        if (d1) item { V2Divider() }
        if (t1) item { V2Text() }
        if (d2) item { V2Divider() }
        if (t2) item { V2Text() }
        if (d3) item { V2Divider() }
    }
}

@Composable
private fun V2Text() {
    Text(
        modifier = Modifier
            .padding(4.dp)
            .offset(y = 0.5.dp)
            .background(Color.Red),
        text = "Test",
    )
}

@Composable
private fun V2Divider() {
    Box(
        modifier = Modifier
            .background(Color.Yellow)
            .height(0.dp)
    ) {
        HorizontalDivider(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .offset(y = (-1).dp)
                .background(Color.Green),
            thickness = 2.dp
        )
    }
}

@Composable
private fun ColumnDividerDemo(modifier: Modifier = Modifier) {
    val values = mapOf(
        "Item 1" to 3 + 10,
        "Item 2" to 7 + 10,
        "Item 3" to 7 + 10,
        "Item 4" to 18 + 10,
        "Item 5" to 24 + 10,
    )

    val min = values.values.min().toFloat()
    val max = values.values.max().toFloat() + 1
    var sliderValue by rememberSaveable { mutableFloatStateOf(min + (max - min) / 3) }
    val position = sliderValue.roundToInt()

    var d1 by rememberSaveable { mutableStateOf(true) }
    var d2 by rememberSaveable { mutableStateOf(true) }
    var d3 by rememberSaveable { mutableStateOf(true) }
    var t1 by rememberSaveable { mutableStateOf(true) }
    var t2 by rememberSaveable { mutableStateOf(true) }

    Column(modifier = modifier) {
        Slider(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = min..max,
            //steps = (max - min).toInt() - 1,
        )
        Text("$min - $max -> $position ($sliderValue)")
        ColumnDivider(
            values = values,
            dividerPosition = position,
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Row {
            Checkbox(checked = d1, onCheckedChange = { d1 = it })
            Checkbox(checked = d2, onCheckedChange = { d2 = it })
            Checkbox(checked = d3, onCheckedChange = { d3 = it })
        }
        Row {
            Checkbox(checked = t1, onCheckedChange = { t1 = it })
            Checkbox(checked = t2, onCheckedChange = { t2 = it })
        }
        ColumnDivider2(d1 = d1, t1 = t1, d2 = d2, t2 = t2, d3 = d3)
    }
}

@Preview(showBackground = true, widthDp = 140)
@Composable
private fun ColumnDividerDemoPreview() {
    PracticeTheme {
        ColumnDividerDemo()
    }
}