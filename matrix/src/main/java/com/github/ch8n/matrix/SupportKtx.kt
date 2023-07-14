package com.github.ch8n.matrix


class MatrixIterator<T>(
    private val rows: Int, private val columns: Int, private val getItemAt: (row: Int, col: Int) -> T
) : Iterator<T> {

    private var currentRowIndex = 0
    private var currentColumnIndex = 0
    override fun hasNext(): Boolean = (currentRowIndex < rows) && (currentColumnIndex < columns)
    override fun next(): T {
        if (!hasNext()) throw NoSuchElementException()
        return getItemAt(currentRowIndex, currentColumnIndex).also {
            if (currentColumnIndex == columns - 1) {
                currentColumnIndex = 0
                currentRowIndex += 1
            } else {
                currentColumnIndex += 1
            }
        }
    }
}