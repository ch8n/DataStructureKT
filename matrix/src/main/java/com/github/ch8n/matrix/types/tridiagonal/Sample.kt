package com.github.ch8n.matrix.types.tridiagonal

import com.github.ch8n.matrix.core.matrixOf

fun main() {
    val triDiagonalMatrix1 = TriDiagonalMatrix.of(
        default = 0,
        items = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    )
    println(triDiagonalMatrix1)

    repeat(triDiagonalMatrix1.rowsCount) {
        println("row #$it")
        println(triDiagonalMatrix1.rows(it).joinToString())
    }

    println("===============")

    repeat(triDiagonalMatrix1.columnsCount) {
        println("column #$it")
        println(triDiagonalMatrix1.columns(it).joinToString())
    }

    println("===============")

    val matrix = matrixOf(4, 4) { row, col ->
        val lastColumnIndex = 4 - 1
        row + col + ((lastColumnIndex * row) + 1)
    }
    println(matrix)

    val triDiagonalMatrix2 = matrix.asTriDiagonal(0)

    println(triDiagonalMatrix2)

    println("===============")

    println(matrix.isTriDiagonal(0))
    println(triDiagonalMatrix2.isTriDiagonal(0))

    val triDiagonalMatrix3 = matrix.toTriDiagonal(0)
    println(triDiagonalMatrix3)

    println("===============")

}