package com.github.ch8n.matrix


fun diagonalMatrixOf(vararg values: Int): Matrix<Int> {
    val rowSize = values.size
    val columnSize = values.size
    return matrixOf(rowSize, columnSize) { row: Int, col: Int ->
        if (row == col) values.get(row) else 0
    }
}

fun <T> diagonalMatrixOf(values: List<T>, default: T): Matrix<T> {
    val rowSize = values.size
    val columnSize = values.size
    return matrixOf(rowSize, columnSize) { row: Int, col: Int ->
        if (row == col) values.get(row) else default
    }
}

fun <T> List<T>.toDiagonalMatrix(default: T): Matrix<T> {
    val rowSize = size
    val columnSize = size
    return matrixOf(rowSize, columnSize) { row: Int, col: Int ->
        if (row == col) get(row) else default
    }
}

fun <T> Array<T>.toDiagonalMatrix(default: T): Matrix<T> {
    val rowSize = size
    val columnSize = size
    return matrixOf(rowSize, columnSize) { row: Int, col: Int ->
        if (row == col) get(row) else default
    }
}