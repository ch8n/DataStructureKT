package com.github.ch8n.stdlib

/***
 * One Away: There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 */
private fun main() {
    println("pale".isOneEditAway2("ple"))
    println("pale".isOneEditAway2("bale"))
    println("pales".isOneEditAway2("pale"))
    println("pale".isOneEditAway2("bake"))

    println()
    println("pale".isOneEditAway3("ple"))
    println("pale".isOneEditAway3("bale"))
    println("pales".isOneEditAway3("pale"))
    println("pale".isOneEditAway3("bake"))
}

fun String.isOneEditAway2(that: String): Boolean {
    val chars = this.toCharArray()
    var differCount = 0
    chars.forEach { char ->
        if (!that.contains(char)) differCount++
    }
    return differCount == 1
}

fun String.isOneEditAway1(that: String): Boolean {
    val longest = if (this.length > that.length) this else that
    val short = if (this.length > that.length) that else this
    if (longest.length - short.length > 1) return false

    var differCount = 0
    var pt1 = 0
    var pt2 = 0
    repeat(longest.length) { index ->
        if (longest.get(index) == short.get(index)) {
            pt1++
            pt2++
        } else {

        }
    }

    return differCount == 1
}


fun String.isOneEditAway3(that: String): Boolean {
    if (this == that) return true
    if (this.length - that.length > 1) return false

    val chars = this.toCharArray()
    var differCount = 0
    chars.forEach { char ->
        if (!that.contains(char)) differCount++
        if (differCount > 1) {
            return false
        }
    }
    return true
}