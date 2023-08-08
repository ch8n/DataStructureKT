package com.github.ch8n.matrix.types.upperTriangle

import com.github.ch8n.matrix.core.Matrix
import com.github.ch8n.matrix.core.matrixOf

/***
 *  row --->
 *  X | 0 1 2 3
 *  0 | 1 2 3 4
 *  1 | 0 5 6 7
 *  2 | 0 0 8 9
 *  3 | 0 0 0 10
 *
 *  upper triangle matrix means :
 *  upper half triangle has value & lower half has zero / default
 *
 *  if rowIndex <= columnIndex -> value
 *  else  -> zero|default
 */

fun <T> Matrix<T>.asUpperTriangleMatrix(default: T): Matrix<T> {
    return matrixOf(rowsCount, columnsCount) { row, col ->
        if (row <= col) get(row, col) else default
    }
}



