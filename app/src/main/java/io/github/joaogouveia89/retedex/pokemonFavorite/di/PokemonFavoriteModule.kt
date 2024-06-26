package io.github.joaogouveia89.retedex.pokemonFavorite.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.joaogouveia89.retedex.core.data.local.daos.PokemonDao
import io.github.joaogouveia89.retedex.pokemonFavorite.data.repository.PokemonFavoriteRepositoryImpl
import io.github.joaogouveia89.retedex.pokemonFavorite.data.source.PokemonFavoriteLocalDataSourceImpl
import io.github.joaogouveia89.retedex.pokemonFavorite.data.usecase.AddPokemonFavoriteUseCaseImpl
import io.github.joaogouveia89.retedex.pokemonFavorite.data.usecase.DeletePokemonFavoriteUseCaseImpl
import io.github.joaogouveia89.retedex.pokemonFavorite.data.usecase.GetPokemonsFavoriteUseCaseImpl
import io.github.joaogouveia89.retedex.pokemonFavorite.data.usecase.IsPokemonFavoriteUseCaseImpl
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.repository.PokemonFavoriteRepository
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.source.PokemonFavoriteLocalDataSource
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase.AddPokemonFavoriteUseCase
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase.DeletePokemonFavoriteUseCase
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase.GetPokemonsFavoriteUseCase
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase.IsPokemonFavoriteUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonFavoriteModule {
    @Provides
    @Singleton
    fun providePokemonFavoriteLocalDataSource(dao: PokemonDao): PokemonFavoriteLocalDataSource =
        PokemonFavoriteLocalDataSourceImpl(dao = dao)

    @Provides
    @Singleton
    fun providePokemonFavoriteRepository(localDataSource: PokemonFavoriteLocalDataSource): PokemonFavoriteRepository =
        PokemonFavoriteRepositoryImpl(localDataSource = localDataSource)

    @Provides
    @Singleton
    fun provideAddPokemonFavoriteUseCase(repository: PokemonFavoriteRepository): AddPokemonFavoriteUseCase =
        AddPokemonFavoriteUseCaseImpl(repository = repository)

    @Provides
    @Singleton
    fun provideDeletePokemonFavoriteUseCase(repository: PokemonFavoriteRepository): DeletePokemonFavoriteUseCase =
        DeletePokemonFavoriteUseCaseImpl(repository = repository)

    @Provides
    @Singleton
    fun provideIsPokemonFavoriteUseCase(repository: PokemonFavoriteRepository): IsPokemonFavoriteUseCase =
        IsPokemonFavoriteUseCaseImpl(repository = repository)

    @Provides
    @Singleton
    fun provideGetPokemonFavoriteUseCase(repository: PokemonFavoriteRepository): GetPokemonsFavoriteUseCase =
        GetPokemonsFavoriteUseCaseImpl(repository = repository)
}