public class ex1_1_13 {
	//writes the transposition of a matrix mat[r][c] into trans
	//trans must be the right dimensions
	public static void transpose(double[][] mat, int rows, int cols, double[][] trans) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				trans[c][r] = mat[r][c];
			}
		}
	}
	//prints a matrix
	public static void printMat(double[][] mat, int rows, int cols) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				System.out.printf("%5.1f", mat[r][c]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		double[][] testMat = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12} };
		double[][] transpose = new double[3][4];
		transpose(testMat, 4, 3, transpose);
		printMat(testMat, 4, 3);
		printMat(transpose, 3, 4);
	}
}