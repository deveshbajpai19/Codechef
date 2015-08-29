import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 *Given an array A of length N, your task is to find the element which repeats in A maximum number of times as well as the corresponding count. In case of ties, choose the smaller element first.
Input

First line of input contains an integer T, denoting the number of test cases. Then follows description of T cases. Each case begins with a single integer N, the length of A. Then follow N space separated integers in next line. Assume that 1 <= T <= 100, 1 <= N <= 100 and for all i in [1..N] : 1 <= A[i] <= 10000
Output

For each test case, output two space separated integers V & C. V is the value which occurs maximum number of times and C is its count.
Example

Input:
2
5
1 2 3 2 5
6
1 2 2 1 1 2

Output:
2 2
1 3

Description:
In first case 2 occurs twice whereas all other elements occur only once. 
In second case, both 1 and 2 occur 3 times but 1 is smaller than 2. 
 */

/**
 * @author Devesh Bajpai
 * 
 * Algorithm: For linear complexity, maintain a hash map of the list of numbers with their frequency as their values.
 * To find the maximum frequency element, iterate over the map and find it. Important to note, since we wish to report
 * the smallest number in case of ties, use a tree map. It would always process the smallest number first and hence
 * while checking the ties, it won't be overwritten by a larger number with same frequency.
 * 
 * Problem Url: https://www.codechef.com/problems/MAXCOUNT
 *
 */
public class MAXCOUNT 
{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		MAXCOUNT obj = new MAXCOUNT();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		
		StringBuffer out = new StringBuffer("");
		for(int i=0;i<testcases;i++)
		{
			int num = Integer.parseInt(br.readLine());
			String[] strNumArr = br.readLine().split(" ");
			int[] numArr = new int[strNumArr.length];
			int j = 0;
			for(String strNum: strNumArr)
			{
				numArr[j] = Integer.parseInt(strNum);
				j++;
			}
			out.append(obj.findFunction(num,numArr)+"\n");
		}
		System.out.println(out.toString());

	}

	private String findFunction(int num, int[] numArr) 
	{
		TreeMap<Integer,Integer> numMap = new TreeMap<Integer,Integer>();
		int maxCountNum = 0;
		int maxCount = 0;
		//O(n) to build the numMap
		for(int numArrVal: numArr)
		{
			if(numMap.containsKey(numArrVal))
			{
				numMap.put(numArrVal, numMap.get(numArrVal)+1);
			}
			else
			{
				numMap.put(numArrVal, 1);
			}
		}
		
		//O(n) to find the most occurring number
		for (int key : numMap.keySet()) {
		    if(numMap.get(key)>maxCount)
		    {
		    	maxCountNum = key;
		    	maxCount = numMap.get(key);
		    }
		}
		return (maxCountNum+" "+maxCount);
	}

}
