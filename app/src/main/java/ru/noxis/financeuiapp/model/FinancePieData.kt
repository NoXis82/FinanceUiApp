package ru.noxis.financeuiapp.model

import androidx.compose.ui.graphics.Color

data class FinancePieData(
    val label: String,
    val currentValue: Float,
    val fullValue: Float,
    val keyColor: Color
)
