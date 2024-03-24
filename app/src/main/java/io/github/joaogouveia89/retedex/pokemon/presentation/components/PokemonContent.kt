package io.github.joaogouveia89.retedex.pokemon.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import io.github.joaogouveia89.retedex.R
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.core.presentation.common.ErrorScreen
import io.github.joaogouveia89.retedex.core.presentation.common.LoadingScreen
import io.github.joaogouveia89.retedex.core.presentation.common.LoadingView
import io.github.joaogouveia89.retedex.core.presentation.common.PokemonListItem
import io.github.joaogouveia89.retedex.ui.theme.BlueSecondary

@Composable
fun PokemonContent(
    modifier: Modifier = Modifier,
    pagingPokemons: LazyPagingItems<Pokemon>,
    paddingValues: PaddingValues,
    onClick: (pokemonId: Int) -> Unit
) {
    if (pagingPokemons.loadState.refresh is LoadState.Loading) {
        LoadingScreen()
    } else {
        Box(
            modifier = modifier.background(BlueSecondary)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = paddingValues
            ) {
                items(pagingPokemons.itemCount) { index ->
                    val pokemonNullable = pagingPokemons[index]

                    pokemonNullable?.let { pokemon ->
                        PokemonListItem(
                            pokemon = pokemon,
                            onClick = onClick
                        )
                    }
                }
                pagingPokemons.apply {
                    when {
                        loadState.append is LoadState.Loading -> {
                            item {
                                LoadingView()
                            }
                        }

                        loadState.refresh is LoadState.Error -> {
                            item {
                                ErrorScreen(
                                    message = R.string.check_internet_connection_error,
                                    retry = { retry() }
                                )
                            }
                        }

                        loadState.append is LoadState.Error -> {
                            item {
                                ErrorScreen(
                                    message = R.string.check_internet_connection_error,
                                    retry = { retry() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}