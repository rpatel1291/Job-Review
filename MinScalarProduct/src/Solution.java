
/**
 * Problem: Minimum Scalar Product
 * @author Ravi
 */
/*
 * Given two vectors v1 and v2 of equal length. The scalar product of the vectors is a single number produced by sum of the products x1y1 + ... + xnyn.
 * If you are allowed to permute the coordinates of each vector. What is the minimum possible scalar product.
 * 
 * Inputs:
 * 		T - # of test cases
 * 		N - # of coordinates in vector
 * 		v1 - list of coordinates for vector v1 => represented by array
 * 		v2 - list of coordinates for vector v2 => represented by array
 *    
 * Output:
 * 		Case # X : Y
 * 		where X is case number and Y is the resulting number 
 * 
 */

import java.util.Scanner;
import java.io.IOError;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter the number of cases to test? ");
		int testCases = 0;

		try {
			testCases = userInput.nextInt();
		} catch (InputMismatchException ime) {
			System.out.println("Error: Input type is not integer type.");
			System.out.println("Program Crash.");
			System.exit(1);
		}
		if (testCases <= 0) {
			System.out.println("There are no cases to test.");
			System.out.println("Program end.");
			System.exit(0);
		}
		int test = 0;
		while (test < testCases) {

			int vectorLength = 0;

			System.out.println("Enter the number of elements/coordinates in each vector?");
			try {
				vectorLength = userInput.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("Error: Input type is not integer type.");
				System.out.println("Program Crash.");
				System.exit(1);
			}
			if (vectorLength <= 0) {
				System.out.println("There are no elements in vector.");
				System.out.println("Program end.");
				System.exit(0);
			}

			int[] vector1 = new int[vectorLength], vector2 = new int[vectorLength];

			int vectorCounter = 0; // Variable to count both arrays being filled
			// Create the two vectors
			while (vectorCounter < 2) {
				for (int start = 0; start < vectorLength; start++) {
					int temp = 0;
					try {
						System.out
								.println("Enter the " + start + " element for the" + (vectorCounter + 1) + " vector?");
						temp = userInput.nextInt();
					} catch (InputMismatchException ime) {
						System.out.println("Error: Input type is not integer type.");
						System.out.println("Program Crash.");
						System.exit(1);
					}
					if (vectorCounter == 0) {
						vector1[start] = temp;
					} else {
						vector2[start] = temp;
					}
				}
				vectorCounter++;
			}

			Arrays.sort(vector1);
			Arrays.sort(vector2);

			int sum = 0;
			for (int startVector1 = 0, startVector2 = vectorLength - 1; startVector1 < vectorLength
					&& startVector2 >= 0; startVector1++, startVector2--) {
				sum += vector1[startVector1] * vector2[startVector2];
			}
			System.out.println("Case #"+(test+1)+": "+sum);
			
			test++;
		}
		userInput.close();
	}
}