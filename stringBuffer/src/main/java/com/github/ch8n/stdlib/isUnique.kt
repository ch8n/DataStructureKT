package com.github.ch8n.stdlib


/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
fun main() {
    println("one".isUnique2())
    println("oneo".isUnique2())
}

fun String.isUnique4(): Boolean {
    return toCharArray()
        .groupBy { it }
        .values
        .all { it.size == 1 }
}

fun String.isUnique1(): Boolean {
    val countArray = Array(256) { 0 }
    this.forEach {
        val charCount = countArray.get(it.code)
        if (charCount > 0) {
            return false
        } else {
            countArray.set(it.code, charCount + 1)
        }
    }
    return true
}

fun String.isUnique2(): Boolean {
    val charSet = this.toSet()
    return this.length == charSet.size
}


fun String.isUnique3(): Boolean {
    val chars = toCharArray().sorted()
    return chars.foldIndexed(true) { index, acc, char ->
        if (index == lastIndex) return@foldIndexed acc
        if (char == chars.get(index + 1)) {
            return@foldIndexed false
        }
        acc
    }
}