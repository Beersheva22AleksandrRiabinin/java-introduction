
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
		int[][] res = new int[matrix[0].length][matrix.length];	
		for (int i = 0; i < res.length ; i++) {			
			for (int j = 0; j < res[0].length; j++) {
				res[i][j] = matrix[j][i];
			}			
		}	
		return res;
	}
	

}
