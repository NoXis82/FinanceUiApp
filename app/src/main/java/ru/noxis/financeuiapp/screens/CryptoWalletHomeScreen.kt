package ru.noxis.financeuiapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.noxis.financeuiapp.R
import ru.noxis.financeuiapp.components.CryptoCard
import ru.noxis.financeuiapp.enums.CryptoCardStyle
import ru.noxis.financeuiapp.model.CryptoCardData

@Composable
@Preview(showBackground = true)
fun CryptoWalletHomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        CryptoWalletCoinCardPairRow()

        AssetCardListDemoScreen()
    }
}

@Composable
@Preview(device = Devices.PIXEL_4, backgroundColor = 0xFFFFFFFF, showBackground = true)
fun CryptoWalletCoinCardPairRow(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        CryptoCard(
            style = CryptoCardStyle.Dark,
            data = CryptoCardData(
                name = "Bitcoin",
                icon = R.drawable.ic_btc,
                value = 3.689087f,
                valueChange = -18,
                currentTotal = 98160
            )
        )

        CryptoCard(
            style = CryptoCardStyle.Light,
            data = CryptoCardData(
                name = "Ethereum",
                icon = R.drawable.ic_ethereum,
                value = 94.48096f,
                valueChange = 26,
                currentTotal = 180480
            )
        )
    }
}