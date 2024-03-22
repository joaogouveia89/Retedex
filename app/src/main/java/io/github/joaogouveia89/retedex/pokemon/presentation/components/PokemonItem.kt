package io.github.joaogouveia89.retedex.pokemon.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.joaogouveia89.retedex.ui.theme.BluePrimary
import io.github.joaogouveia89.retedex.ui.theme.black

@Composable
fun PokemonItem(
    modifier: Modifier = Modifier,
    index: Int,
    name: String,
    onClick: (pokemonId: Int) -> Unit
) {
    Box(
        modifier = modifier
            .background(BluePrimary)
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(6.dp)
                .clickable {
                    onClick(index)
                },
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text(
                    text = "$index - $name",
                    color = black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium,
                    fontSize = 25.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun PokemonItemPreview() {
    PokemonItem(
        index = 4,
        name = "Charmander",
        onClick = {}
    )
}