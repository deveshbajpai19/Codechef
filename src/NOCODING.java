import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Question: http://www.codechef.com/problems/NOCODING
  Solution: Add 1 and length of the string to changes (for initial loading and printing each character)
  respectively.
  Now, check difference of current and next character. If its decreasing, add 26 to its absolute value.
  Else, directly add it. Finally, check for optimality.
*/
public class NOCODING 
{

	public static void main(String[] args) throws IOException 
	{
		NOCODING obj = new NOCODING();
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
	
	private String findFunction(String str)
	{	
		int len = str.length();
		
		if(len==0)
			return "YES";
		//The 1 is to load, and the length to print each character
		int changes = 1+len;
		int i = 0;
		while(i < len-1)
		{
			changes += difference(str.charAt(i), str.charAt(i+1));
			i++;
		}
		
		//System.out.println("changes "+changes);
		if(changes<=(len*11))
			return "YES";
		else
			return "NO";
	}
	
	private int difference(char a, char b)
	{
		int diff = b-a;
		
		if(diff<0)
			return 26-(-diff);
		else
			return diff;
	}
}
