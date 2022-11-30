package telran.digital.numbers.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.digital.numbers.DigitalNumbersPrinting.*;

public class DigitalPrintingTest {
	@Test
	@Disabled
	void lineTest() {
		System.out.println(line(30, 30));
	}
	@Test
	@Disabled
	void verticalLineTest() {
		displayStrings(rigthVerticalLine(30, 5));
	}
	@Test
	@Disabled
	void twoVerticalLinesTest() {
		displayStrings(twoVerticalLines(30, 10, 5));
	}
	@Test
	@Disabled
	void zeroTest() {
		displayStrings(zero(30, 8, 7));
	}
	@Test
	@Disabled
	void oneTest() {
		displayStrings(one(30, 8, 7));
	}
	@Test
	@Disabled
	void twoTest() {
		displayStrings(two(30, 8, 7));
	}
	@Test
	@Disabled
	void threeTest() {
		displayStrings(three(30, 8, 7));
	}
	@Test
	@Disabled
	void fourTest() {
		displayStrings(four(30, 8, 7));
	}
	@Test
	@Disabled
	void fiveTest() {
		displayStrings(five(30, 8, 7));
	}
	@Test
	@Disabled
	void sixTest() {
		displayStrings(six(30, 8, 7));
	}
	@Test
	@Disabled
	void sevenTest() {
		displayStrings(seven(30, 8, 7));
	}
	@Test
	@Disabled
	void eightTest() {
		displayStrings(eight(30, 8, 7));
	}
	@Test
	@Disabled
	void nineTest() {
		displayStrings(nine(30, 8, 7));
	}
	
	@Test
	//@Disabled
	void displayDigitalNumberTest() {
		displayDigitalNumber(1234567890, 2, 8, 7);
		System.out.print("\r");
		displayDigitalNumber(1234567890, 2, 8, 8);
	}
}
