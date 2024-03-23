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
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.core.presentation.common.AsyncImageUrl
import io.github.joaogouveia89.retedex.ui.theme.BluePrimary
import io.github.joaogouveia89.retedex.ui.theme.black

@Composable
fun PokemonItem(
    modifier: Modifier = Modifier,
    pokemon: Pokemon,
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
                    onClick(pokemon.pokeId)
                },
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text(
                    text = "#${pokemon.pokeId}",
                    color = black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )


                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(pokemon.spriteUrl)
                        .crossfade(true)
                        .error(R.drawable.pokeball)
                        .placeholder(R.drawable.pokeball)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.FillHeight,
                    modifier = modifier
                        .padding(start = 6.dp)
                )

                Text(
                    text = pokemon.name,
                    color = black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 4.dp, start = 6.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PokemonItemPreview() {
    PokemonItem(
        pokemon = Pokemon(
            pokeId = 4,
            name = "Charmander",
            spriteUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/x-y/4.png"
        ),
        onClick = {}
    )
}