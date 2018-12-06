
public class P56_EnterenceNodeOfCircle {

	public void findEnterence(SinglyLinkedList SLL)//suppose a circle in the singly linked list
	{
		if(SLL ==null || SLL.head.next == null)
		{System.out.println("Null Exception!");
		return;}
		Node p1 = SLL.head.next; //run one step;
		Node p2 = SLL.head.next; //run two steps
		//find the circle
		p1 = p1.next;
		p2 = p2.next.next;
		while(p1!= p2)
		{
			p1 = p1.next;
			p2 = p2.next.next;
		}
		//calculate length of circle
		int steps =1;
		p1 = p1.next;
		while(p1 != p2)
		{
			steps++;
			p1 = p1.next;
		}
		//find the enterence
		p1 = SLL.head.next;
		p2 = SLL.head.next;
		while(steps!=0)
		{
			p1 = p1.next;
			steps--;
		}
		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}
		System.out.println("Find the enterence :"+p1.value);
	}
	
	public static void main(String [] args)
	{

		P56_EnterenceNodeOfCircle  test = new P56_EnterenceNodeOfCircle ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array ={1,2,3,4,5,6,7,8,9};
		SinglyLinkedList SLL = new SinglyLinkedList(array);
		Node p= SLL.head.next;
		while(p.value !=5)
			p = p.next;
		SLL.rear.next = p;
		test.findEnterence(SLL);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		SLL.rear.next = SLL.head.next;
		test.findEnterence(SLL);
		SLL.rear.next = SLL.rear;
		test.findEnterence(SLL);
		int [] arrayOne = {1};
		SinglyLinkedList SLLOne = new SinglyLinkedList(arrayOne);
		SLLOne.rear.next=SLLOne.head.next;
		test.findEnterence(SLLOne);
		
		//exception test		
		System.out.println("\nException Test:");
		test.findEnterence(null);
	}
}
