package io.github.joaogouveia89.retedex.pokemonFavorite.data.usecase

import io.github.joaogouveia89.retedex.core.util.ResultData
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.repository.PokemonFavoriteRepository
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase.IsPokemonFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class IsPokemonFavoriteUseCaseImpl @Inject constructor(
    private val repository: PokemonFavoriteRepository
): IsPokemonFavoriteUseCase {
    override suspend fun invoke(params: IsPokemonFavoriteUseCase.Params): Flow<ResultData<Boolean>> =
        flow {
            val isFavorite: Boolean = repository.isFavorite(pokeId = params.pokeId)
            emit(ResultData.Success(isFavorite))
        }.flowOn(Dispatchers.IO)
}