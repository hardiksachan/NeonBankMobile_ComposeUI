package com.hardiksachan.neonbankmobile_composeui

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color

fun linearInclinedGradient(
    initialColor: Color,
    finalColor: Color
) = linearGradient(
    0.0f to initialColor,
    1.0f to finalColor,
    start = Offset.Zero,
    end = Offset(1200f, 2400f)
)