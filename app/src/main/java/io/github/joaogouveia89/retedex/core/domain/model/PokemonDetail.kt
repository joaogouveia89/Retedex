package io.github.joaogouveia89.retedex.core.domain.model

data class PokemonDetail(
    val name: String,
    val backdropImageUrl: String?,
    val species: String,
    val types: List<String>,
    val weight: Int,
    val abilities: List<String>,
    val sprite: String
)
