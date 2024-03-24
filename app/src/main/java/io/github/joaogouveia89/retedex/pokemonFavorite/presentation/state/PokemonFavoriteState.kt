package io.github.joaogouveia89.retedex.pokemonFavorite.presentation.state

import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class PokemonFavoriteState(
    val pokemons: Flow<List<Pokemon>> = emptyFlow()
)
