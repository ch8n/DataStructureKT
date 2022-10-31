package com.github.ch8n.recursion


internal fun main() {

    val result1 = recursion { head { 3.power(0) } }
    val result2 = recursion { head { 3.power(1) } }
    val result3 = recursion { head { 3.power(2) } }
    val result4 = recursion { head { 3.power(3) } }
    val result5 = recursion { head { 3.power(4) } }

    println(listOf(result1,result2,result3,result4,result5))
}