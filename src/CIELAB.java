import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * In Ciel's restaurant, a waiter is training.
Since the waiter isn't good at arithmetic, sometimes he gives guests wrong change.
Ciel gives him a simple problem.
What is A-B (A minus B) ?
Surprisingly, his answer is wrong.
To be more precise, his answer has exactly one wrong digit.
Can you imagine this?
Can you make the same mistake in this problem?
Input

An input contains 2 integers A and B.
Output

Print a wrong answer of A-B.
Your answer must be a positive integer containing the same number of digits as the correct answer, and exactly one digit must differ from the correct answer.
Leading zeros are not allowed.
If there are multiple answers satisfying the above conditions, anyone will do.
Constraints

1 ≤ B < A ≤ 10000
Sample Input

5858 1234
Sample Output

1624
Output details

The correct answer of 5858-1234 is 4624.
So, for instance, 2624, 4324, 4623, 4604 and 4629 will be accepted, but 0624, 624, 5858, 4624 and 04624 will be rejected.
 */

/**
 * @author deveshbajpai
 * 
 * Algorithm: Calculate the difference of the 2 numbers and obtain the last digit of the result. If its 9, reduce it by 1
 * and otherwise, increase it by 1. Replace that digit by the new last digit and build the new result. Use StringBuffer
 * to build the result. Note that the 48 is added to the result to take care of integer to ASCII char conversion.
 * 
 * Problem Url: https://www.codechef.com/problems/CIELAB/
 *
 */
public class CIELAB {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		CIELAB obj = new CIELAB();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str_num = br.readLine().split(" ");
		
		System.out.println(obj.findFunction(str_num)+"\n");
		
	}

	private StringBuilder findFunction(String[] str_num) 
	{
		int a = Integer.parseInt(str_num[0]);
		int b = Integer.parseInt(str_num[1]);
		
		int resultLastDigit = (a-b)%10;
		StringBuilder correctResult = new StringBuilder((a-b)+"");
		
		if(resultLastDigit==9)
			resultLastDigit--;
		else
			resultLastDigit++;
		
		correctResult.setCharAt(correctResult.length()-1, (char) (resultLastDigit+48));
		
		
		return correctResult;
	}

}
