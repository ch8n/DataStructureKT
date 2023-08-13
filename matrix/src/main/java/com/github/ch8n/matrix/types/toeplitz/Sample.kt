package com.github.ch8n.matrix.types.toeplitz

import com.github.ch8n.matrix.core.matrixOf
import com.github.ch8n.matrix.types.lowerTriangle.LowerTriangleMatrix
import com.github.ch8n.matrix.types.lowerTriangle.TriangleMatrixStrategy
import com.github.ch8n.matrix.types.symmetric.toSymmetricMatrix


internal fun main() {

    /***
     * input -> 1, 2, 3, 4, 5, 6, 7
     *   row --->
     *  * X | 0  1  2  3
     *  * 0 |~1~~2~~3~~4~
     *  * 1 |~5~~1~~2~~3~
     *  * 2 |~6~~5~~1~~2~
     *  * 3 |~7~~6~~5~~1~
     */

    val toeplitzMatrix = ToeplitzMatrix.of(
        items = arrayOf(1, 2, 3, 4, 5, 6, 7)
    )

    println(toeplitzMatrix)
    println("===============")


    repeat(toeplitzMatrix.rowsCount) {
        println("row #$it")
        println(toeplitzMatrix.rows(it).joinToString())
    }

    println("===============")

    repeat(toeplitzMatrix.columnsCount) {
        println("column #$it")
        println(toeplitzMatrix.columns(it).joinToString())
    }

    println("===============")


    val matrix = matrixOf(4, 4) { row, col ->
        val lastColumnIndex = 4 - 1
        row + col + ((lastColumnIndex * row) + 1)
    }
    println(matrix)
    println("===============")

    val matrixAsToeplitz = matrix.asToeplitz()

    println(matrixAsToeplitz)
    println("===============")

    val matrixToToeplitz = matrix.toToeplitzMatrix()
    println(matrixToToeplitz)
    println("===============")

    val listToToeplitz = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .toToeplitzMatrix()
    println(listToToeplitz)
    println("===============")

    val arrayToToeplitz = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .toToeplitzMatrix()
    println(arrayToToeplitz)
    println("===============")

    val toeplitzMatrix1 = toeplitzMatrixOf(Array(10) { it + 1 })
    println(toeplitzMatrix1)
    println("===============")

    val toeplitzMatrix2 = toeplitzMatrixOf(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    println(toeplitzMatrix2)
    println("===============")

    val toeplitzMatrix3 = toeplitzMatrixOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(toeplitzMatrix3)
    println("===============")
}


