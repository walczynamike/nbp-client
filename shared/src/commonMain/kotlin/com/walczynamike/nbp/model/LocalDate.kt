package com.walczynamike.nbp.model

/**
 * A simple date representation with year, month, and day values.
 *
 * @param year Full year value (e.g. 2025)
 * @param month Month number, from 1 (January) to 12 (December)
 * @param day Day of the month, from 1 to 31
 *
 * @throws IllegalArgumentException if the month is not in 1..12 or the day is not in 1..31
 */
data class LocalDate(
    val year: Int,
    val month: Int,
    val day: Int,
)

/**
 * Formats the [LocalDate] instance as a string in `yyyy-MM-dd` format.
 */
internal fun LocalDate.toFormattedDate(): String {
    return "$year-${month.toString().padStart(2, '0')}-${day.toString().padStart(2, '0')}"
}