package io.github.joaogouveia89.retedex.pokemon.domain.usecase

import androidx.paging.PagingData
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface GetPokemonsUseCase {
    operator fun invoke(): Flow<PagingData<Pokemon>>
}