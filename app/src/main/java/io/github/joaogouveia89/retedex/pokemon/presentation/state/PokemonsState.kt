package io.github.joaogouveia89.retedex.pokemon.presentation.state

import androidx.paging.PagingData
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon

data class PokemonsState(
    var pokemons: PagingData<Pokemon>
)
