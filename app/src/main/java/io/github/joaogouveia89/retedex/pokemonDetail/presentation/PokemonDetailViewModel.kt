package io.github.joaogouveia89.retedex.pokemonDetail.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.core.domain.model.PokemonDetail
import io.github.joaogouveia89.retedex.core.util.Constants
import io.github.joaogouveia89.retedex.core.util.ResultData
import io.github.joaogouveia89.retedex.core.util.UtilFunctions
import io.github.joaogouveia89.retedex.pokemonDetail.domain.usecase.GetPokemonDetailUseCase
import io.github.joaogouveia89.retedex.pokemonDetail.presentation.state.PokemonDetailState
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase.AddPokemonFavoriteUseCase
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase.DeletePokemonFavoriteUseCase
import io.github.joaogouveia89.retedex.pokemonFavorite.domain.usecase.IsPokemonFavoriteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
    private val addPokemonFavoriteUseCase: AddPokemonFavoriteUseCase,
    private val deletePokemonFavoriteUseCase: DeletePokemonFavoriteUseCase,
    private val isPokemonFavoriteUseCase: IsPokemonFavoriteUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val uiState: StateFlow<PokemonDetailState>
        get() = _uiState

    private val pokeId = savedStateHandle.get<Int>(key = Constants.POKEMON_DETAIL_ARGUMENT_KEY)

    private var _uiState = MutableStateFlow(PokemonDetailState(PokemonDetail()))

    init {
        pokeId?.let {
            getPokemonDetail(PokemonDetailEvent.GetPokemonDetail(it))
            checkedFavorite(PokemonDetailEvent.CheckedFavorite(it))
        }
    }

    private fun checkedFavorite(checkedFavorite: PokemonDetailEvent.CheckedFavorite) {
        event(checkedFavorite)
    }

    private fun getPokemonDetail(event: PokemonDetailEvent.GetPokemonDetail) {
        event(event)
    }

    fun addRemoveFavorite(pokemon: Pokemon) {
        if (uiState.value.pokemonDetails.isFavorite) {
            event(PokemonDetailEvent.RemoveFavorite(pokemon))
        } else {
            event(PokemonDetailEvent.AddFavorite(pokemon))
        }
    }

    private fun event(event: PokemonDetailEvent) {
        when (event) {
            is PokemonDetailEvent.AddFavorite -> {
                viewModelScope.launch {
                    addPokemonFavoriteUseCase.invoke(
                        params = AddPokemonFavoriteUseCase.Params(event.pokemon)
                    ).collectLatest { result ->
                        when (result) {
                            is ResultData.Success -> {
                                _uiState.update {
                                    it.copy(
                                        pokemonDetails = it.pokemonDetails.copy(
                                            isFavorite = true
                                        )
                                    )
                                }
                            }

                            is ResultData.Failure -> {
                                UtilFunctions.logError(
                                    "DETAIL",
                                    "Erro ao cadastrar filme nos favoritos"
                                )
                            }

                            is ResultData.Loading -> {}
                        }
                    }
                }
            }

            is PokemonDetailEvent.CheckedFavorite -> {
                viewModelScope.launch {
                    isPokemonFavoriteUseCase.invoke(
                        params = IsPokemonFavoriteUseCase.Params(pokeId = event.pokeId)
                    ).collectLatest { result ->
                        when (result) {
                            is ResultData.Success -> {
                                _uiState.update {
                                    it.copy(
                                        pokemonDetails = it.pokemonDetails.copy(
                                            isFavorite = result.data
                                        )
                                    )
                                }
                            }

                            is ResultData.Failure -> {
                                UtilFunctions.logError(
                                    "DETAIL",
                                    "Erro ao atualizar filme nos favoritos"
                                )
                            }

                            is ResultData.Loading -> {}
                        }
                    }
                }
            }

            is PokemonDetailEvent.RemoveFavorite -> {
                viewModelScope.launch {
                    deletePokemonFavoriteUseCase.invoke(
                        params = DeletePokemonFavoriteUseCase.Params(event.pokemon)
                    ).collectLatest { result ->
                        when (result) {
                            is ResultData.Success -> {
                                _uiState.update {
                                    it.copy(
                                        pokemonDetails = it.pokemonDetails.copy(
                                            isFavorite = false
                                        )
                                    )
                                }
                            }

                            is ResultData.Failure -> {
                                UtilFunctions.logError(
                                    "DETAIL",
                                    "Erro ao remover filme nos favoritos"
                                )
                            }

                            is ResultData.Loading -> {}
                        }
                    }
                }
            }

            is PokemonDetailEvent.GetPokemonDetail -> {
                viewModelScope.launch {
                    getPokemonDetailUseCase.invoke(pokeId = event.pokeId)
                        .collect { resultData ->
                            when (resultData) {
                                is ResultData.Success -> {
                                    _uiState.update {
                                        it.copy(
                                            pokemonDetails = resultData.data.apply {
                                                // to ensure to get the state favorite state instead of the default one which is always false
                                                resultData.data.isFavorite =
                                                    it.pokemonDetails.isFavorite
                                            },
                                            isLoading = false,
                                            error = null
                                        )
                                    }
                                }

                                is ResultData.Failure -> {
                                    _uiState.update {
                                        it.copy(
                                            error = resultData.e.message.toString(),
                                            isLoading = false
                                        )
                                    }
                                    UtilFunctions.logError(
                                        "DETAIL-ERROR",
                                        resultData.e.message.toString()
                                    )
                                }

                                is ResultData.Loading -> {
                                    _uiState.update {
                                        it.copy(
                                            error = null,
                                            isLoading = true
                                        )
                                    }
                                }
                            }
                        }
                }
            }
        }
    }
}