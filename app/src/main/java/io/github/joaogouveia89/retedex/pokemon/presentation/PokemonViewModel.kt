package io.github.joaogouveia89.retedex.pokemon.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.pokemon.domain.usecase.GetPokemonsUseCase
import io.github.joaogouveia89.retedex.pokemon.presentation.state.PokemonsState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class Inputs {
    val getPokemons = MutableSharedFlow<Unit>()
}

interface Outputs {
    val pokemonsState: Flow<PokemonsState>
}

interface PokemonViewModelType {
    val inputs: Inputs
    val outputs: Outputs
}


@HiltViewModel
class PokemonViewModel @Inject constructor(
    getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel(), PokemonViewModelType, Outputs {

    private val getPokemons: Flow<PagingData<Pokemon>> =
        getPokemonsUseCase.invoke()
        .cachedIn(viewModelScope)

    override val pokemonsState: Flow<PokemonsState> = getPokemons
        .map {
            PokemonsState(it)
        }


    override val inputs = Inputs()

    override val outputs: Outputs = this
}