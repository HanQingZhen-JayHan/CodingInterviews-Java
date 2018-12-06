
public class P43_NumberProbabilityInNDices {

	public void probability(int n)
	{
		if(n<=0)
		{
			System.out.println("The number of Dices is exception! n= "+n);
			return;
		}
	System.out.println(n+" Dices :");	
	//recursion(n);
	int diceNumber = 6;
	int [] [] array = new int [2][n*diceNumber+1];
	int flag =0;
	for(int i =1; i<=diceNumber;i++)
		array[flag][i]=1;
	for(int k=2;k<=n;k++)
	{
		for(int j =0;j<k;j++)
		{
			array[1-flag][j]=0;
		}
		for(int i = k;i<=diceNumber*k;i++)
		{
			array[1-flag][i] = 0;
			for(int m=1;m<=i &&m<=diceNumber;m++)
				array[1-flag][i] += array[flag][i-m];
		}
		flag=1-flag;
	}
	int sum =0;
	for(int k =n;k<array[flag].length;k++){
		System.out.println((k)+": "+array[flag][k]);
		sum +=array[flag][k];
	}
	System.out.println("Sum = "+sum);
	}


	public static void main(String [] args)
	{

		P43_NumberProbabilityInNDices  test = new P43_NumberProbabilityInNDices ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int n=3;
		test.probability(n);
		test.probability(2);
		//boundary test		
		System.out.println("\nBoundary Test:");
		n=1;
		test.probability(n);
		//n = Integer.MAX_VALUE;
		n=10;
		test.probability(n);
		
		//exception test		
		System.out.println("\nException Test:");
		n=0;
		test.probability(n);
		n=-1;
		test.probability(n);
	}
}
