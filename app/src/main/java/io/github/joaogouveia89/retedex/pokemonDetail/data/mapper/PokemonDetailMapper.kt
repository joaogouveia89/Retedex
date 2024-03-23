package io.github.joaogouveia89.retedex.pokemonDetail.data.mapper

import io.github.joaogouveia89.retedex.core.data.remote.response.PokemonDetailResponse
import io.github.joaogouveia89.retedex.core.domain.model.PokemonDetail
import io.github.joaogouveia89.retedex.core.util.ktx.capitalizeFirst

fun PokemonDetailResponse.asPokemonDetail() =
    PokemonDetail(
        name = this.name.capitalizeFirst(),
        backdropImageUrl = this
            .sprites
            .other
            .officialArtwork
            .frontDefault,
        types = this.types.map { it.type.name.capitalizeFirst() },
        weightInGrams = this.weight * 100, //api returns the weight in hectograms, and 1 hg = 100 g
        heightInMeters = this.height / 10.0, //api returns the height in decimeters, and 1 dc = 0.1 m
        abilities = this.abilities.map { it.ability.name.capitalizeFirst() },
        moves = this.moves.map { it.move.name.capitalizeFirst() }
    )