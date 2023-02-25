package com.github.ch8n.matrix

internal fun main() {
    //val fixedArray = FixedArray.of(5) { -1 }
    //val fixedArray = fixedArrayOf(5) { -1 }
    val fixedArray = fixedArrayOf(-1, -1, -1, -1)

    repeat(fixedArray.size) { index ->
        println(fixedArray.get(index))
    }

    repeat(fixedArray.size) { index ->
        fixedArray.set(index, index)
    }

    repeat(fixedArray.size) { index ->
        println(fixedArray.get(index))
    }

    fixedArray.forEach { item ->
        print(item)
    }
}
