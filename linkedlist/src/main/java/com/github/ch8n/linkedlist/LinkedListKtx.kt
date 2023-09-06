package com.github.ch8n.linkedlist

import kotlin.math.max

fun <T> linkedListOf(vararg items: T): LinkedList<T> =
    LinkedListImpl.from(items.asList())

fun <T> mutableLinkedListOf(vararg items: T): MutableLinkedList<T> =
    LinkedListImpl.mutableFrom(items.asList())


fun LinkedList<Int>.sum(): Int {
    val list = this
    var sum = 0
    list.onEach { sum += it }
    return sum
}

fun <T> LinkedList<T>.findPositionOf(target: T): Int {
    var foundAtPosition = -1
    var position = 0
    onEach {
        position += 1
        if (target == it) {
            foundAtPosition = position
        }
    }
    return foundAtPosition
}

fun <T> MutableLinkedList<T>.findLinkOrNull(target: T): Link<T>? {
    var foundLink: Link<T>? = null
    eachLink {
        if (it.value == target) {
            foundLink = it
        }
    }
    return foundLink
}

fun LinkedList<Int>.maxOrNull(): Int? {
    if (isEmpty()) return null
    val list = this
    var max: Int? = null
    list.onEach { item -> max = max(max ?: 0, item) }
    return max
}


fun MutableLinkedList<Int>.sum(): Int {
    var current = firstLinkOrNull
    var sum = 0
    while (current != null) {
        sum += current.value
        current = current.next
    }
    return sum
}

fun MutableLinkedList<Int>.maxOrNull(): Int? {
    if (isEmpty()) return null
    var max: Int? = null
    var current = firstLinkOrNull
    while (current != null) {
        max = max(max ?: 0, current.value)
        current = current.next
    }
    return max
}

fun MutableLinkedList<Int>.isSorted(): Boolean {
    if (isEmpty()) return true
    var current: Link<Int>? = firstLinkOrNull
    var next = current?.next
    while (next != null) {
        val currentValue = current?.value ?: Int.MIN_VALUE
        val nextValue = next?.value ?: Int.MIN_VALUE
        if (currentValue > nextValue) return false
        current = next
        next = current.next
    }
    return true
}

fun MutableLinkedList<Int>.insertSorted(value: Int) {
    if (!isSorted()) throw IllegalStateException("LinkedList isn't sorted!")

    // check for head location swapping
    val head: Link<Int>? = firstLinkOrNull
    val headValue = head?.value ?: Int.MIN_VALUE
    if (value <= headValue) {
        val nextLink = firstLinkOrNull?.next
        val currentLink = Link(headValue)
        currentLink.next = nextLink
        firstLinkOrNull?.value = value
        firstLinkOrNull?.next = currentLink
        return
    }

    // check for other places
    var current = firstLinkOrNull
    var next = current?.next

    while (next != null) {
        val currentValue = current?.value ?: Int.MIN_VALUE
        val nextValue = next.value
        if (value in currentValue..nextValue) {
            val newLink = Link(value)
            newLink.next = next
            current?.next = newLink
            return
        }
        current = next
        next = current.next
    }

    // check for last places
    val lastValue = current?.value ?: Int.MIN_VALUE
    if (lastValue < value) {
        val newLink = Link(value)
        current?.next = newLink
    }
}

fun MutableLinkedList<Int>.sort() {
    if (isEmpty()) return
    var current: Link<Int>? = firstLinkOrNull
    var next: Link<Int>? = current?.next

    while (current != null) {

        if (next == null) {
            current = current.next
            next = current?.next
            continue
        }

        val currentValue = current.value
        val nextValue = next.value

        if (currentValue < nextValue) {
            next = next.next
        } else {
            current.value = nextValue
            next.value = currentValue
        }

    }
}
