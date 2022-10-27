package com.github.ch8n.recursion


internal fun main() {
    // 6699 is recursive call limit for my device

    recursion {
        head {
            repeat(5) {
                println("head executed...$it")
            }
        }
    }

    recursion {
        tail {
            repeat(5) {
                println("tail executed...$it")
            }
        }
    }
}