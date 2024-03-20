package io.github.joaogouveia89.retedex.core.domain.model

data class PokemonDetail(
    val name: String,
    val backdropImageUrl: String?,
    val species: List<String>,
    val spritesUrls: List<String>,
    val weight: Int,
    val stats: List<String>
)
