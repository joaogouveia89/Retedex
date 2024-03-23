import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.movieapp.core.presentation.navigation.BottomNavItem
import io.github.joaogouveia89.retedex.core.presentation.navigation.PokemonDetailsScreenNav
import io.github.joaogouveia89.retedex.core.util.Constants.POKEMON_DETAIL_ARGUMENT_KEY
import io.github.joaogouveia89.retedex.pokemon.presentation.PokemonScreen
import io.github.joaogouveia89.retedex.pokemon.presentation.PokemonViewModel
import io.github.joaogouveia89.retedex.pokemonDetail.presentation.PokemonDetailScreen
import io.github.joaogouveia89.retedex.pokemonDetail.presentation.PokemonDetailViewModel

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
                navigateToPokemon = {

                }
            )
        }
    }
}