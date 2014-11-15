package NOV14;
//http://www.codechef.com/NOV14/problems/PRPALN/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class PRPALN 
{

	public static void main(String[] args) 
	{
		PRPALN obj = new PRPALN();
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		ArrayList<String> output = new ArrayList<String>();
		int _t = 0;
		while(_t < t)
		{	
			output.add(obj.solve(in.nextLine()));
			_t++;
		}
		for(String o: output)
			System.out.println(o);
	}
	
	private String solve(String str)
	{	
		int len = str.length();
		
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		//build frequency hash map
		for(int i=0;i<len;i++)
		{
			if(hm.containsKey(str.charAt(i)))
				hm.put(str.charAt(i), hm.get(str.charAt(i))+1);
			else
				hm.put(str.charAt(i), 1);
		}
		
		
		//System.out.println(hm);
		
		
		//CASE A: even length string 
		//All characters should have even frequency with exception to only one character
		if(len%2==0)
		{	
			int oddFreqCharCount = 0;
			for (Map.Entry<Character,Integer> entry : hm.entrySet()) 
			{	
				if(entry.getValue()%2!=0 && oddFreqCharCount<2)
					oddFreqCharCount++;
				else if(entry.getValue()%2!=0 && oddFreqCharCount==2)
					return "NO";
			}
			if(oddFreqCharCount>2)
				return "NO";
		}
		//CASE B: odd length string
		//Cannot  have odd 3 or more characters with odd frequency  
		else
		{
			int oddFreqCharCount = 0;
			for (Map.Entry<Character,Integer> entry : hm.entrySet()) 
			{	
				if(entry.getValue()%2!=0 && oddFreqCharCount<3)
					oddFreqCharCount++;
				else if(entry.getValue()%2!=0 && oddFreqCharCount==3)
					return "NO";
			}
			if(oddFreqCharCount>=3)
				return "NO";
		}
		
		
		
		return "YES";
	}

}
