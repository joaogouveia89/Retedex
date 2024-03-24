package io.github.joaogouveia89.retedex.pokemonDetail.domain.repository

import io.github.joaogouveia89.retedex.core.domain.model.PokemonDetail

interface PokemonDetailRepository {
    suspend fun getPokemonDetails(pokeId: Int): PokemonDetail
}