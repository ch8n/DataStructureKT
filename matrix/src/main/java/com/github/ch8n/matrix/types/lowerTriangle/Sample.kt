package com.github.ch8n.matrix.types.lowerTriangle

import com.github.ch8n.matrix.core.matrixOf


internal fun main() {

    /***
     *  row --->
     *  X | 0 1 2 3
     *  0 | 1 0 0 0
     *  1 | 2 3 0 0
     *  2 | 4 5 6 0
     */

    val lowerTriangularMatrix = LowerTriangleMatrix.of(
        matrixStrategy = TriangleMatrixStrategy.RowMajor,
        default = 0,
        items = arrayOf(1, 2, 3, 4, 5, 6)
    )

    println(lowerTriangularMatrix)

    repeat(lowerTriangularMatrix.rowsCount) {
        println(lowerTriangularMatrix.rows(it).joinToString())
    }

    repeat(lowerTriangularMatrix.columnsCount) {
        println(lowerTriangularMatrix.columns(it).joinToString())
    }

    val lowerTriangularMatrix2 = LowerTriangleMatrix.of(
        matrixStrategy = TriangleMatrixStrategy.ColumnMajor,
        default = 0,
        items = arrayOf(1, 2, 3, 4, 5, 6)
    )

    println(lowerTriangularMatrix2)

    repeat(lowerTriangularMatrix2.rowsCount) {
        println(lowerTriangularMatrix2.rows(it).joinToString())
    }

    repeat(lowerTriangularMatrix2.columnsCount) {
        println(lowerTriangularMatrix2.columns(it).joinToString())
    }

    val matrix = matrixOf(3, 3) { row, col ->
        val lastColumnIndex = 3 - 1
        row + col + ((lastColumnIndex * row) + 1)
    }
    println(matrix)

    val matrixAsLowerTriangle = matrix.asLowerTriangleMatrix(default = 0)
    println(matrixAsLowerTriangle)

    println(matrixAsLowerTriangle.isLowerTriangleMatrix(default = 0))

    val lowerTriangleMatrix4 = matrix.toLowerTriangleMatrix(default = 0)
    println(lowerTriangleMatrix4)

    val lowerTriangleMatrix5 = listOf(1, 2, 3, 4, 5, 6)
        .toLowerTriangleMatrix(
            default = 0,
            matrixStrategy = TriangleMatrixStrategy.RowMajor
        )
    println(lowerTriangleMatrix5)

    val lowerTriangleMatrix6 = Array(6) { it }
        .toLowerTriangleMatrix(
            default = 0,
            matrixStrategy = TriangleMatrixStrategy.RowMajor
        )

    println(lowerTriangleMatrix6)

}


