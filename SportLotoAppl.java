
public class SportLotoAppl {
	
	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in a sequence of 6 random numbers
	 * no additional collections / arrays
	 */
	public static void main(String[] args) {
		long a = 0;
		int i = 0;
		while (i < 6) {
			int b = getRandomInt(1, 6);
			if (BitOperations.getBitValue(a, b) == 0) {
			System.out.print(b + " ");
			a = BitOperations.invertBitValue(a, b);
			i ++;
			}
		}
		
//		long a = 0;
//		int i = 1;
//		while (i < 7) {
//			int b = getRandomInt(1, 6);
//			if (BitOperations.getBitValue(a, b) == 0) {
//			a = BitOperations.invertBitValue(a, b);
//			int c = BitOperations.onesInNumber(a);
//			if (c == i) {
//			System.out.print(b + " ");
//			i ++;
//			}
//			}
//		}
		
	}
	
	
	public static int getRandomInt(int min,int max) {
		return (int) (min + Math.random() * (max - min +1));
	}
	
}


