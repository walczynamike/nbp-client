package com.walczynamike.nbp.model

/**
 * Represents a currency code as defined by ISO 4217.
 *
 * @property code The ISO 4217 currency code.
 */
sealed class CurrencyCode(val code: String) {
    data object AMD : CurrencyCode("AMD") // Armenian dram
    data object ANG : CurrencyCode("ANG") // Netherlands Antillean guilder
    data object AOA : CurrencyCode("AOA") // Angolan kwanza
    data object ARS : CurrencyCode("ARS") // Argentine peso
    data object AUD : CurrencyCode("AUD") // Australian dollar
    data object AWG : CurrencyCode("AWG") // Aruban florin
    data object AZN : CurrencyCode("AZN") // Azerbaijani manat
    data object BAM : CurrencyCode("BAM") // Bosnia and Herzegovina convertible mark
    data object BBD : CurrencyCode("BBD") // Barbados dollar
    data object BDT : CurrencyCode("BDT") // Bangladeshi taka
    data object BGN : CurrencyCode("BGN") // Bulgarian lev
    data object BHD : CurrencyCode("BHD") // Bahraini dinar
    data object BIF : CurrencyCode("BIF") // Burundian franc
    data object BMD : CurrencyCode("BMD") // Bermudian dollar
    data object BND : CurrencyCode("BND") // Brunei dollar
    data object BOB : CurrencyCode("BOB") // Boliviano
    data object BOV : CurrencyCode("BOV") // Bolivian Mvdol (funds code)
    data object BRL : CurrencyCode("BRL") // Brazilian real
    data object BSD : CurrencyCode("BSD") // Bahamian dollar
    data object BTN : CurrencyCode("BTN") // Bhutanese ngultrum
    data object BWP : CurrencyCode("BWP") // Botswana pula
    data object BYN : CurrencyCode("BYN") // Belarusian ruble
    data object BZD : CurrencyCode("BZD") // Belize dollar
    data object CAD : CurrencyCode("CAD") // Canadian dollar
    data object CDF : CurrencyCode("CDF") // Congolese franc
    data object CHE : CurrencyCode("CHE") // WIR euro (complementary currency)
    data object CHF : CurrencyCode("CHF") // Swiss franc
    data object CHW : CurrencyCode("CHW") // WIR franc (complementary currency)
    data object CLF : CurrencyCode("CLF") // Unidad de Fomento (funds code)
    data object CLP : CurrencyCode("CLP") // Chilean peso
    data object CNY : CurrencyCode("CNY") // Chinese yuan
    data object COP : CurrencyCode("COP") // Colombian peso
    data object COU : CurrencyCode("COU") // Unidad de Valor Real (funds code)
    data object CRC : CurrencyCode("CRC") // Costa Rican colon
    data object CUC : CurrencyCode("CUC") // Cuban convertible peso
    data object CUP : CurrencyCode("CUP") // Cuban peso
    data object CVE : CurrencyCode("CVE") // Cape Verdean escudo
    data object CZK : CurrencyCode("CZK") // Czech koruna
    data object DJF : CurrencyCode("DJF") // Djiboutian franc
    data object DKK : CurrencyCode("DKK") // Danish krone
    data object DOP : CurrencyCode("DOP") // Dominican peso
    data object DZD : CurrencyCode("DZD") // Algerian dinar
    data object EGP : CurrencyCode("EGP") // Egyptian pound
    data object ERN : CurrencyCode("ERN") // Eritrean nakfa
    data object ETB : CurrencyCode("ETB") // Ethiopian birr
    data object EUR : CurrencyCode("EUR") // Euro
    data object FJD : CurrencyCode("FJD") // Fijian dollar
    data object FKP : CurrencyCode("FKP") // Falkland Islands pound
    data object GBP : CurrencyCode("GBP") // British pound sterling
    data object GEL : CurrencyCode("GEL") // Georgian lari
    data object GHS : CurrencyCode("GHS") // Ghanaian cedi
    data object GIP : CurrencyCode("GIP") // Gibraltar pound
    data object GMD : CurrencyCode("GMD") // Gambian dalasi
    data object GNF : CurrencyCode("GNF") // Guinean franc
    data object GTQ : CurrencyCode("GTQ") // Guatemalan quetzal
    data object GYD : CurrencyCode("GYD") // Guyanese dollar
    data object HKD : CurrencyCode("HKD") // Hong Kong dollar
    data object HNL : CurrencyCode("HNL") // Honduran lempira
    data object HRK : CurrencyCode("HRK") // Croatian kuna
    data object HTG : CurrencyCode("HTG") // Haitian gourde
    data object HUF : CurrencyCode("HUF") // Hungarian forint
    data object IDR : CurrencyCode("IDR") // Indonesian rupiah
    data object ILS : CurrencyCode("ILS") // Israeli new shekel
    data object INR : CurrencyCode("INR") // Indian rupee
    data object IQD : CurrencyCode("IQD") // Iraqi dinar
    data object IRR : CurrencyCode("IRR") // Iranian rial
    data object ISK : CurrencyCode("ISK") // Icelandic króna
    data object JMD : CurrencyCode("JMD") // Jamaican dollar
    data object JOD : CurrencyCode("JOD") // Jordanian dinar
    data object JPY : CurrencyCode("JPY") // Japanese yen
    data object KES : CurrencyCode("KES") // Kenyan shilling
    data object KGS : CurrencyCode("KGS") // Kyrgyzstani som
    data object KHR : CurrencyCode("KHR") // Cambodian riel
    data object KMF : CurrencyCode("KMF") // Comorian franc
    data object KPW : CurrencyCode("KPW") // North Korean won
    data object KRW : CurrencyCode("KRW") // South Korean won
    data object KWD : CurrencyCode("KWD") // Kuwaiti dinar
    data object KYD : CurrencyCode("KYD") // Cayman Islands dollar
    data object KZT : CurrencyCode("KZT") // Kazakhstani tenge
    data object LAK : CurrencyCode("LAK") // Lao kip
    data object LBP : CurrencyCode("LBP") // Lebanese pound
    data object LKR : CurrencyCode("LKR") // Sri Lankan rupee
    data object LRD : CurrencyCode("LRD") // Liberian dollar
    data object LSL : CurrencyCode("LSL") // Lesotho loti
    data object LYD : CurrencyCode("LYD") // Libyan dinar
    data object MAD : CurrencyCode("MAD") // Moroccan dirham
    data object MDL : CurrencyCode("MDL") // Moldovan leu
    data object MGA : CurrencyCode("MGA") // Malagasy ariary
    data object MKD : CurrencyCode("MKD") // Macedonian denar
    data object MMK : CurrencyCode("MMK") // Myanmar kyat
    data object MNT : CurrencyCode("MNT") // Mongolian tögrög
    data object MOP : CurrencyCode("MOP") // Macanese pataca
    data object MRU : CurrencyCode("MRU") // Mauritanian ouguiya
    data object MUR : CurrencyCode("MUR") // Mauritian rupee
    data object MVR : CurrencyCode("MVR") // Maldivian rufiyaa
    data object MWK : CurrencyCode("MWK") // Malawian kwacha
    data object MXN : CurrencyCode("MXN") // Mexican peso
    data object MXV : CurrencyCode("MXV") // Mexican Unidad de Inversion (UDI)
    data object MYR : CurrencyCode("MYR") // Malaysian ringgit
    data object MZN : CurrencyCode("MZN") // Mozambican metical
    data object NAD : CurrencyCode("NAD") // Namibian dollar
    data object NGN : CurrencyCode("NGN") // Nigerian naira
    data object NIO : CurrencyCode("NIO") // Nicaraguan córdoba
    data object NOK : CurrencyCode("NOK") // Norwegian krone
    data object NPR : CurrencyCode("NPR") // Nepalese rupee
    data object NZD : CurrencyCode("NZD") // New Zealand dollar
    data object OMR : CurrencyCode("OMR") // Omani rial
    data object PAB : CurrencyCode("PAB") // Panamanian balboa
    data object PEN : CurrencyCode("PEN") // Peruvian sol
    data object PGK : CurrencyCode("PGK") // Papua New Guinean kina
    data object PHP : CurrencyCode("PHP") // Philippine peso
    data object PKR : CurrencyCode("PKR") // Pakistani rupee
    data object PLN : CurrencyCode("PLN") // Polish złoty
    data object PYG : CurrencyCode("PYG") // Paraguayan guaraní
    data object QAR : CurrencyCode("QAR") // Qatari riyal
    data object RON : CurrencyCode("RON") // Romanian leu
    data object RSD : CurrencyCode("RSD") // Serbian dinar
    data object RUB : CurrencyCode("RUB") // Russian ruble
    data object RWF : CurrencyCode("RWF") // Rwandan franc
    data object SAR : CurrencyCode("SAR") // Saudi riyal
    data object SBD : CurrencyCode("SBD") // Solomon Islands dollar
    data object SCR : CurrencyCode("SCR") // Seychellois rupee
    data object SDG : CurrencyCode("SDG") // Sudanese pound
    data object SEK : CurrencyCode("SEK") // Swedish krona
    data object SGD : CurrencyCode("SGD") // Singapore dollar
    data object SHP : CurrencyCode("SHP") // Saint Helena pound
    data object SLE : CurrencyCode("SLE") // Sierra Leonean leone
    data object SOS : CurrencyCode("SOS") // Somali shilling
    data object SRD : CurrencyCode("SRD") // Surinamese dollar
    data object SSP : CurrencyCode("SSP") // South Sudanese pound
    data object STN : CurrencyCode("STN") // São Tomé and Príncipe dobra
    data object SVC : CurrencyCode("SVC") // Salvadoran colón
    data object SYP : CurrencyCode("SYP") // Syrian pound
    data object SZL : CurrencyCode("SZL") // Eswatini lilangeni
    data object THB : CurrencyCode("THB") // Thai baht
    data object TJS : CurrencyCode("TJS") // Tajikistani somoni
    data object TMT : CurrencyCode("TMT") // Turkmenistani manat
    data object TND : CurrencyCode("TND") // Tunisian dinar
    data object TOP : CurrencyCode("TOP") // Tongan paʻanga
    data object TRY : CurrencyCode("TRY") // Turkish lira
    data object TTD : CurrencyCode("TTD") // Trinidad and Tobago dollar
    data object TWD : CurrencyCode("TWD") // New Taiwan dollar
    data object TZS : CurrencyCode("TZS") // Tanzanian shilling
    data object UAH : CurrencyCode("UAH") // Ukrainian hryvnia
    data object UGX : CurrencyCode("UGX") // Ugandan shilling
    data object USD : CurrencyCode("USD") // United States dollar
    data object USN : CurrencyCode("USN") // US Dollar (Next day)
    data object UYI : CurrencyCode("UYI") // Uruguay Peso en Unidades Indexadas (UI)
    data object UYU : CurrencyCode("UYU") // Uruguayan peso
    data object UYW : CurrencyCode("UYW") // Unidad previsional
    data object UZS : CurrencyCode("UZS") // Uzbekistani soʻm
    data object VED : CurrencyCode("VED") // Venezuelan digital bolívar
    data object VES : CurrencyCode("VES") // Venezuelan sovereign bolívar
    data object VND : CurrencyCode("VND") // Vietnamese đồng
    data object VUV : CurrencyCode("VUV") // Vanuatu vatu
    data object WST : CurrencyCode("WST") // Samoan tālā
    data object XAF : CurrencyCode("XAF") // CFA franc BEAC
    data object XAG : CurrencyCode("XAG") // Silver (one troy ounce)
    data object XAU : CurrencyCode("XAU") // Gold (one troy ounce)
    data object XBA : CurrencyCode("XBA") // European Composite Unit
    data object XBB : CurrencyCode("XBB") // European Monetary Unit
    data object XBC : CurrencyCode("XBC") // European Unit of Account 9
    data object XBD : CurrencyCode("XBD") // European Unit of Account 17
    data object XCD : CurrencyCode("XCD") // East Caribbean dollar
    data object XDR : CurrencyCode("XDR") // IMF special drawing rights
    data object XOF : CurrencyCode("XOF") // CFA franc BCEAO
    data object XPD : CurrencyCode("XPD") // Palladium
    data object XPF : CurrencyCode("XPF") // CFP franc (franc Pacifique)
    data object XPT : CurrencyCode("XPT") // Platinum
    data object XSU : CurrencyCode("XSU") // SUCRE
    data object XUA : CurrencyCode("XUA") // ADB Unit of Account
    data object YER : CurrencyCode("YER") // Yemeni rial
    data object ZAR : CurrencyCode("ZAR") // South African rand
    data object ZMW : CurrencyCode("ZMW") // Zambian kwacha
    data object ZWL : CurrencyCode("ZWL") // Zimbabwean dollar
    data class Custom(val customCode: String) : CurrencyCode(customCode)

    override fun toString(): String = code
}