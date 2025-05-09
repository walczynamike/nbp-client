package com.walczynamike.nbp.ktor

import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.Logger

actual val ktorLogger: Logger
    get() = Logger.ANDROID