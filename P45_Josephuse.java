
public class P45_Josephuse {

	public void lastNumber(int n, int m)
	{
		if(n<1 || m<1)
		{
			System.out.println("There are some exception! n = "+n+", m= "+m);
			return;
		}
		System.out.println("Hello,  Josephuse!  n = "+n+", m= "+m);
		if(n == 1)
		{
			System.out.println("The last number is "+0);
			return;
		}
   solution1_formula(n,m);
	solution2_linkedList(n,m);
   //solution3
   System.out.println("Recursion: The last number is "+recursion(n,m));
	}
	
	private void solution1_formula(int n, int m) {
		// TODO Auto-generated method stub
		if(n<1 |m<1)
			return;
		int last =0;
		for(int i = 2;i<=n;i++)//反向重建递归，因为知道边界值，向上递推
			last = (last+m)%i;
		System.out.println("Formula: The last number is "+last);

	}
public int recursion(int n,int m)
{
	if(n<1 |m<1)  //exception
		return -1;
	if(n == 1)    //boudary 
		return 0;
	int last = (recursion(n-1,m)+m)%n;
	return last;
}
	private void solution2_linkedList(int n, int m) {
		// TODO Auto-generated method stub
		int [] josephuse = new int[n];
		for(int i=0;i<n;i++)
			josephuse[i]=i;
		SinglyLinkedList SLL = new SinglyLinkedList(josephuse);
		SLL.rear.next = SLL.head.next;
		int count =1;
		int number =n;
		Node p = SLL.head.next;
// 0 1 2 3 4 5 6 7 8 9 10:josephuse
// 1 2 3 1 2 3 1 2 3 1 2  :index
//    p x                          :p
// 1 2 0 1 2 0 1 2 0 1 2  :count
	
		while(number != 1)
		{
			if(count == m-1)
			{
				count =0;
				//System.out.println("The delete number is "+p.next.value);
				p.next = p.next.next;
				number --;
			}
			count++;
			p = p.next;
		}
		System.out.println("LinkedList: The last number is "+p.value);
	}


	public static void main(String [] args)
	{

		P45_Josephuse  test = new P45_Josephuse ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int n=5;
		int m = 3;
		test.lastNumber(n, m);
		n = 11;
		test.lastNumber(n, m);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		n =1;
		test.lastNumber(n, m);
		//n =Integer.MAX_VALUE;
		n =1000;
		test.lastNumber(n, m);
		
		//exception test		
		System.out.println("\nException Test:");
		n=0;
		test.lastNumber(n, m);
		m=-1;
		test.lastNumber(n, m);
	}
}
