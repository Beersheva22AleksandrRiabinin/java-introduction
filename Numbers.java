
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
	int aux = number;
	
	if (number > 0) {
	do {
		aux /= 10;
		amount++;
	} while (aux != 0);
	 	
	if (amount == 6) {
	int a = number % 10;
	int b = number / 10 % 10;
	int c = number / 100 % 10;
	int d = number / 1000 % 10;
	int e = number / 10000 % 10;
	int f = number / 100000; 
	
	if (a + b + c == d + e + f) {
	res = true;
	}
	}
	} 
	
	return res; 
	}
		
}
