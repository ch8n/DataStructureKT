package com.github.ch8n

import com.github.ch8n.algorithms.linearSearch
import com.github.ch8n.array.StaticArray
import com.github.ch8n.array.staticArrayOf
import com.github.ch8n.array.toStaticArray

@JvmInline
value class Index(val value: Int)

fun StaticArray<Int>.missingItems(): StaticArray<Int> {
    if (size == 0) return staticArrayOf()
    val max = this.max()
    val buffer = staticArrayOf(max + 1) { 0 }
    forEach { buffer.set(it, 1) }
    return buffer.filter { it == 0 }.toStaticArray()
}

fun String.println() {
    println(this)
}

fun main() {
    // 0 1 2 3 4 5
    // 1,2,4,5,7,8
    //staticArrayOf(1, 2, 4, 5, 7, 8).missingItems()
    val test1 = staticArrayOf(2, 4, 8)
    val test2 = staticArrayOf(1, 2, 6, 7, 8)
    //println(test1.mergeSorted12(test2).joinToString(","))
    return
    reverseArray()
    finMinMax()
    findKthMinMax()
    sort012()
    sortPositiveNegative()
    findUnionIntersectionSorted()
    cyclicRotateArray()
    largestContiguousSum()
    minimizeDifferenceBetweenHeights()
    minimumJumps()
    findDuplicates()
    mergedSortedNoExtraSpace()
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

private fun cyclicRotateArray() {
    buildString {
        val array = staticArrayOf(3, 4, 5, 6, 12)
        appendLine("array 1 | " + array.joinToString())
        var first = array.first()
        for (index in 1..array.lastIndex) {
            val temp = array.get(index)
            array.set(index, first)
            first = temp
        }
        array.set(0, first)
        appendLine("rotated | " + array.joinToString())
    }.println()
}

private fun largestContiguousSum() {
    buildString {
        val array = staticArrayOf(1, 2, 3, -2, 5)
        // max sum -1
        appendLine("array 1 | " + array.joinToString())
        var longestSum = array.get(0)
        var previousSum = array.get(0)
        for (index in 1..array.lastIndex) {
            previousSum = maxOf(array.get(index), previousSum + array.get(index))
            longestSum = maxOf(previousSum, longestSum)
        }
        appendLine("largest sum | $longestSum ")
    }.println()
}

private fun minimizeDifferenceBetweenHeights() {
    /**
     * Find out the minimum possible difference between the height of the shortest
     * and tallest towers after you have modified each tower.
     */
    buildString {
        val array = staticArrayOf(1, 5, 8, 10)
        val k = 2
        appendLine("array " + array.joinToString())
        appendLine("k = " + k)

        var max = array.last() - k
        var min = array.first() + k
        var diff = max - min

        for (index in 1 until array.lastIndex) {
            val height = array.get(index)
            max = maxOf(height + k, max)
            min = minOf(height - k, min)
        }

        diff = minOf(diff, max - min)

        appendLine("minimum possible difference | $diff ")
    }.println()
}

private fun minimumJumps() {
    buildString {
        val array = staticArrayOf(1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9)
        //val array = staticArrayOf(1, 0, 2)
        appendLine("array " + array.joinToString())
        var currentIndex = 0
        var jumps = 0
        while (currentIndex < array.lastIndex) {
            jumps++
            val jumpLength = array.get(currentIndex)
            if (jumpLength == 0) {
                jumps = -1
                break
            }
            currentIndex += jumpLength
        }
        appendLine("jumps $jumps")
    }.println()
}

private fun findDuplicates() {
    buildString {
        //val array = staticArrayOf(1, 3, 4, 2, 2)
        val array = staticArrayOf(3, 1, 3, 4, 2)
        appendLine("array " + array.joinToString())
        val grouping = array.groupBy { it }
        val duplicate = grouping.filter { it.value.count() > 1 }.entries.first().key
        appendLine("duplicate $duplicate")
    }.println()
}

private fun mergedSortedNoExtraSpace() {
    buildString {
        val array1 = staticArrayOf(1, 3, 5, 7)
        val array2 = staticArrayOf(0, 2, 6, 8, 9)
        appendLine("array1 " + array1.joinToString())
        appendLine("array2 " + array2.joinToString())

        var l1Index = 0
        var l2Index = 0
        var iter = 0
        while (l1Index < array1.lastIndex && l2Index < array2.lastIndex) {
            if (array1.get(l1Index) < array2.get(l2Index)) {
                l1Index++
            } else if (array1.get(l1Index) > array2.get(l2Index)) {
                val temp = array1.get(l1Index)
                array1.set(l1Index, array2.get(l2Index))
                array2.set(l2Index, temp)
                l2Index++
            }
        }

        appendLine("after merged!")
        appendLine("array1 " + array1.joinToString())
        appendLine("array2 " + array2.joinToString())

    }.println()
}



