package com.walczynamike.nbp.ktor

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

internal actual val ktorHttpClientEngine: HttpClientEngine
    get() = OkHttp.create()