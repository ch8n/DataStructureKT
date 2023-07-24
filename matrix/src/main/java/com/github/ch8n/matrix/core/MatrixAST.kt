package com.github.ch8n.matrix.core

interface MatrixOperations<T> : Iterable<T> {
    val rowsCount: Int

    val columnsCount: Int
    fun rows(row: Int): Array<T>
    fun columns(columns: Int): Array<T>
    fun get(row: Int, col: Int): T
    fun set(row: Int, col: Int, value: T)
    fun onEach(iterator: (row: Int, col: Int, value: T) -> Unit)

    val size: Pair<Int, Int>
}

interface MatrixOpsAdvance<T> : MatrixOperations<T> {
    // advance
    fun plus(matrix: Matrix<T>)
    fun minus(matrix: Matrix<T>)
    fun cross(matrix: Matrix<T>)
    fun dot(matrix: Matrix<T>)
    fun transpose(matrix: Matrix<T>)
    fun inverse(matrix: Matrix<T>)
}
