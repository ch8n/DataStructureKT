package com.github.ch8n.recursion


fun main() {
    val headSum: Int = recursion {
        head {
            sum()
        }
    }

    val tailSum: Int = recursion {
        tail {
            sum()
        }
    }
}