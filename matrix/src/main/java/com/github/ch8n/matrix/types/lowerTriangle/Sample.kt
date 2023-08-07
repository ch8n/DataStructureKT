package com.github.ch8n.matrix.types.lowerTriangle


internal fun main() {

    /***
     *  row --->
     *  X | 0 1 2 3
     *  0 | 1 0 0 0
     *  1 | 2 3 0 0
     *  2 | 4 5 6 0
     */

    val lowerTriangularMatrix = LowerTriangleMatrix.of(
        storageStrategy = LowerTriangleStrategy.RowMajor,
        default = 0,
        items = arrayOf(1, 2, 3, 4, 5, 6)
    )

    println(lowerTriangularMatrix)

    repeat(lowerTriangularMatrix.rowsCount){
        println(lowerTriangularMatrix.rows(it).joinToString())
    }

    repeat(lowerTriangularMatrix.columnsCount){
        println(lowerTriangularMatrix.columns(it).joinToString())
    }

    val lowerTriangularMatrix2 = LowerTriangleMatrix.of(
        storageStrategy = LowerTriangleStrategy.ColumnMajor,
        default = 0,
        items = arrayOf(1, 2, 3, 4, 5, 6)
    )

    println(lowerTriangularMatrix2)

    repeat(lowerTriangularMatrix2.rowsCount){
        println(lowerTriangularMatrix2.rows(it).joinToString())
    }

    repeat(lowerTriangularMatrix2.columnsCount){
        println(lowerTriangularMatrix2.columns(it).joinToString())
    }

}


