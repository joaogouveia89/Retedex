package io.github.joaogouveia89.retedex.core.presentation.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.github.joaogouveia89.retedex.ui.theme.BluePrimary
import io.github.joaogouveia89.retedex.ui.theme.YellowPrimary

@Composable
fun BottomNavigationBar(
    navController: NavController,
) {
    val items = listOf(
        BottomNavItem.Pokemon,
        BottomNavItem.PokemonFavorite,
    )

    BottomNavigation(
        contentColor = YellowPrimary,
        backgroundColor = BluePrimary

    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { destination ->
            BottomNavigationItem(
                selected = currentRoute == destination.route,
                onClick = {
                    navController.navigate(destination.route) {
                        // the new screen is put on the top of the navigation stack
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(destination.icon),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = destination.title),
                        // to avoid text overlapping the icon
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(navController = rememberNavController())
}