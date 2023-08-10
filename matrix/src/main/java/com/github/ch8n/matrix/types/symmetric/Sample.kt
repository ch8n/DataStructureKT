package com.github.ch8n.matrix.types.symmetric

import com.github.ch8n.matrix.core.matrixOf
import com.github.ch8n.matrix.types.lowerTriangle.LowerTriangleMatrix
import com.github.ch8n.matrix.types.lowerTriangle.TriangleMatrixStrategy


internal fun main() {

    /***
     * input -> 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
     *  row --->
     * X | 0  1  2  3
     * 0 |~1~~2~~3~~4~
     * 1 |~2~~5~~6~~7~
     * 2 |~3~~6~~8~~9~
     * 3 |~4~~7~~9~~10~
     */

    val symmetricMatrix1 = SymmetricMatrix.of(
        selectionStrategy = SymmetricSelectionStrategy.LowerTriangle,
        items = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    )

    println(symmetricMatrix1)
    println("===============")

    val symmetricMatrix2 = SymmetricMatrix.of(
        selectionStrategy = SymmetricSelectionStrategy.UpperTriangle,
        items = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    )
    println(symmetricMatrix2)
    println("===============")


    repeat(symmetricMatrix1.rowsCount) {
        println("row #$it")
        println(symmetricMatrix1.rows(it).joinToString())
    }

    println("===============")

    repeat(symmetricMatrix1.columnsCount) {
        println("column #$it")
        println(symmetricMatrix1.columns(it).joinToString())
    }

    println("===============")


    val matrix = matrixOf(4, 4) { row, col ->
        val lastColumnIndex = 4 - 1
        row + col + ((lastColumnIndex * row) + 1)
    }
    println(matrix)
    println("===============")

    val matrixAsSymmetricLower = matrix.asSymmetricMatrix(
        selectionStrategy = SymmetricSelectionStrategy.LowerTriangle
    )

    println(matrixAsSymmetricLower)
    println("===============")

    val matrixAsSymmetricUpper = matrix.asSymmetricMatrix(
        selectionStrategy = SymmetricSelectionStrategy.UpperTriangle
    )
    println(matrixAsSymmetricUpper)
    println("===============")

    println(matrix.isSymmetric())
    println(matrixAsSymmetricLower.isSymmetric())
    println(matrixAsSymmetricUpper.isSymmetric())
    println("===============")

    println(matrix)
    val symmetricMatrix3 = matrix.toSymmetricMatrix(
        selectionStrategy = SymmetricSelectionStrategy.LowerTriangle
    )
    println(symmetricMatrix3)
    println("===============")

    println(matrix)
    val symmetricMatrix4 = matrix.toSymmetricMatrix(
        selectionStrategy = SymmetricSelectionStrategy.UpperTriangle
    )
    println(symmetricMatrix4)
    println("===============")

    val symmetricMatrix5 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .toSymmetricMatrix(selectionStrategy = SymmetricSelectionStrategy.LowerTriangle)
    println(symmetricMatrix5)
    println("===============")

    val symmetricMatrix6 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .toSymmetricMatrix(selectionStrategy = SymmetricSelectionStrategy.UpperTriangle)

    println(symmetricMatrix6)
    println("===============")

    val symmetricMatrix7 = Array(10) { it + 1 }
        .toSymmetricMatrix(selectionStrategy = SymmetricSelectionStrategy.LowerTriangle)

    println(symmetricMatrix7)

    val symmetricMatrix8 = Array(10) { it + 1 }
        .toSymmetricMatrix(selectionStrategy = SymmetricSelectionStrategy.UpperTriangle)

    println(symmetricMatrix8)
    println("===============")

    val symmetricMatrix9 = symmetricMatrixOf(Array(10) { it + 1 })
    println(symmetricMatrix9)
    println("===============")

    val symmetricMatrix10 = symmetricMatrixOf(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    println(symmetricMatrix10)
    println("===============")

    val symmetricMatrix11 = symmetricMatrixOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(symmetricMatrix11)
    println("===============")
}


