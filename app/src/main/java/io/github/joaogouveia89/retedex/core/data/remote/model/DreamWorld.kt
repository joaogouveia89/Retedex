package io.github.joaogouveia89.retedex.core.data.remote.model

import com.google.gson.annotations.SerializedName

data class DreamWorld(
    @SerializedName("front_default")
    val frontDefault: String,
    @SerializedName("front_female")
    val frontFemale: Any
)
