package br.com.movieapp.core.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.github.joaogouveia89.retedex.R

sealed class BottomNavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
) {

    //ImageVector.vectorResource(R.drawable.ic_pikachu)
    object Pokemon : BottomNavItem(
        title = R.string.pokemon,
        icon = R.drawable.ic_pikachu,
        route = "pokemon_list_route"
    )

    object PokemonFavorite : BottomNavItem(
        title = R.string.favorites,
        icon = R.drawable.ic_favorite,
        route = "pokemon_favorite_route"
    )


}