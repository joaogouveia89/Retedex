package io.github.joaogouveia89.retedex.core.util

import timber.log.Timber

object UtilFunctions {
    fun logError(tag: String, message: String) {
        Timber.tag(tag).e("Error -> $message")
    }
}