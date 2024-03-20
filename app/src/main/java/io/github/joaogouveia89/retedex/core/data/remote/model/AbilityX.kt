package io.github.joaogouveia89.retedex.core.data.remote.model

import com.google.gson.annotations.SerializedName

data class AbilityX(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)