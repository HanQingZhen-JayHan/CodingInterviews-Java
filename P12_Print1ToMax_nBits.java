
public class P12_Print1ToMax_nBits {

	public static void print(int n)
	{
		if(n<1)
		{
			System.out.println("The n is illegal! n= "+n);
			return;
		}
		char [] number = new char[n];
		for(int i=0;i<=9;i++)
		{
			number[0]=(char) (i+'0');
			recursion(number,1,n);
		}
	}
	private static void recursion(char[] number, int index,int n) {
		// TODO Auto-generated method stub
		if(n == index)
		{
			int j=n-1;
			for(int m=0;m<n;m++)
				if(number[m]!='0'){
					j=m;
					break;}
			
			for (;j<n;j++)
			        System.out.print(number[j]);
			System.out.println();
			return;
		}
		for(int k =0;k<=9;k++)
		{
			number[index]=(char) (k+'0');
			recursion(number,index+1,n);
		}
	}
	/*
	public static void main(String [] args)
	{
        System.out.println("The matrix is exception! ");
        P12_Print1ToMax_nBits  test = new P12_Print1ToMax_nBits();
		//test
		//founction test
		System.out.println("Founction Test:");
		int n =3;
		test.print(n);
		//boundary test		
		System.out.println("\nBoundary Test:");
		n=1;
		test.print(n);
		//n=0x7fffffff;
		
		//exception test		
		System.out.println("\nException Test:");
		n = 0;
		test.print(n);
		n = -3;
		test.print(n);
	}
	*/
}
