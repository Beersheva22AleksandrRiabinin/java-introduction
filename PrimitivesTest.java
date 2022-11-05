import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void dataTypeTest() {
//		int b = 10;
//		short a = 20000;
//		char c = 'd';
//		long l = (long) 10.1;
//		byte b1 = (byte) 1000;
//		a = (short) l;
//		float f = 10.2f;
		int b2 = 0xfffffff1;
		
		assertEquals(-15, b2);
	}
	@Test
	@Disabled
	void operatorTest() {
		int a = 10;
		assertEquals(13, a + 3);
		assertEquals(1, a % 3);
		int number = 123;
		assertEquals(3, getThirdDigit(number));
		assertEquals(2, getSecondDigit(number));
		assertEquals(1, getFirstDigit(number));
		
	}
	
	//Assumption: all three methods take number comprising of three digits
	private Integer getFirstDigit(int number) {
		
		return number / 100 % 10;  // "number / 100" works too, because 1.23 in int will be 1
	}
	private Integer getSecondDigit(int number) {
		
		return number / 10 % 10;
	}
	private int getThirdDigit(int number) {
		
				return number % 10;
	}
	
	@Test
	@Disabled
	void getBitValueTest() {
		long num = 0x3ab7f5L; //0011 1010 1011 _0_111 11_1_1 0101
		assertEquals(1, BitOperations.getBitValue(num, 5));
		assertEquals(0, BitOperations.getBitValue(num, 11));
		assertEquals(-1, BitOperations.getBitValue(num, 100));
		assertEquals(-1, BitOperations.getBitValue(num, -2));
	}
	
	@Test
	@Disabled
	void setBitValueTest() {
		long number = 0x3ab7f5;
//		0x3ab7f5	001110101011011111110101
//		0x3ab7e5	001110101011011111100101
//		0x3ab7f7	001110101011011111110111		
		assertEquals(0x3ab7e5, BitOperations.setBitValue(number, 4, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 3, false));
		assertEquals(0x3ab7f7, BitOperations.setBitValue(number, 1, true));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 2, true));
	}
	
	@Test
	@Disabled
	void revertBitValueTest() {
		long number = 0x3ab7f5; 
//		0x3ab7f5	001110101011011111110101
//		0x3ab7e5	001110101011011111100101
//		0x3ab7f4	001110101011011111110100           
		assertEquals(0x3ab7e5, BitOperations.invertBitValue(number, 4));
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(number, 0));
	}
	
	@Test
	void digitsNumberTest() {
		long a = 44;
		assertEquals(2, Numbers.getNdigits(a));
		long b = 1234567;
		assertEquals(7, Numbers.getNdigits(b));
		long c = -4;
		assertEquals(1, Numbers.getNdigits(c));
		long d = 0;
		assertEquals(1, Numbers.getNdigits(d));
	}
	@Test
	void leadingZerosTest() {
		long a = 0xFF;
		assertEquals(56, BitOperations.leadingZeros(a));
		long b = -222;
		assertEquals(0, BitOperations.leadingZeros(b));
		
	}
	@Test 
	void leadingOnesTest() {
		long a = 0xFF;
		assertEquals(8, BitOperations.onesInNumber(a));
		long b = 1024;
		assertEquals(1, BitOperations.onesInNumber(b));
		long c = 0xF0000;
		assertEquals(4, BitOperations.onesInNumber(c));
		long d = -1;
		assertEquals(64, BitOperations.onesInNumber(d));
		long e = -3;
		assertEquals(63, BitOperations.onesInNumber(e));
	}
	@Test
	void isHappyNumberTest() {
		int a = 912453;
		assertEquals(true, Numbers.isHappyNumber(a));
		int b = 190532;
		assertEquals(true, Numbers.isHappyNumber(b));
		int c = 222223;
		assertEquals(false, Numbers.isHappyNumber(c));
		int d = 1234567;
		assertEquals(false, Numbers.isHappyNumber(d));
		int e = 12345;
		assertEquals(false, Numbers.isHappyNumber(e));
		int f = -913562;
		assertEquals(false, Numbers.isHappyNumber(f));
		int g = 100001;
		assertEquals(true, Numbers.isHappyNumber(g));
		int h = 0;
		assertEquals(false, Numbers.isHappyNumber(h)); 
		
	}

}
