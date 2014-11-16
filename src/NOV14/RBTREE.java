package NOV14;

//http://www.codechef.com/NOV14/problems/RBTREE/
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class RBTREE 
{

	public static void main(String[] args) 
	{
		RBTREE obj = new RBTREE();
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		ArrayList<Integer> output = new ArrayList<Integer>();
		int _t = 0;
		String start_color = "b";
		while(_t < t)
		{	
			
			String input = in.nextLine();
			if(input.contains("Qb") || input.contains("Qr"))
			{
				String color = input.split(" ")[0].split("Q")[1];
				int nodeA = Integer.parseInt(input.split(" ")[1]);
				int nodeB = Integer.parseInt(input.split(" ")[2]);
				output.add((obj.Qb_Qr_move(color, start_color, nodeA, nodeB)));
				
			}
			else if(input.contains("Qi"))
			{
				start_color = obj.Qi_move(start_color);
			}
			_t++;
		}
		for(Integer o: output)
			System.out.println(o);
		
	}
	private int Qb_Qr_move(String color, String start_color, int nodeA, int nodeB)
	{	
		//calculate the path of the nodeA to root (1)
		LinkedHashSet<Integer> pathA = findRootNodePath(nodeA);
		
		//calculate the path of the nodeA to root (1)
		LinkedHashSet<Integer> pathB = findRootNodePath(nodeB);
			
		//find the lca
		int lca = findLCA(pathA, pathB);
		
		//find level of lca (it starts from 0)
		int level_lca = (int) (Math.log(lca) / Math.log(2));
		
		//find color of lca 
		String color_lca = "";
		if(level_lca%2==0)
			color_lca = start_color;
		else
		{
			if(start_color=="r")
				color_lca = "b";
			else
				color_lca = "r";
		}
		
		//calculate level of nodeA and nodeB 
		int level_nodeA = (int) (Math.log(nodeA) / Math.log(2));
		int level_nodeB = (int) (Math.log(nodeB) / Math.log(2));
		
		int path_lca_A_black = 0; 
		int path_lca_B_black = 0;
		int path_lca_A_red = 0;
		int path_lca_B_red = 0;
		
		//calculate the count for color of nodes from LCA to node nodeA 
		int[] path_color_countA = findLCANodePathColorCount(level_nodeA, level_lca, color_lca); 
		path_lca_A_black = path_color_countA[0];
		path_lca_A_red = path_color_countA[1];
		
		//calculate the count for color of nodes from LCA to node nodeB 
		int[] path_color_countB = findLCANodePathColorCount(level_nodeB, level_lca, color_lca); 
		path_lca_B_black = path_color_countB[0];
		path_lca_B_red = path_color_countB[1];
		
		int return_color_count = 0;
		if(color.equals("r"))
		{	
			return_color_count = path_lca_A_red + path_lca_B_red;
			if(color_lca.equals("r"))
				return_color_count++;
			
		}
		else if(color.equals("b"))
		{
			return_color_count = path_lca_A_black + path_lca_B_black;
			if(color_lca.equals("b"))
				return_color_count++;
			
		}	
		
		return return_color_count;
	}
	private String Qi_move(String start_color)
	{	
		if(start_color.equals("r"))
			return "b";
		else if(start_color.equals("b"))
			return "r";
		return "";
	}
	
	private int findLCA(LinkedHashSet<Integer> pathA, LinkedHashSet<Integer> pathB)
	{
		int lca = 1;
		for(int t_nodeB : pathB)
		{
			if(pathA.contains(t_nodeB))
			{
				lca = t_nodeB;			
				break;
			}
		}
		return lca;
	}
	
	private LinkedHashSet<Integer> findRootNodePath(int node)
	{
		LinkedHashSet<Integer> path = new LinkedHashSet<Integer>();
		int parent = node;
		while(parent>=1)
		{	
			path.add(parent);
			if(parent%2==0)
			{
				parent = parent/2;
			}
			else
			{
				parent = (parent-1)/2;
			}		
		}
		
		return path;
	}
	
	private int[] findLCANodePathColorCount(int level_node, int level_lca, String color_lca)
	{	
		int path_lca_black = 0;
		int path_lca_red = 0;
		int diff = level_node - level_lca;
		if(diff%2==0)
		{
			path_lca_black = path_lca_red = diff/2;
		}
		else
		{
			path_lca_black = path_lca_red = (diff-1)/2;
			if(color_lca.equals("r"))
				path_lca_black++;
			else if(color_lca.equals("b"))
				path_lca_red++;
		}
		
		return new int []{path_lca_black,path_lca_red};
	}
}
