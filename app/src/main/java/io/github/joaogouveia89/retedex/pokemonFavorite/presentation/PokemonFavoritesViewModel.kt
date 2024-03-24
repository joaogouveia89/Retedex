package io.github.joaogouveia89.retedex.pokemonFavorite.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase.GetPokemonsFavoriteUseCase
import io.github.joaogouveia89.retedex.pokemonFavorite.presentation.state.PokemonFavoriteState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonFavoritesViewModel @Inject constructor(
    private val getPokemonsFavoriteUseCase: GetPokemonsFavoriteUseCase
) : ViewModel() {
    var uiState by mutableStateOf(PokemonFavoriteState())
        private set

    init {
        fetch()
    }

    private fun fetch() {
        viewModelScope.launch {
            val pokemons =  getPokemonsFavoriteUseCase.invoke()
            uiState = uiState.copy(pokemons = pokemons)
        }
    }
}