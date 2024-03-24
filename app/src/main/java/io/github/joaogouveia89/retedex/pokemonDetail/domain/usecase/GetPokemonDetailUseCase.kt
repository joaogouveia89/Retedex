package io.github.joaogouveia89.retedex.pokemonDetail.domain.usecase

import io.github.joaogouveia89.retedex.core.domain.model.PokemonDetail
import io.github.joaogouveia89.retedex.core.util.ResultData
import kotlinx.coroutines.flow.Flow

interface GetPokemonDetailUseCase {
    suspend operator fun invoke(pokeId: Int): Flow<ResultData<PokemonDetail>>
}