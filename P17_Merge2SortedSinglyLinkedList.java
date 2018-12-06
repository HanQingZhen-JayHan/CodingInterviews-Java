
public class P17_Merge2SortedSinglyLinkedList {

	public static void merge(SinglyLinkedList SLL1, SinglyLinkedList SLL2)
	{
		if(SLL1 == null || SLL2 == null)
		{
			if(SLL1 != null)
			{
				SLL1.display();
			}
			else if(SLL2 != null)
			{
				SLL2.display();

			}
			else
			{
				System.out.println("Two Singly Linked Lists are NULL! ");
			}
			return;
		}
		if(SLL1 == SLL2)
		{
			System.out.println("The two Singly Linked Lists are the same addree in the ram!");
			SLL1.display();
			return;
		}
		Node p1 = SLL1.head.next;
		Node p2 = SLL2.head.next;
		Node p  = SLL1.head ;
		while(p1!= null && p2!= null)
		{
			if(p1.value<p2.value)
			{
				p.next = p1;
				p1= p1.next;	
				p = p.next;
			}
			else if(p1.value >p2.value)
			{
				p.next = p2;
				p2 = p2.next;
				p = p.next;
			}
			else
				p2 = p2.next;
		}
		if(p1!=null)
		{p.next = p1;}
		else
			p.next = p2;
		
			SLL1.display();
	}
	
	public static Node merge_recursion(Node head1, Node head2)
	{
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		Node head;
		if(head1.value < head2.value)
		{
			head =head1;
			head1 = head1.next;
		}
		else{
			head = head2;
			head2 = head2.next;
		}
		head.next = merge_recursion(head1,head2);
		return head;
	}
	public static void recursionMergeTest(Node head1, Node head2)
	{
		Node head = merge_recursion(head1,head2);
		System.out.println("The merge in recursion method:");
		while(head!= null)
		{
			System.out.print(head.value+" ");
			head = head.next;
		}
		System.out.println();
	}
	/*
	public static void main(String [] args)
	{

		P17_Merge2SortedSinglyLinkedList  test = new P17_Merge2SortedSinglyLinkedList ();
		/*  
		 //   not a recursion test
		int [] array1 ={1,3,4,5,6,8};
		SinglyLinkedList SLL1 = new SinglyLinkedList(array1);
		int [] array2 ={1,2,3,6,7,8,10,11,12};
		SinglyLinkedList SLL2 = new SinglyLinkedList(array2);
		//test
		//founction test
		System.out.println("Founction Test:");
		test.merge(SLL1, SLL2);

		//boundary test		
		System.out.println("\nBoundary Test:");
		int[] array1_singly  ={3};
		SinglyLinkedList SLL1_boundary = new SinglyLinkedList(array1_singly);
		int [] array2_singly ={5};
		SinglyLinkedList SLL2_boundary  = new SinglyLinkedList(array2_singly);
		test.merge(SLL1_boundary, SLL2_boundary);
		
		SLL1 = new SinglyLinkedList(array1);
		SLL2 = new SinglyLinkedList(array2);
		test.merge(null, SLL2);
		test.merge(SLL1, null);
		
		test.merge(SLL1, SLL1);//the same address in ram!
		//recursionMergeTest(SLL1.head.next,SLL1.head.next);
		int [] array1_copy = {1,3,4,5,6,8};
		SLL2 = new SinglyLinkedList(array1_copy);
		test.merge(SLL1, SLL2);
		
		//exception test		
		System.out.println("\nException Test:");
		test.merge(null, null);
*/
	/*	
		//recursion test
		int [] array1 ={1,3,4,5,6,8};
		SinglyLinkedList SLL1 = new SinglyLinkedList(array1);
		int [] array2 ={1,2,3,6,7,8,10,11,12};
		SinglyLinkedList SLL2 = new SinglyLinkedList(array2);
		//test
		//founction test
		System.out.println("Founction Test:");
		recursionMergeTest(SLL1.head.next,SLL2.head.next);
		//boundary test		
		System.out.println("\nBoundary Test:");
		int[] array1_singly  ={3};
		SinglyLinkedList SLL1_boundary = new SinglyLinkedList(array1_singly);
		int [] array2_singly ={5};
		SinglyLinkedList SLL2_boundary  = new SinglyLinkedList(array2_singly);
		recursionMergeTest(SLL1_boundary.head.next,SLL2_boundary.head.next);
		
		SLL1 = new SinglyLinkedList(array1);
		SLL2 = new SinglyLinkedList(array2);
		recursionMergeTest(null,SLL2.head.next);
		recursionMergeTest(SLL1.head.next,null);
		

		//recursionMergeTest(SLL1.head.next,SLL1.head.next);  //cant not test cycle
		int [] array1_copy = {1,3,4,5,6,8};
		SLL2 = new SinglyLinkedList(array1_copy);
		recursionMergeTest(SLL1.head.next,SLL2.head.next);
		//exception test		
		System.out.println("\nException Test:");
		recursionMergeTest(null,null);
		
	}
	
	*/
}
