package io.github.joaogouveia89.retedex.pokemon.domain.source

import io.github.joaogouveia89.retedex.core.data.remote.response.PokemonResponse
import io.github.joaogouveia89.retedex.core.paging.PokemonPagingSource

interface PokemonDataSource {

    fun getPokemonPagingSource(): PokemonPagingSource
    suspend fun getPokemonList(offset: Int, limit: Int): PokemonResponse
}