package io.github.joaogouveia89.retedex.pokemon.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.joaogouveia89.retedex.ui.theme.black


fun statsStringList(
    lazyListScope: LazyListScope,
    @StringRes title: Int,
    list: List<String>
) {
    lazyListScope.item {
        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(id = title),
            color = black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
    lazyListScope.items(list.size){
        Row {
            Icon(
                modifier = Modifier
                    .size(18.dp),
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = Color.Black
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                text = list[it],
                color = black,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        }
    }
}