package io.github.ydlv.javadoc_gh_pages_example.math.linalg;

/**
 * Represents a matrix.
 */
public class Matrix {
    private final double[][] data;
    /**
     * The amount of rows in this matrix.
     */
    public final int rowCount;
    /**
     * The amount of columns in this matrix.
     */
    public final int colCount;

    /**
     * Creates a new matrix with the specified data. The array will be deep-copied.
     * @param data the numbers in the matrix. This array will be deep-copied
     */
    public Matrix(double[][] data) {
        // deep-copy data
        rowCount = data.length;
        colCount = data[0].length;
        this.data = new double[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            if(data[i].length != colCount) {
                throw new IllegalArgumentException("Invalid matrix data");
            }
            System.arraycopy(data[i], 0, this.data[i], 0, colCount);
        }
    }

    /**
     * retrieve the number at the specified row and column.
     * @param row the row number
     * @param col the column number
     * @return Mat[row, col]
     */
    public double get(int row, int col) {
        return data[row][col];
    }


    /**
     * Creates a column-vector as a matrix
     * with the specified data.
     * @param data the numbers in the column vector
     */
    public static Matrix column(double... data) {
        int rowCount = data.length;
        int colCount = 1;
        double[][] result = new double[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            result[i][0] = data[i];
        }
        return new Matrix(result);
    }

    /**
     * Creates a row-vector as a matrix
     * with the specified data.
     * @param data the numbers in the row vector
     * @return a matrix that is a row-vector
     */
    public static Matrix row(double... data) {
        int rowCount = 1;
        int colCount = data.length;
        double[][] result = new double[rowCount][colCount];
        for (int i = 0; i < colCount; i++) {
            result[0][i] = data[i];
        }
        return new Matrix(result);
    }

    /**
     * Returns an identity matrix of the specified size.
     * For a shorter alias, see {@link #eye(int)}
     * @param size the size of the matrix (amount of rows, which is
     *             also equal to the amount of columns)
     * @return the identity matrix of that size
     */
    public static Matrix identity(int size) {
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }
        return new Matrix(result);
    }

    /**
     * Returns an identity matrix of the specified size.
     * This method is a shorter alias for {@link #identity(int)}
     * @param size the size of the matrix (amount of rows, which is
     *             also equal to the amount of columns)
     * @return the identity matrix of that size
     */
    public static Matrix eye(int size) {
        return identity(size);
    }

    /**
     * Returns a constant matrix of the specified size.
     * @param rowCount the amount of rows
     * @param colCount the amount of columns
     * @param value the value of all elements
     * @return a matrix of size rowCount x colCount where
     * all the elements are value
     */
    public static Matrix constant(int rowCount, int colCount, double value) {
        double[][] result = new double[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                result[i][j] = value;
            }
        }
        return new Matrix(result);
    }

    /**
     * Returns a matrix filled with zeros of the specified size.
     * @param rowCount the amount of rows in the matrix
     * @param colCount the amount of columns in the matrix
     * @return a matrix of size rowCount x colCount where
     * all the elements are 0
     */
    public static Matrix zeros(int rowCount, int colCount) {
        return constant(rowCount, colCount, 0);
    }

    /**
     * Returns a matrix filled with ones of the specified size.
     * @param rowCount the amount of rows in the matrix
     * @param colCount the amount of columns in the matrix
     * @return a matrix of size rowCount x colCount where
     * all the elements are 1
     */
    public static Matrix ones(int rowCount, int colCount) {
        return constant(rowCount, colCount, 1);
    }

    /**
     * Returns the product of this matrix with the other matrix.
     * The other matrix must have the same amount of rows as
     * this matrix has columns.
     * The returned matrix will have same amount of rows as this
     * matrix has rows and amount of columns as the other
     * matrix has columns.
     * @param other a matrix by which this matrix is multiplied.
     * @return this x other
     */
    public Matrix multiply(Matrix other) {
        if (colCount != other.rowCount) {
            throw new IllegalArgumentException("Invalid matrix multiplication");
        }
        double[][] result = new double[rowCount][other.colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < other.colCount; j++) {
                double sum = 0;
                for (int k = 0; k < colCount; k++) {
                    sum += data[i][k] * other.data[k][j];
                }
                result[i][j] = sum;
            }
        }
        return new Matrix(result);
    }

    /**
     * Returns a transposed copy of this matrix.
     * A transposed copy has the same amount of rows
     * as the amount of columns and the same amount
     * of columns as the amount of rows.
     * For the returned matrix, the (i, j)-th element
     * is the (j, i)-th element of this matrix.
     * @return a transposed copy of this matrix
     */
    public Matrix transpose() {
        double[][] result = new double[colCount][rowCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                result[j][i] = data[i][j];
            }
        }
        return new Matrix(result);
    }

    /**
     * Returns the sum of this matrix with the other matrix.
     * The other matrix must have the same amount of rows
     * and columns.
     * @param other the other matrix
     * @return this + other
     */
    public Matrix add(Matrix other) {
        if (rowCount != other.rowCount || colCount != other.colCount) {
            throw new IllegalArgumentException("Invalid matrix addition");
        }
        double[][] result = new double[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                result[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    /**
     * Returns the difference of this matrix with the other matrix.
     * The other matrix must have the same amount of rows
     * and columns.
     * @param other the other matrix
     * @return this - other
     */
    public Matrix minus(Matrix other) {
        if (rowCount != other.rowCount || colCount != other.colCount) {
            throw new IllegalArgumentException("Invalid matrix subtraction");
        }
        double[][] result = new double[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                result[i][j] = data[i][j] - other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    /**
     * Returns the product of this matrix with the scalar
     * @param scalar the scalar by which this matrix is multiplied
     * @return this * scalar
     */
    public Matrix multiply(double scalar) {
        double[][] result = new double[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                result[i][j] = data[i][j] * scalar;
            }
        }
        return new Matrix(result);
    }


    /**
     * Calculates the minor of this matrix.
     * The minor of a matrix A of size m x n is a matrix M
     * of size m-1 x n-1, that is identical to A
     * except that the i-th row and the j-th column
     * are removed.
     * @param i the row index of the minor
     * @param j column index of the minor
     * @return the minor matrix
     */
    public Matrix minor(int i, int j) {
        double[][] result = new double[rowCount - 1][colCount - 1];
        int r = 0;
        for (int x = 0; x < rowCount; x++) {
            if (x == i) {
                continue;
            }
            int c = 0;
            for (int y = 0; y < colCount; y++) {
                if (y == j) {
                    continue;
                }
                result[r][c] = data[x][y];
                c++;
            }
            r++;
        }
        return new Matrix(result);
    }

    /**
     * Calculates the determinant of this matrix.
     * The determinant of a matrix A of size m x n
     * is the product of the numbers on the main diagonal
     * of A.
     * @return The determinant of this matrix
     * @implNote The implementation is using a recursive formula
     * based on the {@link #minor(int, int)} method. This has O(n!) time
     * complexity and thus is not recommended for large matrices.
     * There exist polynomial time algorithms that can be used
     * instead, but this one is used here for simplicity of implementation,
     * as this module is not meant for any real-world application,
     * and is only meant to demonstrate Javadoc.
     */
    public double determinant() {
        if (rowCount != colCount) {
            throw new IllegalArgumentException("Matrix must be square");
        }
        if (rowCount == 1) {
            return data[0][0];
        }
        double sum = 0;
        int sgn = -1;
        for (int i = 0; i < colCount; i++, sgn *= -1) {
            sum += data[0][i] * minor(0, i).determinant() * sgn;
        }
        return sum;
    }
}
