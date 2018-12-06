import java.util.Random;


public class SortedSinglyLinkedList<T extends Comparable<T>> {

	NodeT<T> head;
	int length;
	public SortedSinglyLinkedList()//head node sorted singly linked list
	{
		this.length = 0;
		head = new NodeT<T>();
	}
	public SortedSinglyLinkedList(T [] array)
	{
		this();
		if(array == null || array.length<1)
			return;
		int index = 0;
		while(index<array.length)
		{
			insert(array[index]);
			index++;
		}
	}
	public void insert(T x) {
		// TODO Auto-generated method stub
		if(x !=null){
			NodeT<T> p = this.head.next;
			NodeT<T> front = this.head;
			while(p != null && p.data.compareTo(x)<0)
			{
				front =p;
				p  = p.next;
			}
			front.next = new NodeT<T>(x,p);
			length++;
		}
	}
	public void remove(T x)
	{
		if(x !=null){
			NodeT<T> p = this.head.next;
			NodeT<T> front = this.head;
			while(p != null && p.data.compareTo(x)<0)
			{
				front =p;
				p  = p.next;
			}
			if(p!= null && p.data.compareTo(x)==0){
			front.next = p.next;
			length--;
			}
		}
	}
	public void print()
	{
		if(this.head.next == null)
			return;
		System.out.println(this.toString());
	}
	public String toString()
	{
		if(this.head.next == null)
			return null;
		NodeT<T> p =this.head.next;
		StringBuilder strBuilder = new StringBuilder();
		while(p != null)
		{
			strBuilder.append(p.data.toString());
			strBuilder.append("->");
			p = p.next;
		}
		strBuilder.append("null");
		return strBuilder.toString();
	}
	public static void main(String [] args)
	{


		//test
		//founction test
		System.out.println("Founction Test:");
		Integer [] array = {1,5,-90,3,8,11,54,15,-9,-100,100};
		SortedSinglyLinkedList<Integer>  test = new SortedSinglyLinkedList<Integer> (array);
		test.print();
		test.insert(new Integer(-1));
		test.print();
		test.remove(new Integer(-100));
		test.print();
		
		//boundary test		
		System.out.println("\nBoundary Test:");

		
		//exception test		
		System.out.println("\nException Test:");
	}
}
class NodeT<T>
{
	T data;
	NodeT<T> next;
	public NodeT()
	{
		data = null;
		next = null;
	}
	public NodeT(T value)
	{
		data = value;
		next  =null;
	}
	public NodeT(T value, NodeT<T> next)
	{
		data = value;
		this.next  =next;
	}
	public String toString()
	{
		return data.toString();
	}
}