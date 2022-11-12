import java.util.Arrays;

public class MyArrays {
/**
 * 
 * @param array
 * @param number
 * @return new array with added at end a given number
 */
	public static int[] addsNumber (int[] array, int number) {
		int res[] = Arrays.copyOf(array, array.length + 1);
		res[array.length] = number;
//		System.out.print(Arrays.toString(res));
		//use standard class Arrays, method copyOf
	return res;
	}
	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in a given array
	 * if index doesn't exist in a given array it returns the same array
	 */
	public static int[] removeNumber(int array[], int index) {
		int res[] = array;	
		if (index < array.length && index > -1) {
			res = new int[array.length - 1];
			System.arraycopy(array, 0, res, 0, index);
			System.arraycopy(array, index + 1, res, index,  array.length - index - 1);						
			}
//		System.out.print(Arrays.toString(res));	
		//use standard class System, method arraycopy
		return res;
	}
	/**
	 * 
	 * @param arraySorted - sorted array
	 * @param number
	 * @return new array with inserted number at index for keeping array sorted
	 */
	public static int [] insertSorted(int arraySorted[], int number) {
		int index = Arrays.binarySearch(arraySorted, number);
//		System.out.print(" " + index + " ");
		if (index < 0) {
			index = -index - 1;
		}
		return insertAtIndex(arraySorted, number, index);
		
			//use the method binarySearch of standard class Arrays
			//use the method arraycopy of the standard class System
	}
	private static int[] insertAtIndex(int[]array, int number, int index) {
		int res[] = new int[array.length + 1];
		System.arraycopy(array, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(array, index, res, index + 1,  array.length - index);	
		return res;
	}
	/**\
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index value if number exists otherwise -1
	 * O[N] - search number in unsorted array
	 * O[LogN] - search number in sorted (binary search)
	 */
	public static int binarySearch(int arraySorted[], int number) {
		int left = 0;
		int right = arraySorted.length -1;
		int middle = right / 2;
		while (left <= right && arraySorted[middle] != number) {
			if (number < arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}		

			left = 0;
			right = middle;
			middle = right / 2;
			while (left <= right && arraySorted[middle] == number && right != 0) {
				if (number != arraySorted[middle]) {
					left = middle + 1;				
				} else {
					right = middle;			
				}
				middle = (left + right) / 2;				
			}				

			while (left <= right && arraySorted[middle] != number) {
				if (number != arraySorted[middle]) {
					left = middle + 1;				
				} else {
					right = middle;			
				}
				middle = (left + right) / 2;		
			}				
		
		return left > right ? -1 : middle;
	}
	
	public static boolean isOneSwapForSorted(int array[]) {
		boolean res = false;
		int sortArray[] = new int[array.length];
		System.arraycopy(array, 0, sortArray, 0, array.length);
		bubbleSort(sortArray);
		int count = 0;
		for (int i = 0; i < array.length; i++) {			
			if (array[i] != sortArray[i]) {
				count++;
			}			
		}
			if (count == 2 && count != 0) {
				res = true;
			}
		return res;
	}
	
	public static int[] bubbleSort(int array[]) {		
		for (int i = 0; i < array.length; i++) {
			moveGreaterRight(array);
		}		
		return array;
	}	
	private static int[] moveGreaterRight(int array[]) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}		
		}
		return array;
	}
	
	
	
	
}