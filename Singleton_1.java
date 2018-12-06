
public class Singleton_1 {
	private volatile static Singleton_1 singleton;
	private Singleton_1(){}
	
	private static Singleton_1 getInstance(){
		if(singleton == null)
		{
			synchronized(Singleton_1.class){         
				if(singleton == null){
			    singleton = new Singleton_1();
				}
				}
		}
		return singleton;
	}
	
//	public static void main(String [] args)
//	{
//		//test
//		Singleton_1 test1 = Singleton_1.getInstance();
//		Singleton_1 test2 = Singleton_1.getInstance();
//		
//		System.out.println("Singleton Pattern Test:\n");
//		System.out.println("test1 == test2:"+(test1==test2));
//	}
}
