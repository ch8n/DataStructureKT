package com.github.ch8n.array

import com.github.ch8n.algorithms.linearSearch

internal fun main() {
    //val fixedArray = FixedArray.of(5) { -1 }
    //val fixedArray = fixedArrayOf(5) { -1 }
    //val fixedArray = staticArrayOf(-1, -1, -1, -1)
    val staticArray = staticArrayOf(-1, -1, -1, -1)

    repeat(staticArray.size) { index ->
        print(staticArray.get(index))
        print(",")
    }

    repeat(staticArray.size) { index ->
        staticArray.set(index, index)
    }

    println()

    repeat(staticArray.size) { index ->
        print(staticArray.get(index))
        print(",")
    }

    println()

    staticArray.forEach { item ->
        print(item)
        print(",")
    }

    println()
    println(staticArray.linearSearch(5))
    println(staticArray.linearSearch(2))
}
