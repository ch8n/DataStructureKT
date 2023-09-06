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

    mutableLinkedList.insertAll(listOf(9, 8, 7))

    buildString {
        mutableLinkedList.eachLink {
            append(it)
            append(",")
        }
    }.also(::println)

    mutableLinkedList.replaceAll(listOf(9, 99, 999))

    buildString {
        mutableLinkedList.eachLink {
            append(it)
            append(",")
        }
    }.also(::println)

    println("==== LinkedList Sum ====")
    val linkedList1 = linkedListOf(1, 2, 3, 4, 5)
    linkedList.snapShot().joinToString(",").also(::println)
    println("sum -> ${linkedList1.sum()}")
    println("max -> ${linkedList1.maxOrNull()}")
    println("Position Of 3 -> ${linkedList1.findPositionOf(3)}")
    println("insert @ 0 -> ${linkedList1.insertAt(0, 0)} result -> ${linkedList1.snapShot()}")
    println("insert @ 2 -> ${linkedList1.insertAt(2, 9)} result -> ${linkedList1.snapShot()}")
    println(
        "insert @ ${linkedList1.lastIndex} -> ${
            linkedList1.insertAt(
                linkedList1.lastIndex,
                999
            )
        } result -> ${linkedList1.snapShot()}"
    )
    println("delete @ ${linkedList1.lastIndex} -> ${linkedList1.deleteAt(linkedList1.lastIndex)} result -> ${linkedList1.snapShot()}")
    println("delete @ 0 -> ${linkedList1.deleteAt(0)} result -> ${linkedList1.snapShot()}")
    println("delete @ 2 -> ${linkedList1.deleteAt(2)} result -> ${linkedList1.snapShot()}")


    println("==== MutableLinkedList Sum ====")
    val mutableLinkedList1 = mutableLinkedListOf(1, 2, 3, 4, 5)
    mutableLinkedList1.snapShot().joinToString(",").also(::println)
    println("sum -> ${mutableLinkedList1.sum()}")
    println("max -> ${mutableLinkedList1.maxOrNull()}")
    println("Link Of 3 -> ${mutableLinkedList1.findLinkOrNull(3)}")
    println("insert @ 0 -> ${mutableLinkedList1.insertAt(0, 0)} result -> ${mutableLinkedList1.snapShot()}")
    println("insert @ 2 -> ${mutableLinkedList1.insertAt(2, 9)} result -> ${mutableLinkedList1.snapShot()}")
    println(
        "insert @ ${mutableLinkedList1.lastIndex} -> ${
            mutableLinkedList1.insertAt(
                mutableLinkedList1.lastIndex,
                999
            )
        } result -> ${mutableLinkedList1.snapShot()}"
    )
    println("delete @ ${mutableLinkedList1.lastIndex} -> ${mutableLinkedList1.deleteAt(mutableLinkedList1.lastIndex)} result -> ${mutableLinkedList1.snapShot()}")
    println("delete @ 0 -> ${mutableLinkedList1.deleteAt(0)} result -> ${mutableLinkedList1.snapShot()}")
    println("delete @ 2 -> ${mutableLinkedList1.deleteAt(2)} result -> ${mutableLinkedList1.snapShot()}")

    val mutableLinkedList2 = mutableLinkedListOf(1, 3, 4, 2, 9, 8)
    println("isSorted ${mutableLinkedList2.snapShot()} -> ${mutableLinkedList2.isSorted()}")
    println("sort ${mutableLinkedList2.snapShot()} -> ${mutableLinkedList2.sort()} result -> ${mutableLinkedList2.snapShot()}")
    println("isSorted ${mutableLinkedList2.snapShot()} -> ${mutableLinkedList2.isSorted()}")

    println("Sorted insert ${mutableLinkedList2.snapShot()} -> ${mutableLinkedList2.insertSorted(0)} result -> ${mutableLinkedList2.snapShot()}")
    println("Sorted insert ${mutableLinkedList2.snapShot()} -> ${mutableLinkedList2.insertSorted(3)} result -> ${mutableLinkedList2.snapShot()}")
    println("Sorted insert ${mutableLinkedList2.snapShot()} -> ${mutableLinkedList2.insertSorted(10)} result -> ${mutableLinkedList2.snapShot()}")

    println("Delete @ 0 ${mutableLinkedList2.snapShot()} -> ${mutableLinkedList2.deleteAt(0)} result -> ${mutableLinkedList2.snapShot()}")
    println("Delete @ 2 ${mutableLinkedList2.snapShot()} -> ${mutableLinkedList2.deleteAt(2)} result -> ${mutableLinkedList2.snapShot()}")
    println("Delete @ 7 ${mutableLinkedList2.snapShot()} -> ${mutableLinkedList2.deleteAt(6)} result -> ${mutableLinkedList2.snapShot()}")


    val mutableLinkedList3 = mutableLinkedListOf(1, 1, 2, 3, 3, 4, 5, 9, 9)
    println("remove duplicated from sorted ${mutableLinkedList3.snapShot()} -> ${mutableLinkedList3.uniqueSorted()} result -> ${mutableLinkedList3.snapShot()}")

}