package client

import com.walczynamike.nbp.client.NbpGoldPriceClient
import com.walczynamike.nbp.ktor.createNbpHttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockRequestHandleScope
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import kotlinx.coroutines.test.runTest
import mockjsonresponse.cenyzlota_2025_05_08_2025_05_12
import mockjsonresponse.cenyzlota_2025_05_12
import testdata.GoldPricesTestData
import util.mockSuccessfulRequest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class NbpGoldPricesClientTest {

    @Test
    fun `Given successful response When getPriceToday is called Then response is parsed correctly`() =
        successfulRequestTest(
            mockUrlString = "https://api.nbp.pl/api/cenyzlota/today/",
            mockResponseContent = cenyzlota_2025_05_12,
            expectedParsedResponse = GoldPricesTestData.date_2025_05_12,
            nbpClientAction = { client -> client.getPriceToday() },
        )

    @Test
    fun `Given successful response When getCurrentPrice is called Then response is parsed correctly`() =
        successfulRequestTest(
            mockUrlString = "https://api.nbp.pl/api/cenyzlota/",
            mockResponseContent = cenyzlota_2025_05_12,
            expectedParsedResponse = GoldPricesTestData.date_2025_05_12,
            nbpClientAction = { client -> client.getCurrentPrice() },
        )

    @Test
    fun `Given successful response When getLastPrices is called Then response is parsed correctly`() =
        successfulRequestTest(
            mockUrlString = "https://api.nbp.pl/api/cenyzlota/last/3/",
            mockResponseContent = cenyzlota_2025_05_08_2025_05_12,
            expectedParsedResponse = listOf(
                GoldPricesTestData.date_2025_05_08,
                GoldPricesTestData.date_2025_05_09,
                GoldPricesTestData.date_2025_05_12,
            ),
            nbpClientAction = { client -> client.getLastPrices(3) },
        )

    @Test
    fun `Given successful response When getPriceOnDate is called Then response is parsed correctly`() =
        successfulRequestTest(
            mockUrlString = "https://api.nbp.pl/api/cenyzlota/2025-05-12/",
            mockResponseContent = cenyzlota_2025_05_12,
            expectedParsedResponse = GoldPricesTestData.date_2025_05_12,
            nbpClientAction = { client -> client.getPriceOnDate("2025-05-12") },
        )

    @Test
    fun `Given successful response When getPricesInRange is called Then response is parsed correctly`() =
        successfulRequestTest(
            mockUrlString = "https://api.nbp.pl/api/cenyzlota/2025-05-08/2025-05-12/",
            mockResponseContent = cenyzlota_2025_05_08_2025_05_12,
            expectedParsedResponse = listOf(
                GoldPricesTestData.date_2025_05_08,
                GoldPricesTestData.date_2025_05_09,
                GoldPricesTestData.date_2025_05_12,
            ),
            nbpClientAction = { client ->
                client.getPricesInRange(startDate = "2025-05-08", endDate = "2025-05-12")
            },
        )

    private fun <T> successfulRequestTest(
        mockUrlString: String,
        mockResponseContent: String,
        expectedParsedResponse: T,
        nbpClientAction: suspend (NbpGoldPriceClient) -> T,
    ) = runTest {
        val nbpClient = setupClient { request ->
            mockSuccessfulRequest(
                httpRequestData = request,
                urlString = mockUrlString,
                responseContent = mockResponseContent,
            )
        }

        val result = nbpClientAction(nbpClient)

        assertEquals(expectedParsedResponse, result)
    }


    private fun setupClient(
        handler: suspend MockRequestHandleScope.(HttpRequestData) -> HttpResponseData,
    ): NbpGoldPriceClient {
        val mockEngine = MockEngine { request ->
            handler(request)
        }
        return NbpGoldPriceClient(
            httpClient = createNbpHttpClient(mockEngine),
        )
    }
}

