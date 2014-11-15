package NOV14;

import java.util.ArrayList;
import java.util.Scanner;

/*
http://www.codechef.com/NOV14/problems/POWERMUL

Algorithm: We cancel the the multipliers of F(r) from the numerator so that the required value becomes
(r+1)^(r+1)....N^N / 1^1.....(N-r)^(N-r)

This solution only handles the Objective 1 of the question. Still need to complete the other 2 objectives.
*/
public class POWERMUL 
{

	public static void main(String[] args) 
	{	
		POWERMUL obj = new POWERMUL();
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		int _t = 0;
		ArrayList<Integer> output = new ArrayList<Integer>();
		while(_t < t)
		{
			int m,n,q;
			//do
			//{
				String[] vals = in.nextLine().split(" ");
				n = Integer.parseInt(vals[0]);
				m = Integer.parseInt(vals[1]);
				q = Integer.parseInt(vals[2]);
			//}while(!obj.isPrime(m) && n>500);
			int _q = 0;
			while(_q < q)
			{	
				int r = Integer.parseInt(in.nextLine());
				output.add(obj.solve(m,n,r));
				_q++;
			}
			_t++;
			
		}
		
		//print output
		for(int o: output)
			System.out.println(o);
	}
	
	public boolean isPrime(int num)
	{
		for(int i=2;i<num;i++)
			if(num%i==0)
				return false;
		return true;
	}
	
	
	public int solve(int m, int n, int r)
	{	
		//calculate the reduced numerator
		int num = 1;
		for(int i=(r+1);i<=n;i++)
		{
			num*= Math.pow(i,i);
		}
		//calculate the reduced denominator
		int den = 1;
		for(int i=1;i<=(n-r);i++)
		{
			den*= Math.pow(i,i);
		}
		
		return (num/den)%m;
	}
	
	/*
	public int solve(int m, int n, int r)
	{	
		//calculate the reduced numerator
		int num = 0;
		for(int i=(r+1);i<=n;i++)
		{
			num += i*Math.log10(i);
		}
		//calculate the reduced denominator
		int den = 0;
		for(int i=1;i<=(n-r);i++)
		{
			den += i*Math.log10(i);
		}
		
		return (int) (Math.pow(10,(num-den))%m);
	}
	*/
}
