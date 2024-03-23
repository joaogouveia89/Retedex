package io.github.joaogouveia89.retedex.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.joaogouveia89.retedex.core.data.local.daos.PokemonDao
import io.github.joaogouveia89.retedex.core.data.local.entities.PokemonEntity

@Database(
    entities = [PokemonEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}