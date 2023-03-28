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