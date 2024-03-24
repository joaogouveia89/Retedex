package io.github.joaogouveia89.retedex.pokemonFavorite.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.github.joaogouveia89.retedex.R
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.core.presentation.common.PokemonListItem
import io.github.joaogouveia89.retedex.ui.theme.BluePrimary
import io.github.joaogouveia89.retedex.ui.theme.black
import io.github.joaogouveia89.retedex.ui.theme.white

@Composable
fun PokemonsFavoritesContent(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    pokemons: List<Pokemon>,
    onClick: (id: Int) -> Unit
) {
    Box(
        modifier = modifier
            .background(white)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(BluePrimary)
    ) {
        if (pokemons.isEmpty()) {
            Text(
                text = stringResource(id = R.string.favorite_pokemons_empty),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = black,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = paddingValues
            ) {
                items(pokemons.size) { index ->
                    val pokemon = pokemons[index]

                    PokemonListItem(
                        pokemon = pokemon,
                        onClick = onClick
                    )
                }
            }
        }
    }
}