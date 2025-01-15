package ru.noxis.financeuiapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices.PIXEL_4
import androidx.compose.ui.tooling.preview.Preview
import ru.noxis.financeuiapp.components.FinancePieRowView
import ru.noxis.financeuiapp.model.FinancePieData
import ru.noxis.financeuiapp.ui.theme.BerryRed
import ru.noxis.financeuiapp.ui.theme.Blue
import ru.noxis.financeuiapp.ui.theme.Green
import ru.noxis.financeuiapp.ui.theme.Orange
import ru.noxis.financeuiapp.ui.theme.Pine
import ru.noxis.financeuiapp.ui.theme.Pink

@Composable
@Preview(device = PIXEL_4, backgroundColor = 0xFFFFFFFF, showBackground = true)
fun FinancePieRowDemoScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceEvenly) {

        FinancePieRowView(
            pieDataPair = Pair(
                FinancePieData("Today", 181.39f, 1000f, Pink),
                FinancePieData("March", 734.02f, 1000f, Pine)
            )
        )

        FinancePieRowView(
            pieDataPair = Pair(
                FinancePieData("Entertainment", 5.01f, 300f, Orange),
                FinancePieData("Restaurant", 120.02f, 500f, Blue)
            )
        )

        FinancePieRowView(
            pieDataPair = Pair(
                FinancePieData("Services", 51.01f, 300f, Green),
                FinancePieData("Transport", 220.02f, 500f, BerryRed)
            )
        )
    }
}