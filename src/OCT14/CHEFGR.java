package OCT14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * http://www.codechef.com/OCT14/problems/CHEFGR
 * 
 * Find the maximum height column. Now, you need to make all the columns atleast that high.
 * Take the difference of all columns with the maximum height column. If that is equal to the 
 * m mud provided, answer is Yes. Else if, the difference of mud available and the mud needed to
 * make all columns equal to the tallest height column is a multiple of total number of columns,
 * we can again redistribute the remain mud in all the columns and still maintain their heights to be
 * equal. If these cases do not match, we return No. 
*/
public class CHEFGR 
{

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		CHEFGR obj = new CHEFGR();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		
		StringBuffer out = new StringBuffer("");
		for(int i=0;i<testcases;i++)
		{
			String n_m = br.readLine();
			int n = Integer.parseInt(n_m.split(" ")[0]);
			int m = Integer.parseInt(n_m.split(" ")[1]);
			String[] str_cols = br.readLine().split(" ");
			int[] cols  = new int[n];
			for(int j=0;j<n;j++)
			{
				cols[j] = Integer.parseInt(str_cols[j]);
			}
			out.append(obj.findFunction(n,m,cols)+"\n");
		}
		System.out.println(out.toString());
		

	}

	private String findFunction(int n, int m, int[] cols) 
	{
		int max_col = Integer.MIN_VALUE;
		int mudNeeded = 0;
		//find the maximum column
		for(int col: cols)
		{
			if(col>max_col)
				max_col = col;
		}
		//find the total cubes of mud needed 
		for(int col: cols)
		{
			mudNeeded+= (max_col-col);
				
		}
		
		if(mudNeeded==m)
			return "Yes";
		else if(mudNeeded < m && (m-mudNeeded)%n==0)
			return "Yes";
		else
			return "No";
	}
	
	
	
}
