package io.github.joaogouveia89.retedex.core.data.remote.model

import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationI
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationIi
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationIii
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationIv
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationV
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationVi
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationVii
import io.github.joaogouveia89.retedex.core.data.remote.model.GenerationViii

data class Versions(
    val generation-i: GenerationI,
    val generation-ii: GenerationIi,
    val generation-iii: GenerationIii,
    val generation-iv: GenerationIv,
    val generation-v: GenerationV,
    val generation-vi: GenerationVi,
    val generation-vii: GenerationVii,
    val generation-viii: GenerationViii
)