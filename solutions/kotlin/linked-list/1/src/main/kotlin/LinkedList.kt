class Deque<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun push(value: T) {
        if (tail === null) {
            val onlyNode = Node(value)
            tail = onlyNode
        } else {
            val lastNode = Node(value)
            tail!!.next = lastNode
            lastNode.previous = tail as Node<T>
            tail = lastNode
        }

        if (head === null) {
            head = tail
        }
    }

    fun pop(): T? {
        val lastNode = tail
        val value = lastNode?.value

        val previousNode = tail?.previous
        if (previousNode != null) {
            previousNode.next = null
            tail?.previous = null
            tail = previousNode
        }

        return value
    }

    fun unshift(value: T) {
        if (head === null) {
            val onlyNode = Node(value)
            head = onlyNode
        } else {
            val firstNode = Node(value)
            head!!.previous = firstNode
            firstNode.next = head as Node<T>
            head = firstNode
        }

        if (tail === null) {
            tail = head
        }
    }

    fun shift(): T? {
        val firstNode = head
        val value = firstNode?.value

        val nextNode = head?.next
        if (nextNode != null) {
            nextNode.next = null
            head?.next = null
            head = nextNode
        }

        return value
    }

    private class Node<T>(val value: T) {
        var previous: Node<T>? = null
        var next: Node<T>? = null
    }
}