package io.github.joaogouveia89.retedex.core.util.ktx

fun Int.toWeightString() =  when {
    this >= 1000000 -> "${this / 1000000} tn"
    this >= 1000 -> "${this / 1000} kg"
    else -> "$this g"
}