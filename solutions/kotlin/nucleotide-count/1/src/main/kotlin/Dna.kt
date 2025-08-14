class Dna(private val nucleotides: String) {
    init {
        require(!nucleotides.matches(".*[^ACTG].*".toRegex()))
    }
    val nucleotideCounts: Map<Char, Int>
    get() {
        val counts = HashMap<Char, Int>(mapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0))
        nucleotides.map { counts.set(it, counts.get(it)!! + 1) }
        return counts
    }
}