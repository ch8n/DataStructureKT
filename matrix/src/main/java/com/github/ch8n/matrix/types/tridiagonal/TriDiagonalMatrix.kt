package com.github.ch8n.matrix.types.tridiagonal

import com.github.ch8n.matrix.MatrixIterator
import com.github.ch8n.matrix.core.MatrixOperations
import kotlin.math.sqrt


/***
 * input -> 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
 *  row --->
 * X | 0  1  2  3
 * 0 |~1~~8~~0~~0~
 * 1 |~5~~2~~9~~0~
 * 2 |~0~~6~~3~~10~
 * 3 |~0~~0~~7~~4~
 *
 * TriDiagonal Matrix means :
 * 1. upper diagonal has values
 * 2. lower diagonal has values
 * 3. diagonal has values
 * 4. rest values are zero
 * i.e.
 *  for upper Diagonal => rowIndex - colIndex = 1
 *  for lower Diagonal => rowIndex - colIndex = -1
 *  for Diagonal => rowIndex - colIndex = 0
 *  else 0
 *
 *  NonZeroElements = 3n - 2
 */

enum class TriDiagonal {
    Lower,
    Central,
    Upper,
    NonDiagonal;

    companion object {
        fun of(row: Int, col: Int): TriDiagonal {
            return when (row - col) {
                -1 -> Upper
                0 -> Central
                1 -> Lower
                else -> NonDiagonal
            }
        }
    }
}

class TriDiagonalMatrix<T> private constructor(
    val default: T,
    private val items: Array<T>
) : MatrixOperations<T> {

    /***
     *  row --->
     * X | 0  1  2  3
     * 0 |~1~~8~~0~~0~
     * 1 |~5~~2~~9~~0~
     * 2 |~0~~6~~3~~10~
     * 3 |~0~~0~~7~~4~
     * input -> 1,2,3,4 | 5,6,7 | 8,9,10
     * center -> 00,11,22,33
     * 00 -> 1 -> 0
     * 11 -> 2 -> 1
     * 22 -> 2 -> 3
     * lower ->  10,21,32
     * 10 -> 5 -> 4 -> (rowCount - 1) + col = 4 - 1 + 1
     * 21 -> 6 -> 5 -> (rowCount - 1) + col = 4 - 1 + 2
     * 32 -> same
     * upper ->  01,12,23
     * 01 -> 8 -> 7 -> (rowCount - 1) + (rowCount - 2) + row = 4 + 3 + 0 = 7
     * 12 -> 8 -> 9 -> (rowCount - 1) + (rowCount - 2) + row = 4 + 3 + 1 = 8
     * 23 -> same
     *
     */
    private fun getIndex(row: Int, col: Int): Int {
        return when (TriDiagonal.of(row, col)) {
            TriDiagonal.Central -> row
            TriDiagonal.Lower -> (rowsCount - 1) + col
            TriDiagonal.Upper -> (rowsCount - 1) + (rowsCount - 2) + row
            TriDiagonal.NonDiagonal -> -1
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
        return (0..columnsCount).map { get(row, it) as Any }.toTypedArray() as Array<T>
    }

    override fun columns(columns: Int): Array<T> {
        return (0..rowsCount).map { get(it, columns) as Any }.toTypedArray() as Array<T>
    }

    override fun get(row: Int, col: Int): T {
        val index = getIndex(row, col)
        return if (index != -1) items.get(index) else default
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


    override val size: Pair<Int, Int>
        get() = rowsCount to columnsCount

    override fun set(row: Int, col: Int, value: T) {
        when (TriDiagonal.of(row, col)) {
            TriDiagonal.Lower -> TODO()
            TriDiagonal.Central -> TODO()
            TriDiagonal.Upper -> TODO()
            TriDiagonal.NonDiagonal -> {}
        }
    }

    override fun iterator(): Iterator<T> {
        return MatrixIterator(rowsCount, columnsCount, ::get)
    }


    companion object {
        fun <T> of(
            default: T,
            items: Array<T>
        ) = TriDiagonalMatrix(default, items)
    }
}