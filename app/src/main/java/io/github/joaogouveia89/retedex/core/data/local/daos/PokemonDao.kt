package io.github.joaogouveia89.retedex.core.data.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.joaogouveia89.retedex.core.data.local.entities.PokemonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * FROM Pokemon ORDER BY pokeId")
    fun getPokemons(): Flow<List<PokemonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemonEntity: PokemonEntity)

    @Query("SELECT COUNT(*) FROM Pokemon WHERE pokeId = :pokeId")
    suspend fun isFavorite(pokeId: Int): Int

    @Delete
    suspend fun deletePokemon(pokemonEntity: PokemonEntity)
}