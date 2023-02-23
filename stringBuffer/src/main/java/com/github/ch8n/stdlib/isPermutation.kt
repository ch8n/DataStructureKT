package com.github.ch8n.stdlib


private fun main() {
    println("moon".isPermutationOf1("toon"))
    println("on".isPermutationOf1("no"))

    println("moon".isPermutationOf2("toon"))
    println("on".isPermutationOf2("no"))
}

fun String.isPermutationOf1(that: String): Boolean {
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

    if (firstChars.size != secondChars.size) {
        return false
    }

    firstChars.forEach { (char, count1) ->
        val count2 = secondChars.get(char) ?: 0
        if (count1 != count2) {
            return false
        }
    }
    return true
}

fun String.isPermutationOf2(that: String): Boolean {
    val input1 = this.toCharArray().sorted().joinToString()
    val input2 = that.toCharArray().sorted().joinToString()
    return input1 == input2
}
