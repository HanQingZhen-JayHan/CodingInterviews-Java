import java.util.Iterator;
import java.util.Stack;


public class P7_QueueBy2Stacks {

	public static Stack<Integer> stackA  ;
	public static Stack<Integer> stackB ;
	public static boolean error = false;

	public P7_QueueBy2Stacks()
	{
		stackA   =new Stack<Integer>();
		stackB = new Stack<Integer>();
	}
	
	public  void appendTail(int tail)
	{
		stackA.push(tail);
		error = false;
	}
	
	public static int deleteHead()
	{
		if(stackA.isEmpty() && stackB.isEmpty())
		{
			error= true;
			return -1;
		}
		if(stackB.isEmpty())
		{
			while(!stackA.isEmpty())
				stackB.push(stackA.pop());
			return stackB.pop();
		}
		return stackB.pop();
		
	}
	public static void display()
	{
		System.out.println("Stack A :");
		Iterator iterator = stackA.iterator();
		while(iterator.hasNext())
		{
			System.out.print(iterator.next().toString()+" ");
		}
		System.out.println();
		System.out.println("Stack B :");
		iterator = stackB.iterator();
		while(iterator.hasNext())
		{
			System.out.print(iterator.next().toString()+" ");
		}
		System.out.println();
	}
	/*
	public static void main(String [] args)
	{
        System.out.println("The matrix is exception! ");
        P7_QueueBy2Stacks queue = new P7_QueueBy2Stacks();
		//test
		//founction test
		System.out.println("Founction Test:");
		queue.appendTail(1);
		queue.appendTail(2);
		queue.appendTail(3);
		queue.appendTail(4);
		queue.display();
		System.out.println("The delete head of queue is :"+queue.deleteHead());
		System.out.println("The delete head of queue is :"+queue.deleteHead());
		queue.display();
		queue.appendTail(5);
		queue.appendTail(6);
		queue.display();
		//boundary test		
		System.out.println("\nBoundary Test:");
       while(!queue.error)
    	   System.out.println("The delete head of queue is :"+queue.deleteHead());
   		queue.display();
		
		//exception test		
		System.out.println("\nException Test:");
		queue.appendTail(1);
		System.out.println("The state of queue is :"+queue.error);
		queue.display();

		System.out.println("The first delete head of queue is :"+queue.deleteHead());
		System.out.println("The state of queue is :"+queue.error);
		queue.display();
		
		
		System.out.println("The second delete head of queue is :"+queue.deleteHead());
		System.out.println("The state of queue is :"+queue.error);
		queue.display();
	}
	*/
}
