package JAN14;

/*
 * http://www.codechef.com/JAN14/problems/ERROR
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ERROR 
{

	public static void main(String[] args) throws IOException 
	{
		ERROR obj = new ERROR();
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

	private String findFunction(String word) 
	{
		String pattern1 = "010";
		String pattern2 = "101";
		
		if(word.contains(pattern1) || word.contains(pattern2))
			return "Good";
		else
			return "Bad";
	}

}
