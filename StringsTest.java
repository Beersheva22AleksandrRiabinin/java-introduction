import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StringsTest {
String word="yellow";
	@Test
	@Disabled
	void sortStringsNumbersTest() {
		String array[] = {"127", "-128", "0", "25", "25", "-128", "127"};
		String expected[] = {"-128", "-128", "0", "25", "25", "127", "127"};
		Strings.sortStringNumbers(array);
		assertArrayEquals(expected, array);
	}
	@Test
	@Disabled
	void isAnagramTest() {
		
		assertTrue(Strings.isAnagram(word, "loweyl")); 
		assertTrue(Strings.isAnagram(word, "elolyw")); 
		assertTrue(Strings.isAnagram(word, "wolley")); 
		assertTrue(Strings.isAnagram(word, "loleyw")); 
		assertTrue(Strings.isAnagram("yttttoooo", "ooootttty"));
		assertFalse(Strings.isAnagram(word,"")); 
		assertFalse(Strings.isAnagram(word, "yellob")); 
		assertFalse(Strings.isAnagram(word,"yello")); 
		assertFalse(Strings.isAnagram(word,"yelllo")) ;
		assertFalse(Strings.isAnagram(word, "wolkez"));
		assertFalse(Strings.isAnagram(word, "yeooow"));
		assertFalse(Strings.isAnagram("yttttoooo", "yoootttty"));
	}
	@Test
	void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));	
	}
	@Test
	void ipV4Octet() {
		assertTrue("255".matches(Strings.ipV4Octet()));
		assertTrue("0".matches(Strings.ipV4Octet()));
		assertTrue("12".matches(Strings.ipV4Octet()));
		assertTrue("123".matches(Strings.ipV4Octet()));
		assertFalse("345".matches(Strings.ipV4Octet()));
		assertFalse("1234".matches(Strings.ipV4Octet()));
		assertFalse("3 4".matches(Strings.ipV4Octet()));
		assertFalse("-34".matches(Strings.ipV4Octet()));
		assertFalse("12x".matches(Strings.ipV4Octet()));
		assertFalse("".matches(Strings.ipV4Octet()));
	}
	
	void ipV4() {
		assertTrue("255.255.255.255".matches(Strings.ipV4()));
		assertTrue("0.0.0.0".matches(Strings.ipV4()));
		assertTrue("12.13.14.15".matches(Strings.ipV4()));
		assertTrue("123.132.231.213".matches(Strings.ipV4()));
		assertFalse("345.111.111.111".matches(Strings.ipV4()));
		assertFalse("111.111.345.111".matches(Strings.ipV4()));
		assertFalse("1234.222.222.222".matches(Strings.ipV4()));
		assertFalse("3 4.123.123.123".matches(Strings.ipV4()));
		assertFalse("-34.123.123.123".matches(Strings.ipV4()));
		assertFalse("12x.123.123.123".matches(Strings.ipV4()));
		assertFalse("123.123.123".matches(Strings.ipV4()));
	}

}