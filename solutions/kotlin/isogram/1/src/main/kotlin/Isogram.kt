object Isogram {
    fun isIsogram(input: String): Boolean {
        val cleanedInput = input.toLowerCase().filter { it.isLetter() }
        return cleanedInput.length == cleanedInput.toSet().size
    }
}