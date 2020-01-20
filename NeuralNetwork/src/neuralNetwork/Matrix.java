package neuralNetwork;

/**
 * Class for a matrix-data-structure as linked-lists
 * @author fwilhelm92
 * @IDE Eclipse 2018-09 (4.9.0)
 * @version Java 1.8.0_191-b12
 * @based on https://www.geeksforgeeks.org/construct-linked-list-2d-matrix/
 * @based on https://introcs.cs.princeton.edu/java/95linear/Matrix.java.html
 *
 */

public class Matrix {
	
	// Variables		----------------------------------------------------------------------------------------
	public final int rows;				
	public final int cols; 				
	private final double[][] matrix;	
	
	// Constructor		----------------------------------------------------------------------------------------
	/**
	 * Create matrix from scratch by using number of rows and columns
	 * @param rows
	 * @param cols
	 */
	public Matrix(int rows, int cols) {
		
		this.rows = rows;
		this.cols = cols;
		
		matrix = new double[rows][cols];
	}
	
	/**
	 * Create matrix with array[][]
	 * @param matrix
	 */
	public Matrix(double[][] matrix) {
		rows = matrix.length;
		cols = matrix[0].length;
		this.matrix = new double[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
	}
	
	private Matrix(Matrix copyMatrix) { // Copy constructor (why?)
		this(copyMatrix.matrix);
	}
	
	// Getter 			----------------------------------------------------------------------------------------
	
	public double[][] asArray() {
		
		double[][] array = this.matrix;	
		return array;
	}	
	
	/**
	 * Swap specific rows and columns in matrix.
	 * @param row
	 * @param col
	 */
	public void swap(int row, int col) {
		double[] temp = matrix[row];
		matrix[row] = matrix[col];
		matrix[col] = temp;
	}
	
	/**
	 * Transpose and by this create the new matrix
	 * @return transposed matrix
	 */
	public Matrix transpose() {
		Matrix transMatrix = new Matrix(cols, rows);
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				transMatrix.matrix[j][i] = this.matrix[i][j];
			}
		}
		return transMatrix;
	}
	
	/**
	 * This method sums a given matrix with another one
	 * @throws if matrix-dimensions do not correspond in both matrices
	 * @param matrixB
	 * @return new matrix with sum
	 */
	public Matrix sumMatrix(Matrix matrixB) {
		Matrix matrixA = this;
		if(matrixB.rows != matrixA.rows || matrixB.cols != matrixA.cols) {
			throw new RuntimeException("Matrix-Dimension do not correspond.");
		}
		else {
			Matrix matrixSum = new Matrix(rows, cols);
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					matrixSum.matrix[i][j] = matrixA.matrix[i][j] + matrixB.matrix[i][j];
				}
			}
			return matrixSum;
		}
	}
	
	/**
	 * This method sums a given matrix with another one
	 * @throws if matrix-dimensions do not correspond in both matrices
	 * @param matrixB
	 * @return new matrix with subtracted values
	 */
	public Matrix subtrMatrix(Matrix matrixB) {
		Matrix matrixA = this;
		if(matrixB.rows != matrixA.rows || matrixB.cols != matrixA.cols) {
			throw new RuntimeException("Matrix-Dimension do not correspond.");
		}
		else {
			Matrix matrixSubtr = new Matrix(rows, cols);
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					matrixSubtr.matrix[i][j] = matrixA.matrix[i][j] - matrixB.matrix[i][j];
				}
			}
			return matrixSubtr;
		}
	}
	
	/**
	 * This method sums a given matrix with another one
	 * @throws if matrix-dimensions do not correspond in both matrices
	 * @param matrixB
	 * @return new matrix with multiplicated values
	 */
	public Matrix multiplMatrix(Matrix matrixB) {
		Matrix matrixA = this;
		if(matrixA.cols == matrixB.cols && matrixA.rows == matrixB.rows) { // two 1-d matrices
			Matrix matrixMultipl = new Matrix(matrixA.rows, 1);
			for(int i = 0; i < matrixMultipl.rows; i++) {	
				matrixMultipl.matrix[i][0] = matrixA.matrix[i][0] * matrixB.matrix[i][0];
			}
			return matrixMultipl;
		}
		
		if(matrixA.cols != matrixB.rows) {
			throw new RuntimeException("Matrix-Dimension do not correspond.");
		}
		
		else {
			Matrix matrixMultipl = new Matrix(matrixA.rows, matrixB.cols);
			for(int i = 0; i < matrixMultipl.rows; i++) {
				for(int j = 0; j < matrixMultipl.cols; j++) {
					for(int k = 0; k < matrixA.cols; k++) {
						matrixMultipl.matrix[i][j] += (matrixA.matrix[i][k] * matrixB.matrix[k][j]);
					}
					
				}
			}
			return matrixMultipl;
		}
	}
	
	/**
	 * Method to display the matrix in a proper way. 
	 */
	public void display() {
		for(int i = 0; i < rows; i++) {
			System.out.print("[");
			for(int j = 0; j < cols; j++) {
				if(j < cols - 1) {
					System.out.print(matrix[i][j] + ", ");
				}
				else {
					System.out.println(matrix[i][j] + "]");
				}
			}			
		}
		System.out.println();
	}
	


}
