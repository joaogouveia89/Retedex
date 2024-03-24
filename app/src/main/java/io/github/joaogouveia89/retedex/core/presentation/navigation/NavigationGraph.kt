package io.github.joaogouveia89.retedex.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import io.github.joaogouveia89.retedex.core.util.Constants.POKEMON_DETAIL_ARGUMENT_KEY
import io.github.joaogouveia89.retedex.pokemon.presentation.PokemonScreen
import io.github.joaogouveia89.retedex.pokemon.presentation.PokemonViewModel
import io.github.joaogouveia89.retedex.pokemonDetail.presentation.PokemonDetailScreen
import io.github.joaogouveia89.retedex.pokemonDetail.presentation.PokemonDetailViewModel
import io.github.joaogouveia89.retedex.pokemonFavorite.presentation.PokemonFavoritesScreen
import io.github.joaogouveia89.retedex.pokemonFavorite.presentation.PokemonFavoritesViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Pokemon.route
    ) {
        composable(BottomNavItem.Pokemon.route) {
            val viewModel: PokemonViewModel = hiltViewModel()
            val uiState = viewModel.uiState
            PokemonScreen(
                uiState = uiState,
                navigateToDetailPokemon = {
                    navController.navigate(PokemonDetailsScreenNav.DetailScreen.passPokemonId(it))
                }
            )
        }

        composable(BottomNavItem.PokemonFavorite.route) {
            val viewModel: PokemonFavoritesViewModel = hiltViewModel()
            val state = viewModel.uiState.pokemons.collectAsStateWithLifecycle(emptyList())
            PokemonFavoritesScreen(
                pokemons = state.value,
                navigateToDetailPokemon = {
                    navController.navigate(PokemonDetailsScreenNav.DetailScreen.passPokemonId(it))
                }
            )
        }

        composable(
            route = PokemonDetailsScreenNav.DetailScreen.route,
            arguments = listOf(
                navArgument(POKEMON_DETAIL_ARGUMENT_KEY) {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) {
            val viewModel: PokemonDetailViewModel = hiltViewModel()
            val uiState = viewModel.uiState

            PokemonDetailScreen(
                uiState = uiState,
                onFavoriteStateChange = { pokemon ->
                    viewModel.addRemoveFavorite(pokemon)
                }
            )
        }
    }
}