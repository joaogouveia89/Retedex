package io.github.joaogouveia89.retedex.pokemon.presentation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.paging.compose.collectAsLazyPagingItems
import io.github.joaogouveia89.retedex.R
import io.github.joaogouveia89.retedex.core.presentation.common.RetedexAppBar
import io.github.joaogouveia89.retedex.pokemon.presentation.components.PokemonContent
import io.github.joaogouveia89.retedex.pokemon.presentation.state.PokemonsState
import timber.log.Timber

@Composable
fun PokemonScreen(
    uiState: PokemonsState,
    navigateToDetailPokemon: (Int) -> Unit
) {

    val pokemons = uiState.pokemons.collectAsLazyPagingItems()
    Scaffold(
        topBar = {
            RetedexAppBar(
                title = R.string.pokemon
            )
        }
    ) { paddingValues ->
        PokemonContent(
            pagingPokemons = pokemons,
            paddingValues = paddingValues,
            onClick = { pokemonIndex ->
                Timber.i("PokemonIndex = $pokemonIndex")
                navigateToDetailPokemon(pokemonIndex)
            }
        )
    }
}