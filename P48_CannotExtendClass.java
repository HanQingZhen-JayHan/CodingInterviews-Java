
public class P48_CannotExtendClass 
//extends FinalClass      //syntax error:The type P48_CannotExtendClass cannot subclass the final class FinalClass
//extends PrivateClass   //syntax error:Implicit super constructor PrivateClass() is not visible for default constructor. Must define an explicit constructor
{

}
final class FinalClass{
	public FinalClass()
	{
		System.out.println("The class is final type, so cann't be extend!");
	}
}

class PrivateClass{
	private PrivateClass(){
		System.out.println("The class is private construct, so cann't be extends !");
	}
}