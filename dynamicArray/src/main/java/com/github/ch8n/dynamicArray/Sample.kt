package com.github.ch8n.dynamicArray

internal fun main() {
    val dynamicArray = DynamicArray<Int>(0)
    with(dynamicArray) {
        println("Size : $size")
        forEachIndexed { index, item ->
            println("item :  $index -> $item")
        }
        println("add : ${add(9)}")
        println("add : ${add(8)}")

        // bugged! todo fix
        println("add : ${add(7)}")

        forEachIndexed { index, item ->
            println("item :  $index -> $item")
        }

        println("set : ${set(0, 1)}")

        forEachIndexed { index, item ->
            println("item :  $index -> $item")
        }

        println("item : ${get(0)}")

    }

}
