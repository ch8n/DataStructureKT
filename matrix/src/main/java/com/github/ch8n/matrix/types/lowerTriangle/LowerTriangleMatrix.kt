package com.github.ch8n.matrix.types.lowerTriangle

import com.github.ch8n.matrix.MatrixIterator
import com.github.ch8n.matrix.core.Matrix
import com.github.ch8n.matrix.core.MatrixOperations

/***
 *  row --->
 *  X | 0 1 2 3
 *  0 | 1 0 0 0
 *  1 | 2 3 0 0
 *  2 | 4 5 6 0
 *  3 | 7 8 9 10
 *
 *  lower triangle matrix means :
 *  upper half triangle is zero|default & lower half has value
 *  if rowIndex > columnIndex -> zero|default
 *  if rowIndex <= columnIndex -> value
 */
class LowerTriangleMatrix<T> private constructor(
    override val rowsCount: Int,
    override val columnsCount: Int,
    val default: T,
    initializer: (row: Int, col: Int) -> T
) : MatrixOperations<T> {

    private val array = Array(rowsCount) { row ->
        Array(columnsCount) { col ->
            if (row > col) default else get(row, col) as Any
        }
    }

    override val size: Pair<Int, Int>
        get() = Pair(rowsCount, columnsCount)

    val upperTriangleElementCount: Int
        get() {
            val totalElements = size.first * size.second
            return (totalElements * (totalElements - 1)) / 2
        }

    val lowerTriangleElementCount: Int
        get() {
            val totalElements = size.first * size.second
            return (totalElements * (totalElements + 1)) / 2
        }

    @Suppress("UNCHECKED_CAST")
    override fun rows(row: Int): Array<T> {
        return array.get(row) as Array<T>
    }

    override fun columns(columns: Int): Array<T> {
        TODO("Not yet implemented")
    }

    @Suppress("UNCHECKED_CAST")
    override fun get(row: Int, col: Int): T {
        return array.get(row).get(col) as T
    }

    override fun set(row: Int, col: Int, value: T) {
        array.get(row).set(col, value)
    }

    inline fun onEach(iterator: (row: Int, col: Int, value: T) -> Unit) {
        (0 until rowsCount).forEach { row ->
            (0 until columnsCount).forEach { col ->
                iterator.invoke(row, col, get(row, col))
            }
        }
    }

    override fun iterator(): Iterator<T> {
        return MatrixIterator(rowsCount, columnsCount, ::get)
    }

    companion object {
        fun <T> of(
            rowsCount: Int,
            columnsCount: Int,
            default: T,
            initializer: (row: Int, col: Int) -> T
        ): LowerTriangleMatrix<T> {
            return LowerTriangleMatrix(rowsCount, columnsCount, default, initializer)
        }
    }
}

fun <T> Matrix<T>.toLowerTriangleMatrix(default: T): LowerTriangleMatrix<T> {
    return LowerTriangleMatrix.of(rowsCount, columnsCount, default) { row, col ->
        if (row > col) default else get(row, col)
    }
}