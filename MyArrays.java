import java.util.Arrays;

public class MyArrays {
/**
 * 
 * @param array
 * @param number
 * @return new array with added at end a given number
 */
	public static int[] addsNumber (int[] array, int number) {
		int myArray[] = Arrays.copyOf(array, array.length + 1);
		myArray[array.length] = number;
//		System.out.print(Arrays.toString(myArray));
		//use standard class Arrays, method copyOf
	return myArray;
	}
	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in a given array
	 * if index doesn't exist in a given array it returns the same array
	 */
	public static int[] removeNumber(int array[], int index) {
		int myArray[] = new int[array.length - 1];
		int[] res;
		if (index < array.length && index > -1) {
			System.arraycopy(array, 0, myArray, 0, index);
			System.arraycopy(array, index + 1, myArray, index,  array.length - index - 1);
			res = myArray;			
			} else { res = array;			
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
		int myArray[] = new int[arraySorted.length + 1];
		int index = Arrays.binarySearch(arraySorted, number);
//		System.out.print(" " + index + " ");
		index *= -1;
		System.arraycopy(arraySorted, 0, myArray, 0, index - 1);
		System.arraycopy(arraySorted, index - 1, myArray, index, arraySorted.length - index + 1);
		myArray[index - 1] = number;
//		System.out.print(Arrays.toString(myArray));	
			//use the method binarySearch of standard class Arrays
			//use the method arraycopy of the standard class System
		return myArray;
	}
}