package com.github.ch8n.matrix.types.sparseMatrix


fun <T> ArrayList<SparseCoordinate<T>>.append(row: Int, col: Int, value: T) {
    add(
        SparseCoordinate(
            row = row,
            column = col,
            value = value
        )
    )
}

fun <T> buildSparseCoordinates(builder: ArrayList<SparseCoordinate<T>>.() -> Unit): Array<SparseCoordinate<T>> {
    val list = arrayListOf<SparseCoordinate<T>>()
    builder.invoke(list)
    return list.toTypedArray()
}

fun <T> sparseMatrixOf(
    rowCount: Int,
    columnCount: Int,
    default: T,
    builder: ArrayList<SparseCoordinate<T>>.() -> Unit
): SparseMatrix<T> {
    return SparseMatrix.of(
        default = default,
        rowsCount = rowCount,
        columnsCount = columnCount,
        sparseCoordinate = buildSparseCoordinates(builder)
    )
}

infix operator fun SparseMatrix<Int>.plus(that: SparseMatrix<Int>): SparseMatrix<Int> {
    if (this.rowsCount != that.rowsCount || this.columnsCount != that.columnsCount) {
        throw IllegalStateException("Matrix with different dimensions cannot be added")
    }
    val coordinates1 = this.coordinates
    val coordinates2 = that.coordinates
    val addedCoordinates = Array(coordinates1.size + coordinates2.size) { SparseCoordinate<Int>(-1, -1, -1) }
    var currentIndex = 0
    var coordinate1Index = 0
    var coordinate2Index = 0
    while (coordinate1Index < coordinates1.lastIndex && coordinate2Index < coordinates2.lastIndex) {
        val item1 = coordinates1.get(coordinate1Index)
        val item2 = coordinates2.get(coordinate2Index)
        when {
            item1.row < item2.row -> {
                addedCoordinates.set(currentIndex++, item1)
                coordinate1Index++
            }

            item1.row > item2.row -> {
                addedCoordinates.set(currentIndex++, item2)
                coordinate2Index++
            }

            else -> {
                if (item1.column == item2.column) {
                    val updated = item1.value + item2.value
                    addedCoordinates.set(currentIndex++, item1.copy(value = updated))
                    coordinate1Index++
                    coordinate2Index++
                }

                if (item1.column < item2.column) {
                    addedCoordinates.set(currentIndex++, item1)
                    coordinate1Index++
                }

                if (item1.column > item2.column) {
                    addedCoordinates.set(currentIndex++, item2)
                    coordinate2Index++
                }
            }
        }
    }
    for (index in coordinate1Index..coordinates1.lastIndex) {
        addedCoordinates.set(currentIndex++, coordinates1.get(index))
    }

    for (index in coordinate2Index..coordinates2.lastIndex) {
        addedCoordinates.set(currentIndex++, coordinates2.get(index))
    }

    return sparseMatrixOf(rowsCount, columnsCount, this.default) {
        this.addAll(addedCoordinates.filter { it.row != -1 || it.column != -1 })
    }
}

