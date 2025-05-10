package com.walczynamike.nbp.ktor

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

internal actual val ktorHttpClientEngine: HttpClientEngine
    get() = Darwin.create()