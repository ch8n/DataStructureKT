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