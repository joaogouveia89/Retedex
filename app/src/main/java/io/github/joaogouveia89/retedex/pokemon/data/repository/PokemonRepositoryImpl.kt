package io.github.joaogouveia89.retedex.pokemon.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.pokemon.domain.repository.PokemonRepository
import io.github.joaogouveia89.retedex.pokemon.domain.source.PokemonDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonDataSource
) : PokemonRepository {
    override fun getPokemons(pagingConfig: PagingConfig): Flow<PagingData<Pokemon>> =
        Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDataSource.getPokemonPagingSource()
            }
        ).flow
}