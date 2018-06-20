
/**
 * Problem: Jarvis is weak in computing palindromes for Alphanumeric characters.
 * While Ironman is busy fighting Thanos, he needs to activate sonic punch but
 * Jarvis is stuck in computing palindromes. You are given a string containing
 * the alphanumeric character. Find whether the string is palindrome or not. If
 * you are unable to solve it then it may result in the death of Iron Man.
 * 
 * Input: First line contains "t", number of test cases, followed by test case s, string
 * Output: "YES" -> if string is a palindrome; "NO" -> if string is not a palindrome.
 * @author Ravi
 *
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("How many cases will be tested?");
		int testCases = 0;
		try {
			testCases = userInput.nextInt();
		} catch (InputMismatchException ime) {
			System.out.println("Error: Input type is not integer type");
			System.exit(1);
		}
		if (testCases < 1 || testCases > 100) {
			System.out.println("Error: Number of Cases are out of bounds");
			System.exit(0);
		}
		int caseNumber = 0;
		while (caseNumber < testCases) {
			System.out.println("Enter test string:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String testString = null;
			try {
				testString = br.readLine();
			} catch (IOException e) {
				System.out.println("Error");
				System.exit(1);
			}
			testString = testString.toLowerCase();
			testString = testString.replaceAll("[^a-z0-9]", "");
			
			String result = null;
			if(testString.length()%2==0) {
				for(int start=0, end=testString.length()-1; start < end; start++, end--) {
					if(testString.charAt(start) != testString.charAt(end)) {
						result = "NO";
					}
				}
				result = "YES";
			}
			else {
				for(int start=0, end=testString.length()-1; start != end; start++, end--) {
					if(testString.charAt(start) != testString.charAt(end)) {
						result="NO";
					}
				}
				result = "YES";
			}
			System.out.println(result);
			caseNumber++;
		}
		
		userInput.close();
	}

}
