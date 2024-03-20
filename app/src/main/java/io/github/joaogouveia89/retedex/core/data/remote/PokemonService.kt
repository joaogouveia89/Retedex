package io.github.joaogouveia89.retedex.core.data.remote

import io.github.joaogouveia89.retedex.core.data.remote.response.PokemonDetailResponse
import io.github.joaogouveia89.retedex.core.data.remote.response.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): PokemonResponse

    @GET("pokemon/{pokemon_id}")
    suspend fun getPokemonDetail(
        @Path("pokemon_id") pokemonId: Int
    ): PokemonDetailResponse
}