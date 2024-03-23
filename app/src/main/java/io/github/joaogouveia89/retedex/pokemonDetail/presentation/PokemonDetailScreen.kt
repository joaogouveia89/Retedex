package io.github.joaogouveia89.retedex.pokemonDetail.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import io.github.joaogouveia89.retedex.R
import io.github.joaogouveia89.retedex.core.presentation.common.RetedexAppBar
import io.github.joaogouveia89.retedex.pokemon.presentation.components.statsStringList
import io.github.joaogouveia89.retedex.pokemonDetail.presentation.state.PokemonDetailState
import io.github.joaogouveia89.retedex.ui.theme.black
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PokemonDetailScreen(
    uiState: StateFlow<PokemonDetailState>,
    navigateToPokemon: () -> Unit
) {
    val pokemonDetailState by uiState.collectAsState()

    Scaffold(
        topBar = {
            RetedexAppBar(
                title = R.string.pokemon_details
            )
        }
    ) { paddingValues ->
        val pokemonDetails = pokemonDetailState.pokemonDetails

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item{
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(pokemonDetails.backdropImageUrl)
                        .crossfade(true)
                        .error(R.drawable.poke_error)
                        .placeholder(R.drawable.pokemon_logo)
                        .build(),
                    contentDescription = "Pokemon detail backdrop image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
            item {
                Row {
                    Text(
                        text = pokemonDetails.name,
                        color = black,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.CenterVertically)
                    )
                    IconButton(
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
            }

            item{
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = pokemonDetails.types.joinToString(", "),
                    color = black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            }

            item{
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = stringResource(id = R.string.base_xp, pokemonDetails.baseXp),
                    color = black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = stringResource(id = R.string.pokemon_details_weight, pokemonDetails.weightInGrams),
                        color = black,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    )
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = stringResource(id = R.string.pokemon_details_height, pokemonDetails.heightInMeters),
                            color = black,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp
                        )
                    }
                }
            }

            statsStringList(
                lazyListScope = this,
                title = R.string.abilities,
                list = pokemonDetails.abilities
            )

            statsStringList(
                lazyListScope = this,
                title = R.string.moves,
                list = pokemonDetails.moves
            )
        }
    }
}