package io.github.joaogouveia89.retedex.pokemon.presentation.state

import androidx.paging.PagingData
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class PokemonsState(
    var pokemons: Flow<PagingData<Pokemon>> = flowOf()
)
