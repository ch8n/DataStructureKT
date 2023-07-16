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

    println("rowCount  ${matrix.rowsCount}")
    println("row 0  ${matrix.rows(0).joinToString()}")
    println("columnCount ${matrix.columnsCount}")
    println("columns ${matrix.columns(0).joinToString()}")
    println("get 1,1 ${matrix.get(1,1)}")
    println("set 1,1 to 99 ${matrix.set(1,1,99)}")
    println("after update get 1,1 ${matrix.get(1,1)}")

    println(matrix.toString())
}
