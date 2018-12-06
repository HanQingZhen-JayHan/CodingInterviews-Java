
public class P5_ReverseDisplayLinklist {

	public static void reverseDidplay(SinglyLinkedList SLL )
	{
		if(SLL == null)
		{
			System.out.println("The singlyLinkedList is exception!");
			return;
		}
		SLL.reverseDisplay();
		//SLL.reverseDisplay_stack();
		//SLL.reverseDisplay_recursion(SLL.head.next);
	}
	
/*	
	public static void main(String [] args)
	{

        P5_ReverseDisplayLinklist ReverseDisplay =new P5_ReverseDisplayLinklist();
        
		//test
        int array [] = {1,2,3,4,5};
        SinglyLinkedList SLL = new SinglyLinkedList(array);
        System.out.println("The original linkedlist:");
        SLL.display();
		//founction test
		System.out.println("Founction Test:");
		System.out.println("The reverse linkedlist:");
		ReverseDisplay.reverseDidplay(SLL);

		
		//boundary test		
		System.out.println("\nBoundary Test:");
        int array1 [] = {1};
        SLL = new SinglyLinkedList(array1);
        ReverseDisplay.reverseDidplay(SLL);
        
		//exception test		
		System.out.println("\nException Test:");
        int array_exception [] = {};
        SLL = new SinglyLinkedList(array_exception);
        ReverseDisplay.reverseDidplay(SLL);
        ReverseDisplay.reverseDidplay(null);
        
	}
	*/
}
