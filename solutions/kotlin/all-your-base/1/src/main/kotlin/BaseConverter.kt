class BaseConverter(private val oldBase: Int, private val digits: IntArray) {

    init {
        require(oldBase >= 2) { "Bases must be at least 2." }
        require(digits.isNotEmpty()) { "You must supply at least one digit." }
        require(digits.none { it < 0 }) { "Digits may not be negative." }
        require(digits.all { it < oldBase }) { "All digits must be strictly less than the base." }
        require(digits.size == 1 || digits.first() != 0) { "Digits may not contain leading zeros." }
    }

    fun convertToBase(newBase: Int): IntArray {
        require(newBase >= 2) { "Bases must be at least 2." }

        val decimalValue = digits.fold(0) { acc, digit -> acc * oldBase + digit }

        if (decimalValue == 0) {
            return intArrayOf(0)
        }

        val result = mutableListOf<Int>()
        var value = decimalValue
        while (value > 0) {
            val remainder = value % newBase
            result.add(remainder)
            value /= newBase
        }

        return result.reversed().toIntArray()
    }
}