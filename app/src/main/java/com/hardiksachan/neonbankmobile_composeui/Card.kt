package com.hardiksachan.neonbankmobile_composeui

import androidx.compose.ui.graphics.Color


data class Card(
    val cardNumber: Int,
    val title: String,
    val amount: Int,
    val color: Color
)
