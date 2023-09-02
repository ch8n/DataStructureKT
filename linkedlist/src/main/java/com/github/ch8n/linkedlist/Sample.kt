package com.github.ch8n.linkedlist

fun main() {
    val linkedList = linkedListOf(1, 2, 3, 4, 5)

    val first = linkedList.firstOrNull
    println(first)

    val last = linkedList.lastOrNull
    println(last)

    val item3 = linkedList.getOrNull(3)
    println(item3)


    buildString {
        linkedList.onEach {
            append(it)
            append(",")
        }
    }.also(::println)

    linkedList.snapShot().joinToString().also(::println)


    val mutableLinkedList = mutableLinkedListOf(1, 2, 3, 4, 5)

    val firstLink = mutableLinkedList.firstLinkOrNull
    println(firstLink)

    val lastLink = mutableLinkedList.lastLinkOrNull
    println(lastLink)

    val item3Link = mutableLinkedList.getLinkOrNull(3)
    println(item3Link)


    buildString {
        mutableLinkedList.eachLink {
            append(it)
            append(",")
        }
    }.also(::println)

    mutableLinkedList.insertAll(listOf(9,8,7))

    buildString {
        mutableLinkedList.eachLink {
            append(it)
            append(",")
        }
    }.also(::println)

    mutableLinkedList.replaceAll(listOf(9,99,999))

    buildString {
        mutableLinkedList.eachLink {
            append(it)
            append(",")
        }
    }.also(::println)
}