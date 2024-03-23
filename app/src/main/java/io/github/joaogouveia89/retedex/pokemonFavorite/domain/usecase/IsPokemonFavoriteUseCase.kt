package io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase

import io.github.joaogouveia89.retedex.core.util.ResultData
import kotlinx.coroutines.flow.Flow

interface IsPokemonFavoriteUseCase {
    suspend operator fun invoke(params: Params): Flow<ResultData<Boolean>>
    data class Params(val pokeId: Int)
}