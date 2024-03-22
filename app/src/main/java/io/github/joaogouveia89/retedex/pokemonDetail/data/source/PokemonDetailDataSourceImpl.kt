package io.github.joaogouveia89.retedex.pokemonDetail.data.source

import io.github.joaogouveia89.retedex.core.data.remote.PokemonService
import io.github.joaogouveia89.retedex.core.data.remote.response.PokemonDetailResponse
import io.github.joaogouveia89.retedex.pokemonDetail.domain.source.PokemonDetailDataSource
import javax.inject.Inject

class PokemonDetailDataSourceImpl @Inject constructor(
    private val service: PokemonService
): PokemonDetailDataSource {
    override suspend fun getPokemonDetail(pokeId: Int): PokemonDetailResponse =
        service.getPokemonDetail(pokeId)
}