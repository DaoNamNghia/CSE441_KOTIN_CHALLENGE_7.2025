class RotationalCipher(private val offset: Int) {

    fun encode(text: String) = text.map { if(it.isLetter()) it.encode(offset)  else it }.joinToString("")

    private val lowercaseAlphabet = CharRange('a', 'z').toList()
    private val uppercaseAlphabet = CharRange('A', 'Z').toList()

    private fun List<Char>.shift(value: Char, offset: Int): Char = get((indexOf(value) + offset) % size)

    private fun Char.encode(offset: Int) =
            if(isUpperCase()) uppercaseAlphabet.shift(this, offset)
            else lowercaseAlphabet.shift(this, offset)
}