package com.github.ch8n.matrix.types.upperTriangle


internal fun main() {

    /***
     *  row --->
     *  X | 0 1 2 3
     *  0 | 1 2 3 4
     *  1 | 0 5 6 7
     *  2 | 0 0 8 9
     */

    val upperTriangularMatrix = UpperTriangleMatrix.of(
        storageStrategy = UpperTriangleStrategy.RowMajor,
        default = 0,
        items = arrayOf(1, 2, 3, 4, 5, 6)
    )

    println(upperTriangularMatrix)

    repeat(upperTriangularMatrix.rowsCount){
        println(upperTriangularMatrix.rows(it).joinToString())
    }

    repeat(upperTriangularMatrix.columnsCount){
        println(upperTriangularMatrix.columns(it).joinToString())
    }

    val upperTriangularMatrix2 = UpperTriangleMatrix.of(
        storageStrategy = UpperTriangleStrategy.ColumnMajor,
        default = 0,
        items = arrayOf(1, 2, 3, 4, 5, 6)
    )

    println(upperTriangularMatrix2)

    repeat(upperTriangularMatrix2.rowsCount){
        println(upperTriangularMatrix2.rows(it).joinToString())
    }

    repeat(upperTriangularMatrix2.columnsCount){
        println(upperTriangularMatrix2.columns(it).joinToString())
    }

}


