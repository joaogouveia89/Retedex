package io.github.joaogouveia89.retedex.core.data.remote.model

import com.google.gson.annotations.SerializedName
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationI
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationIi
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationIii
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationIv
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationV
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationVi
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationVii
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationViii

data class Versions(
    @SerializedName("generation-i:")
    val generationI: GenerationI,
    @SerializedName("generation-ii")
    val generationIi: GenerationIi,
    @SerializedName("generation-iii")
    val generationIii: GenerationIii,
    @SerializedName("generation-iv")
    val generationIv: GenerationIv,
    @SerializedName("generation-v")
    val generationV: GenerationV,
    @SerializedName("generation-vi:")
    val generationVi: GenerationVi,
    @SerializedName("generation-vii")
    val generationVii: GenerationVii,
    @SerializedName("generation-viii")
    val generationViii: GenerationViii
)
