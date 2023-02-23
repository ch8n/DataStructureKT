package com.github.ch8n.stdlib


/**
 * Given two strings,write a method to decide if one is a permutation of the
 * other.
 */
private fun main() {
    println("moon".isPermutationOf("toon"))
    println("on".isPermutationOf("no"))

    println("moon".isPermutationOf1("toon"))
    println("on".isPermutationOf1("no"))

    println("moon".isPermutationOf2("toon"))
    println("on".isPermutationOf2("no"))
}

fun String.isPermutationOf1(that: String): Boolean {

    if (this.length != that.length) {
        return false
    }

    val firstChars = this.fold(mutableMapOf<Char, Int>()) { acc, char ->
        var count = acc.get(char) ?: 0
        count += 1
        acc.set(char, count)
        acc
    }

    val secondChars = that.fold(mutableMapOf<Char, Int>()) { acc, char ->
        var count = acc.get(char) ?: 0
        count += 1
        acc.set(char, count)
        acc
    }

    firstChars.forEach { (char, count1) ->
        val count2 = secondChars.get(char) ?: 0
        if (count1 != count2) {
            return false
        }
    }
    return true
}


//Using Chat GPT
fun String.isPermutationOf(that: String): Boolean {

    if (this.length != that.length) {
        return false
    }

    val charCount = Array(256) { 0 }

    this.forEach {
        val asciiCode = it.code
        charCount.set(asciiCode, charCount.get(asciiCode) + 1)
    }

    that.forEach {
        val asciiCode = it.code
        val count = charCount.get(asciiCode)
        if (count == 0) return false
        charCount.set(asciiCode, charCount.get(asciiCode) - 1)
    }

    return true
}

fun String.isPermutationOf2(that: String): Boolean {
    val input1 = this.toCharArray().sorted().joinToString()
    val input2 = that.toCharArray().sorted().joinToString()
    return input1 == input2
}
