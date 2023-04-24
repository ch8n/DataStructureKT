package com.github.ch8n

import com.github.ch8n.algorithms.binarySearch
import com.github.ch8n.algorithms.linearSearch
import com.github.ch8n.array.staticArrayOf

internal fun main() {
    //val fixedArray = FixedArray.of(5) { -1 }
    //val fixedArray = fixedArrayOf(5) { -1 }
    val staticArray = staticArrayOf(-1, -1, -1, -1)

    println()
    println("printing current item")
    (0..staticArray.lastIndex).forEach { index ->
        print(staticArray.get(index))
        print(",")
    }

    println()
    println("updating item")
    repeat(staticArray.size) { index ->
        println("from ${staticArray.get(index)} to $index")
        staticArray.set(index, index)
    }

    println()
    println("print all content using index + get")
    repeat(staticArray.size) { index ->
        print(staticArray.get(index))
        print(",")
    }

    println()
    println("print all content using forEach")
    staticArray.forEach { item ->
        print(item)
        print(",")
    }

    println()
    println("linearSearch -> 2 @ ${staticArray.linearSearch(2)}")
    println("linearSearch -> 8 @ ${staticArray.linearSearch(8)}")

    println()
    println("binarySearch -> 2 @ ${staticArray.binarySearch(2)}")
    println("binarySearch -> 8 @ ${staticArray.binarySearch(8)}")

    println()
    println("Min: ${staticArray.min()}")
    println("Max: ${staticArray.max()}")
    println("Sum: ${staticArray.sum()}")
    println("Average: ${staticArray.average()}")

    println(
        """
            current -> ${staticArray.joinToString()}
            reverse(extra space) -> ${staticArray.reversed().joinToString()}
            current -> ${staticArray.joinToString()}
        """.trimIndent()
    )

    println(
        """
            current -> ${staticArray.joinToString()}
            reverse(In Place) -> ${staticArray.reverseInPlace()}
            current -> ${staticArray.joinToString()}
        """.trimIndent()
    )

    println(
        """
            current -> ${staticArray.joinToString()}
            reverse(In Place 2) -> ${staticArray.reverseInPlace2()}
            current -> ${staticArray.joinToString()}
        """.trimIndent()
    )

    println(
        """
            current -> ${staticArray.joinToString()}
            reverse(In Place 2) -> ${staticArray.shiftRight()}
            current -> ${staticArray.joinToString()}
        """.trimIndent()
    )

    println(
        """
            new -> ${staticArrayOf(1, 2, 3, 4, 5).joinToString()}
            isAscendingSorted -> ${staticArrayOf(1, 2, 3, 4, 5).isAscendingSorted()}
            isDescendingSorted -> ${staticArrayOf(1, 2, 3, 4, 5).isDescendingSorted()}
            isAscendingSorted -> ${staticArrayOf(5, 4, 3, 2, 1).isAscendingSorted()}
            isDescendingSorted -> ${staticArrayOf(5, 4, 3, 2, 1).isDescendingSorted()}
        """.trimIndent()
    )

    println(
        """
            list1 -> ${staticArrayOf(1, 2, 3).joinToString()}
            list2 -> ${staticArrayOf(4, 5, 6).joinToString()}
            merged -> ${staticArrayOf(1, 2, 3).merge(staticArrayOf(4, 5, 6)).joinToString()}
        """.trimIndent()
    )

}
