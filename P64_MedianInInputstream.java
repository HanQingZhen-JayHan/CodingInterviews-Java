import java.util.Random;


public class P64_MedianInInputstream {
    int MAX_LENGTH = 15;
    int count=0;
	HeapMax max = new HeapMax(MAX_LENGTH);
	HeapMin min  = new  HeapMin(MAX_LENGTH);
	public int median(int n)
	{
		count++;
		if(count==1)//first
		{
			min.add(n);
			min.display();
			max.display();
			return min.peekMin();
		}
		else if((count&0x1) ==0) //even
		{
			max.add(n);
			if(min.peekMin()< max.peekMax())//swap
			{
				int temp = min.removeMin();
				min.add(max.removeMax());
				max.add(temp);
			}
			min.display();
			max.display();
			return (min.peekMin()+max.peekMax())>>1;
		}else{ //odd
		min.add(n);
		if(min.peekMin()< max.peekMax())//swap
		{
			int temp = min.removeMin();
			min.add(max.removeMax());
			max.add(temp);
		}
		min.display();
		max.display();
		return min.peekMin();
	}
	}
	public static void main(String [] args)
	{

		P64_MedianInInputstream  test = new P64_MedianInInputstream ();
		//test
		//founction test
		System.out.println("Founction Test:");
		Random random = new Random();
		for(int i=0;i<10;i++)
			System.out.println("Median :"+test.median(random.nextInt(20)));
		
		//boundary test		
		System.out.println("\nBoundary Test:");

		
		//exception test		
		System.out.println("\nException Test:");
	}
}
