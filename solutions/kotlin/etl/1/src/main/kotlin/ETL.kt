object ETL {
    fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> = source
        .flatMap { (key, value) -> value.map { it.lowercaseChar() to key } }
        .toMap()
}
