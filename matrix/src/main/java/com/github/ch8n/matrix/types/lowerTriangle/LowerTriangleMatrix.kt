package com.github.ch8n.matrix.types.lowerTriangle

import com.github.ch8n.matrix.MatrixIterator
import com.github.ch8n.matrix.core.Matrix
import com.github.ch8n.matrix.core.MatrixOperations

class LowerTriangleMatrix<T>(
    override val rowsCount: Int,
    override val columnsCount: Int
) : MatrixOperations<T> {

    override val size: Pair<Int, Int>
        get() = Pair(rowsCount, columnsCount)

    override fun rows(row: Int): Array<T> {
        TODO("Not yet implemented")
    }

    override fun columns(columns: Int): Array<T> {
        TODO("Not yet implemented")
    }

    override fun get(row: Int, col: Int): T {
        TODO("Not yet implemented")
    }

    override fun set(row: Int, col: Int, value: T) {
        TODO("Not yet implemented")
    }

    override fun onEach(iterator: (row: Int, col: Int, value: T) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<T> {
        return MatrixIterator(rowsCount, columnsCount, ::get)
    }
}