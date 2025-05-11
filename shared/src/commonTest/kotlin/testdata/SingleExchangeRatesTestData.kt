package testdata

import com.walczynamike.nbp.model.RateEntry
import com.walczynamike.nbp.model.SingleRateResponse

internal object SingleExchangeRatesTestData {
    val rates_a_usd = SingleRateResponse(
        table = "A",
        currency = "dolar amerykański",
        code = "USD",
        rates = listOf(
            RateEntry(
                no = "089/A/NBP/2025",
                effectiveDate = "2025-05-09",
                mid = 3.7681,
            ),
        )
    )

    val rates_a_usd_last_3 = SingleRateResponse(
        table = "A",
        currency = "dolar amerykański",
        code = "USD",
        rates = listOf(
            RateEntry(
                no = "087/A/NBP/2025",
                effectiveDate = "2025-05-07",
                mid = 3.7642,
            ),
            RateEntry(
                no = "088/A/NBP/2025",
                effectiveDate = "2025-05-08",
                mid = 3.784,
            ),
            RateEntry(
                no = "089/A/NBP/2025",
                effectiveDate = "2025-05-09",
                mid = 3.7681,
            ),
        )
    )
}