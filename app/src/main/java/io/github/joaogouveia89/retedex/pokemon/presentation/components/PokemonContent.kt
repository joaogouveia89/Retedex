package io.github.joaogouveia89.retedex.pokemon.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.ui.theme.BlueSecondary
import io.github.joaogouveia89.retedex.ui.theme.white

@Composable
fun PokemonContent(
    modifier: Modifier = Modifier,
    pagingPokemons: LazyPagingItems<Pokemon>,
    paddingValues: PaddingValues,
    onClick: (pokemonId: Int) -> Unit
) {
    Box(
        modifier = modifier.background(BlueSecondary)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = paddingValues
        ){
            items(pagingPokemons.itemCount){index ->
                val pokemonNullable = pagingPokemons[index]

                pokemonNullable?.let { pokemon ->
                    PokemonItem(
                        pokemon = pokemon,
                        onClick = onClick
                    )
                }
            }
        }
    }
}