package io.github.joaogouveia89.retedex.core.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.pokemon.data.mapper.asPokemonList
import io.github.joaogouveia89.retedex.pokemon.domain.source.PokemonDataSource
import retrofit2.HttpException
import java.io.IOException

class PokemonPagingSource(
    private val remoteDataSource: PokemonDataSource
) : PagingSource<Int, Pokemon>() {
    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            val offset = params.key ?: 0

            val response = remoteDataSource.getPokemonList(
                offset = offset,
                limit = LIMIT
            )

            val pokemonsResult = response.results

            LoadResult.Page(
                data = pokemonsResult.asPokemonList(),
                prevKey = if (offset == 0) null else offset - LIMIT,
                nextKey = offset + LIMIT
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val LIMIT = 151
    }

}