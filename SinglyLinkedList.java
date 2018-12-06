import java.util.Stack;


public class SinglyLinkedList {
	Node head,rear;
	
	public SinglyLinkedList(){head = rear= new Node();} //Empty SinglyLinkedList also has a head node
	public SinglyLinkedList(int []  array)
	{
		this();
		if(array == null | array.length<=0)
		{
			System.out.println("The array is exception!");
			return;
		}
		for(int i = 0;i<array.length;i++)
		{
			rear.next = new Node(array[i],null);
			rear = rear.next;
		}
	}
	public void display()
	{
		Node p = head.next;
		
		System.out.print("\nhead->");
		while(p!=null)
		{
			System.out.print(p.toString()+"->");
			p = p.next;
		}
		System.out.println("null");
	}
	
	public void reverseDisplay()
	{
		Node p = head.next;
		String reverseStr = new String();
		System.out.print("\nnull<-");
		while(p!=null)
		{
			reverseStr = p.toString()+"<-"+reverseStr;
			p = p.next;
		}
		System.out.println(reverseStr+"head");
	}
	
	public void reverseDisplay_stack()
	{
		Stack<String> stack = new Stack<String>();
		Node p = head.next;
		System.out.print("\nnull");
		while(p!=null)
		{
			stack.push(p.toString());
			stack.push("<-");		
			p = p.next;
		}
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop());
		}
		System.out.println("<-head");
	}
	public void reverseDisplay_recursion(Node p)
	{
		if(p==null)
			return;
	    reverseDisplay_recursion(p.next);	
		System.out.print(p.toString()+"<-");
	}
	
	public void reverseSinglyLinkedList()
	{
		if(this.head.next == null)
		{
			System.out.println("The singly linked list is empty!");
			return ;
		}
		Node front=null;
		Node p = this.head.next;
		Node next = p.next;
		
		while(next!= null)
		{
			p.next = front;
			front = p;
			p = next;
			next = next.next;
		}
		p.next = front;
		this.head.next = p;
	}
}
