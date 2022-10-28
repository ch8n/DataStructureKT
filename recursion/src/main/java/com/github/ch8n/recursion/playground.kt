package com.github.ch8n.recursion


internal fun main() {

    recursion {
        head {
            listOf(1, 2, 3, 4, 5).onReversed { item ->
                println("head onReversed...$item")
            }
        }

        tail {
            listOf(1, 2, 3, 4, 5).onReversed { item ->
                println("tail onReversed...$item")
            }
        }
    }

}