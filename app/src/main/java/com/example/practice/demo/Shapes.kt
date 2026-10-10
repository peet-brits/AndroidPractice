package com.example.practice.demo

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

data object TriangleShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                moveTo(x = size.width / 2f, y = 0f)
                lineTo(x = 0f, y = size.height)
                lineTo(x = size.width, y = size.height)
                close()
            }
        )
    }
}

class BasicStarShape(
    private val stretch: Float = 0f,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val left = 0f - stretch
        val right = size.width + stretch
        val top = 0f - stretch
        val bottom = size.height + stretch
        return Outline.Generic(
            path = Path().apply {
                moveTo(x = (left + right) / 2f, y = top)
                lineTo(x = left, y = bottom)
                lineTo(x = right, y = (top + bottom) / 3f)
                lineTo(x = left, y = (top + bottom) / 3f)
                lineTo(x = right, y = bottom)
                close()
            }
        )
    }
}

class CalculatedStarShape(
    private val points: Int = 5,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val stretch = 0f // stretch not working for this one
        val left = 0f - stretch
        val right = size.width + stretch
        val top = 0f - stretch
        val bottom = size.height + stretch

        var first = true

        return Outline.Generic(
            path = Path().apply {
                starPoints(
                    points = points,
                    centerX = (left + right) / 2,
                    centerY = (top + bottom) / 2,
                    outerRadius = (top + bottom) / 2,
                    innerRadius = (top + bottom) / 4,
                ).forEach { offset ->
                    if (first) {
                        moveTo(offset.x, offset.y)
                        first = false
                    } else {
                        lineTo(offset.x, offset.y)
                    }
                }
                close()
            }
        )
    }
}