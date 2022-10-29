import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
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
		// TODO Auto-generated method stub
		return number / 100 % 10;  // 'number / 100' works too, becouse 1,23 in int will be 1
	}
	private Integer getSecondDigit(int number) {
		// TODO Auto-generated method stub
		return number / 10 % 10;
	}
	private int getThirdDigit(int number) {
		// TODO Auto-generated method stub
				return number % 10;
	}
	
	@Test
	void getBitValueTest() {
		long num = 0x3ab7f5; //001110101011_0_11111_1_10101
		assertEquals(1, BitOperations.getBitValue(num, 5));
		assertEquals(0, BitOperations.getBitValue(num, 11));
		assertEquals(0, BitOperations.getBitValue(num, 1));
		assertEquals(1, BitOperations.getBitValue(num, 2));
		assertEquals(-1, BitOperations.getBitValue(num, 100));
		assertEquals(-1, BitOperations.getBitValue(num, -2));
	
		
	}
	@Test
	void setBitValueTest() {
		long number = 0x3ab7f5;
//		0x3ab7f5	001110101011011111110101
//		0x3ab7e5	001110101011011111100101
//		0x3ab7f7	001110101011011111110111		
		assertEquals(0x3ab7e5, BitOperations.setBitValue(number, 4, false));
		assertEquals(0x3ab7f7, BitOperations.setBitValue(number, 1, true));
	}
	@Test
	void revertBitValueTest() {
		long number = 0x3ab7f5; 
//		0x3ab7f5	001110101011011111110101
//		0x3ab7e5	001110101011011111100101
//		0x3ab7f4	001110101011011111110100
		            
		assertEquals(0x3ab7e5, BitOperations.revertBitValue(number, 4));
		assertEquals(0x3ab7f4, BitOperations.revertBitValue(number, 0));
	}

}
