@file:OptIn(ExperimentalFoundationApi::class)

package com.example.practice.advanced

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.draggable2D
import androidx.compose.foundation.gestures.rememberDraggable2DState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.layout.LazyLayout
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMapIndexedNotNull
import com.example.practice.ui.theme.PracticeTheme
import kotlin.math.roundToInt

data class MindMapItem(
    val absoluteOffset: Offset,
    val content: @Composable (modifier: Modifier) -> Unit,
)

private data class ProcessedMindMapItem(
    val placeable: Placeable,
    val finalXPosition: Int,
    val finalYPosition: Int
)

@Composable
fun LazyMindMap(
    items: List<MindMapItem>,
    onDrag: (delta: IntOffset) -> Unit,
    modifier: Modifier = Modifier,
    mindMapOffset: IntOffset = IntOffset.Zero,
    itemModifier: Modifier = Modifier,
) {
    val boundaryMinSize = 25.dp
    val boundaryMaxWidth = 200.dp
    val boundaryMaxHeight = 100.dp
    LazyLayout(
        modifier = modifier
            .draggable2D(
                state = rememberDraggable2DState { delta ->
                    onDrag(delta.round())
                }
            ),
        itemProvider = {
            object : LazyLayoutItemProvider {
                override val itemCount: Int
                    get() = items.size

                @Composable
                override fun Item(index: Int, key: Any) {
                    items[index].content(
                        itemModifier
                            .widthIn(min = boundaryMinSize, max = boundaryMaxWidth)
                            .heightIn(min = boundaryMinSize, max = boundaryMaxHeight)
                            .border(
                                width = 2.dp,
                                color = Color.LightGray
                            )
                            .padding(16.dp)
                    )
                }
            }
        }
    ) { constraints ->
        val layoutWidth = constraints.maxWidth
        val layoutHeight = constraints.maxHeight

        val visibleArea = IntRect(
            left = 0,
            top = 0,
            right = layoutWidth,
            bottom = layoutHeight
        )

        val visibleItems = items.fastMapIndexedNotNull { index, item ->
            val finalXPosition =
                (item.absoluteOffset.x + layoutWidth / 2 + mindMapOffset.x).roundToInt()
            val finalYPosition =
                (item.absoluteOffset.y + layoutHeight / 2 + mindMapOffset.y).roundToInt()

            val maxItemWidth = boundaryMaxWidth.roundToPx()
            val maxItemHeight = boundaryMaxHeight.roundToPx()
            val extendedItemBounds = IntRect(
                left = finalXPosition - maxItemWidth / 2,
                top = finalYPosition - maxItemHeight / 2,
                right = finalXPosition + 3 * (maxItemWidth / 2),
                bottom = finalYPosition + 3 * (maxItemHeight / 2)
            )

            if (visibleArea.overlaps(extendedItemBounds)) {
                val placeable = compose(index = index).map {
                    it.measure(constraints = Constraints())
                }.first()
                ProcessedMindMapItem(
                    placeable = placeable,
                    finalXPosition = finalXPosition,
                    finalYPosition = finalYPosition
                )
            } else {
                null
            }
        }

        println("Visible item count: ${visibleItems.size}, screen size: $layoutWidth x $layoutHeight")

        layout(constraints.maxWidth, constraints.maxHeight) {
            visibleItems.fastForEach { item ->
                item.placeable.place(
                    x = item.finalXPosition - item.placeable.width / 2,
                    y = item.finalYPosition - item.placeable.height / 2
                )
            }
        }
    }
}

@Composable
fun LazyMindMapDemo(modifier: Modifier = Modifier) {
    val mindMapItems = remember {
        listOf(
            MindMapItem(
                absoluteOffset = Offset(
                    x = 0f,
                    y = 0f
                )
            ) { modifier ->
                Text(text = "Hello world 1", modifier = modifier)
            },
            MindMapItem(
                absoluteOffset = Offset(
                    x = 1_100f,
                    y = 0f
                )
            ) {
                Column(modifier = it.fillMaxWidth()) {
                    Text("Hello world 2")
                    Text("Max width --->")
                }
            },
            MindMapItem(
                absoluteOffset = Offset(
                    x = 300f,
                    y = -1_700f
                )
            ) {
                Text("Hello world 3 ".repeat(30).trimEnd(), modifier = it)
            },
            MindMapItem(
                absoluteOffset = Offset(
                    x = -200f,
                    y = 3_000f
                )
            ) {
                Text("Hello world 4", modifier = it)
            },
            MindMapItem(
                absoluteOffset = Offset(
                    x = -400f,
                    y = 0f,
                )
            ) {
                Box(modifier = it)
            },
            MindMapItem(
                absoluteOffset = Offset(
                    x = 0f,
                    y = 600f,
                )
            ) {
                Box(modifier = it) {
                    Text("a")
                    Text("z", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Right)
                }
            }
        )
    }

    var mindMapOffset by remember {
        mutableStateOf(IntOffset.Zero)
    }
    LazyMindMap(
        items = mindMapItems,
        mindMapOffset = mindMapOffset,
        onDrag = { delta ->
            mindMapOffset += delta
        },
        modifier = modifier
            .fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
private fun LazyMindMapDemoPreview() {
    PracticeTheme {
        LazyMindMapDemo()
    }
}