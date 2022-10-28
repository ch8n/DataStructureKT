package com.github.ch8n.recursion


internal fun main() {

    val result = recursion {
        tail {
            fibonacci(0,1,5,true)
        }
    }

    println(result)
}