
public class P16_ReverseSinglyLinkedList {

	public static void reverse(SinglyLinkedList SLL)
	{
		if(SLL == null)
		{
			System.out.println("The Singly Linked List is NULL!");
			return;
		}
		SLL.reverseSinglyLinkedList();
		SLL.display();
	}
/*	
	public static void main(String [] args)
	{

		P16_ReverseSinglyLinkedList  test = new P16_ReverseSinglyLinkedList ();
		
		int [] array={1,2,3,4,5,6,7,8,9};
		SinglyLinkedList SLL = new SinglyLinkedList(array);
		//test
		//founction test
		System.out.println("Founction Test:");
		System.out.print("Original:");
		SLL.display();
		System.out.print("Reverse:");
		test.reverse(SLL);
		//boundary test		
		System.out.println("\nBoundary Test:");
        int [] array_singly ={1};
        SLL = new SinglyLinkedList(array_singly);
		System.out.print("Original:");
		SLL.display();
		System.out.print("Reverse:");
		test.reverse(SLL);
		
        int [] array_two ={1,2};
        SLL = new SinglyLinkedList(array_two);
		System.out.print("Original:");
		SLL.display();
		System.out.print("Reverse:");
		test.reverse(SLL);
		
		//exception test		
		System.out.println("\nException Test:");
		SLL = new SinglyLinkedList();
		System.out.print("Original:");
		SLL.display();
		System.out.print("Reverse:");
		test.reverse(SLL);
	}
	*/
}
