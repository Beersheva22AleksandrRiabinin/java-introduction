
public class Numbers {
static public int getNdigits(long number) {
	int res = 0;
	do {
		number /= 10;
		res++;
	} while(number != 0);
	return res;
}
/**
 * 
 * @param number
 * @return true only if number comprise of 6 digits
 * and sum of first three digits equals the sum of last three digits 
 */
static public boolean isHappyNumber (int number) {
	boolean res = false;
	int amount = 0;
	int first3 = 0;
	int last3 = 0;
	
	if (number > 0) {
		amount = getNdigits(number);
	 	
	if (amount == 6) { 
	
	for (int i = 0; i < 3; i++) {
		first3 += number % 10;
		number /= 10;
	}
	for (int i = 0; i < 3; i++) {
		last3 += number % 10;
		number /= 10;
	}
	
	if (first3 == last3) {
	res = true;
	}
	}
	} 
	
	return res; 
	}
		
}
