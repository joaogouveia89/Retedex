package io.github.joaogouveia89.retedex.pokemon.data.mapper

import androidx.compose.ui.text.capitalize
import io.github.joaogouveia89.retedex.core.data.remote.model.PokemonResult
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import java.util.Locale

fun List<PokemonResult>.asPokemonList() = map { it ->

    val pokeId = with(it.url.split("/")){
        getOrNull(size - 2)
    }?.toIntOrNull() ?: 0

    Pokemon(
        name = it.name.replaceFirstChar { firstChar ->
            if (firstChar.isLowerCase())
                firstChar.titlecase(Locale.ROOT)
            else it.toString() },
        spriteUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/x-y/$pokeId.png",
        pokeId = pokeId
    )
}
