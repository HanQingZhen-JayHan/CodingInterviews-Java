
public class P67_SphereOfRobortActivite {
	
	public void numberOfGrids(int rows, int columns, int k)
	{
		if(rows<1 || columns <1 || k<1)
		{
			System.out.println("Numberic Excepiton! rows = "+rows+", columns = "+columns+",k = "+k);
			return;
		}
		int grids=0;
		int limits = k;
		int startR=0;
		int startC=0;
		boolean [][] visited = new boolean[rows][columns];
		grids = calculateRecursion(rows,startR,columns,startC,limits,visited);
	}
	
	private int calculateRecursion(int rows, int r, int columns, int c, int limits, boolean[][] visited) {
		// TODO Auto-generated method stub
		if(r>=rows ||r<0 || c>=columns ||c<0) //out of rows x columns
			return 0;
		if(visited[r][c]) //alread visited
			return 0;
		if(sumOfDigits(r)+sumOfDigits(c) > limits){ //out of limits
			visited[r][c] = true;
		return 0;
		}
		
		System.out.print(" ( "+r+" , "+c+" ), ");
		if(r%5==0)
			System.out.println();
		visited[r][c] = true;
		return 1+calculateRecursion(rows,r-1,columns,c,limits,visited) +  //up
					calculateRecursion(rows,r+1,columns,c,limits,visited) + //down
					calculateRecursion(rows,r,columns,c-1,limits,visited) +  //left
					calculateRecursion(rows,r,columns,c+1,limits,visited) ;  //right
	}

	private int sumOfDigits(int n)
	{
		int sum = 0;
		while(n!=0)
		{
			sum +=n%10;
			n = n/10;
		}
		return sum;
	}
	public static void main(String [] args)
	{

		P67_SphereOfRobortActivite  test = new P67_SphereOfRobortActivite ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int rows = 50;
		int columns = 50;
		int k =18;
		test.numberOfGrids(rows, columns, k);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		test.numberOfGrids(1, 1, 1);
		
		//exception test		
		System.out.println("\nException Test:");
		test.numberOfGrids(-1, -1, -1);
	}
}
