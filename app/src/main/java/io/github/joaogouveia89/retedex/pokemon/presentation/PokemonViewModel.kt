package io.github.joaogouveia89.retedex.pokemon.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.joaogouveia89.retedex.pokemon.domain.usecase.GetPokemonsUseCase
import javax.inject.Inject



@HiltViewModel
class PokemonViewModel @Inject constructor(
    getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel(){

}