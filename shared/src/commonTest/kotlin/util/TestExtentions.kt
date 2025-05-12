package util

import io.ktor.client.engine.mock.MockRequestHandleScope
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondBadRequest
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.Url
import io.ktor.http.headersOf

internal fun MockRequestHandleScope.mockSuccessfulRequest(
    httpRequestData: HttpRequestData,
    urlString: String,
    responseContent: String,
): HttpResponseData {
    return if (httpRequestData.url == Url(urlString)) {
        respond(
            content = responseContent,
            headers = headersOf(
                HttpHeaders.ContentType,
                ContentType.Application.Json.toString(),
            ),
        )
    } else {
        respondBadRequest()
    }
}