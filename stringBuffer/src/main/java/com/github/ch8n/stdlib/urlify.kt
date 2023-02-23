package com.github.ch8n.stdlib


/**
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,and that you are given the "true" length of the string.
 * (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 */
private fun main() {
    println("  Mr John Smith   ".toUrlEncoded())
    println("  Mr John Smith   ".toUrlEncoded1())
    println("  Mr John Smith   ".toUrlEncoded2())
}

fun String.toUrlEncoded1(): String {
    return this
        .trim()
        .split(" ")
        .joinToString("%20")
}

// ChatGpt
fun String.toUrlEncoded(): String {
    // Trim the input string to remove leading and trailing whitespace
    val input = this.trim()

    // Replace internal whitespace with '%20'
    return input.replace(" ", "%20")
}

fun String.toUrlEncoded2(): String {
    val input = this
    // split whitespace from start
    var startIndex = 0
    for (index in input.indices) {
        if (!input.get(index).isWhitespace()) {
            break
        }
        startIndex += 1
    }
    // split whitespace from end
    var endIndex = input.lastIndex
    for (index in input.lastIndex downTo startIndex) {
        if (!input.get(index).isWhitespace()) {
            break
        }
        endIndex -= 1
    }
    // replace internal whitespace with %20
    val updated = buildString {
        for (index in startIndex..endIndex) {
            val char = input.get(index)
            if (char.isWhitespace()) {
                append("%20")
            } else {
                append(char)
            }
        }
    }

    return updated
}