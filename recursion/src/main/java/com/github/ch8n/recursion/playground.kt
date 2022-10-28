package com.github.ch8n.recursion


internal fun main() {

    val result = recursion {
        tail {
            fibonacci(
                first = 0,
                second = 1,
                target = 5,
                inclusive = true
            )
        }
    }

    println(result)
}