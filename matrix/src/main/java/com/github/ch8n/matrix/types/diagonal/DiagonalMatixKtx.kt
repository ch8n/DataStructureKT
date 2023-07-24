import com.github.ch8n.matrix.Matrix
import com.github.ch8n.matrix.matrixOf
import com.github.ch8n.matrix.types.diagonal.DiagonalMatrix

fun <T> List<T>.toDiagonalMatrix(default: T): DiagonalMatrix<T> {
    return DiagonalMatrix.of(this, default)
}

fun <T> Array<T>.toDiagonalMatrix(default: T): DiagonalMatrix<T> {
    return DiagonalMatrix.of(this.toList(), default)
}

fun <T> DiagonalMatrix<T>.toMatrix(): Matrix<T> {
    return matrixOf(rowsCount, columnsCount) { row, col ->
        this.get(row, col)
    }
}