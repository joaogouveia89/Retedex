package io.github.joaogouveia89.retedex.pokemonDetail.presentation

import io.github.joaogouveia89.retedex.core.domain.model.Pokemon

sealed class PokemonDetailEvent {
    data class GetPokemonDetail(val pokeId: Int) : PokemonDetailEvent()
    data class AddFavorite(val pokemon: Pokemon) : PokemonDetailEvent()
    data class CheckedFavorite(val pokeId: Int) : PokemonDetailEvent()
    data class RemoveFavorite(val pokemon: Pokemon) : PokemonDetailEvent()
}