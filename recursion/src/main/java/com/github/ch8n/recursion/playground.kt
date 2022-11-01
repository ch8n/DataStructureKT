package com.github.ch8n.recursion


internal fun main() {

    val result1 = recursion {
        head {
            listOf(1, 2, 3, 4, 5).accumulate(1) { acc, next ->
                println("head $acc $next")
                acc * next
            }
        }
    }

    val result2 = recursion {
        tail {
            listOf(1, 2, 3, 4, 5).accumulate(1) { acc, next ->
                println("tail $acc $next")
                acc * next
            }
        }
    }

    println(listOf(result1, result2))
}