package com.github.ch8n.matrix.types.upperTriangle

import com.github.ch8n.matrix.core.matrixOf
import com.github.ch8n.matrix.types.lowerTriangle.TriangleMatrixStrategy


internal fun main() {

    /***
     *  row --->
     *  X | 0 1 2 3
     *  0 | 1 2 3 4
     *  1 | 0 5 6 7
     *  2 | 0 0 8 9
     *  3 | 0 0 0 10
     */


    val triangleMatrix1 = UpperTriangleMatrix.of(
        matrixStrategy = TriangleMatrixStrategy.RowMajor,
        default = 0,
        items = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    )

    println(triangleMatrix1)

    repeat(triangleMatrix1.rowsCount) {
        println(triangleMatrix1.rows(it).joinToString())
    }

    repeat(triangleMatrix1.columnsCount) {
        println(triangleMatrix1.columns(it).joinToString())
    }

    val triangleMatrix2 = UpperTriangleMatrix.of(
        matrixStrategy = TriangleMatrixStrategy.ColumnMajor,
        default = 0,
        items = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    )

    println(triangleMatrix2)

    repeat(triangleMatrix2.rowsCount) {
        println(triangleMatrix2.rows(it).joinToString())
    }

    repeat(triangleMatrix2.columnsCount) {
        println(triangleMatrix2.columns(it).joinToString())
    }


    val matrix = matrixOf(4, 4) { row, col -> row + col }

    val matrixAsUpperTriangle = matrix.asUpperTriangleMatrix(default = 0)
    println(matrixAsUpperTriangle)

    println(matrixAsUpperTriangle.isUpperTriangleMatrix(default = 0))

    val triangleMatrix3 = matrix.toUpperTriangleMatrix(default = 0)
    println(triangleMatrix3)

    val triangleMatrix4 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .toUpperTriangleMatrix(
            default = 0,
            matrixStrategy = TriangleMatrixStrategy.RowMajor
        )
    println(triangleMatrix4)


    val triangleMatrix5 = Array(10) { it + 1 }
        .toUpperTriangleMatrix(
            default = 0,
            matrixStrategy = TriangleMatrixStrategy.RowMajor
        )

    println(triangleMatrix5)

    val triangleMatrix6 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .toUpperTriangleMatrix(
            default = 0,
            matrixStrategy = TriangleMatrixStrategy.ColumnMajor
        )
    println(triangleMatrix6)


    val triangleMatrix7 = Array(10) { it + 1 }
        .toUpperTriangleMatrix(
            default = 0,
            matrixStrategy = TriangleMatrixStrategy.ColumnMajor
        )

    println(triangleMatrix7)

}


