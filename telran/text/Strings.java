package telran.text;

public class Strings {
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1
	 * complexity O[N] two passes
	 * 1. the same length
	 * 2. the same symbols just in different order
	 * one helper - array (char)
	 */
	public static boolean isAnagram(String str1, String str2) {	
//		char [] arr1 = str1.toCharArray();
//		char [] arr2 = str2.toCharArray();
//		boolean res = false;		
//		if (arr1.length == arr2.length) {
//			int helper[] = new int [0xff];
//			for (int i = 0; i < arr1.length; i++) {	
//				helper[arr1[i]] += arr1[i];
//				helper[arr2[i]] -= arr2[i];
//			}
//			res = true;
//			int index = 0;
//			while (index < helper.length && res) {
//				if (helper[index] != 0) {
//					res = false;
//				}
//				index++;
//			}
//		}
//		return res;
		boolean res = false;
		if (str1.length() == str2.length()) {
			int helper[] = new int[Byte.MAX_VALUE];
			res = true;
			fillhelper(helper, str1);
			int index = 0;
			int length = str1.length();
			while (index < length && res) {
				int indSymb = (int) str2.charAt(index);
				if (helper[indSymb] == 0) {
					res = false;
				} else {
					helper[indSymb]--;
					index++;
				}
			}
		}
		return res;
	}			
	
	private static void fillhelper(int[] helper, String str1) {
		int length = str1.length();
		for (int i = 0; i < length; i++) {
			int ind = str1.charAt(i);
			helper[ind]++;
		}	
	}

	static public void sortStringNumbers (String[] array) {
//		String numbers[] = new String[]{"2", "-128", "1", "127", "1", "99", "-2", "1", "0", "-99"};
//		int helper[] = new int [0x100];
//			for (int i = 0; i < numbers.length; i++) {
//				helper[Integer.parseInt(numbers[i]) + 0x80] += 1;		
//			}
//			int help = 0;
//			for (int i = 0; i < helper.length; i++) {
//				if (helper[i] != 0) {	
//					while (helper[i] > 0) {
//						helper[i] --;
//						numbers[help] = String.valueOf(i - 0x80);
//						help++;
//					}
//				}
//			}
		int offset = Byte.MAX_VALUE + 1;
		int helper[] = new int[offset * 2];
		fillHelper(helper, array, offset);
		sortFromHelper(array, helper, offset);
	}

	private static void sortFromHelper(String[] array, int[] helper, int offset) {
		int arrayInd = 0;
		for (int i = 0; i < helper.length; i++) {
			for (int j = 0; j < helper[i]; j++) {
				array[arrayInd++] = getStringNumberFromIndex(i, offset);
			}
		}		
	}

	private static String getStringNumberFromIndex(int index, int offset) {
		int number = index - offset;		
		return Integer.toString(number);
	}

	private static void fillHelper(int[] helper, String[] array, int offset) {
		for (int i = 0; i < array.length; i++) {
			int index = getIndexFromStringNumber(array[i], offset);
			helper[index]++;
		}	
	}

	private static int getIndexFromStringNumber(String string, int offset) {
		int number = Integer.parseInt(string);
		return number + offset;
	}

	public static String javaNameExp() {
		
		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	}
	public static String ipV4Octet() {

//		return "\\d|\\d{2}|[01]\\d{2}|2[0-4]\\d|25[0-5]";
		return "([01]?\\d\\d?|2([0-4]\\d|5[0-5]))";
	}
	public static String ipV4() {
		String octetExp = ipV4Octet();
//		return String.format("(%s\\.){3}%s", octetExp, octetExp);
		return String.format("(%1$s\\.){3}%1$s", octetExp);
	}
	
	
	private static String arithmeticExpression() {
		String operatorExp = operator();
		String operandExp = operand();
		//adds checking right placing the braces 
		String openBrace = "\\(";
		String closeBrace = "\\)";		
		String operandWithBraces = String.format("%2$s*%1$s%3$s*", operandExp, openBrace, closeBrace);
		return String.format("%1$s(%2$s%1$s)*", operandWithBraces, operatorExp);

	}
	
	public static String onlyDigOperand() {
		return "(\\d+\\.?\\d*|\\.\\d+)";
	}

	public static String operand() {
		String operand = "(\\d+\\.?\\d*|\\.\\d+)"; 
		String javaVar = javaNameExp();
		//ads possibility of using Java variables 
		return String.format("(%1$s|%2$s)", operand, javaVar);
	}

	private static String operator() {
		
		return "([-+*/])";
	}
	public static boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s+", "");
		return expression.matches(arithmeticExpression());
	}
	/**
	 * 
	 * @param expression
	 * @param values
	 * @param namesSorted - variable names sorted
	 * @return computed value of a given expression or Double.NaN
	 */
	public static Double computeArithmeticExpression(String expression, 
			double values[], String names[]) { 
		Double res = Double.NaN;
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()]+", "");
			String operands[] = expression.split(operator());
			String operators[] = expression.split(operand());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			while (index < operands.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[index], values, names);
				res = computeOperation(res, operandValue, operators[index]);
				index++;
			}			
		}
		return res;
	}

	private static Double computeOperation(Double operand1, double operand2, 
			String operator) {
		Double res = Double.NaN;
		if (!Double.isNaN(operand2)) {
			switch(operator) {
			case "+": res = operand1 + operand2; break;
			case "-": res = operand1 - operand2; break;
			case "*": res = operand1 * operand2; break;
			case "/": res = operand1 / operand2; break;
			default: res = Double.NaN;
			}
		}
		return res;
	}

	private static Double getOperandValue(String operand, double[] values, String[] names) {
		Double res = Double.NaN;
		if (values.length == names.length) {
			if (operand.matches(onlyDigOperand())) { 
				res = Double.parseDouble(operand);
			} else if (operand.matches(javaNameExp())){
				int index = 0;
				while (index < names.length && res.isNaN()) {
					if (operand.equals(names[index])) {
						res = values[index];
					}
					index++;
				}
			}
		}	
		// for possible variable names
		return res;
	}

	public static boolean checkBraces(String expression) {
		String[] exp = expression.split("");
		boolean res= false;
		int index = 0;
		int count = 0;
		while (index < exp.length && count > -1) {
			if (exp[index].equals("(")) {
				count++;
			}
			if (exp[index].equals(")")) {
				count--;
			}
			index++;			
		}
		if (count == 0) {
			res = true;
		}
		return res; 
	}

	
	
	
}