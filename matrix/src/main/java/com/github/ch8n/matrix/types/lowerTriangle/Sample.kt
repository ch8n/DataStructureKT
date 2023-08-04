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
        storageStrategy = LowerTriangleStorageStrategy.RowMajor,
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

}


