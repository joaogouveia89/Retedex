package io.github.joaogouveia89.retedex.pokemon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.joaogouveia89.retedex.core.data.remote.PokemonService
import io.github.joaogouveia89.retedex.pokemon.data.repository.PokemonRepositoryImpl
import io.github.joaogouveia89.retedex.pokemon.data.source.PokemonDataSourceImpl
import io.github.joaogouveia89.retedex.pokemon.data.usecase.GetPokemonsUseCaseImpl
import io.github.joaogouveia89.retedex.pokemon.domain.repository.PokemonRepository
import io.github.joaogouveia89.retedex.pokemon.domain.source.PokemonDataSource
import io.github.joaogouveia89.retedex.pokemon.domain.usecase.GetPokemonsUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokemonsFeatureModule {
    @Provides
    @Singleton
    fun providePokemonDataSource(service: PokemonService): PokemonDataSource =
        PokemonDataSourceImpl(service = service)

    @Provides
    @Singleton
    fun providePokemonRepository(remoteDataSource: PokemonDataSource): PokemonRepository =
        PokemonRepositoryImpl(remoteDataSource = remoteDataSource)

    @Provides
    @Singleton
    fun provideGetPokemonUseCase(pokemonRepository: PokemonRepository): GetPokemonsUseCase =
        GetPokemonsUseCaseImpl(repository = pokemonRepository)
}