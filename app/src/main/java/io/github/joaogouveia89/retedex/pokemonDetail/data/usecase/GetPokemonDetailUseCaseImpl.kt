package io.github.joaogouveia89.retedex.pokemonDetail.data.usecase

import io.github.joaogouveia89.retedex.core.domain.model.PokemonDetail
import io.github.joaogouveia89.retedex.pokemonDetail.domain.repository.PokemonDetailRepository
import io.github.joaogouveia89.retedex.pokemonDetail.domain.usecase.GetPokemonDetailUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonDetailUseCaseImpl @Inject constructor(
    private val repository: PokemonDetailRepository
): GetPokemonDetailUseCase {
    override suspend fun invoke(pokeId: Int): Flow<PokemonDetail> =
        repository.getPokemonDetails(pokeId)

}