package io.github.joaogouveia89.retedex.pokemonFavorite.domain.source

import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonFavoriteLocalDataSource {
    fun getPokemons(): Flow<List<Pokemon>>

    suspend fun insert(pokemon: Pokemon)

    suspend fun delete(pokemon: Pokemon)

    suspend fun isFavorite(pokeId: Int): Boolean
}