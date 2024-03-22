package io.github.joaogouveia89.retedex.pokemonDetail.data.mapper

import io.github.joaogouveia89.retedex.core.data.remote.response.PokemonDetailResponse
import io.github.joaogouveia89.retedex.core.domain.model.PokemonDetail

fun PokemonDetailResponse.asPokemonDetail() =
    PokemonDetail(
        name = this.name,
        backdropImageUrl = this
            .sprites
            .other
            .officialArtwork
            .frontDefault,
        species = this.species.name,
        types = this.types.map { it.type.name },
        weight = this.weight,
        abilities = this.abilities.map { it.ability.name },
        sprite = this.sprites.versions.generationI.yellow.frontDefault
    )