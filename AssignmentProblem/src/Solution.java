/**
 * Problem: Assignment Problem 
 * You are the head of a firm and you have to assign
 * jobs to people. You have N persons working under you and you have N jobs that
 * are to be done by these persons. Each person has to do exactly one job and
 * each job has to be done by exactly one person. Each person has his own
 * capability (in terms of time taken) to do any particular job. Your task is to
 * assign the jobs to the persons in such a way that the total time taken is
 * minimum. A job can be assigned to only one person and a person can do only
 * one job.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. Then T test cases follow. The first line of each test case
 * contains an integer N, where N is the number of jobs and the number of
 * persons under you. The next line contains N2 positive integers. The first N
 * of these integers denote the time taken by the first person to do the N jobs,
 * the next N integers denote the time taken by the second person to do the N
 * jobs and so on till the Nth person.
 * 
 * Output: For each test case in a new line, print the time taken in the best
 * possible assignment that you can do.
 * 
 * @author Ravi
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		Scanner userInput = new Scanner(System.in);
		System.out.println("How many cases will be tested?");
		int testCases = 0;
		try {
			testCases = userInput.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("Error. Input is not integer type.");
			System.exit(1);
		}
		if(testCases < 1) {
			System.out.println("No cases to test");
			System.exit(0);
		}
		int cases = 0;
		int workers = 0;
		String[] stringTasks = null;
		int[] intTasks = null;
		while(cases < testCases) {
			System.out.println("Enter the number of workers: ");
			try {
				workers = userInput.nextInt();
			} catch(InputMismatchException ime) {
				System.out.println("Error. Input is not integer type");
				System.exit(1);
			}
			stringTasks = new String[workers*workers];
			intTasks = new int[workers*workers];
			System.out.println("Entrt the time taken for each task/assignment: ");
			String temp = "";
			try {
				stringTasks = br.readLine().split(" ");
			} catch (IOException e) {
				System.out.println("Error. Input is not string type");
				System.exit(1);
			}
			int i = 0;
			for(String x: stringTasks) {
				intTasks[i++] = new Integer(x);
			}
			Arrays.sort(intTasks);
			i = 0;
			int sum = 0;
			while(i < workers) {
				sum += intTasks[i++];
			}
			System.out.println(sum);
			cases++;
		}
		
		userInput.close();
		
	}

}
