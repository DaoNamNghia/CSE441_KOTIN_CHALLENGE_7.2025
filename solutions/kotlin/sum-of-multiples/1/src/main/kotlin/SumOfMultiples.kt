object SumOfMultiples {

    fun sum (nums : Set<Int>, upTo : Int) : Int {
        return (0 until upTo)
        .filter {nums.any {num -> num > 0 && it % num == 0 }}
        .sum()
    }
}