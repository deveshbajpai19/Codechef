
import java.util.Scanner;

/*http://www.codechef.com/problems/TEST
*/
public class TEST 
{

	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		
		while(in.hasNext())
		{
			int num = in.nextInt();
			
			if(num==42)
				break;
			else
				System.out.println(num);
			
		}

	}

}
