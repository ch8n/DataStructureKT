package com.github.ch8n

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

fun <T> StaticArray<T>.shiftRight(times: Int = 2) {
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

fun <T> StaticArray<T>.merge(that: StaticArray<T>): StaticArray<T> {
    return staticArrayOf()
}

