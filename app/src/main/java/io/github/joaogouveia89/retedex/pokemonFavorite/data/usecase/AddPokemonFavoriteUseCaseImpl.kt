package io.github.joaogouveia89.retedex.pokemonFavorite.data.usecase

import io.github.joaogouveia89.retedex.core.util.ResultData
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.repository.PokemonFavoriteRepository
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase.AddPokemonFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AddPokemonFavoriteUseCaseImpl @Inject constructor(
    private val repository: PokemonFavoriteRepository
) : AddPokemonFavoriteUseCase {
    override suspend fun invoke(params: AddPokemonFavoriteUseCase.Params): Flow<ResultData<Unit>> =
        flow {
            val insert: Unit = repository.insert(params.pokemon)
            emit(ResultData.Success(insert))
        }.flowOn(Dispatchers.IO)
}