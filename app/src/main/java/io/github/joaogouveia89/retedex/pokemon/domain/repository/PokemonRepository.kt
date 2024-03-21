package io.github.joaogouveia89.retedex.pokemon.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemons(pagingConfig: PagingConfig): Flow<PagingData<Pokemon>>
}