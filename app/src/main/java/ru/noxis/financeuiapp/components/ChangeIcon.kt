package ru.noxis.financeuiapp.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.noxis.financeuiapp.R

@Composable
fun ChangeIcon(valueChange: Int = -18) {
    var iconModifier: Modifier = Modifier
    val tint: Color
    val contentDescription: String

    if (valueChange > 0) {
        tint = Color(0xFFFFFFFF)
        iconModifier = Modifier.rotate(180f)
        contentDescription = "Arrow Up"
    } else {
        tint = Color(0xFFa97d72)
        contentDescription = "Arrow Down"
    }

    Icon(
        modifier = iconModifier.size(17.dp),
        painter = painterResource(id = R.drawable.ic_arrow_bottom_left),
        contentDescription = contentDescription,
        tint = tint
    )
}