package io.github.joaogouveia89.retedex.pokemon.data.source

import io.github.joaogouveia89.retedex.core.data.remote.PokemonService
import io.github.joaogouveia89.retedex.core.data.remote.response.PokemonResponse
import io.github.joaogouveia89.retedex.core.paging.PokemonPagingSource
import io.github.joaogouveia89.retedex.pokemon.domain.source.PokemonDataSource
import javax.inject.Inject

class PokemonDataSourceImpl @Inject constructor(
    private val service: PokemonService
): PokemonDataSource {

    override fun getPokemonPagingSource(): PokemonPagingSource =
        PokemonPagingSource(this)
    override suspend fun getPokemonList(offset: Int, limit: Int): PokemonResponse =
        service.getPokemons(
            offset = offset,
            limit = limit
        )
}