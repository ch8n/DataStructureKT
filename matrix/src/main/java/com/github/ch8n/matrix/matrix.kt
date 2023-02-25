package com.github.ch8n.matrix


/***
 * Fixed array doesn't have ability to add or remove elements
 * it can only set and get data from array
 */
interface MatrixOperations<T> : Iterable<T> {
    val rowsCount: Int
    val columnsCount: Int
    fun rows(row: Int): Array<T>
    fun columns(columns: Int): Array<T>
    fun get(row: Int, col: Int): T
    fun set(row: Int, col: Int, value: T)

    // advance
    fun plus(matrix: Matrix<T>)
    fun minus(matrix: Matrix<T>)
    fun cross(matrix: Matrix<T>)
    fun dot(matrix: Matrix<T>)
}

val <T> MatrixOperations<T>.size get() = Pair(rowsCount, columnsCount)

class Matrix<T> private constructor(
    override val rowsCount: Int, override val columnsCount: Int, initializer: (row: Int, col: Int) -> T
) : MatrixOperations<T> {

    private val matrix = Array(rowsCount) { rowIndex ->
        Array(columnsCount) { columnIndex ->
            initializer.invoke(rowIndex, columnIndex) as Any
        }
    }

    companion object {
        fun <T> of(rows: Int, columns: Int, initializer: (row: Int, col: Int) -> T): Matrix<T> =
            Matrix(rows, columns, initializer)
    }

    override fun rows(row: Int): Array<T> {
        TODO("Not yet implemented")
    }

    override fun columns(columns: Int): Array<T> {
        TODO("Not yet implemented")
    }

    override fun get(row: Int, col: Int): T {
        TODO("Not yet implemented")
    }

    override fun dot(matrix: Matrix<T>) {
        TODO("Not yet implemented")
    }

    override fun cross(matrix: Matrix<T>) {
        TODO("Not yet implemented")
    }

    override fun minus(matrix: Matrix<T>) {
        TODO("Not yet implemented")
    }

    override fun plus(matrix: Matrix<T>) {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<T> {
        return MatrixIterator(
            rows = rowsCount,
            columns = columnsCount,
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
