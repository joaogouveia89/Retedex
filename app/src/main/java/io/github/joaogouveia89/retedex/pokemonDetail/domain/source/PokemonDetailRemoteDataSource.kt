package io.github.joaogouveia89.retedex.pokemonDetail.domain.source

import io.github.joaogouveia89.retedex.core.data.remote.response.PokemonDetailResponse

interface PokemonDetailRemoteDataSource {
    suspend fun getPokemonDetail(pokeId: Int): PokemonDetailResponse
}