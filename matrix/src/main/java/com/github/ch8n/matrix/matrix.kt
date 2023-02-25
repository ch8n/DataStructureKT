package com.github.ch8n.matrix


/***
 * Fixed array doesn't have ability to add or remove elements
 * it can only set and get data from array
 */
interface MatrixOperations<T> : Iterable<T> {
    val rows: Int
    val columns: Int
    fun get(row: Int, col: Int): T
    fun set(row: Int, col: Int, value: T)
}

val <T> MatrixOperations<T>.size get() = Pair(rows, columns)

class Matrix<T> private constructor(
    override val rows: Int, override val columns: Int, initializer: (row: Int, col: Int) -> T
) : MatrixOperations<T> {

    private val matrix = Array(rows) { rowIndex ->
        Array(columns) { columnIndex ->
            initializer.invoke(rowIndex, columnIndex) as Any
        }
    }

    companion object {
        fun <T> of(rows: Int, columns: Int, initializer: (row: Int, col: Int) -> T): Matrix<T> =
            Matrix(rows, columns, initializer)
    }

    override fun get(row: Int, col: Int): T {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<T> {
        return MatrixIterator(
            rows = rows,
            columns = columns,
            getItemAt = ::get
        )
    }

    override fun set(row: Int, col: Int, value: T) {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return buildString {
            matrix.forEach { column ->
                column.forEach { element ->
                    append(element)
                }
            }
        }
    }
}

fun <T> matrixOf(rows: Int, columns: Int, initializer: (row: Int, col: Int) -> T): Matrix<T> =
    Matrix.of(rows, columns, initializer)
