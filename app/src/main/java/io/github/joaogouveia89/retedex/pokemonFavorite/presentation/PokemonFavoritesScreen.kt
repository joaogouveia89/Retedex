package io.github.joaogouveia89.retedex.pokemonFavorite.presentation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import io.github.joaogouveia89.retedex.R
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.core.presentation.common.RetedexAppBar
import io.github.joaogouveia89.retedex.pokemonFavorite.presentation.components.PokemonsFavoritesContent
import io.github.joaogouveia89.retedex.pokemonFavorite.presentation.state.PokemonFavoriteState

@Composable
fun PokemonFavoritesScreen(
    pokemons: List<Pokemon>,
    navigateToDetailPokemon: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            RetedexAppBar(
                title = R.string.favorite_pokemons
            )
        },
        content = { paddingValues ->
            PokemonsFavoritesContent(
                paddingValues = paddingValues,
                pokemons = pokemons,
                onClick = { pokeId ->
                    navigateToDetailPokemon(pokeId)
                }
            )
        }
    )
}