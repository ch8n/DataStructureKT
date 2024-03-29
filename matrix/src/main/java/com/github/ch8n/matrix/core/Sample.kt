package com.github.ch8n.matrix.core


internal fun main() {
    val rowCount = 3
    val columnCount = 3
    val matrix = matrixOf(rowCount, columnCount) { row, col ->
        val lastColumnIndex = columnCount - 1
        row + col + ((lastColumnIndex * row) + 1)
    }
    println("===== matrix toString ====")
    println(matrix)
    println("===== column Count ====")
    println(matrix.columnsCount)
    println("===== row Count ====")
    println(matrix.rowsCount)
    println("===== Rows ====")
    repeat(matrix.rowsCount) {
        println("===== rows $it ====")
        println(matrix.rows(it).joinToString())
    }
    println("===== Columns ====")
    repeat(matrix.columnsCount) {
        println("===== column $it ====")
        println(matrix.columns(it).joinToString())
    }
    println("===== on Each ====")
    matrix.onEach { row, col, value ->
        println("row $row | column $col -> $value")
    }
    val randomRow = (0 until rowCount).random()
    val randomColumn = (0 until columnCount).random()
    println("===== Get ($randomRow,$randomColumn) item ====")
    println(matrix.get(randomRow, randomColumn))

    val randomValue = (0 until 100).random()
    println("===== Set ($randomRow,$randomColumn) item to $randomValue ====")
    println(matrix.set(randomRow, randomColumn, randomValue))
    println(matrix)

    println("===== Matrix is Diagonal Matrix? ====")
    val inputMatrix1 = matrixOf(rowCount, columnCount) { row, col ->
        val lastColumnIndex = columnCount - 1
        row + col + ((lastColumnIndex * row) + 1)
    }
    println(inputMatrix1)
    println("isDiagonal : ${inputMatrix1.isDiagonal(0)}")

    val diagonal = inputMatrix1.asDiagonal(0)
    println(diagonal)
    println("isDiagonal Now?: ${diagonal.isDiagonal(0)}")

    println("===== List as Diagonal Matrix ====")
    val inputList = listOf(1,2,3,4)
    val diagonal1 = inputList.asDiagonalMatrix(0)
    println(diagonal1)

    println("===== Array as Diagonal Matrix ====")
    val inputArray = arrayOf(1,2,3,4)
    val diagonal2 = inputArray.asDiagonalMatrix(0)
    println(diagonal2)
}


