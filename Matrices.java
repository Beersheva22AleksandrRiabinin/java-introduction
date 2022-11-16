
public class Matrices {
	public static void main(String[] args) {		
	}
	public static int[][] createRandomMatrix(int rows, int colums,int minValue, int maxValue) {
		int res[][] = new int [rows][colums];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				res[i][j] = Numbers.getRandomNumber(minValue, maxValue);
			}
		}
		return res;
	}
	public static int[][] transp(int[][] matrix) {
		int[][] myMatrix = new int[matrix[0].length][matrix.length];	
		for (int i = 0; i < myMatrix.length ; i++) {			
			for (int j = 0; j < myMatrix[0].length; j++) {
				myMatrix[i][j] = matrix[j][i];
			}			
		}	
		return myMatrix;
	}
	

}
