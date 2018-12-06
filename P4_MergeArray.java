
public class P4_MergeArray {

	public static void mergeSortArray(int [] sortArray1,int [] sortArray2)
	{

		if(sortArray1==null |sortArray2==null)
		{
			System.out.println("The array is exception!");
			return;
		}
		if(sortArray1.length <=0 | sortArray2.length<=0 |sortArray1.length<sortArray2.length)
		{
			System.out.println("The array is exception!");
			return;
		}
		
		int length1= sortArray1.length;
		int length2 = sortArray2.length;
	   display(sortArray1);
	   display(sortArray2);
	   int i = length1-1-length2,j=length2-1,m=length1-1;
	   while(i>=0 && j>=0)
	   {
		   if(sortArray1[i]>sortArray2[j]){
			   sortArray1[m--]=sortArray1[i];
				   i--;
		   }
		   else
		   {
			   sortArray1[m--]=sortArray2[j];
			   j--;
		   }
	   }
	   if(i<j){
	   for(int k =0;k<=j;k++)
		   sortArray1[k]=sortArray2[j];
	   }
	   System.out.println("After merge:");
	   display(sortArray1);
	   display(sortArray2);
	}

	public static void display(int array[])
	{
		if(array.length>0)
		{
			int i=-1;
			System.out.print("[");
			while(++i<array.length)
			{
				System.out.print(" "+array[i]);
			}
			System.out.println(" ]");
		}
	}
	/*
	public static void main(String [] args)
	{
		P4_MergeArray merge = new P4_MergeArray();
		
        System.out.println("The matrix is exception! ");
		
		//test
		//founction test
		System.out.println("Founction Test:");
		int array1[] = new int[10];
		for(int i=0;i<5;i++)
		array1[i]=2*i+1;
		int array2[] = {2,4,6,8,10};
		//System.out.println("array1.length: "+array1.length);
		//System.out.println("array2.length: "+array2.length);
		merge.mergeSortArray(array1, array2);
		//boundary test		
		System.out.println("\nBoundary Test:");
        int array4 []={3};
        int array3 [] = new int[2];
        array3[0]=3;
        merge.mergeSortArray(array3, array4);
		
		//exception test		
		System.out.println("\nException Test:");
		int array_exception1 []=null;
		int array_exception2 []={};
		merge.mergeSortArray(array1, array_exception1);
		merge.mergeSortArray(array_exception1, array_exception2);
		merge.mergeSortArray(array1, array_exception2);
	}
	
	*/
}
