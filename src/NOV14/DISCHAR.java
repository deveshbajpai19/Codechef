package NOV14;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.ArrayList;


//http://www.codechef.com/NOV14/problems/DISCHAR

public class DISCHAR 
{

	public static void main(String[] args) 
	{
		DISCHAR obj = new DISCHAR();
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		ArrayList<Integer> output = new ArrayList<Integer>();
		int _t = 0;
		while(_t < t)
		{	
			output.add(obj.solve(in.nextLine()));
			_t++;
		}
		for(int o: output)
			System.out.println(o);
		
	}
	
	private int solve(String str)
	{
		LinkedHashSet<Character> lhs = new LinkedHashSet<Character>();
		
		char[] c = str.toCharArray();
		for(int i=0;i<c.length;i++)
		{
			lhs.add(c[i]);
		}	
		
		return lhs.size();
	}
	
		

}
