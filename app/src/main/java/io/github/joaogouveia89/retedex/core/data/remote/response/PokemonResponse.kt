package io.github.joaogouveia89.retedex.core.data.remote.response

import com.google.gson.annotations.SerializedName
import io.github.joaogouveia89.retedex.core.data.remote.model.PokemonResult

data class PokemonResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val results: List<PokemonResult>
)