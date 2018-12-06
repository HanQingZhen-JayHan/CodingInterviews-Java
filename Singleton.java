
public class Singleton {
	private static Singleton singleton=new Singleton();
	
	private Singleton(){}
	
	public static Singleton getInstance()
	{
		return singleton;
	}
	
//	public static void  main(String [] args)
//	{
//		//test
//		Singleton test1 = Singleton.getInstance();
//		Singleton test2 = Singleton.getInstance();
//		
//		//should ouput true
//		System.out.println("Singleton Pattern Test:\n");
//		System.out.println("test1==test2:"+(test1==test2));
//	}
}
