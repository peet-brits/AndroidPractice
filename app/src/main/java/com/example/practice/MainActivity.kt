package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FreakyDivider(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

val values = mapOf(
    "Item 1" to 3,
    "Item 2" to 7,
    "Item 3" to 7,
    "Item 4" to 18,
    "Item 5" to 23,
)

@Composable
fun FreakyDivider(
    modifier: Modifier = Modifier,
    dividerPosition: Int = 10,
) {
    val entries = values.entries.toList()
    var dividerPlaced = false

    LazyColumn(
        modifier = modifier
            .background(Color.Blue),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        contentPadding = PaddingValues(vertical = 6.dp),
    ) {
        itemsIndexed(entries) { index, (item, number) ->
            val isLast = index == entries.lastIndex

            Box {
                if (dividerPosition <= number && !dividerPlaced) {
                    dividerPlaced = true
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .offset(y = (-4).dp),
                        thickness = 2.dp
                    )
                }

                if (isLast && !dividerPlaced) {
                    dividerPlaced = true
                    HorizontalDivider(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(horizontal = 4.dp)
                            .offset(y = 4.dp),
                        thickness = 2.dp
                    )
                }

                Text(
                    text = "$item = $number",
                    modifier = Modifier.background(Color.Red)
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun FreakyDividerPreview() {
    PracticeTheme {
        FreakyDivider()
    }
}