package io.github.joaogouveia89.retedex.pokemonDetail.data.source

import io.github.joaogouveia89.retedex.core.data.remote.PokemonService
import io.github.joaogouveia89.retedex.core.data.remote.response.PokemonDetailResponse
import io.github.joaogouveia89.retedex.pokemonDetail.domain.source.PokemonDetailRemoteDataSource
import javax.inject.Inject

class PokemonDetailRemoteDataSourceImpl @Inject constructor(
    private val service: PokemonService
): PokemonDetailRemoteDataSource {
    override suspend fun getPokemonDetail(pokeId: Int): PokemonDetailResponse =
        service.getPokemonDetail(pokeId)
}