
public class P37_TheFirstPublicNodeInTwoLinkedList {
	public void findThePublicNode(Node list1, Node list2)
	{
		if(list1 == null | list2 == null)
		{
			System.out.println("list1 or list2 is NULL!");
			return;
		}
		
		//print list
	System.out.print("The List1: ");	
	Node  p = list1;
	while(p!= null)
	{
		System.out.print(p.value+" ");
		p = p.next;
	}
	System.out.println();
	
	System.out.print("The List2: ");	
	p = list2;
	while(p!= null)
	{
		System.out.print(p.value+" ");
		p = p.next;
	}
	System.out.println();
	
	//check
	int length1 =0;
	p = list1;
	while(p!= null){  length1++; p = p.next; }
	int length2 =0;
	p = list2;
	while(p!= null){  length2++;  p = p.next;}
	Node p1 = list1;
	Node p2 = list2;
	if(length1>length2)
	{
		int diff = length1-length2;
		int count =0;
		while(diff != count & p1 != null)
		{
			count++;
			p1 = p1.next;
		}
	}
	else{
		int diff = length2-length1;
		int count =0;
		while(diff != count & p2 != null)
		{
			count++;
			p2 = p2.next;
		}
	}
	while(p1 != null && p2 != null)
	{
		if(p1 == p2)
		{
			break;
		}
		p1 = p1.next;
		p2 = p2.next;
	}
	if(p1 != null && p2 != null)
		System.out.println("Find the public node : "+p1);
	else
		System.out.println("NOT Find the public node !");
	}
	
	
	public static void main(String [] args)
	{

		P37_TheFirstPublicNodeInTwoLinkedList  test = new P37_TheFirstPublicNodeInTwoLinkedList ();
		//test
		//founction test
		System.out.println("Founction Test:");
		// not have
		int [] array1 = {1,9,4,6,3,8,2};
		SinglyLinkedList list1 = new SinglyLinkedList(array1);
		int [] array2 = {16,13,18,12};
		SinglyLinkedList list2 = new SinglyLinkedList(array2);
		test.findThePublicNode(list1.head.next, list2.head.next);
		
		//have
		Node publicNode = new Node(10);
		list1.rear.next = publicNode;
		list2.rear.next = publicNode;
		test.findThePublicNode(list1.head.next, list2.head.next);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		Node node1 = new Node(1);
		Node node2 = node1;
		test.findThePublicNode(node1, node2);
		test.findThePublicNode(list1.head.next, list1.head.next);
		
		//exception test		
		System.out.println("\nException Test:");
		test.findThePublicNode(null, null);
	}
}
