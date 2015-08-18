import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


/**
 * 
 */

/**
 * @author deveshbajpai
 *
 * Question:
 * Chef wrote some text on a piece of paper and now he wants to know how many holes are in the text. 
 * What is a hole? If you think of the paper as the plane and a letter as a curve on the plane, 
 * then each letter divides the plane into regions. For example letters "A", "D", "O", "P", "R" 
 * divide the plane into two regions so we say these letters each have one hole. Similarly, 
 * letter "B" has two holes and letters such as "C", "E", "F", "K" have no holes. 
 * We say that the number of holes in the text is equal to the total number of holes in the letters of the text. 
 * Help Chef to determine how many holes are in the text.

Input

The first line contains a single integer T <= 40, the number of test cases. T test cases follow. The only line of each test case contains a non-empty text composed only of uppercase letters of English alphabet. The length of the text is less then 100. There are no any spaces in the input.
Output

For each test case, output a single line containing the number of holes in the corresponding text.
Example

Input:
2
CODECHEF
DRINKEATCODE

Output:
2
5

Algorithm:
Pre-process the one and two hole characters in a hashmap with holes count as value. Iterate over the string and check it's current 
character's presence in the hashmap. If found, add the holes count from it in the counter maintaining the total number of holes for
that word. Return that counter.

Problem Url:
https://www.codechef.com/problems/HOLES
 *
 */
public class HOLES {

	/**
	 * @param args
	 */
	private static HashMap <Character,Integer> holesCount = new HashMap<Character,Integer>();
	
	
	private void preProcessing()
	{	
		//set oneHoles
		holesCount.put('A',1);
		holesCount.put('D',1);
		holesCount.put('O',1);
		holesCount.put('P',1);
		holesCount.put('Q',1);
		holesCount.put('R',1);
		
		//set twoHoles
		holesCount.put('B',2);
	}
	
	private int findFunction(String word)
	{	
		int holes = 0;
		for(int i=0;i<word.length();i++)
		{
			char curChar = word.charAt(i);
			if(holesCount.containsKey(curChar))
				holes+=holesCount.get(curChar);
		}
		return holes;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		HOLES obj = new HOLES();
		obj.preProcessing();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		
		StringBuffer out = new StringBuffer("");
		for(int i=0;i<testcases;i++)
		{
			String word = br.readLine();
			out.append(obj.findFunction(word)+"\n");
		}
		System.out.println(out.toString());
	
	}

}
