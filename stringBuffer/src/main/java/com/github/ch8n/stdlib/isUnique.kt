package com.github.ch8n.stdlib


fun main() {
    println("one".isUniqueIterative())
    println("oneo".isUniqueIterative())
}

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
fun String.isUnique(): Boolean {
    return toCharArray()
        .groupBy { it }
        .values
        .all { it.size == 1 }
}

fun String.isUniqueIterative(): Boolean {
    val chars = toCharArray().sorted()
    return chars.foldIndexed(true) { index, acc, char ->
        if (index == lastIndex) return@foldIndexed acc
        if (char == chars.get(index + 1)) {
            return@foldIndexed false
        }
        acc
    }
}