package io.github.joaogouveia89.retedex.pokemonFavorite.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.github.joaogouveia89.retedex.R
import io.github.joaogouveia89.retedex.core.domain.model.Pokemon
import io.github.joaogouveia89.retedex.ui.theme.black
import io.github.joaogouveia89.retedex.ui.theme.white

@Composable
fun MovieFavoritesContent(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    pokemons: List<Pokemon>,
    onClick: (id: Int) -> Unit
) {
    Box(
        modifier = modifier
            .background(white)
    ) {
        if (pokemons.isEmpty()) {
            Text(
                text = stringResource(id = R.string.favorite_pokemons_empty),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = black,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}