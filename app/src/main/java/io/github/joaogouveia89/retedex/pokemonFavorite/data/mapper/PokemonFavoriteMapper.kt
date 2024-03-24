package io.github.joaogouveia89.retedex.pokemonFavorite.data.mapper

import io.github.joaogouveia89.retedex.core.data.local.entities.PokemonEntity
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon

fun List<PokemonEntity>.toPokemons() = map { pokeEntity ->
    Pokemon(
        name = pokeEntity.name,
        pokeId = pokeEntity.pokeId,
        spriteUrl = pokeEntity.spriteUrl
    )
}

fun Pokemon.toPokemonEntity() =
    PokemonEntity(
        pokeId = pokeId,
        name = name,
        spriteUrl = spriteUrl
    )