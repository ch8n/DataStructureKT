package com.github.ch8n.stdlib


/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin­ drome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 */
private fun main() {
    println("Tact Coa".isPalindrome1())
    println("mom".isPalindrome1())

    println("Tact Coa".isPalindrome2())
    println("mom".isPalindrome2())

    println("Tact Coa".isPalindrome3())
    println("mom".isPalindrome3())
}

fun String.isPalindrome1(): Boolean {
    val input = this
    val reverseInput = buildString {
        repeat(input.length) { iteration ->
            val lastIndex = input.lastIndex
            append(input.get(lastIndex - iteration))
        }
    }
    return input == reverseInput
}

fun String.isPalindrome2(): Boolean {
    val charCounts = this
        .groupBy { it }
        .map { it.key to it.value.size }

    var oddCounts = 0
    charCounts.forEach { (char, count) ->
        if (count % 2 != 0) {
            oddCounts += 1
            if (oddCounts > 1) return false
        }
    }
    return true
}

fun String.isPalindrome3(): Boolean {
    val charCounts = Array(256) { 0 }
    forEach { char ->
        val count = charCounts.get(char.code) + 1
        charCounts.set(char.code, count)
    }

    var oddCounts = 0
    charCounts.forEach { count ->
        if (count % 2 != 0) {
            oddCounts += 1
            if (oddCounts > 1) return false
        }
    }
    return true
}
