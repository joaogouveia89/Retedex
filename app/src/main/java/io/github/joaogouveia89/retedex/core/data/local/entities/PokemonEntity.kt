package io.github.joaogouveia89.retedex.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Pokemon")
data class PokemonEntity(
    @PrimaryKey(autoGenerate = false)
    val pokeId: Int,
    val name: String,
    val spriteUrl: String
)
