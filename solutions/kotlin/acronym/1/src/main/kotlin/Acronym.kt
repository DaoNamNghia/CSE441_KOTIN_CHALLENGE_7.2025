object Acronym {
    fun generate(phrase: String) : String {
        return phrase.split(" ","-","_")
                .filter {it.isNotBlank()}
                .map { it[0] }.map {it.toUpperCase()}.joinToString ("")
    }
}
