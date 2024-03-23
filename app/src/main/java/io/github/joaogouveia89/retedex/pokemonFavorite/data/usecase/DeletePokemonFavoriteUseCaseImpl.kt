package io.github.joaogouveia89.retedex.pokemonFavorite.data.usecase

import io.github.joaogouveia89.retedex.core.util.ResultData
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.repository.PokemonFavoriteRepository
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase.DeletePokemonFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DeletePokemonFavoriteUseCaseImpl @Inject constructor(
    private val repository: PokemonFavoriteRepository
) : DeletePokemonFavoriteUseCase {
    override suspend fun invoke(params: DeletePokemonFavoriteUseCase.Params): Flow<ResultData<Unit>> =
        flow {
            val delete: Unit = repository.delete(params.pokemon)
            emit(ResultData.Success(delete))
        }.flowOn(Dispatchers.IO)
}