
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
			int helper[] = new int [0xff];
			for (int i = 0; i < arr1.length; i++) {	
				helper[arr1[i]] += arr1[i];
				helper[arr2[i]] -= arr2[i];
			}
			res = true;
			int index = 0;
			while (index < helper.length && res) {
				if (helper[index] != 0) {
					res = false;
				}
				index++;
			}
		}
		return res;
	}			
	
	static public void sortStringNumbers () {
	String numbers[] = new String[]{"2", "-128", "1", "127", "1", "99", "-2", "1", "0", "-99"};
	int helper[] = new int [0x100];
		for (int i = 0; i < numbers.length; i++) {
			helper[Integer.parseInt(numbers[i]) + 0x80] += 1;		
		}
		int help = 0;
		for (int i = 0; i < helper.length; i++) {
			if (helper[i] != 0) {	
				while (helper[i] > 0) {
					helper[i] --;
					numbers[help] = String.valueOf(i - 0x80);
					help++;
				}
			}
		}
	}
	
}
