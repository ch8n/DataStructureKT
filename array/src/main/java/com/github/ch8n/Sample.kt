package com.github.ch8n

import com.github.ch8n.algorithms.binarySearch
import com.github.ch8n.algorithms.linearSearch
import com.github.ch8n.array.StaticArray
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
            reverse(In Place 2) -> ${staticArray.rotate()}
            current -> ${staticArray.joinToString()}
        """.trimIndent()
    )

    println(
        """
            new -> ${staticArrayOf(1, 2, 3, 4, 5).joinToString()}
            isAscendingSorted -> ${staticArrayOf(1, 2, 3, 4, 5).isAscendingSorted()}
            isDescendingSorted -> ${staticArrayOf(1, 2, 3, 4, 5).isDescendingSorted()}
            new -> ${staticArrayOf(5, 4, 3, 2, 1).joinToString()}
            isAscendingSorted -> ${staticArrayOf(5, 4, 3, 2, 1).isAscendingSorted()}
            isDescendingSorted -> ${staticArrayOf(5, 4, 3, 2, 1).isDescendingSorted()}
        """.trimIndent()
    )

    println(
        """
            list -> ${staticArrayOf(-1, 2, 5, -3, 6, 7).joinToString()}
            shift positive right -> ${
            staticArrayOf(-1, 2, 5, -3, 6, 7).let {
                it.shiftPositiveRight()
                it.joinToString()
            }
        }
        """.trimIndent()
    )


//    println(
//        """
//            list -> ${staticArrayOf(-1, 2, 0, -3, 0, 7).joinToString()}
//            shift positive right -> ${
//            staticArrayOf(-1, 2, 0, -3, 0, 7).let {
//                it.shiftPositiveRight()
//                it.joinToString()
//            }
//        }
//        """.trimIndent()
//    )


    println(
        """
           list 1 -> ${staticArrayOf(1, 2, 3).joinToString()}
           list 2 -> ${staticArrayOf(7, 9, 12).joinToString()}
           merged -> ${
            staticArrayOf(1, 2, 3).merge(staticArrayOf(7, 9, 12)).joinToString()
        }
        """.trimIndent()
    )

    println(
        """
           list 1 -> ${staticArrayOf(1, 2, 3, 11).joinToString()}
           list 2 -> ${staticArrayOf(9, 12).joinToString()}
           mergeSorted -> ${
            staticArrayOf(1, 2, 3, 11).mergeSorted(staticArrayOf(9, 12)).joinToString()
        }
        """.trimIndent()
    )

    println(
        """
           list 1 -> ${staticArrayOf(1, 12, 3).joinToString()}
           list 2 -> ${staticArrayOf(3, 12, 18, 25, 1).joinToString()}
           union -> ${
            staticArrayOf(1, 12, 3)
                .union(staticArrayOf(3, 12, 18, 25, 1))
                .joinToString()
        }
        """.trimIndent()
    )

    println(
        """
           list 1 -> ${staticArrayOf(1, 2, 3, 5).joinToString()}
           list 2 -> ${staticArrayOf(2, 4, 5, 6, 8, 9).joinToString()}
           unionSorted -> ${
            staticArrayOf(1, 2, 3, 5)
                .unionSorted(staticArrayOf(2, 4, 5, 6, 8, 9))
                .joinToString()
        }
        """.trimIndent()
    )

    println(
        """
           list 1 -> ${staticArrayOf(1, 2, 3, 5).joinToString()}
           list 2 -> ${staticArrayOf(2, 4, 5, 6, 8, 9).joinToString()}
           intersection -> ${
            staticArrayOf(1, 2, 3, 5)
                .intersection(staticArrayOf(2, 4, 5, 6, 8, 9))
                .joinToString()
        }
        """.trimIndent()
    )

    println(
        """
           list 1 -> ${staticArrayOf(1, 2, 3, 5).joinToString()}
           list 2 -> ${staticArrayOf(2, 4, 5, 6, 8, 9).joinToString()}
           intersectionSorted -> ${
            staticArrayOf(1, 2, 3, 5)
                .intersectionSorted(staticArrayOf(2, 4, 5, 6, 8, 9))
                .joinToString()
        }
        """.trimIndent()
    )

    println(
        """
           list 1 -> ${staticArrayOf(1, 2, 3, 5).joinToString()}
           list 2 -> ${staticArrayOf(2, 4, 5, 6, 8, 9).joinToString()}
           difference -> ${
            staticArrayOf(1, 2, 3, 5)
                .difference(staticArrayOf(2, 4, 5, 6, 8, 9))
                .joinToString()
        }
        """.trimIndent()
    )

    println(
        """
           list 1 -> ${staticArrayOf(1, 2, 3, 5).joinToString()}
           list 2 -> ${staticArrayOf(2, 4, 5, 6, 8, 9).joinToString()}
           differenceSorted -> ${
            staticArrayOf(1, 2, 3, 5)
                .differenceSorted(staticArrayOf(2, 4, 5, 6, 8, 9))
                .joinToString()
        }
        """.trimIndent()
    )

    println(
        """
           list 1 -> ${staticArrayOf(3, 6, 6, 10, 12, 15, 15, 15, 20).joinToString()}
           findDuplicateSorted -> ${
            staticArrayOf(3, 6, 6, 10, 12, 15, 15, 15, 20)
                .findDuplicateSorted()
                .joinToString()
        }
        """.trimIndent()
    )

    println(
        """
           list 1 -> ${staticArrayOf(3, 6, 6, 10, 12, 15, 15, 15, 20).joinToString()}
           countDuplicateSorted -> ${
            staticArrayOf(3, 6, 6, 10, 12, 15, 15, 15, 20)
                .countDuplicateSorted()
                .joinToString()
        }
        """.trimIndent()
    )

    println(
        """
           list 1 -> ${staticArrayOf(6, 3, 8, 10, 16, 7, 5, 2, 9, 14).joinToString()}
           pairSumTo -> ${
            staticArrayOf(6, 3, 8, 10, 16, 7, 5, 2, 9, 14)
                .pairSumTo(10)
                .joinToString()
        }
        """.trimIndent()
    )

    println(
        """
           list 1 -> ${staticArrayOf(6, 3, 8, 10, 16, 7, 5, 2, 9, 14).joinToString()}
           pairSumTo2 -> ${
            staticArrayOf(6, 3, 8, 10, 16, 7, 5, 2, 9, 14)
                .pairSumTo2(10)
                .joinToString()
        }
        """.trimIndent()
    )

}
