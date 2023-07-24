package com.github.ch8n.matrix.types.lowerTriangle

import com.github.ch8n.matrix.core.matrixOf


internal fun main() {

    val rowCount = 3
    val columnCount = 3

    val matrix = matrixOf(rowCount, columnCount) { row, col ->
        val lastColumnIndex = columnCount - 1
        row + col + ((lastColumnIndex * row) + 1)
    }

    val lowerTriangleMatrix = matrix.toLowerTriangleMatrix(0)
    println("Lower Triangle | lower element count | ${lowerTriangleMatrix.lowerTriangleElementCount} ")
    println("Lower Triangle | upper element count | ${lowerTriangleMatrix.upperTriangleElementCount} ")

}


