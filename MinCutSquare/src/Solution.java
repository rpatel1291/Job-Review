/**
 * Problem: Dilpreet wants to paint his dog- Buzo's home that has n boards with
 * different lengths[A1, A2,..., An]. He hired k painters for this work and each
 * painter takes 1 unit time to paint 1 unit of the board.The problem is to find
 * the minimum time to get this job done under the constraints that any painter
 * will only paint continuous sections of boards, say board {2, 3, 4} or only
 * board {1} or nothing but not board {2, 4, 5}.
 * 
 * Input: The first line consists of a single integer T, the number of test
 * cases. For each test case, the first line contains an integer k denoting the
 * number of painters and integer n denoting the number of boards. Next line
 * contains n- space separated integers denoting the size of boards.
 * 
 * Output: For each test case, the output is an integer displaying the minimum
 * time for painting that house.
 * 
 * @author Ravi
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("How many cases will be tested?");
		int testCases = 0;
		try {
			testCases = userInput.nextInt();
		} catch(InputMismatchException ime) {
			System.out.println("Error: Input is not integer type");
			System.exit(1);
		}
		if( testCases < 1) {
			System.out.println("No test cases");
			System.exit(0);
		}
		int numberOfPainters = 0 , numberOfWalls = 0;
		System.out.println("Enter the number of painters followed by number of walls: ");
		try {
			numberOfPainters = userInput.nextInt();
			numberOfWalls = userInput.nextInt();
		} catch(InputMismatchException ime) {
			System.out.println("Error: Input is not integer type");
			System.exit(1);
		}
		int[] wallArray = new int[numberOfWalls];
		String[] inputArray = null;
		System.out.println("Enter number of boards for each wall:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			inputArray = br.readLine().split(" ");
		} catch(IOException e) {
			System.exit(1);
		}
		int i = 0, sum = 0;
		for(String x: inputArray) {
			
			try{
				wallArray[i++] = new Integer(x);
				sum += new Integer(x);
			} catch(NumberFormatException nfe) {
				
			}
		}
		float avgBoards = (sum*1.0f)/numberOfPainters;
		int[] boardsPerPainter = new int[numberOfPainters];
		i = 0;
		while(i< numberOfPainters) {
			boardsPerPainter[i] = 0; 
			i++;
		}
		i = 0; 
		for(int x: wallArray) {
			if(boardsPerPainter[i] < avgBoards) {
				boardsPerPainter[i] += x;
			}
			else {
				i++;
				boardsPerPainter[i] += x;
			}
		}
		
		for(int x: boardsPerPainter) {
			System.out.println(x);
		}
		
		userInput.close();
		
		
		
	}

}
