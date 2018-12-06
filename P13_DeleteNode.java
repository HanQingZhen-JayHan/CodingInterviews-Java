import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class P13_DeleteNode {

	public static void delete(Node p, Node head)
	{
		if(p == null |head == null)
		{
			System.out.println("The P node or Head node is NULL! ");
			return;
		}
		if(p.next==null) //p is tial node
		{
			Node front = head;
			Node temp = front.next;
			while(temp != p)
			{
				front = temp;
				temp = temp.next;
			}
			temp=null;
			return;
		}
		p.value = p.next.value ;
		p.next = p.next.next;
	}
	public static void display(Node p)
	{
		while(p!=null){
			System.out.print(p+"->");
			p = p.next;
		}
		System.out.println();
	}
	public static void display_list(List list)
	{
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+"("+i+")->");
		System.out.println();
	}
	/*
	public static void main(String [] args)
	{
        
        P13_DeleteNode  test = new P13_DeleteNode ();
        LinkedList<Node> list = new LinkedList<Node>();
        Node head = new Node();
        Node p = head;   //point
        int n=10;
        for(int i=0;i<n;i++){
        	p.next=new Node(i,null); //point
        	list.add(p.next);
        	//list.set(i, p);
        	p=p.next;
        }
        display(head.next);
        display_list(list);
        System.out.println("The head of list is "+list.getFirst());
        System.out.println("The tail of list is "+list.getLast());
		//test
		//founction test
		System.out.println("Founction Test:");
		test.delete(list.get(5),head);
		display(head.next);
		display_list(list);
		
		//boundary test		//ps one node list not test.
		System.out.println("\nBoundary Test:");
		test.delete(list.get(0),head);
		display(head.next);
		display_list(list);
		test.delete(list.get(n-1),head);
		display(head.next);
		display_list(list);
		
		//exception test		
		System.out.println("\nException Test:");
		test.delete(null,null);
		display(head.next);
		display_list(list);
	}
	*/
}
