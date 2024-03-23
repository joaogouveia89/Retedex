package io.github.joaogouveia89.retedex.pokemonDetail.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.joaogouveia89.retedex.core.domain.model.PokemonDetail
import io.github.joaogouveia89.retedex.core.util.Constants
import io.github.joaogouveia89.retedex.pokemonDetail.domain.usecase.GetPokemonDetailUseCase
import io.github.joaogouveia89.retedex.pokemonDetail.presentation.state.PokemonDetailState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    val uiState: StateFlow<PokemonDetailState>
        get() = _uiState

    private val pokeId = savedStateHandle.get<Int>(key = Constants.POKEMON_DETAIL_ARGUMENT_KEY)

    private val _uiState = MutableStateFlow(PokemonDetailState(PokemonDetail()))

    init {
        pokeId?.let {
            viewModelScope.launch {
                getPokemonDetailUseCase.invoke(it).collect {
                    _uiState.value = PokemonDetailState(it)
                }
            }
        }
    }
}