
public class P30_KMins {

	public static void printKMins(int [] array, int k)
	{
		if(array == null )
		{System.out.println("The array is NULL!");
		return;
		}
		if(array.length<=0)
		{
			System.out.println("The array is EMPTY !");
			return;
		}
		if(k>array.length || k<=0)
		{
			System.out.println("The k is out boundary of array! k= "+k);
			return;
		}
//		solution_partion(array, k);
		solution_heap(array,k);
	}
	private static void solution_partion(int[] array, int k) {
		// TODO Auto-generated method stub
		Partition partition = new Partition();
		partition.minK(array, k);
	}
	private static void solution_heap(int[] array, int k) {
		// TODO Auto-generated method stub
		HeapMax  heapmax = new HeapMax(k);
		for(int i:array)
		{
			if(heapmax.size!=heapmax.maxsize)
			{
				heapmax.add(i);
			}
			else{
				if(i<heapmax.peekMax()){
					heapmax.removeMax();
					heapmax.add(i);
				}
			}
		}
		heapmax.display();
		
	}
	/*
	public static void main(String [] args)
	{

		P30_KMins  test = new P30_KMins ();
		
		int [] array = {4,5,2,3,1,9,30,6,5};
		int k=3;
		//test
		//founction test
		System.out.println("Founction Test:");
		test.printKMins(array, k);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		k =1;
		test.printKMins(array, k);
		k =2;
		test.printKMins(array, k);
		k = array.length;
		test.printKMins(array, k);
		k = array.length-1;
		test.printKMins(array, k);
		int [] arrayOne ={1};
		k =1;
		test.printKMins(arrayOne, k);
		
		//exception test		
		System.out.println("\nException Test:");
		k = 0;
		test.printKMins(array, k);
		k = array.length+1;
		test.printKMins(array, k);
		int [] arrayEmpty = {};
		k =3;
		test.printKMins(arrayEmpty, k);
		test.printKMins(null, k);
	}
	*/
}
