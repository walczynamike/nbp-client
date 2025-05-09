package com.walczynamike.nbp.ktor

import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.Logger

actual val ktorLogger: Logger
    get() = Logger.DEFAULT