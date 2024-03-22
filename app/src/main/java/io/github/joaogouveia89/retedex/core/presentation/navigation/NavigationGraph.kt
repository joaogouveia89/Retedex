import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.movieapp.core.presentation.navigation.BottomNavItem
import io.github.joaogouveia89.retedex.pokemon.presentation.PokemonScreen
import io.github.joaogouveia89.retedex.pokemon.presentation.PokemonViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Pokemon.route
    ) {
        composable(BottomNavItem.Pokemon.route) {
            val viewModel: PokemonViewModel = hiltViewModel()
            PokemonScreen()
            /*val uiState = viewModel.uiState

            MoviePopularScreen(
                uiState = uiState,
                navigateToDetailMovie = {
                    navController.navigate(DetailScreenNav.DetailScreen.passMovieId(it))
                })*/
        }

        composable(BottomNavItem.PokemonFavorite.route) {

        }
    }
}