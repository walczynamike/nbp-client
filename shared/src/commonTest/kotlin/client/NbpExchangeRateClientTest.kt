package client

import com.walczynamike.nbp.client.NbpExchangeRateClient
import com.walczynamike.nbp.ktor.createNbpHttpClient
import com.walczynamike.nbp.model.CurrencyCode
import com.walczynamike.nbp.model.LocalDate
import com.walczynamike.nbp.model.NbpTable
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockRequestHandleScope
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import kotlinx.coroutines.test.runTest
import mockjsonresponse.exchangerates_rates_a_usd
import mockjsonresponse.exchangerates_rates_a_usd_last_3
import mockjsonresponse.exchangerates_tables_a_2025_05_07_2025_05_09_response
import mockjsonresponse.exchangerates_tables_a_2025_05_09_response
import mockjsonresponse.exchangerates_tables_a_last_3_response
import mockjsonresponse.exchangerates_tables_a_response
import testdata.ExchangeRatesTestData
import testdata.SingleExchangeRatesTestData
import util.mockSuccessfulRequest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class NbpExchangeRateClientTest {

    @Test
    fun `Given successful response When getCurrentTable is called Then response is parsed correctly`() =
        successfulRequestTest(
            mockUrlString = "https://api.nbp.pl/api/exchangerates/tables/A/",
            mockResponseContent = exchangerates_tables_a_response,
            expectedParsedResponse = ExchangeRatesTestData.table_a_2025_05_09,
            nbpClientAction = { client ->
                client.getCurrentTable(NbpTable.TABLE_A)
            },
        )

    @Test
    fun `Given successful response When getLastTables is called Then response is parsed correctly`() =
        successfulRequestTest(
            mockUrlString = "https://api.nbp.pl/api/exchangerates/tables/A/last/3/",
            mockResponseContent = exchangerates_tables_a_last_3_response,
            expectedParsedResponse = listOf(
                ExchangeRatesTestData.table_a_2025_05_07,
                ExchangeRatesTestData.table_a_2025_05_08,
                ExchangeRatesTestData.table_a_2025_05_09,
            ),
            nbpClientAction = { client ->
                client.getLastTables(table = NbpTable.TABLE_A, topCount = 3)
            },
        )

    @Test
    fun `Given successful response When getTableByDate is called Then response is parsed correctly`() =
        successfulRequestTest(
            mockUrlString = "https://api.nbp.pl/api/exchangerates/tables/A/2025-05-09/",
            mockResponseContent = exchangerates_tables_a_2025_05_09_response,
            expectedParsedResponse = ExchangeRatesTestData.table_a_2025_05_09,
            nbpClientAction = { client ->
                client.getTableByDate(
                    table = NbpTable.TABLE_A,
                    date = LocalDate(year = 2025, month = 5, day = 9),
                )
            },
        )

    @Test
    fun `Given successful response When getTablesInRange is called Then response is parsed correctly`() =
        successfulRequestTest(
            mockUrlString = "https://api.nbp.pl/api/exchangerates/tables/A/2025-05-07/2025-05-09/",
            mockResponseContent = exchangerates_tables_a_2025_05_07_2025_05_09_response,
            expectedParsedResponse = listOf(
                ExchangeRatesTestData.table_a_2025_05_07,
                ExchangeRatesTestData.table_a_2025_05_08,
                ExchangeRatesTestData.table_a_2025_05_09,
            ),
            nbpClientAction = { client ->
                client.getTablesInRange(
                    table = NbpTable.TABLE_A,
                    startDate = LocalDate(year = 2025, month = 5, day = 7),
                    endDate = LocalDate(year = 2025, month = 5, day = 9),
                )
            },
        )

    @Test
    fun `Given successful response When getCurrentCurrencyRate is called Then response is parsed correctly`() =
        successfulRequestTest(
            mockUrlString = "https://api.nbp.pl/api/exchangerates/rates/A/USD/",
            mockResponseContent = exchangerates_rates_a_usd,
            expectedParsedResponse = SingleExchangeRatesTestData.rates_a_usd,
            nbpClientAction = { client ->
                client.getCurrentCurrencyRate(
                    table = NbpTable.TABLE_A,
                    currencyCode = CurrencyCode.USD,
                )
            },
        )

    @Test
    fun `Given successful response When getLastCurrencyRates is called Then response is parsed correctly`() =
        successfulRequestTest(
            mockUrlString = "https://api.nbp.pl/api/exchangerates/rates/A/USD/last/3/",
            mockResponseContent = exchangerates_rates_a_usd_last_3,
            expectedParsedResponse = SingleExchangeRatesTestData.rates_a_usd_last_3,
            nbpClientAction = { client ->
                client.getLastCurrencyRates(
                    table = NbpTable.TABLE_A,
                    currencyCode = CurrencyCode.USD,
                    topCount = 3,
                )
            },
        )

    @Test
    fun `Given successful response When getCurrencyRateInRange Then response is parsed correctly`() =
        successfulRequestTest(
            mockUrlString = "https://api.nbp.pl/api/exchangerates/rates/A/USD/2025-05-07/2025-05-09/",
            mockResponseContent = exchangerates_rates_a_usd_last_3,
            expectedParsedResponse = SingleExchangeRatesTestData.rates_a_usd_last_3,
            nbpClientAction = { client ->
                client.getCurrencyRatesInRange(
                    table = NbpTable.TABLE_A,
                    currencyCode = CurrencyCode.USD,
                    startDate = LocalDate(year = 2025, month = 5, day = 7),
                    endDate = LocalDate(year = 2025, month = 5, day = 9),
                )
            },
        )

    private fun <T> successfulRequestTest(
        mockUrlString: String,
        mockResponseContent: String,
        expectedParsedResponse: T,
        nbpClientAction: suspend (NbpExchangeRateClient) -> T,
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
    ): NbpExchangeRateClient {
        val mockEngine = MockEngine { request ->
            handler(request)
        }
        return NbpExchangeRateClient(
            client = createNbpHttpClient(mockEngine),
        )
    }
}