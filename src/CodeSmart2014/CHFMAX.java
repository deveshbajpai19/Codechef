package CodeSmart2014;
/*
http://www.codechef.com/CDSM2014/problems/CHFMAX
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CHFMAX 
{
	public static void main(String[] args) 
	{	
		CHFMAX c = new CHFMAX();
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int _t = 0;
		ArrayList<String> output = new ArrayList<String>();
		//take input
		while(_t < t)
		{
			String str = in.nextLine();
			output.add(c.solve(str));
			_t++;
		}
		//print the output
		for(String o: output)
			System.out.println(o);
		
	}
	
	private String solve(String str)
	{	
		
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		int maxCount = 0;
		//build frequency map of the string
		for(int i=0;i<str.length();i++)
		{
			if(hm.containsKey(str.charAt(i)))
				hm.put(str.charAt(i), hm.get(str.charAt(i))+1);
			else
				hm.put(str.charAt(i), 1);
		}
		
		//Calculate maxCount for the string
		for (Map.Entry<Character,Integer> entry : hm.entrySet()) 
		{	
			if(entry.getValue()>maxCount)
				maxCount = entry.getValue();
		}
		
		//find the maxCount chars		
		char maxCharA = '\0';
		char maxCharB = '\0';
		char replaceChar = '\0';
		
		for (Map.Entry<Character,Integer> entry : hm.entrySet()) 
		{	
			if(entry.getValue()==maxCount)
			{
				if(maxCharA=='\0')
					maxCharA = entry.getKey();
				else
					maxCharB = entry.getKey();
			}
		}
		
		//check the lower-case max occurring character if 2 max occurring characters are present
		//else just get the single max occurring character
		if(maxCharB!='\0')
		{
			if(maxCharA>='a' && maxCharA<='z')
				replaceChar = maxCharA;
			else
				replaceChar = maxCharB;
		}
		else
			replaceChar = maxCharA;
			
		//return the modified output string
		return str.replaceAll(replaceChar+"","?");
		
	}
	
}
