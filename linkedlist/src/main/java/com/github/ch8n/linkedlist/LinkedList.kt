package com.github.ch8n.linkedlist


interface MutableLinkedList<T> : LinkedList<T> {

    val firstLinkOrNull: Link<T>?

    val lastLinkOrNull: Link<T>?

    fun getLinkOrNull(position: Int): Link<T>?
    override fun insertAt(index: Int, value: T)
    override fun replaceAt(index: Int, value: T)
    override fun deleteAt(index: Int)
    fun insertAll(list: List<T>)
    fun replaceAll(list: List<T>)
    fun eachLink(iteration: (link: Link<T>) -> Unit)

}


interface LinkedList<T> {

    val firstOrNull: T?
    val lastOrNull: T?

    val size: Int
    fun insertAt(index: Int, value: T)
    fun replaceAt(index: Int, value: T)
    fun deleteAt(index: Int)

    val lastIndex: Int
    fun isEmpty(): Boolean
    fun getOrNull(position: Int): T?
    fun onEach(iteration: (item: T) -> Unit)
    fun snapShot(): List<T>
}

data class Link<T>(
    var value: T,
    var next: Link<T>? = null
)

class LinkedListImpl<T> private constructor() : MutableLinkedList<T> {

    private var head: Link<T>? = null
    override val firstLinkOrNull: Link<T>? get() = head

    override val firstOrNull: T? get() = firstLinkOrNull?.value
    override val lastLinkOrNull: Link<T>?
        get() {
            var current = head
            repeat(lastIndex) { current = current?.next }
            return current
        }

    override val lastOrNull: T? get() = lastLinkOrNull?.value

    override fun getLinkOrNull(position: Int): Link<T>? {
        var current = head
        repeat(position) { current = current?.next }
        return current
    }

    override fun getOrNull(position: Int): T? {
        return getLinkOrNull(position)?.value
    }

    override fun insertAt(index: Int, value: T) {
        check(index in 0..lastIndex) { IllegalAccessException("Invalid position") }

        if (index == 0) {
            val newLink = Link(value)
            newLink.next = head
            head = newLink
            return
        }

        var current = head
        (1..index).forEach { _ -> current = current?.next }
        val newLink = Link(value)
        val next = current?.next
        newLink.next = next
        current?.next = newLink
    }

    override fun replaceAt(index: Int, value: T) {
        check(index in 0..lastIndex) { IllegalAccessException("Invalid position") }
        var current = head
        repeat(index) { current = current?.next }
        current?.value = value
    }

    override fun deleteAt(index: Int) {
        check(index in 0..lastIndex) { IllegalAccessException("Invalid position") }

        if (index == 0) {
            val next = head?.next
            head = next
            return
        }

        var current: Link<T>? = head
        var previous: Link<T>? = null
        repeat(index) {
            previous = current
            current = current?.next
        }
        previous?.next = current?.next
    }

    override fun replaceAll(list: List<T>) {
        val newHead = Link(value = list.first())
        var current: Link<T>? = newHead
        (1..list.lastIndex).forEach { index ->
            val newLink = Link(value = list.get(index))
            current?.next = newLink
            current = newLink
        }
        head = newHead
    }

    override fun insertAll(list: List<T>) {
        var current = head
        repeat(lastIndex) { current = current?.next }
        list.forEach { item ->
            val newLink = Link(item)
            current?.next = newLink
            current = newLink
        }
    }

    override val lastIndex get() = size - 1

    override val size: Int
        get() {
            var current = head
            var interations = 0
            while (current != null) {
                interations += 1
                current = current.next
            }
            return interations
        }

    override fun isEmpty() = head == null
    override fun eachLink(iteration: (link: Link<T>) -> Unit) {
        var current: Link<T>? = head
        while (current != null) {
            iteration.invoke(current)
            current = current.next
        }
    }

    override fun onEach(iteration: (item: T) -> Unit) {
        eachLink { iteration.invoke(it.value) }
    }

    override fun snapShot(): List<T> {
        return buildList {
            this@LinkedListImpl.onEach { add(it) }
        }
    }

    companion object {
        fun <T> mutableFrom(items: List<T>): MutableLinkedList<T> {
            val linkedList = LinkedListImpl<T>()
            linkedList.replaceAll(items)
            return linkedList
        }

        fun <T> from(items: List<T>): LinkedList<T> {
            val linkedList = LinkedListImpl<T>()
            linkedList.replaceAll(items)
            return linkedList
        }
    }
}