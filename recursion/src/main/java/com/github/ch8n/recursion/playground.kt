package com.github.ch8n.recursion


internal fun main() {

    val result1 = recursion {
        head {
            listOf(1, 2, 3, 4, 5).sum(0)
        }
    }

    val result2 = recursion {
        tail {
            listOf(1, 2, 3, 4, 5).sum(0)
        }
    }

    println(listOf(result1,result2))
}