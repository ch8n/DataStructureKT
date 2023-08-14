package com.github.ch8n.matrix.types.sparseMatrix


internal fun main() {
    val sparseMatrix1 = SparseMatrix.of(
        default = 0,
        rowsCount = 3,
        columnsCount = 3,
        sparseCoordinate = buildSparseCoordinates {
            append(0, 2, 5)
            append(2, 2, 8)
            append(1, 1, 15)
        }
    )

    println(sparseMatrix1)

    println("=========")

    val sparseMatrix2 = sparseMatrixOf(
        default = 0,
        rowCount = 3,
        columnCount = 3
    ) {
        append(0, 2, 5)
        append(2, 2, 8)
        append(1, 1, 15)
    }

    println(sparseMatrix2)
}


