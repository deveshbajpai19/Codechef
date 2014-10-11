import java.util.Scanner;

/*http://www.codechef.com/problems/HS08TEST
*/
public class HS08TEST 
{

	public static void main(String[] args) 
	{	
		Scanner in = new Scanner(System.in);
		String[] inputs = in.nextLine().split(" ");
		
		double bankCharges = 0.50;
		double X = Double.parseDouble(inputs[0]);
		double Y = Double.parseDouble(inputs[1]);
		
		if(Y-(X+bankCharges)>=0 && X%5==0)
			System.out.println(Y-(X+bankCharges));
		else
			System.out.println(Y);
		
		
		

	}

}
