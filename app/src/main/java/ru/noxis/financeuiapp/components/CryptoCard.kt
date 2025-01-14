package ru.noxis.financeuiapp.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.noxis.financeuiapp.ui.theme.CryptoLightGray
import ru.noxis.financeuiapp.ui.theme.FinanceUiAppTheme






@Composable
fun CryptoCardBackground(
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
        CryptoCardBackground()
    }
}