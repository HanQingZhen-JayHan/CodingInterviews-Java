
public class P4_ReplaceBlank {

	
	public String replaceBlank(String str) {
		// TODO Auto-generated method stub
		if(str == null || str.length()<=0){
	        System.out.println("The String is exception! ");
			return null;
		}
		int length = str.length();
		StringBuilder stringBuilder = new StringBuilder();
		for(int i =0;i<length;i++)
			if(str.charAt(i)==' ')
				stringBuilder.append("%20");
			else
				stringBuilder.append(str.charAt(i));
		
		return stringBuilder.toString();
	}
	
	public static void main(String [] args){
		
		P4_ReplaceBlank test = new P4_ReplaceBlank();
		
		//test
		//founction test
		System.out.println("Founction Test:");
		String str = "We are happy!";
		System.out.println("The Original : "+str);
		System.out.println("Repalced: "+test.replaceBlank(str));

		//boundary test		
		System.out.println("\nBoundary Test:");
		String str1 = "Wearehappy!";
		System.out.println("The Original : "+str1);
		System.out.println("Repalced: "+test.replaceBlank(str1));
		String str2 = "         ";
		System.out.println("The Original : "+str2);
		System.out.println("Repalced: "+test.replaceBlank(str2));
		
		//exception test		
		System.out.println("\nException Test:");
		String str3 = "";
		System.out.println("The Original : "+str3);
		System.out.println("Repalced: "+test.replaceBlank(str3));
		String str4 = null;
		System.out.println("The Original : "+str4);
		System.out.println("Repalced: "+test.replaceBlank(str4));

	}


}
