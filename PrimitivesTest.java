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
	@Disabled
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
	@Disabled
	void leadingZerosTest() {
		long a = 0xFF;
		assertEquals(56, BitOperations.leadingZeros(a));
		long b = -222;
		assertEquals(0, BitOperations.leadingZeros(b));
		
	}
	@Test 
	@Disabled
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
	@Disabled
	void isHappyNumberTest() {
		int expectedTrue = 123123;
		int expectedFalse = 123456;
		assertTrue(Numbers.isHappyNumber(expectedTrue));
		assertFalse(Numbers.isHappyNumber(expectedFalse));		
	}
	@Test
	@Disabled
	void getDigitsTest() {
		int expected[] = {1, 2, 3, 4};
		assertArrayEquals(expected, Numbers.getDigits(1234));
	}
	@Test
	@Disabled
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;	
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[]{1, 2, 3, 4}));
	}
	@Test
	@Disabled
	void verifyIdTest () {
		int id = 346847783;
		assertTrue(IsraelIdentity.verify(id));
		int id2 = 346847782;
		assertFalse(IsraelIdentity.verify(id2));
	}
	@Test
	@Disabled
	void addsNumberTest () {
		int expected[] = {1, 2, 3, 4, 7};
		assertArrayEquals(expected, MyArrays.addsNumber(new int[]{1, 2, 3, 4}, 7));
	}
	@Test 
	@Disabled
	void removeNumber () {
		int expected[] = {1, 2, 4, 5};
		assertArrayEquals(expected, MyArrays.removeNumber(new int[]{1, 2, 3, 4, 5}, 2));
	}
	@Test
	@Disabled
	void insertSorted () {
		int expected[] = {1, 4, 6, 9, 10, 11};
		assertArrayEquals(expected, MyArrays.insertSorted(new int[]{1, 4, 6, 9, 11}, 10));
	}
	@Test
	void binarySearch( ) {
		int number = 3;
		assertEquals(2, MyArrays.binarySearch(new int [] {1,2,3,3,4}, number));
		int number2 = 2;
		assertEquals(1, MyArrays.binarySearch(new int [] {1,2,2,2,3}, number2));
		int number3 = 2;
		assertEquals(0, MyArrays.binarySearch(new int [] {2,2,2,2,2}, number3));
		int number4 = 4;
		assertEquals(-1, MyArrays.binarySearch(new int [] {1,2,3,5}, number4));		
	}
	@Test
	void bubbleSort () {
		int expected[] = {1, 2, 3, 4, 5, 6};
		assertArrayEquals(expected, MyArrays.bubbleSort(new int[]{6, 4, 5, 2, 3, 1}));
	}
	@Test
	void isOneSwapTestTrue() {
	int ar1[] = { 10, 2, 3, 4, 1 };
	assertTrue(MyArrays.isOneSwapForSorted(ar1));
	int ar2[] = { 1, 2, 4, 3, 5, 10 };
	assertTrue(MyArrays.isOneSwapForSorted(ar2));
	int ar3[] = { 1, 2, 3, 10, 5, 4 };
	assertTrue(MyArrays.isOneSwapForSorted(ar3));
	int ar4[] = { 1, 5, 3, 4, 2, 10 };
	assertTrue(MyArrays.isOneSwapForSorted(ar4));
	int ar5[] = { 1, 2, 3, 4, 10, 5 };
	assertTrue(MyArrays.isOneSwapForSorted(ar5));
	int ar6[] = { 2, 1, -3, 4, 5, 10 };
	assertTrue(MyArrays.isOneSwapForSorted(ar6));
	int ar7[] = { 3, 2, 1, 4, 5, 6 };
	assertTrue(MyArrays.isOneSwapForSorted(ar7));
	
	int ar11[] = { 1, 2, 3, 10, -1, 5, 6 };
	assertFalse(MyArrays.isOneSwapForSorted(ar11));
	int ar21[] = { 1, 2, 3, 4, 5, 10 };
	assertFalse(MyArrays.isOneSwapForSorted(ar21));
	int ar31[] = { 5, 1, 2, 4, 6, 10 };
	assertFalse(MyArrays.isOneSwapForSorted(ar31));
	int ar41[] = { 1, 5, 2, 4, 3, 10 };
	assertFalse(MyArrays.isOneSwapForSorted(ar41));
	int ar51[] = { 1, 3, 2, 5, 4, 10, 8 };
	assertFalse(MyArrays.isOneSwapForSorted(ar51));
	int ar61[] = {1, 3, 20, 4, 5, 6, 10};
	assertFalse(MyArrays.isOneSwapForSorted(ar61));
	int ar71[] = {1, 3, 20, 4, 5, 11, 2};
	assertFalse(MyArrays.isOneSwapForSorted(ar71));
	}

}
