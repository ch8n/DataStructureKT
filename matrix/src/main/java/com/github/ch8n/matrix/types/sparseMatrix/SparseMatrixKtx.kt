package com.github.ch8n.matrix.types.sparseMatrix


fun <T> ArrayList<SparseCoordinate<T>>.append(row: Int, col: Int, value: T) {
    add(
        SparseCoordinate(
            row = row,
            column = col,
            value = value
        )
    )
}

fun <T> buildSparseCoordinates(builder: ArrayList<SparseCoordinate<T>>.() -> Unit): Array<SparseCoordinate<T>> {
    val list = arrayListOf<SparseCoordinate<T>>()
    builder.invoke(list)
    return list.toTypedArray()
}

fun <T> sparseMatrixOf(
    rowCount: Int,
    columnCount: Int,
    default: T,
    builder: ArrayList<SparseCoordinate<T>>.() -> Unit
): SparseMatrix<T> {
    return SparseMatrix.of(
        default = default,
        rowsCount = rowCount,
        columnsCount = columnCount,
        sparseCoordinate = buildSparseCoordinates(builder)
    )
}

