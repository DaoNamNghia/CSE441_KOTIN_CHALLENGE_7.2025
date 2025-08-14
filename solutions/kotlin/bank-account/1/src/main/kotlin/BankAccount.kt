class BankAccount {
    private var open = true
    private var _balance = 0L

    var balance: Long = 0L
        get() = locking { _balance }
        private set

    fun adjustBalance(amount: Long) = locking { _balance += amount }

    fun close() { open = false }

    @Synchronized private fun<T> locking(block : () -> T): T {
        check(open)
        return block()
    }
}
