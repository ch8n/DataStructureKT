package com.github.ch8n.matrix.types.symmetric

import com.github.ch8n.matrix.core.Matrix
import com.github.ch8n.matrix.core.matrixOf


fun <T> Matrix<T>.asSymmetricMatrix(
    selectionStrategy: SymmetricSelectionStrategy = SymmetricSelectionStrategy.LowerTriangle
): Matrix<T> {
    return matrixOf(rowsCount, columnsCount) { rowIndex, columnIndex ->
        val isValidRange = when (selectionStrategy) {
            SymmetricSelectionStrategy.LowerTriangle -> rowIndex >= columnIndex
            SymmetricSelectionStrategy.UpperTriangle -> rowIndex <= columnIndex
        }
        if (isValidRange) {
            get(rowIndex, columnIndex)
        } else {
            get(columnIndex, rowIndex)
        }
    }
}

fun <T> Matrix<T>.isSymmetric(): Boolean {
    onEach { rowIndex, columnIndex, value ->
        if (get(columnIndex, rowIndex) != value) {
            return false
        }
    }
    return true
}

inline fun <reified T> List<T>.toSymmetricMatrix(
    selectionStrategy: SymmetricSelectionStrategy
): SymmetricMatrix<T> = symmetricMatrixOf(this, selectionStrategy)

fun <T> Array<T>.toSymmetricMatrix(
    selectionStrategy: SymmetricSelectionStrategy
): SymmetricMatrix<T> = symmetricMatrixOf(this, selectionStrategy)


inline fun <reified T> Matrix<T>.toSymmetricMatrix(
    selectionStrategy: SymmetricSelectionStrategy
): SymmetricMatrix<T> {

    val items: List<T> = buildList {
        onEach { rowIndex, columnIndex, value ->
            when (selectionStrategy) {
                SymmetricSelectionStrategy.LowerTriangle -> if (rowIndex >= columnIndex) add(value)
                SymmetricSelectionStrategy.UpperTriangle -> if (rowIndex <= columnIndex) add(value)
            }
        }
    }
    return SymmetricMatrix.of(
        selectionStrategy = selectionStrategy,
        items = items.toTypedArray()
    )
}

@JvmName("symmetricMatrixFromArray")
fun <T> symmetricMatrixOf(
    items: Array<T>,
    selectionStrategy: SymmetricSelectionStrategy = SymmetricSelectionStrategy.LowerTriangle,
): SymmetricMatrix<T> = SymmetricMatrix.of(selectionStrategy, items)


@JvmName("symmetricMatrixFromList")
inline fun <reified T> symmetricMatrixOf(
    items: List<T>,
    selectionStrategy: SymmetricSelectionStrategy = SymmetricSelectionStrategy.LowerTriangle,
): SymmetricMatrix<T> = SymmetricMatrix.of(selectionStrategy, items.toTypedArray())

@JvmName("symmetricMatrixFromVarargs")
inline fun <reified T> symmetricMatrixOf(
    vararg items: T,
    selectionStrategy: SymmetricSelectionStrategy = SymmetricSelectionStrategy.LowerTriangle,
): SymmetricMatrix<T> = symmetricMatrixOf(items.toList(), selectionStrategy)


