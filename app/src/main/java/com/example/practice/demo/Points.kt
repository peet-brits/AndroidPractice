package com.example.practice.demo

import androidx.compose.ui.geometry.Offset
import kotlin.math.cos
import kotlin.math.sin

// https://chatgpt.com/c/6aca02e8-696c-83e9-9017-eba1c96b8de0

fun starPoints(
    points: Int = 5,
    centerX: Float,
    centerY: Float,
    outerRadius: Float,
    innerRadius: Float,
): List<Offset> {
    return (0 until points * 2).map { i ->
        val angle = Math.PI * i / points - Math.PI / 2
        val radius = if (i % 2 == 0) outerRadius else innerRadius

        Offset(
            x = centerX + (radius * cos(angle)).toFloat(),
            y = centerY + (radius * sin(angle)).toFloat()
        )
    }
}

fun starPointsOuterTips(
    centerX: Float,
    centerY: Float,
    radius: Float,
): List<Offset> =
    (0 until 5).map { i ->
        val angle = 2 * Math.PI * i / 5 - Math.PI / 2

        Offset(
            x = centerX + (radius * cos(angle)).toFloat(),
            y = centerY + (radius * sin(angle)).toFloat()
        )
    }