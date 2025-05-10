package com.walczynamike.nbp.ktor

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.append
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val nbpHttpClient = HttpClient {
    defaultRequest {
        url("https://api.nbp.pl/api/")
    }
    install(Logging) {
        logger = ktorLogger
        level = LogLevel.ALL
    }
    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            },
        )
    }

    headers {
        append(HttpHeaders.Accept, ContentType.Application.Json)
    }
}