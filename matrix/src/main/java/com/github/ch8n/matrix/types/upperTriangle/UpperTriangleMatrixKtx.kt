package com.github.ch8n.matrix.types.upperTriangle

import com.github.ch8n.matrix.core.Matrix
import com.github.ch8n.matrix.core.matrixOf
import com.github.ch8n.matrix.types.lowerTriangle.TriangleMatrixStrategy

/***
 *  row --->
 *  X | 0 1 2 3
 *  0 | 1 2 3 4
 *  1 | 0 5 6 7
 *  2 | 0 0 8 9
 *  3 | 0 0 0 10
 *
 *  upper triangle matrix means :
 *  upper half triangle has value & lower half has zero / default
 *
 *  if rowIndex <= columnIndex -> value
 *  else  -> zero|default
 */

fun <T> Matrix<T>.asUpperTriangleMatrix(default: T): Matrix<T> {
    return matrixOf(rowsCount, columnsCount) { row, col ->
        if (row <= col) get(row, col) else default
    }
}

fun <T> Matrix<T>.isUpperTriangleMatrix(default: T): Boolean {
    onEach { rowIndex, columnIndex, value ->
        if (rowIndex > columnIndex) {
            val isValid = value == default
            if (!isValid) return false
        }
    }
    return true
}

inline fun <reified T> List<T>.toUpperTriangleMatrix(
    default: T,
    matrixStrategy: TriangleMatrixStrategy = TriangleMatrixStrategy.RowMajor,
): UpperTriangleMatrix<T> = upperTriangleMatrixOf(matrixStrategy, default, this)

inline fun <reified T> Array<T>.toUpperTriangleMatrix(
    default: T,
    matrixStrategy: TriangleMatrixStrategy = TriangleMatrixStrategy.RowMajor,
): UpperTriangleMatrix<T> = upperTriangleMatrixOf(matrixStrategy, default, this)


inline fun <reified T> Matrix<T>.toUpperTriangleMatrix(
    default: T,
    matrixStrategy: TriangleMatrixStrategy = TriangleMatrixStrategy.RowMajor,
): UpperTriangleMatrix<T> {

    val items: List<T> = buildList {
        onEach { rowIndex, columnIndex, value ->
            if (rowIndex <= columnIndex) add(value)
        }
    }

    return upperTriangleMatrixOf(
        matrixStrategy = matrixStrategy,
        default = default,
        items = items
    )
}

@JvmName("upperTriangleMatrixFromArray")
fun <T> upperTriangleMatrixOf(
    matrixStrategy: TriangleMatrixStrategy,
    default: T,
    items: Array<T>,
): UpperTriangleMatrix<T> {
    return UpperTriangleMatrix.of(
        matrixStrategy = matrixStrategy,
        default = default,
        items = items
    )
}

@JvmName("upperTriangleMatrixFromList")
inline fun <reified T> upperTriangleMatrixOf(
    matrixStrategy: TriangleMatrixStrategy,
    default: T,
    items: List<T>,
): UpperTriangleMatrix<T> {
    return upperTriangleMatrixOf(
        matrixStrategy = matrixStrategy,
        default = default,
        items = items.toTypedArray()
    )
}

@JvmName("upperTriangleMatrixFromVarargs")
inline fun <reified T> upperTriangleMatrixOf(
    matrixStrategy: TriangleMatrixStrategy,
    default: T,
    vararg items: T,
): UpperTriangleMatrix<T> {
    return upperTriangleMatrixOf(matrixStrategy, default, items.toList())
}





