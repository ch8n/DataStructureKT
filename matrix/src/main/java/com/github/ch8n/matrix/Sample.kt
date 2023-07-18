package com.github.ch8n.matrix

internal fun main() {
    val rowSize = 3
    val columnSize = 3
    val matrix = matrixOf(rowSize, columnSize) { row: Int, col: Int ->
        val lastColumnIndex = columnSize - 1
        row + col + ((lastColumnIndex * row) + 1)
    }
    println(matrix.toString())

    println("rowCount  ${matrix.rowsCount}")
    println("row 0  ${matrix.rows(0).joinToString()}")
    println("columnCount ${matrix.columnsCount}")
    println("columns ${matrix.columns(0).joinToString()}")
    println("get 1,1 ${matrix.get(1, 1)}")
    println("set 1,1 to 99 ${matrix.set(1, 1, 99)}")
    println("after update get 1,1 ${matrix.get(1, 1)}")
    println(matrix.toString())

    println("joinToString" + matrix.joinToString())
    println("forEach" + matrix.forEach { println(it) })
    println("isDiagonal " + matrix.isDiagonal())

    val matrix2 = matrixOf(rowSize, columnSize) { row: Int, col: Int ->
        if (row == col) 1 else 0
    }
    println(matrix2.toString())
    println("isDiagonal " + matrix2.isDiagonal())

    val matrix3 = diagonalMatrixOf(1, 2, 3, 4)
    println(matrix3.toString())
    println("isDiagonal " + matrix3.isDiagonal())

    val matrixStr = diagonalMatrixOf(listOf("A", "C", "D"), "A")
    println(matrixStr.toString())
    println("isDiagonal " + matrixStr.isDiagonal("A"))

    val listMatrix = listOf("X", "Y", "Z").toDiagonalMatrix("A")
    println(listMatrix.toString())
    println("isDiagonal " + listMatrix.isDiagonal("A"))

    val arrayMatix = arrayOf("c","h","8","n").toDiagonalMatrix("*")
    println(arrayMatix.toString())
    println("isDiagonal " + arrayMatix.isDiagonal("*"))

    val diagonalMatrix = DiagonalMatrix.of(listOf(1,2,3),0)
    println(diagonalMatrix.toString())
    println("rowCount  ${diagonalMatrix.rowsCount}")
    println("row 0  ${diagonalMatrix.rows(0).joinToString()}")
    println("row 1  ${diagonalMatrix.rows(1).joinToString()}")
    println("row 2  ${diagonalMatrix.rows(2).joinToString()}")
    println("columnCount ${diagonalMatrix.columnsCount}")
    println("columns 0 ${diagonalMatrix.columns(0).joinToString()}")
    println("columns 1 ${diagonalMatrix.columns(1).joinToString()}")
    println("columns 2 ${diagonalMatrix.columns(2).joinToString()}")
    println("get 1,1 ${diagonalMatrix.get(1, 1)}")
    println("set 1,1 to 99 ${diagonalMatrix.set(1, 1, 99)}")
    println("after update get 1,1 ${diagonalMatrix.get(1, 1)}")
    println(diagonalMatrix.toString())

    println("joinToString" + diagonalMatrix.joinToString())
    println("forEach" + diagonalMatrix.forEach { println(it) } )

}
