package com.github.ch8n.matrix.types.diagonal

import com.github.ch8n.matrix.core.matrixOf
import diagonalMatrixOf
import toDiagonalMatrix
import toMatrix


internal fun main() {
    val diagonalMatrix = diagonalMatrixOf(listOf(1, 2, 3), 0)
    println("===== diagonal items ====")
    println(diagonalMatrix.diagonalItems.joinToString())
    println("===== default value ====")
    println(diagonalMatrix.defaultValue)
    println("===== column Count ====")
    println(diagonalMatrix.columnsCount)
    println("===== row Count ====")
    println(diagonalMatrix.rowsCount)
    println("===== Rows ====")
    repeat(diagonalMatrix.rowsCount) {
        println("===== rows $it ====")
        println(diagonalMatrix.rows(it).joinToString())
    }
    println("===== Columns ====")
    repeat(diagonalMatrix.columnsCount) {
        println("===== column $it ====")
        println(diagonalMatrix.columns(it).joinToString())
    }
    println("===== on Each ====")
    diagonalMatrix.onEach { row, col, value ->
        println("row $row | column $col -> $value")
    }
    println("===== toString ====")
    println(diagonalMatrix.toString())

    val randomRow = (0 until diagonalMatrix.rowsCount).random()
    val randomColumn = (0 until diagonalMatrix.columnsCount).random()
    println("===== Get ($randomRow,$randomColumn) item ====")
    println(diagonalMatrix.get(randomRow, randomColumn))

    val randomValue = (0 until 100).random()
    println("===== Set ($randomRow,$randomRow) item to $randomValue ====")
    println(diagonalMatrix.set(randomRow, randomColumn, randomValue))
    println(diagonalMatrix)

    println("===== List to Diagonal Matrix ====")
    val inputList = listOf(2, 3, 4)
    println(inputList.toDiagonalMatrix(0))

    println("===== Array to Diagonal Matrix ====")
    val inputArray = arrayOf(2, 3, 4)
    println(inputArray.toDiagonalMatrix(0))

    println("===== Matrix to Diagonal Matrix ====")
    val inputMatrix = matrixOf(3, 3) { row, col ->
        row + col
    }
    println(inputMatrix)
    println(inputMatrix.toDiagonalMatrix(0))

    println("===== Diagonal Matrix to Matrix ====")
    val inputDiagonalMatrix = diagonalMatrixOf(listOf(1, 2, 3, 4), 99)
    println(inputDiagonalMatrix)
    println(inputDiagonalMatrix.toMatrix())
}
