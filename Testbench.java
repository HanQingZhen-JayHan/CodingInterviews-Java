
public class Testbench {

	public static void main_temp(String [] args)
	{

        Testbench  test = new Testbench ();
		//test
		//founction test
		System.out.println("Founction Test:");
		
		//boundary test		
		System.out.println("\nBoundary Test:");

		
		//exception test		
		System.out.println("\nException Test:");
	}
	
	public void display(int [] array){
		if(array == null ||array.length<1)
		{
			System.out.println("The array is Exception!");
			return;
		}
		System.out.print("The array: [ ");
		for(int k:array)
			System.out.print(k+" ");
		System.out.println("]");
	}
	
	
	
	
	
	
	//4.MERGE SORT
	//1) merge sort  (stable) //down to top
	//Time complexity : O(n*logn)   Space complexity : O(n)
	public void mergeSort(int [] array)
	{
		if(array != null && array.length>0)
		{
			int [] Y = new int[array.length];
			int n = 1; // length of  subsequence to merge 1 2 4 8 ...2**n
			while(n<array.length)
			{
				mergePass(array,Y,n); //merge array to Y
				n = 2*n;
				//if(n<array.length)
				//{
					mergePass(Y,array,n); //reback merge Y to array
					n = 2*n;
				//}
			}
		}
	}	
	
	private void mergePass(int[] X, int[] Y, int n) {//all subarray merge
		// TODO Auto-generated method stub
		int start = 0;
		while(start<X.length-2*n+1) //double merge (two length of subarray is equal)
		{
			merge(X,Y,start,start+n,n);
			start +=2*n; //next start index
		}
		if(start+n<X.length)//two length of subarray isn't equal
			merge(X,Y,start,start+n,n);
		else
			for(int j = start;j<X.length;j++) //fragment
				Y[j] = X[j];
	}
	private void merge(int[] X, int[] Y, int start, int i, int n) { //two  adjacent sub array merge
		// TODO Auto-generated method stub
		int firstIndex = start;   //first sub array is in front ,second sub array is in behind means [first,second]
		int firstEnd  =i;
		int secondIndex = i;
		int Yindex = start;
		int len = n; //the length of merge array
		while(firstIndex<firstEnd && secondIndex<i+n && secondIndex<X.length) //firstIndex ,secondIndex must be valid
		{
			if(X[firstIndex]<X[secondIndex])
				Y[Yindex++] = X[firstIndex++];
			else
				Y[Yindex++] = X[secondIndex++];//smaller will be in the front of Y
		}
		while(firstIndex<firstEnd) // if first sub array is not empty
			Y[Yindex++] = X[firstIndex++];
		while(secondIndex<i+n && secondIndex<X.length) //if second sub array is not empty
			Y[Yindex++] = X[secondIndex++];
	}
	
}
