package io.github.joaogouveia89.retedex.core.presentation.navigation

import io.github.joaogouveia89.retedex.core.util.Constants

sealed class PokemonDetailsScreenNav(val route: String) {
    data object DetailScreen : PokemonDetailsScreenNav(
        route = "pokemon_detail_destination?${Constants.POKEMON_DETAIL_ARGUMENT_KEY}=" +
                "{${Constants.POKEMON_DETAIL_ARGUMENT_KEY}}"
    ) {
        fun passPokemonId(pokemonId: Int) =
            "pokemon_detail_destination?${Constants.POKEMON_DETAIL_ARGUMENT_KEY}=$pokemonId"
    }
}