package io.github.joaogouveia89.retedex.pokemonDetail.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.joaogouveia89.retedex.core.data.remote.PokemonService
import io.github.joaogouveia89.retedex.pokemonDetail.data.repository.PokemonDetailRepositoryImpl
import io.github.joaogouveia89.retedex.pokemonDetail.data.source.PokemonDetailDataSourceImpl
import io.github.joaogouveia89.retedex.pokemonDetail.data.usecase.GetPokemonDetailUseCaseImpl
import io.github.joaogouveia89.retedex.pokemonDetail.domain.repository.PokemonDetailRepository
import io.github.joaogouveia89.retedex.pokemonDetail.domain.source.PokemonDetailDataSource
import io.github.joaogouveia89.retedex.pokemonDetail.domain.usecase.GetPokemonDetailUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonDetailsFeatureModule {
    @Provides
    @Singleton
    fun providePokemonDetailsDataSource(service: PokemonService): PokemonDetailDataSource =
        PokemonDetailDataSourceImpl(service = service)

    @Provides
    @Singleton
    fun providePokemonDetailRepository(dataSource: PokemonDetailDataSource): PokemonDetailRepository =
        PokemonDetailRepositoryImpl(dataSource = dataSource)

    @Provides
    @Singleton
    fun provideGetPokemonDetailUseCase(repository: PokemonDetailRepository): GetPokemonDetailUseCase =
        GetPokemonDetailUseCaseImpl(repository = repository)
}