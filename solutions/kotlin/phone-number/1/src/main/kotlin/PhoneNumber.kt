class PhoneNumber(source: String) {

    private val validPhoneNumber = "^[2-9]\\d{2}[2-9]\\d{6}".toRegex()

    val number: String = parseNumber(source)
    val areaCode: String = number.substring(0..2)
    val exchangeCode: String = number.substring(3..5)
    val subscriberNumber: String = number.substring(6..9)

    override fun toString() = "($areaCode) $exchangeCode-$subscriberNumber"

    private fun parseNumber(source: String): String {
        val digits = source.filter { it.isDigit() }
        return when (digits.length) {
            10 -> validate(digits)
            11 -> {
                require(digits.take(1) == "1") { "Invalid international country code ${digits.take(1)}" }
                validate(digits.drop(1))
            }
            else -> throw IllegalArgumentException("$source should have 10 or 11 digits")
        }
    }

    private fun validate(digits: String): String {
        require(digits.matches(validPhoneNumber)) { "$digits is not a valid NANP phone number" }
        return digits
    }

}