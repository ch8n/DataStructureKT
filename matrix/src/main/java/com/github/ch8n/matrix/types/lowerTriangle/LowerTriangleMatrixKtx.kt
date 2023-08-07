package com.github.ch8n.matrix.types.lowerTriangle

import com.github.ch8n.matrix.core.Matrix
import com.github.ch8n.matrix.core.matrixOf
import com.github.ch8n.matrix.types.lowerTriangle.LowerTriangleStrategy.*


fun <T> Matrix<T>.asLowerTriangleMatrix(default: T): Matrix<T> {
    return matrixOf(rowsCount, columnsCount) { rowIndex, columnIndex ->
        if (rowIndex >= columnIndex) get(rowIndex, columnIndex) else default
    }
}


//TODO failing fix
fun <T> Matrix<T>.isLowerTriangleMatrix(default: T): Boolean {
    onEach { rowIndex, columnIndex, value ->
        if (rowIndex < columnIndex) {
            val isValid = value == default
            if (!isValid) return false
        }
    }
    return true
}

inline fun <reified T> List<T>.toLowerTriangleMatrix(
    default: T,
    storageStrategy: LowerTriangleStrategy = RowMajor,
): LowerTriangleMatrix<T> = lowerTriangleMatrixOf(storageStrategy, default, this)

inline fun <reified T> Array<T>.toLowerTriangleMatrix(
    default: T,
    storageStrategy: LowerTriangleStrategy = RowMajor,
): LowerTriangleMatrix<T> = lowerTriangleMatrixOf(storageStrategy, default, this)


inline fun <reified T> Matrix<T>.toLowerTriangleMatrix(
    default: T,
    storageStrategy: LowerTriangleStrategy = RowMajor,
): LowerTriangleMatrix<T> {

    val items: List<T> = buildList {
        onEach { rowIndex, columnIndex, value ->
            if (rowIndex >= columnIndex) add(value)
        }
    }

    return lowerTriangleMatrixOf(
        storageStrategy = storageStrategy,
        default = default,
        items = items
    )
}

@JvmName("lowerTriangleMatrixFromArray")
fun <T> lowerTriangleMatrixOf(
    storageStrategy: LowerTriangleStrategy,
    default: T,
    items: Array<T>,
): LowerTriangleMatrix<T> {
    return LowerTriangleMatrix.of(
        storageStrategy = storageStrategy,
        default = default,
        items = items
    )
}

@JvmName("lowerTriangleMatrixFromList")
inline fun <reified T> lowerTriangleMatrixOf(
    storageStrategy: LowerTriangleStrategy,
    default: T,
    items: List<T>,
): LowerTriangleMatrix<T> {
    return lowerTriangleMatrixOf(
        storageStrategy = storageStrategy,
        default = default,
        items = items.toTypedArray()
    )
}

@JvmName("lowerTriangleMatrixFromVarargs")
inline fun <reified T> lowerTriangleMatrixOf(
    storageStrategy: LowerTriangleStrategy,
    default: T,
    vararg items: T,
): LowerTriangleMatrix<T> {
    return lowerTriangleMatrixOf(storageStrategy, default, items.toList())
}


