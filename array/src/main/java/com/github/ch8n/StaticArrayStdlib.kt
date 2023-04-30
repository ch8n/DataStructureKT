package com.github.ch8n

import com.github.ch8n.algorithms.binarySearch
import com.github.ch8n.algorithms.linearSearch
import com.github.ch8n.array.StaticArray
import com.github.ch8n.array.staticArrayOf


fun StaticArray<Int>.max(): Int {
    return fold(get(0)) { acc, item ->
        return@fold if (item > acc) {
            item
        } else {
            acc
        }
    }
}

fun StaticArray<Int>.min(): Int {
    return fold(get(0)) { acc, item ->
        return@fold if (item < acc) {
            item
        } else {
            acc
        }
    }
}


fun <T> StaticArray<T>.reversed(): StaticArray<T> {
    return staticArrayOf(size) {
        get(lastIndex - it)
    }
}

fun <T> StaticArray<T>.reverseInPlace() {
    val midIndex = if (lastIndex % 2 == 0) (lastIndex / 2) - 1 else (lastIndex / 2)
    (0..midIndex).forEach { index ->
        val _firstIndex = index
        val _lastIndex = lastIndex - index
        val first = get(_firstIndex)
        val last = get(_lastIndex)
        set(_firstIndex, last)
        set(_lastIndex, first)
    }
}

fun <T> StaticArray<T>.reverseInPlace2() {
    var ptrStart = 0
    var ptrEnd = lastIndex
    while (ptrStart < ptrEnd) {
        val first = get(ptrStart)
        val last = get(ptrEnd)
        set(ptrStart, last)
        set(ptrEnd, first)
        ptrStart += 1
        ptrEnd -= 1
    }
}

fun <T> StaticArray<T>.rotate(times: Int = 2) {
    repeat(times) {
        var temp: T = get(lastIndex)
        for (index in lastIndex downTo 1) {
            val secondLast = get(index - 1)
            set(index - 1, temp)
            temp = secondLast
        }
        set(lastIndex, temp)
    }
}


fun StaticArray<Int>.sum(): Int = fold(0) { total, item ->
    return@fold total + item
}


fun StaticArray<Int>.average(): Float {
    return sum() / size.toFloat()
}

fun StaticArray<Int>.isAscendingSorted(): Boolean {
    var lastItem = last()
    for (index in lastIndex - 1 downTo 0) {
        val previous = get(index)
        if (previous > lastItem) {
            return false
        }
        lastItem = previous
    }
    return true
}


fun StaticArray<Int>.isDescendingSorted(): Boolean {
    var firstItem = first()
    for (index in 1..lastIndex) {
        val next = get(index)
        if (firstItem < next) {
            return false
        }
        firstItem = next
    }
    return true
}

fun StaticArray<Int>.shiftPositiveRight() {
    var negativeIndex = 0
    var positiveIndex = lastIndex

    fun StaticArray<Int>.swap(fromIndex: Int, toIndex: Int) {
        val first = get(fromIndex)
        val second = get(toIndex)
        set(toIndex, first)
        set(fromIndex, second)
    }

    while (negativeIndex < positiveIndex) {
        while (get(negativeIndex) < 0) negativeIndex++
        while (get(positiveIndex) > 0) positiveIndex--
        if (negativeIndex < positiveIndex) {
            swap(negativeIndex, positiveIndex)
        }
    }
}

fun StaticArray<Int>.merge(that: StaticArray<Int>): StaticArray<Int> {
    val merged = staticArrayOf(this.size + that.size) { -1 }
    var current = 0
    this.forEach {
        merged.set(current, it)
        ++current
    }
    that.forEach {
        merged.set(current, it)
        ++current
    }
    return merged
}


