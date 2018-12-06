
public class P13_AddNode {
	public static Node add(int v, Node p, Node head)
	{
		if(head == null)
			return new Node(v);
		if(p == null)
		{
			Node t = head;
			while(t.next != null)
				t = t.next;
			t.next = new Node(v);
			return head;
		}
		Node temp = new Node(p.value,p.next);
		p.next = temp;
		p.value = v ;
		
		return head;
	}
	static void display(Node head)
	{
		if(head != null)
		{
			Node p =head;
			while(p!=null){
				System.out.print(p+"->");
				p = p.next;
			}
			System.out.println();
		}
	}

	public static void main(String [] args)
	{

        P13_AddNode  test = new P13_AddNode ();
        
        
		//test
        Node head=null;
        Node tail =null;
		//boundary test		
		System.out.println("\nBoundary Test:");
		 head = test.add(4,null,head); //add when null
		//tail = head;
		display(head);
		head = test.add(1,head,head); //add when p =head
		display(head);
		head = test.add(3,head.next,head);//add when p=tail
		display(head);
		head = test.add(5,null,head);//add when p=null
		display(head);

		
		//founction test
		System.out.println("Founction Test:");
		head = test.add(2,head.next,head);
		display(head);

		//exception test		
		System.out.println("\nException Test:");
	}

}
