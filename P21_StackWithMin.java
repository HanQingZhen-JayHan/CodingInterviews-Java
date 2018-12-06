import java.util.Iterator;
import java.util.Random;
import java.util.Stack;


public class P21_StackWithMin {

	static Stack<Integer> dataStack = new Stack<Integer>();
	static Stack<Integer> minStack =  new Stack<Integer>();
	static boolean status= true;
	public static void push(int v)
	{
		System.out.println("Push a number: "+v);
		dataStack.push(v);
		status = true;
		System.out.println("The status of stack : "+status);
		if(minStack.isEmpty() )
		minStack.push(v);
			else if(v<minStack.peek())
				minStack.push(v);
		else 
			minStack.push(minStack.peek());
			
	}
	public static int pop()
	{
		if(dataStack.isEmpty())
		{
			System.out.println("The stack is EMPTY!");
			status = false;
			System.out.println("The status of stack : "+status);
			return -1;
		}
		System.out.println("Pop a number: "+dataStack.peek());
		minStack.pop();
		return dataStack.pop();
	}
	public static int min()
	{
		if(minStack.isEmpty()){
			status=false;
			return -1;
		}
		System.out.println("The min of stack is "+minStack.peek());
		return minStack.peek();
	}
	static void display()
	{
		if(dataStack.isEmpty())
			return;
		System.out.println("The stack contains :");
		Iterator<Integer> iterator = dataStack.iterator();
		while(iterator.hasNext())
			System.out.print(iterator.next()+" ");
	}
	/*
	public static void main(String [] args)
	{

		P21_StackWithMin  test = new P21_StackWithMin ();
		Random random = new Random();
		//test
		//founction test
		System.out.println("Founction Test:");
		int i =10;
		while(i-- >0)
		{
			test.push(random.nextInt(100));
			test.min();
		}

		//boundary test		
		System.out.println("\nBoundary Test:");
		//pop to empty
		i=11;
		while(i-->0)
		{
			test.pop();
			test.min();
		}
		//push the same number
		i=5;
		while(i-->0)
		{
			test.push(9);
			test.min();
		}
		//exception test		
		System.out.println("\nException Test:");
		// empty  then pop
		i=15;
		while(i-->0)
		{
			test.pop();
			test.min();
		}
	}
	*/
}
