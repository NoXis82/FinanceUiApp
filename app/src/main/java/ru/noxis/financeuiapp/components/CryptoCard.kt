package ru.noxis.financeuiapp.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import ru.noxis.financeuiapp.R
import ru.noxis.financeuiapp.enums.CryptoCardStyle
import ru.noxis.financeuiapp.model.CryptoCardData
import ru.noxis.financeuiapp.ui.theme.CryptoLightGray
import ru.noxis.financeuiapp.ui.theme.FinanceUiAppTheme
import java.text.DecimalFormat

@Composable
fun CryptoCard(
    style: CryptoCardStyle = CryptoCardStyle.Dark,
    data: CryptoCardData
) {

    val cardBackground: Color = when (style) {
        CryptoCardStyle.Dark -> Color(0xFF000000)
        CryptoCardStyle.Light -> Color(0xFFadc9ae)
    }

    val textColor: Color = when (style) {
        CryptoCardStyle.Dark -> Color(0xFFFFFFFF)
        CryptoCardStyle.Light -> Color(0xFF000000)
    }

    Box {
        CryptoCardBackground(cardBackground)

        var visible by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            delay(300)
            visible = true
        }

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn() + slideInVertically { fullHeight -> fullHeight },
        ) {
            CryptoCardContent(data, textColor)
        }

    }

}


@Composable
private fun CryptoCardContent(
    data: CryptoCardData,
    textColor: Color
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.size(150.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Text(
                    text = "${data.valueChange}%",
                    color = textColor,
                    style = MaterialTheme.typography.labelMedium
                )
                ChangeIcon(data.valueChange)
            }

            Icon(
                painter = painterResource(id = data.icon),
                contentDescription = "Card Icon",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
        }
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = data.name,
                color = textColor,
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = "${data.value}",
                color = textColor,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = formatCurrentTotal(data.currentTotal),
                color = textColor,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

private fun formatCurrentTotal(currentTotal: Long): String {
    val decimalFormat = DecimalFormat("$#,###")
    return decimalFormat.format(currentTotal)
}


@Composable
private fun CryptoCardBackground(
    cardBackground: Color = Color.Black,
    bubbleColor: Color = CryptoLightGray,
    backgroundColor: Color = Color.White,
    cardSize: Dp = 150.dp,
) {
    val radius = cardSize.value / 2f
    Box {

        Card(
            modifier = Modifier
                .size(cardSize)
                .clip(RoundedCornerShape(15.dp)),
            colors = CardDefaults.cardColors(containerColor = cardBackground)
        ) {
            Canvas(modifier = Modifier.size(cardSize)) {
                drawRect(
                    color = backgroundColor,
                    topLeft = Offset(x = size.width - radius + (radius * 0.2f), y = 12f),
                    size = size / 2f
                )
                drawRect(
                    color = backgroundColor,
                    topLeft = Offset(x = cardSize.value * 1.3f, y = cardSize.value * -1f),
                    size = size / 2f
                )
                drawCircle(
//                color = Color.Red,
                    color = backgroundColor,
                    radius = cardSize.value / 1.5f,
                    center = Offset(
                        x = size.width - radius + (radius * 0.2f),
                        y = radius - (radius * 0.2f)
                    )
                )
                drawCircle(
//                color = Color.Green,
                    color = cardBackground,
                    radius = radius * 0.8f,
                    center = Offset(
                        x = size.width / 2.14f,
                        y = radius - (radius * 0.2f)
                    )
                )

                drawCircle(
//                color = Color.Green,
                    color = cardBackground,
                    radius = radius * 0.8f,
                    center = Offset(
                        x = size.width - radius + (radius * 0.2f),
                        y = radius + (radius * 1.93f)
                    )
                )

//            drawCircle(
//                color = bubbleColor,
//                radius = radius * 0.8f,
//                center = Offset(
//                    x = size.width - radius + (radius * 0.2f),
//                    y = radius - (radius * 0.2f)
//                )
//            )

            }
        }
        Canvas(modifier = Modifier.size(cardSize)) {
            drawRect(
                color = backgroundColor,
                topLeft = Offset(x = size.width - (cardSize.value / 2f) - 7.5f, y = 0f),
                size = size / 5f
            )
            drawCircle(
                color = bubbleColor,
                radius = radius * 0.8f,
                center = Offset(
                    x = size.width - radius + (radius * 0.2f),
                    y = radius - (radius * 0.2f)
                )
            )
        }
    }
}


@Preview
@Composable
private fun CryptoCardPreview() {
    FinanceUiAppTheme {
        CryptoCard(
            data = CryptoCardData(
                name = "Bitcoin",
                icon = R.drawable.ic_btc,
                value = 3.689087f,
                valueChange = -18,
                currentTotal = 98160
            )
        )
    }
}