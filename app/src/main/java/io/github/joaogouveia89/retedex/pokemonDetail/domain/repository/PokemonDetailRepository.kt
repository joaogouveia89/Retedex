package io.github.joaogouveia89.retedex.pokemonDetail.domain.repository

import io.github.joaogouveia89.retedex.core.domain.model.PokemonDetail
import kotlinx.coroutines.flow.Flow

interface PokemonDetailRepository {
    suspend fun getPokemonDetails(pokeId: Int): Flow<PokemonDetail>
}