package io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase

import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.core.util.ResultData
import kotlinx.coroutines.flow.Flow

interface DeletePokemonFavoriteUseCase{
    suspend operator fun invoke(params: Params): Flow<ResultData<Unit>>
    data class Params(val pokemon: Pokemon)
}