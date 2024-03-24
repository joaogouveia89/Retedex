package io.github.joaogouveia89.retedex.core.domain.model

data class Pokemon(
    val name: String,
    val pokeId: Int,
    val spriteUrl: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/x-y/$pokeId.png"
)