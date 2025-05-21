package com.walczynamike.nbp.model


/**
 * Represents the types of tables published by the NBP (Narodowy Bank Polski).
 */
enum class NbpTable(internal val value: String) {
    /**
     * Exchange rates for major currencies (mid-market rates).
     */
    TABLE_A("A"),

    /**
     * Exchange rates for less common currencies.
     */
    TABLE_B("B"),

    /**
     * Buy and sell rates for major currencies (used for currency exchange).
     */
    TABLE_C("C"),
}