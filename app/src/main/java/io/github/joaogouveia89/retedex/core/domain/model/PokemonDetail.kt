package io.github.joaogouveia89.retedex.core.domain.model

data class PokemonDetail(
    val name: String = "",
    val backdropImageUrl: String? = null,
    val heightInMeters: Double = 0.0,
    val baseXp: Int = 0,
    val types: List<String> = listOf(),
    val weightInGrams: Int = 0,
    val abilities: List<String> = listOf(),
    val moves: List<String> = listOf()
)
