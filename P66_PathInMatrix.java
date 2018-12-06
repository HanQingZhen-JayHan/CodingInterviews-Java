import java.util.Iterator;
import java.util.Stack;


public class P66_PathInMatrix {
//trace back
	public void hasPath(char [][] matrix,String str)
	{
		if(matrix == null ||matrix.length<=0 || matrix[0].length<=0){
	         System.out.println("The matrix is exception! ");
	         return;
	}
		if(str == null)
		{
			System.out.println("NULL Exception! str = "+str);
			return;
		}
		if(str.length()<=0)
		{
			System.out.println("EMPTY Exception!  str = "+str);
			return;
		}
		System.out.println("Search target: "+str);
		int rows = matrix.length;
		int columns = matrix[0].length;
		for(int r=0;r<rows;r++)
			for(int c = 0;c<columns;c++)
			{
				Stack<Character> stack = new Stack<Character>();
				boolean [][]visited = new boolean[rows][columns];//initial false;
				boolean pass = recursionTracBack(matrix,rows,r,columns,c,str,0,stack,visited);
				if(pass)
					//printStack(stack);
					;
				else
					System.out.println("Start point ( "+r+" , "+c+" ) don't trace the "+str);
			}
		
	}
	private <T> void printStack(Stack<T> stack)
	{
		Iterator<T> iterator = stack.iterator();
		System.out.print("Find the path: ");
		while(iterator.hasNext())
			System.out.print(iterator.next()+" ");
		System.out.println();
	}
	private boolean recursionTracBack(char [][] matrix,int rows,int r, int columns,int c, String str,int index,Stack<Character> stack,boolean [][]visited) {
		// TODO Auto-generated method stub
		if(index == str.length())//recursion end
		{
			return true;
		}
		if(r<0||r>= rows||c<0||c>=columns)
			return false;
		boolean find = false;
		if(!visited[r][c] && (matrix[r][c]==str.charAt(index))){
		stack.push(str.charAt(index));
		visited[r][c]=true;
		find =recursionTracBack(matrix,rows,r-1,columns,c,str,index+1,stack,visited) || //up
				 recursionTracBack(matrix,rows,r+1,columns,c,str,index+1,stack,visited)|| //down
				 recursionTracBack(matrix,rows,r,columns,c-1,str,index+1,stack,visited) || //left
				 recursionTracBack(matrix,rows,r,columns,c+1,str,index+1,stack,visited);    //right
		if(find)
		{
			System.out.print("Start point ( "+r+" , "+c+" ) ");//find the target string
			printStack(stack);
		}
		stack.pop();
		visited[r][c]=false;
		}
		return find;
	}

	public static void main(String [] args)
	{

		P66_PathInMatrix  test = new P66_PathInMatrix ();
		//test
		//founction test
		System.out.println("Founction Test:");
		char [][] matrix ={{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
		String str = "bcced";
		//yes
		test.hasPath(matrix, str);
		//no
		test.hasPath(matrix, "abcb");
		//boundary test		
		System.out.println("\nBoundary Test:");
		char [][]matrixOne={{'a'}};
		test.hasPath(matrixOne, "a");
		test.hasPath(matrixOne, "b");
		
		//exception test		
		System.out.println("\nException Test:");
		test.hasPath(matrixOne,null);
		test.hasPath(null,"a");
	}
}
