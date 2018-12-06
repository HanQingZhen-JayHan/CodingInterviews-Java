
public class P3_MatrixFind {

	public void findNumber(int[][] matrix, int number) {
		// TODO Auto-generated method stub
		boolean result = false;
		if(matrix == null ||matrix.length<=0 || matrix[0].length<=0){
		         System.out.println("The matrix is exception! ");
		         return;
		}
		
		int row_max = matrix.length-1;
		int column_max = matrix[0].length-1;
		if(matrix[0][0]>number ||matrix[row_max][column_max]<number)
		{
	         System.out.println(number+" in the matrix: "+result);
	         return;
		}
		
		int row=0;
		int column = column_max;
		while(row<= row_max && column>=0)
		{
			if(matrix[row][column] == number){
				result = true;
				break;
			}
			else if(matrix[row][column]<number)
				     row++;
			else
				    column--;
		}
		
        System.out.println(number+" in the matrix: "+result);
	}
	/*
	public static void main(String [] args){
		P3_MatrixFind matrixFind = new P3_MatrixFind();
		
		//test
		//founction test
		System.out.println("Founction Test:");
		int matrix [] [] ={{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}};
		int number  = 8;
		int error = 16;
		matrixFind.findNumber(matrix,number);
		matrixFind.findNumber(matrix,error);
		
		System.out.println("\nBoundary Test:");
		//boundary test
		int min  = 0;
		int max = 15;
		matrixFind.findNumber(matrix,min);
		matrixFind.findNumber(matrix,max);
		
		System.out.println("\nException Test:");
		//exception test
		int matrix_exception1  [] [] ={{}}; //{};
		int matrix_exception2 [] [] = null;
		int number_exception;
		matrixFind.findNumber(matrix_exception1,number);
		matrixFind.findNumber(matrix_exception2,number);
		
		System.out.println("row : "+matrix_exception1.length);
		System.out.println("column :"+matrix_exception1[0].length);
	}

*/
}
