
public class P28_SolutionOfQueens {
	
	public static void printSolution(int number)
	{
		if(number<=0)
		{
			System.out.println("The number of Queens must be bigger thean 0! number= "+number);
			return;
		}
		//Every queen in a different row;
		//Every queen in a different column;
		//Every  two queens not in a diagonal;
		//step1:set every queen in a different row;
		//step2:columns[] means every queen's column;
		//step3:permutation columns array,then check every two queens are not in a diagonal;
		int [] columns =  new int[number];
		for(int i= 0;i <columns.length;i++)
			columns[i] = i;
		
		recursionEightQueens(columns,0);
	}

	private static void recursionEightQueens(int[] columns, int index) {
		// TODO Auto-generated method stub
		if(columns.length-1 == index)
		{
			boolean failed = false;
			for(int i=0;i<columns.length;i++){
				for(int j = 0;j<columns.length;j++)
				{
					failed=(i!=j)&&(( i-j == columns[i]-columns[j]) ||( j-i== columns[i]-columns[j]));
					if(failed)
					{
						break;
					}
				}
			if(failed)
			{
				break;
			}}
			if(!failed){
				for(int k:columns)
					System.out.print(k+" ");
				System.out.println();
			}
				
		}
		
		//permutation
		for(int i = index;i<columns.length;i++)
		{
			int temp = columns[i];
			columns[i]=columns[index];
			columns[index] = temp;
			recursionEightQueens(columns,index+1);
			temp = columns[index];
			columns[index] = columns[i];
			columns[i]=temp;
		}
	}
/*
	public static void main(String [] args)
	{

		P28_SolutionOfQueens  test = new P28_SolutionOfQueens ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int number =8;
		test.printSolution(number);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		for(int i =1;i<10;i++)
		{
			System.out.println(i+" queens solution: ");
			test.printSolution(i);
		}
		number = 1;
		test.printSolution(number);
		number=4;
		test.printSolution(number);
		
		//exception test		
		System.out.println("\nException Test:");
		test.printSolution(0);
	}
	*/
}
