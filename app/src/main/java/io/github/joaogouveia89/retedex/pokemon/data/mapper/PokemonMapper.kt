package io.github.joaogouveia89.retedex.pokemon.data.mapper

import io.github.joaogouveia89.retedex.core.data.remote.model.PokemonResult
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.core.util.ktx.capitalizeFirst

fun List<PokemonResult>.asPokemonList() = map { it ->

    val pokeId = with(it.url.split("/")) {
        getOrNull(size - 2)
    }?.toIntOrNull() ?: 0

    Pokemon(
        name = it.name.capitalizeFirst(),
        pokeId = pokeId
    )
}
