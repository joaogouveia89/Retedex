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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import io.github.joaogouveia89.retedex.R
import io.github.joaogouveia89.retedex.core.presentation.common.AsyncImageUrl
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
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )

                // TODO: if the pokemon is a favorite one, show the sprites of it
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("")
                        .crossfade(true)
                        .error(R.drawable.pokeball)
                        .placeholder(R.drawable.pokeball)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.FillHeight,
                    modifier = modifier
                        .padding(start = 6.dp)
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