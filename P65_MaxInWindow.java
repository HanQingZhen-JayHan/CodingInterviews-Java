import java.util.Deque;
import java.util.LinkedList;


public class P65_MaxInWindow {

	public void maxInWindow(int [] array, int windowSize)
	{
		if(array == null )
		{
			System.out.println("NULL EXCPTION!");
			return;
		}
		if(windowSize<1)
		{
			System.out.println("Window's length is illegal! windowSize = "+windowSize);
			return;
		}
		if(array.length<1 || array.length<windowSize)
		{
			System.out.println("The length of array si illegal! array.length = "+array.length+", windowSize = "+windowSize);
			return;
		}
		System.out.print("The array: [ ");
		for(int k:array)
			System.out.print(k+" ");
		System.out.println("]");
		
		Deque<Integer> dequeue = new LinkedList<Integer>();

		System.out.print("The max: [ ");
		for(int i=0; i<array.length;i++)
		{			//dequeue.peekFirst() means maxIndex
			if(!dequeue.isEmpty() && i>=dequeue.peekFirst()+3)// if maxIndex out of window, so delete
				dequeue.pollFirst();
			if(!dequeue.isEmpty() && array[i]>array[dequeue.peekFirst()]){// find new max
				dequeue.pollFirst();//delete old
				dequeue.offerFirst(i);//add new
			}
			else{                              //add last
				while(!dequeue.isEmpty() && array[i]>array[dequeue.peekLast()])// delete small
				{
					dequeue.pollLast();
				}
				dequeue.offerLast(i);
			}
			if(i>=2)//more 3 elements outputs
				System.out.print(array[dequeue.peekFirst()]+" ");//The max in the  current window	
		}
		System.out.println("]");
	}
	
	public static void main(String [] args)
	{

		P65_MaxInWindow  test = new P65_MaxInWindow ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array = {2,3,4,2,6,2,5,1};
		test.maxInWindow(array, 3);
		int [] arrayLong = {2,1,3,4,9,2,6,12,13,14,2,5,1};
		test.maxInWindow(arrayLong, 3);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] array3= {2,3,4};
		test.maxInWindow(array3, 3);
		int [] arraySame = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		test.maxInWindow(arraySame, 3);
		int [] arrayRasie ={1,2,3,4,5,6,7,8,9,10};
		test.maxInWindow(arrayRasie, 3);
		int [] arrayDes = {10,9,8,7,6,5,4,3,2,1};
		test.maxInWindow(arrayDes, 3);
		
		//exception test		
		System.out.println("\nException Test:");
		int [] arrayEmpty = {};
		test.maxInWindow(arrayEmpty, 3);
		int [] array2 = {1,2};
		test.maxInWindow(array2, 3);
		test.maxInWindow(array2, -1);
		test.maxInWindow(null, -1);
	}
}
