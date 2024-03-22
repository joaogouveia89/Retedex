package io.github.joaogouveia89.retedex.pokemonDetail.data.repository

import io.github.joaogouveia89.retedex.core.domain.model.PokemonDetail
import io.github.joaogouveia89.retedex.pokemonDetail.data.mapper.asPokemonDetail
import io.github.joaogouveia89.retedex.pokemonDetail.domain.repository.PokemonDetailRepository
import io.github.joaogouveia89.retedex.pokemonDetail.domain.source.PokemonDetailDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class PokemonDetailRepositoryImpl @Inject constructor(
    val dataSource: PokemonDetailDataSource
): PokemonDetailRepository {
    override suspend fun getPokemonDetails(pokeId: Int): Flow<PokemonDetail> =
        flowOf(dataSource.getPokemonDetail(pokeId).asPokemonDetail())

}