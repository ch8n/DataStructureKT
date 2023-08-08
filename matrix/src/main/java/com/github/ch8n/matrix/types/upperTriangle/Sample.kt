package com.github.ch8n.matrix.types.upperTriangle

import com.github.ch8n.matrix.core.matrixOf


internal fun main() {

    /***
     *  row --->
     *  X | 0 1 2 3
     *  0 | 1 2 3 4
     *  1 | 0 5 6 7
     *  2 | 0 0 8 9
     *  3 | 0 0 0 10
     */

    val matrix = matrixOf(4, 4) { row, col ->
        val lastColumnIndex = 4 - 1
        row + col + ((lastColumnIndex * row) + 1)
    }
    println(matrix)

    val matrixAsUpperTriangleMatrix = matrix.asUpperTriangleMatrix(0)
    println(matrixAsUpperTriangleMatrix)

}


