package io.github.joaogouveia89.retedex.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.joaogouveia89.retedex.core.data.local.PokemonDatabase
import io.github.joaogouveia89.retedex.core.data.local.daos.PokemonDao
import io.github.joaogouveia89.retedex.core.util.Constants.POKEMON_DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun providePokemonDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        PokemonDatabase::class.java,
        POKEMON_DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun providePokemonDao(
        database: PokemonDatabase
    ): PokemonDao = database.pokemonDao()
}