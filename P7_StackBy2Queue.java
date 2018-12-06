import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class P7_StackBy2Queue {
	public static Queue<Integer> queueA = new LinkedList<Integer>();
	public static Queue<Integer> queueB = new LinkedList<Integer>();
	public static boolean error = false;
	
	public static void push(int data)
	{
		int flag =0;
		error= false;
		if(queueA.isEmpty()){
			queueA.offer(data);
			flag =1;}
		else if(queueB.isEmpty()){
			queueB.offer(data);
			flag =2;}
		else
		{
			error = true;
			return;
		}
		if(flag ==1)
		{
			while(!queueB.isEmpty())
				queueA.offer(queueB.remove());
		}
		else if(flag ==2)
		{
			while(!queueA.isEmpty())
				queueB.offer(queueA.remove());
		}
		else
		{
			error = true;
			System.out.println("The push error!");
			return;
		}
		
	}
	public static int pop()
	{
		if(queueA.isEmpty() && queueB.isEmpty())
		{
			System.out.println("The queue is empty, can not pop anymore!");
			error = true;
			return -1;
		}
		else if(!queueA.isEmpty())
			return queueA.remove();
		
	   // if(!queueB.isEmpty())
			return queueB.remove();
	}
	public static void display()
	{
		System.out.println("Queue A:");
		Iterator iterator = queueA.iterator();
		while(iterator.hasNext())
			System.out.print(iterator.next()+" ");
		
		System.out.println();
		System.out.println("Queue B:");
		iterator = queueB.iterator();
		while(iterator.hasNext())
			System.out.print(iterator.next()+" ");
		System.out.println();
	}
	/*
	public static void main(String [] args)
	{

        P7_StackBy2Queue stack = new P7_StackBy2Queue();
		//test
		//founction test
		System.out.println("Founction Test:");
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.display();
		System.out.println("The pop of stack is :"+stack.pop());
		System.out.println("The pop of stack is :"+stack.pop());
		System.out.println("The pop of stack is :"+stack.pop());
		stack.display();
		stack.push(5);
		stack.push(6);
		stack.display();
		//boundary test		
		System.out.println("\nBoundary Test:");
		while(!stack.error)
			System.out.println("The pop of stack is :"+stack.pop());
		
		//exception test		
		System.out.println("\nException Test:");
		stack.push(1);
		System.out.println("The state of stack is :"+stack.error);
		
		System.out.println("The pop of stack is :"+stack.pop());
		System.out.println("The state of stack is :"+stack.error);
		stack.display();
		System.out.println("The pop of stack is :"+stack.pop());
		System.out.println("The state of stack is :"+stack.error);
		stack.display();
		System.out.println("The pop of stack is :"+stack.pop());
		System.out.println("The state of stack is :"+stack.error);
		stack.display();
		
	}
	*/
}
