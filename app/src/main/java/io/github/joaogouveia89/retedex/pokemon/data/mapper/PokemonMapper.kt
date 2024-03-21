package io.github.joaogouveia89.retedex.pokemon.data.mapper

import io.github.joaogouveia89.retedex.core.data.remote.model.PokemonResult
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon

fun List<PokemonResult>.asPokemonList() = map {
        Pokemon(
            name = it.name,
            url = it.url
        )
    }