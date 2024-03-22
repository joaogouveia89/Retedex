package io.github.joaogouveia89.retedex.pokemon.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.joaogouveia89.retedex.pokemon.domain.usecase.GetPokemonsUseCase
import io.github.joaogouveia89.retedex.pokemon.presentation.state.PokemonsState
import javax.inject.Inject



@HiltViewModel
class PokemonViewModel @Inject constructor(
    getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel(){
    var uiState by mutableStateOf(PokemonsState())
        private set

    init {
        val pokemons = getPokemonsUseCase.invoke()
            .cachedIn(viewModelScope)

        uiState = uiState.copy(pokemons = pokemons)
    }
}