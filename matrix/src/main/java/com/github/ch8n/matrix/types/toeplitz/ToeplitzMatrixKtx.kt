package com.github.ch8n.matrix.types.toeplitz

import com.github.ch8n.matrix.core.Matrix
import com.github.ch8n.matrix.core.matrixOf


fun <T> Matrix<T>.asToeplitz(): Matrix<T> {
    val row = rows(0)
    val column = columns(0)
    val items = row + column.drop(1)
    fun getIndex(row: Int, col: Int): Int {
        return when {
            /*upper triangle */row <= col -> col - row
            /*lower triangle */row > col -> (rowsCount - 1) + (col - row)
            else -> throw IllegalStateException("Element not in lower or upper triangle matrix!")
        }
    }
    return matrixOf(rowsCount, columnsCount) { rowIndex, columnIndex ->
        val index = getIndex(rowIndex, columnIndex)
        items.get(index)
    }
}


inline fun <reified T> List<T>.toToeplitzMatrix(): ToeplitzMatrix<T> = toeplitzMatrixOf(this)

fun <T> Array<T>.toToeplitzMatrix(): ToeplitzMatrix<T> = toeplitzMatrixOf(this)


inline fun <reified T> Matrix<T>.toToeplitzMatrix(): ToeplitzMatrix<T> {
    val row = rows(0)
    val column = columns(0)
    val items = row + column.drop(1)
    return ToeplitzMatrix.of(items = items)
}


@JvmName("toeplitzMatrixFromArray")
fun <T> toeplitzMatrixOf(items: Array<T>): ToeplitzMatrix<T> =
    ToeplitzMatrix.of(items)


@JvmName("toeplitzMatrixFromList")
inline fun <reified T> toeplitzMatrixOf(items: List<T>): ToeplitzMatrix<T> =
    ToeplitzMatrix.of(items.toTypedArray())

@JvmName("toeplitzMatrixFromVarargs")
inline fun <reified T> toeplitzMatrixOf(vararg items: T): ToeplitzMatrix<T> =
    toeplitzMatrixOf(items.toList())


