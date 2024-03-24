package io.github.joaogouveia89.retedex.pokemonFavorite.data.source

import io.github.joaogouveia89.retedex.core.data.local.daos.PokemonDao
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.pokemonFavorite.data.mapper.toPokemonEntity
import io.github.joaogouveia89.retedex.pokemonFavorite.data.mapper.toPokemons
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.source.PokemonFavoriteLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokemonFavoriteLocalDataSourceImpl @Inject constructor(
    private val dao: PokemonDao
) : PokemonFavoriteLocalDataSource {
    override fun getPokemons(): Flow<List<Pokemon>> =
        dao.getPokemons().map { it.toPokemons() }

    override suspend fun insert(pokemon: Pokemon) {
        dao.insertPokemon(pokemon.toPokemonEntity())
    }

    override suspend fun delete(pokemon: Pokemon) {
        dao.deletePokemon(pokemon.toPokemonEntity())
    }

    override suspend fun isFavorite(pokeId: Int): Boolean =
        dao.isFavorite(pokeId) != 0

}