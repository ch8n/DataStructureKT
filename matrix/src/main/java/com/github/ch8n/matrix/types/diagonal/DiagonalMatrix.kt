package com.github.ch8n.matrix.types.diagonal

import com.github.ch8n.matrix.MatrixIterator
import com.github.ch8n.matrix.core.MatrixOperations

class DiagonalMatrix<T> private constructor(
    val defaultValue: T,
    val diagonalItems: List<T>,
) : MatrixOperations<T> {

    override val rowsCount: Int = diagonalItems.size

    override val columnsCount: Int = diagonalItems.size
    override val size: Pair<Int, Int>
        get() = Pair(rowsCount, columnsCount)

    private val array = Array(rowsCount) { rowsCount -> diagonalItems.get(rowsCount) as Any }

    private fun checkRange(row: Int, col: Int) {
        val inValidRange = row in (0 until rowsCount) && col in (0 until columnsCount)
        if (!inValidRange) {
            throw IndexOutOfBoundsException("$row out of $rowsCount or $col out of $columnsCount")
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun rows(row: Int): Array<T> {
        checkRange(row, 0)
        val _row = Array(rowsCount) { if (it == row) array.get(row) else defaultValue as Any }
        return _row as Array<T>
    }

    override fun columns(columns: Int): Array<T> {
        checkRange(0, columns)
        return rows(columns)
    }

    @Suppress("UNCHECKED_CAST")
    override fun get(row: Int, col: Int): T {
        checkRange(row, col)
        return if (row == col) array.get(row) as T else defaultValue
    }

    override fun set(row: Int, col: Int, value: T) {
        checkRange(row, col)
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

    override fun onEach(iterator: (row: Int, col: Int, value: T) -> Unit) {
        (0 until rowsCount).forEach { rowIndex: Int ->
            (0 until columnsCount).forEach { columnIndex: Int ->
                iterator.invoke(rowIndex, columnIndex, get(rowIndex, columnIndex))
            }
        }
    }

    companion object {
        fun <T> of(values: List<T>, default: T): DiagonalMatrix<T> {
            return DiagonalMatrix(default, values)
        }
    }
}
