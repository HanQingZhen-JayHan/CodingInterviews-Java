
public class P20_ClockPrintMatrix {
	
	public static void print(int [][] matrix)
	{
		if(matrix == null)
		{
			System.out.println("The matrix is NULL!");
			return;
		}
		if(matrix.length<=0)
		{
			System.out.println("The row of matrix is empty!");
			return;
		}
		if(matrix[0].length<=0)
		{
			System.out.println("The column of matrix is empty!");
			return;
		}
		
		int rows = matrix.length;
		int columns = matrix[0].length;
		long total = rows*columns;
		int start = 0;
		long count =0;
		           //------------------------>  X
		         //  ^                          |
	    		//   |                          |
				//   |                          |
				//   | 						  |
				//   <--------------------- V
		       //    Y                           X，Y
		while(rows>2*start && columns >2*start)
		{
			int Yend = columns-start-1;
			int Xend = rows-start-1;
			
			for(int i=start;i<=Yend;i++)                             //------------------------>
				System.out.print(matrix[start][i]+" ");        //  ^                          |
			if(Xend >start)												//   |                          |
			for(int i = start+1;i<=Xend ;i++)					//   |                          |
				System.out.print(matrix[i][Yend]+" ");		//   | 						  |
			else break;
			if(Yend>start)												//   <--------------------- V
			for(int i = Yend-1;i>=start;i--)
				System.out.print(matrix[Xend][i]+" ");
			else break;
			
			if(Xend-1>start)
			for(int i = Xend-1;i>=start+1;i--)
				System.out.print(matrix[i][start]+" ");
			else break;
			start++;
		}
	
	}
	
	/*
	public static void main(String [] args)
	{

		P20_ClockPrintMatrix  test = new P20_ClockPrintMatrix ();
		int [][] matrix ={{1,2,3,4,1},{5,6,7,8,1},{9,10,11,12,1},{13,14,15,16,1},{1,1,1,1,1}};
		
		//test
		//founction test
		System.out.println("Founction Test:");
		test.print(matrix);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [][] matrix1={{1}};
		test.print(matrix1);
		int [][] matrix2={{1,2,3,4}};
		test.print(matrix2);
		int [][] matrix3 = {{1},{5},{9},{13}};
		test.print(matrix3);
		//exception test		
		System.out.println("\nException Test:");
		int [][]matrix_exception = {{}};
		test.print(matrix_exception);
		int [][] matrix_exception1 = {{},{}};
		test.print(matrix_exception1);
		test.print(null);
		
	}
	*/
}
