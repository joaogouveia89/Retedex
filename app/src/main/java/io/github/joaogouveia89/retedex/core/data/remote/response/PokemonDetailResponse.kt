package io.github.joaogouveia89.retedex.core.data.remote.response

import io.github.joaogouveia89.retedex.core.data.remote.model.Ability
import io.github.joaogouveia89.retedex.core.data.remote.model.Cries
import io.github.joaogouveia89.retedex.core.data.remote.model.Form
import io.github.joaogouveia89.retedex.core.data.remote.model.GameIndice
import io.github.joaogouveia89.retedex.core.data.remote.model.Move
import io.github.joaogouveia89.retedex.core.data.remote.model.Species
import io.github.joaogouveia89.retedex.core.data.remote.model.Sprites
import io.github.joaogouveia89.retedex.core.data.remote.model.Stat
import io.github.joaogouveia89.retedex.core.data.remote.model.Type

data class PokemonDetailResponse(
    val abilities: List<Ability>,
    val base_experience: Int,
    val cries: Cries,
    val forms: List<Form>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<Any>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val past_abilities: List<Any>,
    val past_types: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)