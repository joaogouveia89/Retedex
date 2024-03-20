package io.github.joaogouveia89.retedex.core.data.remote.model

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)