fun StaticArray<Int>.mergeSorted(that: StaticArray<Int>): StaticArray<Int> {
    var ptrList1 = 0
    var ptrList2 = 0
    val merged = staticArrayOf(this.size + that.size) { -1 }
    var current = 0
    while (ptrList1 < this.lastIndex || ptrList2 < that.lastIndex) {
        when {
            this.get(ptrList1) < that.get(ptrList2) -> {
                merged.set(current, this.get(ptrList1))
                current++
                ptrList1++
            }

            this.get(ptrList1) > that.get(ptrList2) -> {
                merged.set(current, that.get(ptrList2))
                current++
                ptrList2++
            }

            this.get(ptrList1) == that.get(ptrList2) -> {
                merged.set(current, this.get(ptrList1))
                current++
                ptrList1++
                ptrList2++
            }
        }
    }

    for (index in ptrList1..this.lastIndex) {
        merged.set(current, this.get(index))
        current++
    }

    for (index in ptrList2..that.lastIndex) {
        merged.set(current, that.get(index))
        current++
    }
    return merged
}


fun StaticArray<Int>.union(that: StaticArray<Int>): StaticArray<Int> {
    val merged = staticArrayOf<Int>(this.size + that.size) { -1 }
    var current = 0

    this.forEach {
        merged.set(current, it)
        current++
    }

    that.forEach {
        // binary search require item to be sorted
        if (merged.linearSearch(it) == -1) {
            merged.set(current, it)
            current++
        }
    }
    return merged
}


fun StaticArray<Int>.unionSorted(that: StaticArray<Int>): StaticArray<Int> {
    var ptr1 = 0
    var ptr2 = 0
    val union = staticArrayOf(this.size + that.size) { -1 }
    var current = 0
    while (ptr1 < this.lastIndex && ptr2 < that.lastIndex) {
        when {
            this.get(ptr1) < that.get(ptr2) -> {
                if (union.binarySearch(this.get(ptr1)) == -1) {
                    union.set(current, this.get(ptr1))
                    current++
                }
                ptr1++
            }

            this.get(ptr1) > that.get(ptr2) -> {
                if (union.binarySearch(that.get(ptr2)) == -1) {
                    union.set(current, that.get(ptr2))
                    current++
                }
                ptr2++
            }

            this.get(ptr1) == that.get(ptr2) -> {
                if (union.binarySearch(that.get(ptr2)) == -1) {
                    union.set(current, that.get(ptr2))
                    current++
                }
                ptr1++
                ptr2++
            }
        }
    }

    for (index in ptr1..this.lastIndex) {
        union.set(current, this.get(index))
        current++
    }

    for (index in ptr2..that.lastIndex) {
        union.set(current, that.get(index))
        current++
    }

    return union
}


fun StaticArray<Int>.intersection(that: StaticArray<Int>): StaticArray<Int> {
    val intersection = staticArrayOf(this.size + that.size) { -1 }
    var current = 0
    this.forEach {
        if (that.linearSearch(it) != -1) {
            intersection.set(current, it)
            current++
        }
    }
    return intersection
}

fun StaticArray<Int>.intersectionSorted(that: StaticArray<Int>): StaticArray<Int> {
    var ptr1 = 0
    var ptr2 = 0
    val intersection = staticArrayOf(this.size + that.size) { -1 }
    var current = 0
    while (ptr1 < this.size && ptr2 < that.size) {
        when {
            this.get(ptr1) == that.get(ptr2) -> {
                intersection.set(current, this.get(ptr1))
                current++
                ptr1++
                ptr2++
            }

            this.get(ptr1) < that.get(ptr2) -> ptr1++
            this.get(ptr1) > that.get(ptr2) -> ptr2++
        }
    }
    return intersection
}

fun StaticArray<Int>.difference(that: StaticArray<Int>): StaticArray<Int> {
    val difference = staticArrayOf(this.size + that.size) { -1 }
    var current = 0
    this.forEach {
        if (that.linearSearch(it) == -1) {
            difference.set(current, it)
            current++
        }
    }
    return difference
}

fun StaticArray<Int>.differenceSorted(that: StaticArray<Int>): StaticArray<Int> {
    val difference = staticArrayOf(this.size + that.size) { -1 }
    var current = 0
    var ptr1 = 0
    var ptr2 = 0
    while (ptr1 < this.size) {
        when {
            this.get(ptr1) < that.get(ptr2) -> {
                difference.set(current, this.get(ptr1))
                current++
                ptr1++
            }

            this.get(ptr1) > that.get(ptr2) -> ptr2++
            this.get(ptr1) == that.get(ptr2) -> {
                ptr1++
                ptr2++
            }
        }
    }
    return difference
}