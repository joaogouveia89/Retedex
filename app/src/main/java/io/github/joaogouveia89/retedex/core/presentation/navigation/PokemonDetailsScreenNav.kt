package io.github.joaogouveia89.retedex.core.presentation.navigation

import io.github.joaogouveia89.retedex.core.util.Constants

sealed class PokemonDetailsScreenNav(val route: String) {
    object DetailScreen : PokemonDetailsScreenNav(
        route = "movie_detail_destination?${Constants.POKEMON_DETAIL_ARGUMENT_KEY}=" +
                "{${Constants.POKEMON_DETAIL_ARGUMENT_KEY}}"
    ) {
        fun passPokemonId(pokemonId: Int) =
            "movie_detail_destination?${Constants.POKEMON_DETAIL_ARGUMENT_KEY}=$pokemonId"
    }
}