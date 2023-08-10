package com.github.ch8n.matrix.types.symmetric

import com.github.ch8n.matrix.core.MatrixOperations
import kotlin.math.sqrt

enum class SymmetricSelectionStrategy {
    LowerTriangle,
    UpperTriangle
}

/***
 *  row --->
 * X | 0  1  2  3
 * 0 |~1~~2~~3~~4~
 * 1 |~2~~5~~6~~7~
 * 2 |~3~~6~~8~~9~
 * 3 |~4~~7~~9~~10~
 *
 *  symmetric matrix means :
 *  value @ row,col == value @ col,row
 */

class SymmetricMatrix<T> private constructor(
    val selectionStrategy: SymmetricSelectionStrategy,
    private val items: Array<T>,
) : MatrixOperations<T> {

    private val nonZeroItemSize = items.size
    private fun findNumberOfRows(countNonZero: Double): Int {
        val n = (sqrt(1 + 8 * countNonZero) - 1) / 2
        return n.toInt()
    }

    override val rowsCount: Int = findNumberOfRows(nonZeroItemSize.toDouble())
    override val columnsCount: Int = findNumberOfRows(nonZeroItemSize.toDouble())

    override fun rows(row: Int): Array<T> {
        return (0 until columnsCount).map { get(row, it) as Any }.toTypedArray() as Array<T>
    }

    override fun columns(columns: Int): Array<T> {
        return (0 until rowsCount).map { get(it, columns) as Any }.toTypedArray() as Array<T>
    }

    private fun getIndex(row: Int, col: Int): Int = when (selectionStrategy) {
        SymmetricSelectionStrategy.LowerTriangle -> ((row * (row + 1)) / 2) + col
        SymmetricSelectionStrategy.UpperTriangle -> row * rowsCount - (row * (row + 1) / 2) + col
    }

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
        val isValidRange = when (selectionStrategy) {
            SymmetricSelectionStrategy.LowerTriangle -> row >= col
            SymmetricSelectionStrategy.UpperTriangle -> row <= col
        }
        return if (isValidRange) {
            items.get(getIndex(row, col))
        } else {
            items.get(getIndex(col, row))
        }
    }

    override val size: Pair<Int, Int>
        get() = rowsCount to columnsCount

    override fun set(row: Int, col: Int, value: T) {
        checkRange(row, col)
        val isValidRange = when (selectionStrategy) {
            SymmetricSelectionStrategy.LowerTriangle -> row >= col
            SymmetricSelectionStrategy.UpperTriangle -> row <= col
        }
        if (isValidRange) {
            items.set(getIndex(row, col), value)
        } else {
            items.set(getIndex(col, row), value)
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
            selectionStrategy: SymmetricSelectionStrategy,
            items: Array<T>
        ) = SymmetricMatrix(selectionStrategy, items)
    }
}





