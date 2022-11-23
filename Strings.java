
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

		return "\\d|\\d{2}|[01]\\d{2}|2[0-4]\\d|25[0-5]";
	}
	public static String ipV4() {
		
		return "((\\d|\\d{2}|[01]\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(\\d|\\d{2}|[01]\\d{2}|2[0-4]\\d|25[0-5])";
	}

	
	
	
}