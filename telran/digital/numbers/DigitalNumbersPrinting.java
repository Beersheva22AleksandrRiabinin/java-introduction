package telran.digital.numbers;

import java.util.Arrays;

public class DigitalNumbersPrinting {
	private static final String SYMBOL = "*";

	public static void displayDigitalNumber(int number, int offset, int width, int height) {
		int[] digit = getDigits(number);
		String[] res = new String[height];
		Arrays.fill(res, "");
		for (int i = 0; i < digit.length; i++) {
			res = switchOperation(res, digit[i], offset, width, height);
		}
		displayStrings(res);
	}	
	private static String[] switchOperation(String[] res, int digit, int offset, int width, int height) {
		switch(digit) {
			case 0: connectStrings(res, zero(offset, width, height)); break;
			case 1: connectStrings(res, one(offset, width, height)); break;
			case 2: connectStrings(res, two(offset, width, height)); break;
			case 3: connectStrings(res, three(offset, width, height)); break;
			case 4: connectStrings(res, four(offset, width, height)); break;
			case 5: connectStrings(res, five(offset, width, height)); break;
			case 6: connectStrings(res, six(offset, width, height)); break;
			case 7: connectStrings(res, seven(offset, width, height)); break;
			case 8: connectStrings(res, eight(offset, width, height)); break;
			case 9: connectStrings(res, nine(offset, width, height)); break;
		}
		return res;
	}
	private static String[] connectStrings(String[] res, String[] oneDigString) {
		for (int i = 0; i < res.length; i++) {
			res[i] += oneDigString[i];
		}
		return res;
	}
	
	public static String line(int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
	}
	public static String[] rigthVerticalLine(int offset, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL;
		}
		return res;
	}
	public static String[] leftVerticalLine(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 1);
		}
		return res;
	}
	public static String[] twoVerticalLines(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}

	public static String[] zero (int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = twoVerticalLines(offset, width, height - 2);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}
	public static String[] one (int offset, int width, int height) {
		return rigthVerticalLine(offset + width - 1, height);
	}
	public static String[] two (int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = rigthVerticalLine(offset + width - 1, height / 2 - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height / 2] = line(offset, width);
		lines = leftVerticalLine(offset, width, height / 2 - 1);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		res[height - 1] = line(offset, width);		
		return res;
	}
	public static String[] three (int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = rigthVerticalLine(offset + width - 1, height / 2 - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height / 2] = line(offset, width);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		res[height - 1] = line(offset, width);		
		return res;
	}
	public static String[] four (int offset, int width, int height) {
		String[] res = new String[height];
		String[] lines = twoVerticalLines(offset, width, height / 2);
		System.arraycopy(lines, 0, res, 0, lines.length);
		res[height / 2] = line(offset, width);
		lines = rigthVerticalLine(offset + width - 1, height / 2);
		if (height % 2 != 0) {
			System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		} else {
			System.arraycopy(lines, 0, res, height / 2 + 1, lines.length - 1);
		}
		return res;
	}
	public static String[] five (int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = leftVerticalLine(offset, width, height / 2 - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height / 2] = line(offset, width);
		lines = rigthVerticalLine(offset + width - 1, height / 2 - 1);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		res[height - 1] = line(offset, width);	
		return res;
	}
	public static String[] six (int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = leftVerticalLine(offset, width, height / 2 - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height / 2] = line(offset, width);
		lines = twoVerticalLines(offset, width, height / 2 - 1);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}
	public static String[] seven (int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = rigthVerticalLine(offset + width - 1, height - 1);
		System.arraycopy(lines, 0, res, 1, height - 1);
		return res;
	}
	public static String[] eight (int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = twoVerticalLines(offset, width, height / 2 - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height / 2] = line(offset, width);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}
	public static String[] nine (int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = twoVerticalLines(offset, width, height / 2 - 1);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height / 2] = line(offset, width);
		lines = rigthVerticalLine(offset + width - 1, height / 2 - 1);
		System.arraycopy(lines, 0, res, height / 2 + 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static void displayStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}
	
	public static int[] getDigits(int number) {
		int res[] = new int[getNdigits(number)];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = number % 10;
			number /= 10;
		}
		return res;
	}
	static public int getNdigits(long number) {
		int res = 0;
		do {
			number /= 10;
			res++;
		} while(number != 0);
		return res;
		
	}
	
}