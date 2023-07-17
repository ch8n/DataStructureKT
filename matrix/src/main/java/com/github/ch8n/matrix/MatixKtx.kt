package com.github.ch8n.matrix

fun <T> Matrix<T>.isDiagonal(default: T): Boolean {
    onEachIndexed { rowIndex, columnIndex, value ->
        val isDiagonal = when {
            rowIndex != columnIndex && value == default -> true
            rowIndex == columnIndex -> true
            else -> false
        }
        if (!isDiagonal) return false
    }
    return true
}

fun Matrix<Int>.isDiagonal(): Boolean {
    onEachIndexed { rowIndex, columnIndex, value ->
        val isDiagonal = when {
            rowIndex != columnIndex && value == 0 -> true
            rowIndex == columnIndex -> true
            else -> false
        }
        if (!isDiagonal) return false
    }
    return true
}