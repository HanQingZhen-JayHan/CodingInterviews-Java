
public class P15_ThePenultimateNodeK {

	public static void KNodeFromBottom(SinglyLinkedList SLL, int k)
	{
		if(SLL == null || k<=0)
		{
			System.out.println("The SinglyLinkedList is NULL or k <=0!");
			return;
		}
		int count = 0;
		Node target = null ;
		Node p = SLL.head.next;
		while(p!=null)
		{
			count++;
			if(count > k)
				target = target.next;
			else
				target = SLL.head.next;
			p = p.next;
		}
		if(count>= k)
			System.out.println("Find the Node: "+target.value+", from bottom "+k);
		else
			System.out.println("Not Find! "+"from bottom "+k);
	}
	/*
	public static void main(String [] args)
	{

		P15_ThePenultimateNodeK  test = new P15_ThePenultimateNodeK ();
		
		int [] array ={1,2,3,4,5,6,7,8,9};
		SinglyLinkedList SLL =new SinglyLinkedList(array);
		int k=1;
		for (int i : array)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		//test
		//founction test
		System.out.println("Founction Test:");
		k=3; //find
		test.KNodeFromBottom(SLL, k);
		k =10;//not find
		test.KNodeFromBottom(SLL, k);
		//boundary test		
		System.out.println("\nBoundary Test:");
		k=1;
		test.KNodeFromBottom(SLL, k);
		k=array.length;
		test.KNodeFromBottom(SLL, k);
		//exception test		
		System.out.println("\nException Test:");
		k=-1;
		test.KNodeFromBottom(SLL, k);
		SLL=null;
		test.KNodeFromBottom(SLL, k);
	}
	*/
}
