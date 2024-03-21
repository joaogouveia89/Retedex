package io.github.joaogouveia89.retedex.pokemon.data.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.pokemon.domain.repository.PokemonRepository
import io.github.joaogouveia89.retedex.pokemon.domain.usecase.GetPokemonsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonsUseCaseImpl @Inject constructor(
    private val repository: PokemonRepository
): GetPokemonsUseCase {
    override fun invoke(): Flow<PagingData<Pokemon>> =
        repository.getPokemons(
            pagingConfig = PagingConfig(
                pageSize = 151,
                initialLoadSize = 151
            )
        )
}