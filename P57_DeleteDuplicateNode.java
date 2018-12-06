
public class P57_DeleteDuplicateNode {

	public void deleteDuplicate(SinglyLinkedList SLL)
	{
		if(SLL == null)
		{
			System.out.println("NULL Exception!");
			return;
		}
		System.out.print("The original linked list: ");
		SLL.display();
		Node p = SLL.head.next;
		while(p!= null )
		{
			Node temp = p.next;
			while(temp != null && p.value == temp.value)
			{
				temp = temp.next;
			}
			p.next = temp;
			p = p.next;
		}
		System.out.print("After delete duplicate node linked list: ");
		SLL.display();
	}
	public static void main(String [] args)
	{

		P57_DeleteDuplicateNode  test = new P57_DeleteDuplicateNode ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array ={1,2,3,4,5,6,7,8,9};
		SinglyLinkedList SLL = new SinglyLinkedList(array);
		test.deleteDuplicate(SLL);
		int [] arrayDuplicate ={1,1,2,3,3,3,4,4,5,6,7,7,7,7,7,7,7,8,8,9};
		SinglyLinkedList SLLD = new SinglyLinkedList(arrayDuplicate);
		test.deleteDuplicate(SLLD);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] arrayOne = {1};
		SinglyLinkedList SLLOne = new SinglyLinkedList(arrayOne);
		test.deleteDuplicate(SLLOne);
		int [] arraySame= {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
		SinglyLinkedList SLLSame = new SinglyLinkedList(arraySame);
		test.deleteDuplicate(SLLSame);
		
		//exception test		
		System.out.println("\nException Test:");
		test.deleteDuplicate(null);
	}
}
