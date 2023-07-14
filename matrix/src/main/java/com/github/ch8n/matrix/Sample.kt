package com.github.ch8n.matrix

internal fun main() {
    //val fixedArray = FixedArray.of(5) { -1 }
    //val fixedArray = fixedArrayOf(5) { -1 }
    val rowSize = 4
    val columnSize = 4
    val matrix = matrixOf(rowSize, columnSize) { row: Int, col: Int ->
        val lastColumnIndex = columnSize - 1
        row + col + ((lastColumnIndex * row) + 1)
    }
    println(matrix.toString())

}
