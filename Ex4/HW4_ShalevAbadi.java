import java.util.Arrays;

/***
 * 
 * @author xxxx
 *
 */
public class HW4_xxxx {

	private final static int EXCLUDE_NUMBER = 0;

	public static void main(String[] args) {

		/* Test Question 1 */
		System.out.println(dec2Bin(270));
		System.out.println(bin2Dec(100001110));
		System.out.println(hex2Dec("EFD1"));
		System.out.println(dec2Hex(61393));
		System.out.println();

		/* Test Question 2 */
		int[] set = new int[] { 1, 2, 3, 4 };
		int[] subset = new int[set.length];
		System.out.print("Array: ");
		printArray(set);
		
		System.out.println("Subsets of array: ");
		subset(set, subset, 0);
		System.out.println();
		
		/* Test Question 3 */
		specialPrint("Hello", '$');
	}

	/* Question 1.1 */
	private static int dec2Bin(int num) {
		if (num == 0) {
			return 0;
		}
		// Complete the recursion
	}

	/* Question 1.2 */
	private static int bin2Dec(int num) {
		if (num == 0) {
			return 0;
		}
		// Complete the recursion
	}

	/* Question 1.3 */
	private static int hex2Dec(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		// Complete the recursion
	}

	/* Question 1.4 */
	private static char[] hexaMap = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	private static String dec2Hex(int num) {
		if (num < 16) {
			return "" + hexaMap[num];
		}
		// Complete the recursion
	}

	/* Question 2 */

	/* Helper - prints an array except of EXCLUDE_NUMBER */
	private static void printArray(int[] arr) {
		System.out.print('{');
		printArray(arr, 0, true);
		System.out.println('}');
	}

	private static void printArray(int[] arr, int index, boolean isFirst) {
		if (index >= arr.length) {
			return;
		}
		if (arr[index] != EXCLUDE_NUMBER) {
			if (isFirst) {
				System.out.printf("%d", arr[index]);
			} else {
				System.out.printf(", %d", arr[index]);
			}
			isFirst = false;

		}
		printArray(arr, index + 1, isFirst);
	}

	private static void subset(int[] set, int[] subset, int idx) {
		if (idx == set.length) {
			printArray(subset);
			return;
		}

		// Complete the recursion
	}

	/* Question 3 */
	private static void specialPrint(String str, char delimeter) {
		if (str == null || str.length() == 0) {
			return;
		}

		// Complete the recursion
	}

}
