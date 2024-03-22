package io.github.joaogouveia89.retedex.pokemon.data.mapper

import androidx.compose.ui.text.capitalize
import io.github.joaogouveia89.retedex.core.data.remote.model.PokemonResult
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import java.util.Locale

fun List<PokemonResult>.asPokemonList() = map { it ->
    Pokemon(
        name = it.name.replaceFirstChar { firstChar ->
            if (firstChar.isLowerCase())
                firstChar.titlecase(Locale.ROOT)
            else it.toString() },
        url = it.url
    )
}