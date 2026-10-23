package com.example.practice.advanced

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.draggable2D
import androidx.compose.foundation.gestures.rememberDraggable2DState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.layout.LazyLayout
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
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
    val offset: Offset,
    val constraints: Constraints,
    val content: @Composable () -> Unit,
)

private data class ProcessedMindMapItem(
    val placeable: Placeable,
    val finalXPosition: Int,
    val finalYPosition: Int,
)

@Composable
fun LazyMindMap(
    items: List<MindMapItem>,
    onDrag: (delta: IntOffset) -> Unit,
    modifier: Modifier = Modifier,
    mindMapOffset: IntOffset = IntOffset.Zero,
) {
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
                    val item = items[index]
                    Box(
                        modifier = Modifier
                            .background(Color.LightGray)
                    ) {
                        Layout(
                            content = item.content,
                            measurePolicy = { measurables, _ ->
                                val placeableList = measurables.map {
                                    it.measure(item.constraints)
                                }
                                val maxWidth = placeableList.maxOfOrNull { it.width } ?: 0
                                val maxHeight = placeableList.maxOfOrNull { it.height } ?: 0

                                layout(maxWidth, maxHeight) {
                                    placeableList.fastForEach {
                                        it.place(0, 0)
                                    }
                                }
                            }
                        )
                    }
                }
            }
        },
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
                (item.offset.x + layoutWidth / 2 + mindMapOffset.x).roundToInt()
            val finalYPosition =
                (item.offset.y + layoutHeight / 2 + mindMapOffset.y).roundToInt()

            val maxItemWidth = item.constraints.maxWidth
            val maxItemHeight = item.constraints.maxHeight
            val extendedItemBounds = IntRect(
                left = finalXPosition - maxItemWidth / 2,
                top = finalYPosition - maxItemHeight / 2,
                right = finalXPosition + 3 * (maxItemWidth / 2),
                bottom = finalYPosition + 3 * (maxItemHeight / 2)
            )

            if (visibleArea.overlaps(extendedItemBounds)) {
                val placeableList = compose(index = index).map {
                    it.measure(constraints = item.constraints)
                }
                placeableList.map {
                    ProcessedMindMapItem(
                        placeable = it,
                        finalXPosition = finalXPosition,
                        finalYPosition = finalYPosition
                    )
                }
            } else {
                null
            }
        }

        println("Visible item count: ${visibleItems.size}, screen size: $layoutWidth x $layoutHeight")

        layout(constraints.maxWidth, constraints.maxHeight) {
            visibleItems.flatten().fastForEach { item ->
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
                offset = Offset(
                    x = 0f,
                    y = 0f
                ),
                constraints = Constraints(
                    maxWidth = 500,
                    maxHeight = 300,
                )
            ) {
                Text(text = "Hello world 1")
            },
            MindMapItem(
                offset = Offset(
                    x = 1_100f,
                    y = 0f
                ),
                constraints = Constraints(
                    maxWidth = 500,
                    maxHeight = 300,
                )
            ) {
                Column {
                    Text("Hello world 2")
                    Text("Hello world 2 again")
                }
            },
            MindMapItem(
                offset = Offset(
                    x = 300f,
                    y = -1_700f
                ),
                constraints = Constraints(
                    maxWidth = 800,
                    maxHeight = 500,
                )
            ) {
                Text("Hello world 3 ".repeat(30).trimEnd())
            },
            MindMapItem(
                offset = Offset(
                    x = -200f,
                    y = 3_000f
                ),
                constraints = Constraints(
                    maxWidth = 500,
                    maxHeight = 300,
                )
            ) {
                Text("Hello world 4")
            },
            MindMapItem(
                offset = Offset(
                    x = -400f,
                    y = 0f,
                ),
                constraints = Constraints(
                    maxWidth = 100,
                    maxHeight = 100,
                )
            ) {
                Box(Modifier.size(10.dp))
            },
            MindMapItem(
                offset = Offset(
                    x = 0f,
                    y = 600f,
                ),
                constraints = Constraints(
                    maxWidth = 700,
                    maxHeight = 400,
                )
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text("a")
                    Text("z", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Right)
                    Text("m", modifier = Modifier.align(Alignment.BottomCenter))
                }
            },
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