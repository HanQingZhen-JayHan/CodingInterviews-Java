import java.util.Random;


public class P29_ANumberAppearMoreThanAHalfInArray {

	public static void findANumber(int [] array)
	{
		if(array == null)
		{System.out.println("The array is NULL!");
		return;}
		if(array.length<=0)
		{
			System.out.println("The length of array is 0!");
			return;
		}
		solution_partition(array);
		solution_arrayFeature(array);
		
	}
	
	private static void solution_arrayFeature(int[] array) {
		// TODO Auto-generated method stub
		int number = array[0];
		int count = 1;
		for(int i = 1 ; i < array.length; i++)
		{
			if(count ==0){
				number = array[i];
				count++;
			}
			else
			{
				if(number == array[i])
					count++;
				else
					count--;
			}
						
		}
		System.out.println("Solution2: ");
		if(check(array,number)){
			System.out.print(number+" appears more than a half in array: [ ");
		}
		else
			System.out.print("No such a number appears more than a half in array: [");
		for(int k:array)
			System.out.print(k+" ");
		System.out.println("]");
	}
	private static boolean check(int [] array,int n)
	{
		int count =0;
		for(int k:array)
		{
			if(k == n)
				count++;
		}
		return count>array.length/2 ;
	}
	private static void solution_partition(int[] array) {
		// TODO Auto-generated method stub
		int start = 0;
		int end  = array.length-1;
		int mid = start +(end-start)/2;
		int index = partition(array,start,end);
		while(mid != index)
		{
			if(mid>index)
				index = partition(array,index+1,end);
			else
				index = partition(array,start,index-1);
		}
		System.out.println("Solution1: ");
		if(check(array,array[index])){
			System.out.print(array[index]+" appears more than a half in array: [ ");
		}
		else
			System.out.print("No such a number appears more than a half in array: [");
		for(int k:array)
			System.out.print(k+" ");
		System.out.println("]");
	}
public static void swap(int [] array,int i, int j)
{
	int temp = array[i];
	array[i] = array[j];
	array[j]= temp;
}
public static int partition(int [] array,int start, int end)
{
	Random random = new Random();
	int rand = 0;
	if(array.length>1)
		rand=start+random.nextInt(end-start);
	swap(array,rand,end);
	int target = end;
	while(end>start)
	{
		while(array[start]<=array[target] && end>start)
			start++;
		while(array[end]>=array[target]  && end>start)
			end--;
		if(end>start){
		int temp = array[start] ;
		array[start] = array[end];
		array[end] = temp;
		}
	}
	swap(array,start,target);
	return start;
}
/*
	public static void main(String [] args)
	{

		P29_ANumberAppearMoreThanAHalfInArray  test = new P29_ANumberAppearMoreThanAHalfInArray ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array={2,2,3,2,2,1,2,5,4};
		test.findANumber(array);
		//not find
		int [] arrayNo ={5,2,3,2,2,1,2,5,4};
		test.findANumber(arrayNo);
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] arrayOne={1};
		test.findANumber(arrayOne);
		//same
		int [] arraySame ={2,2,2,2,2,2,2,2,2};
		test.findANumber(arraySame);
		//balance
		int [] arrayBalance ={1,1,1,1,2,2,2,2};
		test.findANumber(arrayBalance);
		//Symmetric
		int [] arraySymmetric ={3,3,3,3,2,1,1,1,1};
		test.findANumber(arraySymmetric);
		//exception test		
		System.out.println("\nException Test:");
		int [] arrayEmpty ={};
		test.findANumber(arrayEmpty);
		test.findANumber(null);
		
	}
	*/
}
