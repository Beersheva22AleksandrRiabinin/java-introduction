
public class IsraelIdentity {
	public static final int N_ID_DIGITS = 9;
/**
 * 
 * @param id
 * @return true for right id otherwise false
 * number (9 digits, 0 may be but not 1st digit)
 * control sum should be multiple of 10 (sum % 10 == 0)
 * for even indexes (0, 2, 4, 6, 8) digits as is
 * for odd indexes (1, 3, 5, 7, 9) digit = digit * 2, if > 9 the sum of inner digits is taken
 * example, 123456782 = 1 + 4(2*2) + 3 + 8(4*2) + 5 + 3(6*2 = 12 => 1 + 2) + 7 + 7(8*2=16 => 1 + 6) + 2 = 40
 */
	public static void main(String[] args) {		
		generateRandomId();
	}
	
	public static boolean verify(int id) {
	boolean res = false;
	int sum = idDigitsControlSum(id);
	if (sum % 10 == 0) {
		res = true;
	}	
	return res;
	}
	
	public static int idDigitsControlSum (int id) {
		int arrayId[] = Numbers.getDigits(id);
		int sum = 0;
		for (int i = 0; i < N_ID_DIGITS; i+=2) {
			sum += + arrayId[i];
		}
		for (int i = 1; i < N_ID_DIGITS; i+=2) {
			if (arrayId[i] * 2 > 9) {
				sum += Numbers.getSumDigits(arrayId[i] * 2);
			} else { 
				sum += arrayId[i] * 2;
			} 		
		}
		return sum;
	}	
	/**
	 * 
	 * @return random number of 9 digits matching right Israel id
	 * cycle not more than 9 iterations ( = 9 ? )
	 */
	public static int generateRandomId() {
	int rdmArray[] = new int[N_ID_DIGITS];
	int sum = 0;
	int lastDigit = 0;
		rdmArray[0] = SportLotoAppl.getRandomInt(1, N_ID_DIGITS);		
		for (int i = 1; i < N_ID_DIGITS - 1; i++) {			
			rdmArray[i] = SportLotoAppl.getRandomInt(0, N_ID_DIGITS);		
		}
		int rdmId = Numbers.getNumberFromDigits(rdmArray);
		sum = idDigitsControlSum(rdmId);
		
		if (sum % 10 != 0) {			
			do {				
				sum += 1;
				lastDigit ++;
			} while (sum % 10 != 0);
			rdmArray[N_ID_DIGITS - 1] = lastDigit;
			rdmId = Numbers.getNumberFromDigits(rdmArray);
			System.out.print(rdmId);
			sum = idDigitsControlSum(rdmId);
			System.out.print(" /" + sum + "/");
		} else {
			System.out.print(rdmId + " /" + sum + "/.");
		}	
	return 0;
	}
	
}