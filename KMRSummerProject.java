/**
 * Katie Roy
 * 8/23/2015
 * AP Computer Science
 * Fagan
 */
import java.util.Scanner;

public class KMRSummerProject {

	public static void main(String[] args) {
		int usernum = getInput();
		System.out.println("The first " + usernum + " numbers that are palindromic in both base 10 and base 2 are:");
		int[] palinArr = new int[usernum];
		System.out.format("%16s %16s", "Base 10", "Base 2");
		System.out.println();
		for (int i = 0; i < usernum; i++){
			palinArr[i] = getPalindromeList(usernum)[i];
			System.out.format("%16s %16s", palinArr[i], toBase2(palinArr[i]));
			System.out.println();
		}
		System.out.print("The sum of the first " + usernum + " numbers that are palindromic in both base 10 and base 2 is " + sum(palinArr) + ".");
	}

	/**
	 * pre: none
	 * post: returns a positive integer as entered by the user
	 */
	public static int getInput (){
		Scanner input = new Scanner(System.in);
		int usernum;
		do{
			System.out.print("Enter the number of numbers for summation. Must be a POSITIVE INTEGER: ");
			if(!input.hasNextInt()){
				System.out.print("Not an integer. Try again. ");
				usernum = -1;
				input.next();
			}
			else{
				usernum = input.nextInt();
				if (usernum <= 0)
					System.out.print("Not positive. Try again. ");	
			}
		}while (usernum <= 0);
		input.close();

		return usernum;
	}

	/**
	 * pre: n is a positive base 10 number
	 * post: returns a String representing the base 2 equivalent of n
	 */
	public static String toBase2 (int n){
		int x = 0;
		String str = "";
		while (n > 0){
			x = n%2;
			n = n/2;
			str = String.valueOf(x) + str;
		}
		return str;
	}

	/**
	 * pre: num is not null
	 * post: return true if the parameter is palindromic, false otherwise
	 */
	public static boolean isPalindromic (String num){	
		int count = 0;
		for (int x = 0; x <= ((num.length())/2)-1; x++){
			if (num.charAt(num.length()-x-1) == num.charAt(x))
				count++;
		}
		if (count == (num.length()/2))
			return true;
		else
			return false;

	}

	/**
	 * pre: n>0
	 * post: returns an array of the first n positive numbers that are palindromes in both base 10 and base 2
	 */
	public static int[] getPalindromeList (int n){
		int palinArrCount = 0;
		int x = 1;
		int[] base10PalinArr = new int[n];

		do{
			if(isPalindromic(String.valueOf(x)) && isPalindromic(String.valueOf(toBase2(x)))){
				base10PalinArr[palinArrCount] = x;
				palinArrCount++;
			}

			x++;
		}while (palinArrCount<n);
		return base10PalinArr;
	}

	/**
	 * pre: array is not null
	 * post: returns the sum of the numbers in the array
	 */
	public static int sum (int[] array){
		int sum = 0;
		for(int y = 0; y < array.length;y++)
			sum += array[y];
		return sum;
	}
}

/**
 *Enter the number of numbers for summation. Must be a POSITIVE INTEGER: 2
 *The first 2 numbers that are palindromic in both base 10 and base 2 are:
 *         Base 10           Base 2
 *               1                1
 *               3               11
 *The sum of the first 2 numbers that are palindromic in both base 10 and base 2 is 4.
 */

/**
 *Enter the number of numbers for summation. Must be a POSITIVE INTEGER: fsfh
 *Not an integer. Try again. Enter the number of numbers for summation. Must be a POSITIVE INTEGER: -3
 *Not positive. Try again. Enter the number of numbers for summation. Must be a POSITIVE INTEGER: 0
 *Not positive. Try again. Enter the number of numbers for summation. Must be a POSITIVE INTEGER: 5
 *The first 5 numbers that are palindromic in both base 10 and base 2 are:
 *         Base 10           Base 2
 *               1                1
 *               3               11
 *               5              101
 *               7              111
 *               9             1001
 *The sum of the first 5 numbers that are palindromic in both base 10 and base 2 is 25.
**/

/**
 *Enter the number of numbers for summation. Must be a POSITIVE INTEGER: 16
 *The first 16 numbers that are palindromic in both base 10 and base 2 are:
 *         Base 10           Base 2
 *               1                1
 *               3               11
 *               5              101
 *               7              111
 *               9             1001
 *              33           100001
 *              99          1100011
 *             313        100111001
 *             585       1001001001
 *             717       1011001101
 *            7447    1110100010111
 *            9009   10001100110001
 *           15351   11101111110111
 *           32223  111110111011111
 *           39993 1001110000111001
 *           53235 1100111111110011
 *The sum of the first 16 numbers that are palindromic in both base 10 and base 2 is 159030.
**/

/**
 *Enter the number of numbers for summation. Must be a POSITIVE INTEGER: 25
 *The first 25 numbers that are palindromic in both base 10 and base 2 are:
 *         Base 10           Base 2
 *               1                1
 *               3               11
 *               5              101
 *               7              111
 *               9             1001
 *              33           100001
 *              99          1100011
 *             313        100111001
 *             585       1001001001
 *             717       1011001101
 *            7447    1110100010111
 *            9009   10001100110001
 *           15351   11101111110111
 *           32223  111110111011111
 *           39993 1001110000111001
 *           53235 1100111111110011
 *           53835 1101001001001011
 *           73737 10010000000001001
 *          585585 10001110111101110001
 *         1758571 110101101010101101011
 *         1934391 111011000010000110111
 *         1979791 111100011010110001111
 *         3129213 1011111011111101111101
 *         5071705 10011010110001101011001
 *         5259525 10100000100000100000101
 *The sum of the first 25 numbers that are palindromic in both base 10 and base 2 is 20005383.
 **/
