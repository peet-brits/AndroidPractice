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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
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
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
private fun ColumnDividerDemoPreview() {
    PracticeTheme {
        ColumnDividerDemo()
    }
}