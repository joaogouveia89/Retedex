package io.github.joaogouveia89.retedex.pokemonFavorite.data.usecase

import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.repository.PokemonFavoriteRepository
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase.GetPokemonsFavoriteUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonsFavoriteUseCaseImpl @Inject constructor(
    private val repository: PokemonFavoriteRepository
) : GetPokemonsFavoriteUseCase {
    override suspend fun invoke(): Flow<List<Pokemon>> =
        repository.getPokemons()
}