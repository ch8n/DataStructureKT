package com.github.ch8n.linkedlist

fun main() {
    val linkedList = LinkedListImpl<Int>(1, 2, 3, 4, 5) as MutableLinkedList<Int>

    val firstLink = linkedList.firstLinkOrNull
    println(firstLink)

    val lastLink = linkedList.lastLinkOrNull
    println(lastLink)

    val item3 = linkedList.getLinkOrNull(3)
    println(item3)

    linkedList.insertAt(0, 9)
    linkedList.insertAt(2, 99)
    linkedList.insertAt(linkedList.lastPosition, 999)

    buildString {
        linkedList.eachLink {
            append(it)
            append(",")
        }
    }.also(::println)

    linkedList.replaceAll((0..5).toList())

    buildString {
        linkedList.eachLink {
            append(it)
            append(",")
        }
    }.also(::println)


    linkedList.insertAll((6..12).toList())

    buildString {
        linkedList.eachLink {
            append(it)
            append(",")
        }
    }.also(::println)

    linkedList.snapShot().joinToString().also(::println)
}