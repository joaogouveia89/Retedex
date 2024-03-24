package io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase

import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface GetPokemonsFavoriteUseCase {
    suspend operator fun invoke(): Flow<List<Pokemon>>
}