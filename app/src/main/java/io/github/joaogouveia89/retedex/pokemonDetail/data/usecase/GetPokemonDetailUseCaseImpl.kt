package io.github.joaogouveia89.retedex.pokemonDetail.data.usecase

import androidx.paging.PagingSource
import io.github.joaogouveia89.retedex.core.domain.model.PokemonDetail
import io.github.joaogouveia89.retedex.core.util.ResultData
import io.github.joaogouveia89.retedex.pokemonDetail.domain.repository.PokemonDetailRepository
import io.github.joaogouveia89.retedex.pokemonDetail.domain.usecase.GetPokemonDetailUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonDetailUseCaseImpl @Inject constructor(
    private val repository: PokemonDetailRepository
): GetPokemonDetailUseCase {
    override suspend fun invoke(pokeId: Int): Flow<ResultData<PokemonDetail>> = flow {
        emit(ResultData.Loading)
        try {
            val details = repository.getPokemonDetails(pokeId)
            emit(ResultData.Success(details))
        }catch (exception: IOException) {
            emit(ResultData.Failure(exception))
        } catch (exception: HttpException) {
            emit(ResultData.Failure(exception))
        }
    }

}