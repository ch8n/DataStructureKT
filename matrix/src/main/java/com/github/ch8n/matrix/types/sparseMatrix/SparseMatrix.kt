package com.github.ch8n.matrix.types.sparseMatrix

import com.github.ch8n.matrix.core.MatrixOperations


data class SparseCoordinate<T>(
    val row: Int,
    val column: Int,
    val value: T,
) {
    companion object {
        val EMPTY = SparseCoordinate(
            row = -1,
            column = -1,
            value = Any()
        )
    }
}

class SparseMatrix<T> private constructor(
    override val rowsCount: Int,
    override val columnsCount: Int,
    val default: T,
    val coordinates: Array<SparseCoordinate<T>>,
) : MatrixOperations<T> {

    init {
        coordinates.forEach {
            checkRange(row = it.row, column = it.column)
        }
    }

    override fun rows(row: Int): Array<T> = (0..columnsCount)
        .map { col -> get(row, col) as Any }
        .toTypedArray() as Array<T>

    override fun columns(columns: Int): Array<T> = (0..rowsCount)
        .map { row -> get(row, columns) as Any }
        .toTypedArray() as Array<T>

    private fun checkRange(row: Int, column: Int) {
        if (!isValidRowRange(row)) {
            throw IndexOutOfBoundsException("Invalid RowIndex")
        }

        if (!isValidColumnRange(column)) {
            throw IndexOutOfBoundsException("Invalid ColumnIndex")
        }
    }

    fun isValidRowRange(rowIndex: Int) = rowIndex in 0 until rowsCount
    fun isValidColumnRange(columnIndex: Int) = columnIndex in 0 until columnsCount

    override fun get(row: Int, col: Int): T {
        checkRange(row, col)
        val targetIndex = coordinates.indexOfFirst { it.row == row && it.column == col }
        return if (targetIndex != -1) coordinates.get(targetIndex).value else default
    }

    override val size: Pair<Int, Int>
        get() = rowsCount to columnsCount

    override fun set(row: Int, col: Int, value: T) {
        checkRange(row, col)
        val targetIndex = coordinates.indexOfFirst { it.row == row && it.column == col }
        if (targetIndex != -1) {
            val item = coordinates.get(targetIndex)
            val updated = item.copy(value = value)
            coordinates.set(targetIndex, updated)
        }
    }

    fun onEach(iteration: (row: Int, col: Int, value: T) -> Unit) {
        (0 until rowsCount).forEach { row ->
            (0 until columnsCount).forEach { col ->
                iteration(row, col, get(row, col))
            }
        }
    }

    override fun toString(): String {
        return buildString {
            var _row = 0
            onEach { row, col, value ->
                if (_row != row) {
                    _row = row
                    appendLine()
                }
                append("~$value~")
            }
        }
    }

    override fun iterator(): Iterator<T> {
        var currentRow = 0
        var currentColumn = 0
        return object : Iterator<T> {
            override fun hasNext(): Boolean = isValidRowRange(currentRow)
                    && isValidColumnRange(currentColumn)

            override fun next(): T {
                return get(currentRow++, currentColumn++)
            }
        }
    }

    companion object {
        fun <T> of(
            default: T,
            rowsCount: Int,
            columnsCount: Int,
            sparseCoordinate: Array<SparseCoordinate<T>>
        ): SparseMatrix<T> {
            return SparseMatrix(
                rowsCount = rowsCount,
                columnsCount = columnsCount,
                default = default,
                coordinates = sparseCoordinate
            )
        }
    }
}

