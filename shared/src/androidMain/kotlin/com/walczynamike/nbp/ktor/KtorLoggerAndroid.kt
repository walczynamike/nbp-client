package com.walczynamike.nbp.ktor

import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.Logger

internal actual val ktorLogger: Logger
    get() = Logger.ANDROID