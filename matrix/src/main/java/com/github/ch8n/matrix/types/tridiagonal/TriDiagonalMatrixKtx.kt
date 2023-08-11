package com.github.ch8n.matrix.types.tridiagonal

import com.github.ch8n.matrix.core.Matrix
import com.github.ch8n.matrix.core.matrixOf

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


fun <T> Matrix<T>.asTriDiagonal(default: T): Matrix<T> {
    return matrixOf(rowsCount, columnsCount) { rowIndex, columnIndex ->
        fun getIndex(row: Int, col: Int): Int {
            return when (TriDiagonal.of(row, col)) {
                TriDiagonal.Central -> row
                TriDiagonal.Lower -> (rowsCount - 1) + col
                TriDiagonal.Upper -> (rowsCount - 1) + (rowsCount - 2) + row
                TriDiagonal.NonDiagonal -> -1
            }
        }

        val index = getIndex(rowIndex, columnIndex)
        if (index != -1) get(rowIndex, columnIndex) else default
    }
}

fun <T> Matrix<T>.isTriDiagonal(default: T): Boolean {
    fun getIndex(row: Int, col: Int): Int {
        return when (TriDiagonal.of(row, col)) {
            TriDiagonal.Central -> row
            TriDiagonal.Lower -> (rowsCount - 1) + col
            TriDiagonal.Upper -> (rowsCount - 1) + (rowsCount - 2) + row
            TriDiagonal.NonDiagonal -> -1
        }
    }
    onEach { rowIndex, columnIndex, value ->
        val index = getIndex(rowIndex, columnIndex)
        if (index == -1 && value != default) {
            return false
        }
    }
    return true
}

@Suppress("UNCHECKED_CAST")
fun <T> Matrix<T>.toTriDiagonal(default: T): TriDiagonalMatrix<T> {
    fun getIndex(row: Int, col: Int): Int {
        return when (TriDiagonal.of(row, col)) {
            TriDiagonal.Central -> row
            TriDiagonal.Lower -> (rowsCount - 1) + col
            TriDiagonal.Upper -> (rowsCount - 1) + (rowsCount - 2) + row
            TriDiagonal.NonDiagonal -> -1
        }
    }

    val items = buildList<T> {
        onEach { rowIndex, columnIndex, value ->
            val index = getIndex(rowIndex, columnIndex)
            if (index != -1) add(value)
        }
    }

    return TriDiagonalMatrix.of(
        default = default,
        items = Array(items.size) { items.get(it) as Any }
    ) as TriDiagonalMatrix<T>
}

fun <T> Array<T>.toTriDiagonalMatrix(default: T): TriDiagonalMatrix<T> =
    triDiagonalMatrixOf(default, this)

inline fun <reified T> List<T>.toTriDiagonalMatrix(default: T): TriDiagonalMatrix<T> =
    triDiagonalMatrixOf(default, this)


@JvmName("triDiagonalMatrixFromArray")
fun <T> triDiagonalMatrixOf(
    default: T,
    items: Array<T>,
): TriDiagonalMatrix<T> = TriDiagonalMatrix.of(default, items)


@JvmName("triDiagonalMatrixFromList")
inline fun <reified T> triDiagonalMatrixOf(
    default: T,
    items: List<T>,
): TriDiagonalMatrix<T> = TriDiagonalMatrix.of(default, items.toTypedArray())

@JvmName("triDiagonalMatrixFromVarargs")
inline fun <reified T> triDiagonalMatrixOf(
    default: T,
    vararg items: T,
): TriDiagonalMatrix<T> = triDiagonalMatrixOf(default, items.toList())


