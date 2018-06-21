/**
 * Given a string of length, L, find the longest substring with no repeating characters
 * 
 * Input: String
 * Output: Substring of input string
 * @author Ravi
 *
 */
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String userString = null;
		try {
			userString = userInput.nextLine();
		} catch (InputMismatchException ime) {
			System.out.println("Error. Invalid input type.");
			System.exit(1);
		}
		if(userString.equals("")) {
			System.out.println("String is empty");
			System.exit(0);
		}
		
		int count = 0;
		int max = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		StringBuilder sb = new StringBuilder();
		for(int start = 0; start < userString.length(); start++) {
			String temp = ""+userString.charAt(start);
			if(!map.containsKey(temp)) {
				map.put(temp, start);
				sb.append(temp);
				count++;
			}
			else {
				result.put(sb.toString(), count);
				sb = new StringBuilder();
				sb.append(temp);
				count = 1;
			}
			
		}
		for(Map.Entry<String, Integer> entry : result.entrySet()) {
			if(max < entry.getValue()) {
				max = entry.getValue();
			}
			
		}
		for(Map.Entry<String, Integer> entry : result.entrySet()) {
			if(max == entry.getValue()) {
				System.out.println(entry.getKey());
			}
			
		}
		
		
		userInput.close();
		
	}
	
}
