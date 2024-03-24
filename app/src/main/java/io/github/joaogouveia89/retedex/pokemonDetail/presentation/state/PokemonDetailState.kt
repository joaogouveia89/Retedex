package io.github.joaogouveia89.retedex.pokemonDetail.presentation.state

import io.github.joaogouveia89.retedex.core.domain.model.PokemonDetail

data class PokemonDetailState(
    val pokemonDetails: PokemonDetail,
    val isLoading: Boolean = false,
    val error: String? = null
)
