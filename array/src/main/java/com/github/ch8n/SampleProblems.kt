package com.github.ch8n

import com.github.ch8n.array.StaticArray
import com.github.ch8n.array.staticArrayOf
import java.util.TreeSet

fun String.println() {
    println(this)
}

fun main() {
    reverseArray()
    finMinMax()
    findKthMinMax()
    sort012()
    sortPositiveNegative()
    findUnionIntersectionSorted()
}


private fun reverseArray() {
    buildString {
        val array = staticArrayOf(1, 2, 3, 4, 5)
        appendLine("array " + array.joinToString())
        var start = 0
        var end = array.lastIndex
        while (start < end) {
            val startItem = array.get(start)
            val endItem = array.get(end)
            array.set(start, endItem)
            array.set(end, startItem)
            start++
            end--
        }
        appendLine("reverse " + array.joinToString())
    }.println()
}

private fun finMinMax() {
    buildString {
        val array = staticArrayOf(8, 9, 3, 23, 2, 34)
        appendLine("array " + array.joinToString())
        var min = array.first()
        var max = array.first()
        array.forEach {
            min = minOf(it, min)
            max = maxOf(it, max)
        }
        appendLine("min $min")
        appendLine("max $max")
    }.println()
}

private fun findKthMinMax() {
    // other ways are using heap & treeSet or treeMap
    buildString {
        val array = staticArrayOf(8, 9, 3, 23, 2, 34)
        appendLine("array " + array.joinToString())
        val kth = 3
        val sorted = array.sorted()
        val minIndex = kth - 1
        val maxIndex = array.lastIndex - kth - 1
        val min = sorted.get(minIndex)
        val max = sorted.get(maxIndex)
        appendLine("$kth-rd min  $min")
        appendLine("$kth-rd max  $max")
    }.println()
}

private fun sort012() {
    buildString {
        val array = staticArrayOf(1, 2, 1, 0, 2, 2, 1, 0)
        appendLine("array " + array.joinToString())
        var ptr0 = 0
        var ptr1 = 0
        var ptr2 = array.lastIndex
        while (ptr1 < ptr2) {
            when {
                array.get(ptr1) == 1 -> {
                    ptr1++
                }

                array.get(ptr1) == 0 -> {
                    val item1 = array.get(ptr1)
                    val item2 = array.get(ptr0)
                    array.set(ptr0, item1)
                    array.set(ptr1, item2)
                    ptr0++
                }

                array.get(ptr1) == 2 -> {
                    val item1 = array.get(ptr1)
                    val item2 = array.get(ptr2)
                    array.set(ptr1, item2)
                    array.set(ptr2, item1)
                    ptr2--
                }
            }
        }
        appendLine("sorted 012 " + array.joinToString())
    }.println()
}

private fun sortPositiveNegative() {
    buildString {
        val array = staticArrayOf(-2, 1, 9, -8, 6, -3)
        appendLine("array " + array.joinToString())
        var start = 0
        var end = array.lastIndex
        while (start < end) {
            if (array.get(start) < 0) start++
            if (array.get(end) > 0) end--
            if (start < end) {
                val startItem = array.get(start)
                val endItem = array.get(end)
                array.set(start, endItem)
                array.set(end, startItem)
            }
        }
        appendLine("sorted +ve -ve | " + array.joinToString())
    }.println()
}

private fun findUnionIntersectionSorted() {
    buildString {
        val array1 = staticArrayOf(3, 4, 5, 6)
        val array2 = staticArrayOf(2, 4, 5, 7, 12)
        appendLine("array 1 | " + array1.joinToString())
        appendLine("array 2 | " + array2.joinToString())
        val union = staticArrayOf(array1.size + array2.size) { -1 }
        var currentIndex = 0

        // union
        var array1Index = 0
        var array2Index = 0
        while (array1Index < array1.lastIndex && array2Index < array2.lastIndex) {

            if (array1.get(array1Index) < array2.get(array2Index)) {
                union.set(currentIndex++, array1.get(array1Index++))
            }

            if (array1.get(array1Index) > array2.get(array2Index)) {
                union.set(currentIndex++, array2.get(array2Index++))
            }

            if (array1.get(array1Index) == array2.get(array2Index)) {
                union.set(currentIndex++, array1.get(array1Index))
                array1Index++
                array2Index++
            }

        }

        for (index in array1Index..array1.lastIndex) {
            union.set(currentIndex++, array1.get(index))
        }

        for (index in array2Index..array2.lastIndex) {
            union.set(currentIndex++, array2.get(index))
        }

        appendLine("union | " + union.joinToString())
    }.println()


    buildString {
        val array1 = staticArrayOf(3, 4, 5, 6, 7)
        val array2 = staticArrayOf(2, 4, 5, 7, 12)
        appendLine("array 1 | " + array1.joinToString())
        appendLine("array 2 | " + array2.joinToString())
        val intersection = staticArrayOf(array1.size + array2.size) { -1 }
        var currentIndex = 0

        //intersection
        var array1Index = 0
        var array2Index = 0
        while (array1Index < array1.lastIndex && array2Index < array2.lastIndex) {

            if (array1.get(array1Index) < array2.get(array2Index)) {
                array1Index++
            }

            if (array1.get(array1Index) > array2.get(array2Index)) {
                array2Index++
            }

            if (array1.get(array1Index) == array2.get(array2Index)) {
                intersection.set(currentIndex++, array1.get(array1Index))
                array1Index++
                array2Index++
            }

        }
        appendLine("intersection | " + intersection.joinToString())
    }.println()
}
