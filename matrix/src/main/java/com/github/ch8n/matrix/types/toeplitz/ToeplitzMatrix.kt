package com.github.ch8n.matrix.types.toeplitz

import com.github.ch8n.matrix.core.MatrixOperations
import com.github.ch8n.matrix.types.symmetric.SymmetricMatrix
import com.github.ch8n.matrix.types.symmetric.SymmetricSelectionStrategy
import kotlin.math.abs
import kotlin.math.sqrt


/***
 *  row --->
 * X | 0  1  2  3
 * 0 |~1~~2~~3~~4~
 * 1 |~5~~1~~2~~3~
 * 2 |~6~~5~~1~~2~
 * 3 |~7~~6~~5~~1~
 *
 *  Toeplitz matrix means :
 *  1. diagonal row items are same
 *  i.e. m[row][col] == m[row-1][col-1]
 *  2. no of elements = rowCount + columnCount - 1
 *  3. we just need to store first row & first column
 *  4. if upper triangle item i.e. row <= col look in row
 *  4. if lower triangle item i.e. row >= col look in col
 *
 *  0 1 2 3   4 5 6
 *  ---------------
 *  1,2,3,4 | 5,6,7
 *
 *  upper matrix
 *  00 -> 1 -> 0 -> row - col
 *  10 -> 2 -> 1 -> row - col
 *  30 -> 4 -> 3 -> row - col
 *  row <= col -> row - col
 *
 *  lower matrix
 *  12 -> 5 -> 4 -> 3 + 2 - 1  -> (rowCount - 1) + (col - row)
 *  13 -> 6 -> 5 -> 3 + 3 - 1 -> 5
 *  03 -> 7 -> 6 -> 3 + 3 - 0 -> 6
 *  row >= col -> (rowCount - 1) + (col - row)
 */

class ToeplitzMatrix<T> private constructor(val items: Array<T>) : MatrixOperations<T> {

    private fun getIndex(row: Int, col: Int): Int {
        return when {
            /*upper triangle */row < col -> (rowsCount - 1) + (col - row)
            /*lower triangle */row >= col -> row - col
            else -> throw IllegalStateException("Element not in lower or upper triangle matrix!")
        }
    }

    private fun checkRange(row: Int, column: Int) {
        if (!isValidRowRange(row)) {
            throw IndexOutOfBoundsException("Invalid RowIndex")
        }

        if (!isValidColumnRange(column)) {
            throw IndexOutOfBoundsException("Invalid ColumnIndex")
        }
    }

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

    override fun get(row: Int, col: Int): T {
        checkRange(row, col)
        val index = getIndex(row, col)
        return items.get(index)
    }

    override val size: Pair<Int, Int>
        get() = rowsCount to columnsCount

    override fun set(row: Int, col: Int, value: T) {
        checkRange(row, col)
        val index = getIndex(row, col)
        items.set(index, value)
    }

    fun isValidRowRange(rowIndex: Int) = rowIndex in 0 until rowsCount
    fun isValidColumnRange(columnIndex: Int) = columnIndex in 0 until columnsCount

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

    companion object {
        fun <T> of(items: Array<T>) = ToeplitzMatrix(items)
    }

}