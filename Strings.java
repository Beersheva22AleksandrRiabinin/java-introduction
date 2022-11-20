
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
		char [] arr1 = str1.toCharArray();
		char [] arr2 = str2.toCharArray();
		boolean res = false;
		if (arr1.length == arr2.length) {
			int sum = 0;
			for (int i = 0; i < arr1.length; i++) {	
				sum += arr1[i] - arr2[i];
				if (sum == 0) {
					res = true;
				} else {
					res = false;
				}
			}						
		}
		return res;
	}		
/*	
		boolean res = false;
		char helper[] = new char [0xff];
		if (str1.length() == str2.length()) {
			int sum = 0;	
			for (int i = 0; i < str1.length(); i++) {
				helper = str1.toCharArray();
				sum += helper[i];
				helper = str2.toCharArray();
				sum -= helper[i];
				if (sum == 0) {
					res = true;
				} else {
					res = false;
				}
			}						
		}
		return res;
	}
*/	
	
	static public void sortStringNumbers () {
	String numbers[] = new String[]{"2", "-128", "1", "127", "1", "99", "-2", "1", "0", "-99"};
	int arr[] = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			arr[i] = Integer.parseInt(numbers[i]);
		}
		int helper[] = new int [0x100];
		for (int i = 0; i < arr.length; i++) {
			helper[arr[i] + 0x80] += 1;
		}
		int help = 0;
		for (int i = 0; i < helper.length; i++) {
			if (helper[i] != 0) {	
				while (helper[i] > 0) {
					helper[i] --;
					arr[help] = i - 0x80;
					help++;
				}
			}
		}
	}
	
}
