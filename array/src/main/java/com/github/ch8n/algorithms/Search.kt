package com.github.ch8n.algorithms

import com.github.ch8n.array.StaticArrayOperations

fun <T> StaticArrayOperations<T>.linearSearch(targetValue: T): Int {
    repeat(size) { index ->
        if (get(index) == targetValue) {
            return index
        }
    }
    return -1
}

fun StaticArrayOperations<Int>.binarySearch(targetValue: Int, startIndex: Int = 0, endIndex: Int = size - 1): Int {
    if (startIndex > endIndex) return -1

    val mid = (startIndex + endIndex) / 2
    return when {
        get(mid) == targetValue -> mid

        get(mid) > targetValue -> binarySearch(
            targetValue = targetValue,
            startIndex = startIndex,
            endIndex = mid - 1
        )

        else -> binarySearch(
            targetValue = targetValue,
            startIndex = mid + 1,
            endIndex = endIndex
        )
    }
}