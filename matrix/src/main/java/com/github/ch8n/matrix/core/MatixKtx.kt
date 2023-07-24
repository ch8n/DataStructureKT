package com.github.ch8n.matrix.core

fun <T> Matrix<T>.asDiagonal(default: T): Matrix<T> {
    return matrixOf(rowsCount, columnsCount) { row: Int, col: Int ->
        if (row == col) get(row, col) else default
    }
}

fun <T> List<T>.asDiagonalMatrix(default: T): Matrix<T> {
    return matrixOf(size, size) { row: Int, col: Int ->
        if (row == col) get(row) else default
    }
}

fun <T> Array<T>.asDiagonalMatrix(default: T): Matrix<T> {
    return matrixOf(size, size) { row: Int, col: Int ->
        if (row == col) get(row) else default
    }
}


fun <T> Matrix<T>.isDiagonal(default: T): Boolean {
    onEach { rowIndex, columnIndex, value ->
        val isDiagonal = when {
            rowIndex != columnIndex && value == default -> true
            rowIndex == columnIndex -> true
            else -> false
        }
        if (!isDiagonal) return false
    }
    return true
}

/***
 * isLowerTriangleMatrix means lower triangle has value other has zeros
 * value == 0 if rowIndex < columnIndex
 * value == Any if rowIndex == columnIndex or rowIndex > columnIndex
 *
 * if size of matrix = n^2
 *    non-zero elements = (n * (n+1))/2
 *    zero elements = n^2 - non-zero elements = (n * (n - 1))/2
 */
fun Matrix<Int>.isLowerTriangleMatrix(): Boolean {
    onEach { rowIndex, columnIndex, value ->
        val isValid = rowIndex > columnIndex && value == 0
        if (!isValid) {
            return false
        }
    }
    return true
}