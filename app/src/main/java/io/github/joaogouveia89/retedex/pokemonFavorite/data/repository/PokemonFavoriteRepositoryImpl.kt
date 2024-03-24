package io.github.joaogouveia89.retedex.pokemonFavorite.data.repository

import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.repository.PokemonFavoriteRepository
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.source.PokemonFavoriteLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonFavoriteRepositoryImpl @Inject constructor(
    private val localDataSource: PokemonFavoriteLocalDataSource
) : PokemonFavoriteRepository {
    override fun getPokemons(): Flow<List<Pokemon>> =
        localDataSource.getPokemons()

    override suspend fun insert(pokemon: Pokemon) {
        localDataSource.insert(pokemon)
    }

    override suspend fun delete(pokemon: Pokemon) {
        localDataSource.delete(pokemon)
    }

    override suspend fun isFavorite(pokeId: Int): Boolean =
        localDataSource.isFavorite(pokeId)
}