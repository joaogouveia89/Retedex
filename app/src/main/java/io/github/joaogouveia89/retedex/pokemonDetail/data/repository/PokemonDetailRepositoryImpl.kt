package io.github.joaogouveia89.retedex.pokemonDetail.data.repository

import io.github.joaogouveia89.retedex.core.domain.model.PokemonDetail
import io.github.joaogouveia89.retedex.core.util.ResultData
import io.github.joaogouveia89.retedex.pokemonDetail.data.mapper.asPokemonDetail
import io.github.joaogouveia89.retedex.pokemonDetail.domain.repository.PokemonDetailRepository
import io.github.joaogouveia89.retedex.pokemonDetail.domain.source.PokemonDetailRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class PokemonDetailRepositoryImpl @Inject constructor(
    val dataSource: PokemonDetailRemoteDataSource
): PokemonDetailRepository {
    override suspend fun getPokemonDetails(pokeId: Int): PokemonDetail =
        dataSource.getPokemonDetail(pokeId = pokeId).asPokemonDetail()

}