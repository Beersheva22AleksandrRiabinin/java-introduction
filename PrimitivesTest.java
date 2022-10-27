import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	//@Disabled
	void dataTypeTest() {
		int b = 10;
		short a = 20000;
		char c = 'd';
		long l = (long) 10.1;
		byte b1 = (byte) 1000;
		a = (short) l;
		float f = 10.2f;
		int b2 = 0xfffffff1;
		
		assertEquals(-15, b2);
	}
	@Test
	void operatorTest() {
		int a = 10;
		assertEquals(13, a + 3);
		assertEquals(1, a % 3);
		int number = 123;
		assertEquals(3, getThirdDigit(number));
		assertEquals(2, getSecondDigit(number));
		assertEquals(1, getFirstDigit(number));
		
	}
	private Integer getFirstDigit(int number) {
		// TODO Auto-generated method stub
//		number = number - (number % 10);
//		number = number - (number % 100);
//		number = number / 100;
		return number / 100 % 10;  // 'number / 100' works too, becouse 1,23 in int will be 1
	}
	private Integer getSecondDigit(int number) {
		// TODO Auto-generated method stub
//		number = number - (number % 10);
//		number = number % 100;
//		number = number / 10;
		return number / 10 % 10;
	}
	//Assumption: all three methods take number comprising of three digits
	
	private int getThirdDigit(int number) {
		// TODO Auto-generated method stub
		number = number % 10;
		return number;
	}

}
