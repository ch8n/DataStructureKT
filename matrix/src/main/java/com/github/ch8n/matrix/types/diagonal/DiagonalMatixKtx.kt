import com.github.ch8n.matrix.core.Matrix
import com.github.ch8n.matrix.core.matrixOf
import com.github.ch8n.matrix.types.diagonal.DiagonalMatrix

fun <T> List<T>.toDiagonalMatrix(default: T): DiagonalMatrix<T> {
    return DiagonalMatrix.of(this, default)
}

fun <T> Array<T>.toDiagonalMatrix(default: T): DiagonalMatrix<T> {
    return DiagonalMatrix.of(this.toList(), default)
}

fun <T> Matrix<T>.toDiagonalMatrix(default: T): DiagonalMatrix<T> {
    val diagonal = buildList {
        onEach { rowIndex, columnIndex, value ->
            if (rowIndex == columnIndex) add(value)
        }
    }
    return DiagonalMatrix.of(diagonal, default)
}

fun <T> DiagonalMatrix<T>.toMatrix(): Matrix<T> {
    return matrixOf(rowsCount, columnsCount) { row, col ->
        this.get(row, col)
    }
}

fun <T> diagonalMatrixOf(list: List<T>, default: T): DiagonalMatrix<T> = list.toDiagonalMatrix(default)