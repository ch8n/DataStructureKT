package com.github.ch8n.dynamicArray

internal fun main() {
    val dynamicArray = DynamicArray<Int>(0)
    dynamicArray.add(1)
    dynamicArray.add(2)
    dynamicArray.add(3)
    println("size : ${dynamicArray.size}")
    dynamicArray.forEach { print(it) }

}
