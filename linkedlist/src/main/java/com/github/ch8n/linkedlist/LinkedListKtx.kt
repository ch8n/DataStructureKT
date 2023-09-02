package com.github.ch8n.linkedlist

fun <T> linkedListOf(vararg items: T): LinkedList<T> =
    LinkedListImpl.from(items.asList())

fun <T> mutableLinkedListOf(vararg items: T): MutableLinkedList<T> =
    LinkedListImpl.mutableFrom(items.asList())
