package io.github.joaogouveia89.retedex.core.data.remote.response

import com.google.gson.annotations.SerializedName
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
    @SerializedName("abilities")
    val abilities: List<Ability>,
    @SerializedName("base_experience")
    val baseExperience: Int,
    @SerializedName("cries")
    val cries: Cries,
    @SerializedName("forms")
    val forms: List<Form>,
    @SerializedName("game_indices")
    val gameIndices: List<GameIndice>,
    @SerializedName("height")
    val height: Int,
    @SerializedName("held_items")
    val heldItems: List<Any>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_default")
    val isDefault: Boolean,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String,
    @SerializedName("moves")
    val moves: List<Move>,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("past_abilities")
    val pastAbilities: List<Any>,
    @SerializedName("past_types")
    val pastTypes: List<Any>,
    @SerializedName("species")
    val species: Species,
    @SerializedName("sprites")
    val sprites: Sprites,
    @SerializedName("stats")
    val stats: List<Stat>,
    @SerializedName("types")
    val types: List<Type>,
    @SerializedName("weight")
    val weight: Int
)