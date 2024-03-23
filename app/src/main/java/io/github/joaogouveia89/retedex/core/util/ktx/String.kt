package io.github.joaogouveia89.retedex.core.util.ktx

import java.util.Locale

fun String.capitalizeFirst() =
    replaceFirstChar { firstChar ->
        if (firstChar.isLowerCase())
            firstChar.titlecase(Locale.ROOT)
        else this
    }