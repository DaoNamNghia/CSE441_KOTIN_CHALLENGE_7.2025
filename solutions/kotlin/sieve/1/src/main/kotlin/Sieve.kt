object Sieve {
    private val primes = generateSequence(2 to generateSequence(3) { it + 2 }) {
        val iterator = it.second.iterator()
        val next = iterator.next()
        next to iterator.asSequence().filter { it % next != 0 }
    }.map { it.first }

    fun primesUpTo(upperBound: Int) =
            primes.takeWhile { it <= upperBound }.toList()
}