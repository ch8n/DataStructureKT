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


class DiagonalMatrix<T> private constructor(
    val defaultValue: T,
    val diagonalItems: List<T>,
) : MatrixOperations<T> {

    override val rowsCount: Int = diagonalItems.size
    override val columnsCount: Int = diagonalItems.size

    private val array = Array(rowsCount) { rowsCount -> diagonalItems.get(rowsCount) as Any }

    @Suppress("UNCHECKED_CAST")
    override fun rows(row: Int): Array<T> {
        val _row = Array(rowsCount) { if (it == row) array.get(row) else defaultValue as Any }
        return _row as Array<T>
    }

    override fun columns(columns: Int): Array<T> {
        return rows(columns)
    }

    @Suppress("UNCHECKED_CAST")
    override fun get(row: Int, col: Int): T {
        return if (row != col) return defaultValue else array.get(row) as T
    }

    override fun set(row: Int, col: Int, value: T) {
        if (row == col) array.set(row, value as Any)
    }

    override fun iterator(): Iterator<T> {
        return MatrixIterator(rowsCount, columnsCount, ::get)
    }

    override fun toString(): String {
        return buildString {
            array.forEachIndexed { index, diagonal ->
                (0..array.lastIndex).forEach { row ->
                    append(" ~ ${if (row == index) diagonal else defaultValue} ~ ")
                }
                append("\n")
            }
        }
    }

    companion object {
        fun <T> of(values: List<T>, default: T): DiagonalMatrix<T> {
            return DiagonalMatrix(default, values)
        }
    }
}
