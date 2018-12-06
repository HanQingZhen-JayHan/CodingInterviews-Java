
public class P26_CopyOfComplexList {

	public static void copy(ComplexNode cNode)
	{
		if(cNode == null)
		{
			System.out.println("The Complex Node  is NULL!");
			return;
		}
		System.out.println("The original complex list: ");
		display(cNode);
		//first step: copy node
		ComplexNode p = cNode;
		while(p !=null)
		{
			ComplexNode temp =  new ComplexNode(p.value,p.next,null);
			p.next = temp;
			p = p.next.next;
		}
		System.out.println("Step1: copy node");
		display(cNode);
		//second step: copy sibling link
		ComplexNode original = cNode;

		while(original != null)
		{
			ComplexNode copy     = original.next;
			if(original.sibling != null)
				copy.sibling = original.sibling.next;
			original = original.next.next;

		}
		System.out.println("Step2: copy sibling link");
		display(cNode);
		//third step: split to two complex link
		ComplexNode original_head = cNode;
		ComplexNode copy_head     = original_head.next;
		original = original_head;
		ComplexNode copy     = copy_head;
		while(original != null)
		{

			original.next = original.next.next;
			original = original.next;
			if(original != null){
				copy.next = copy.next.next;
				copy = copy.next;
			}
		}
		//cut tail(last node of copy)
		//original.next =null;
		System.out.println("Step3: "
				+ "The original(split) complex list: ");
		display(original_head);
		System.out.println("The copy complex list: ");
		display(copy_head);
	}
	
	public static void display(ComplexNode cn)
	{
		while(cn!=null)
		{
			System.out.print(cn.value+"(sibling: ");
			if(cn.sibling!= null)
				System.out.print(cn.sibling.value+" )->");
			else
				System.out.print("null )->");
			cn = cn.next;
		}
		System.out.println();
	}
	/*
	public static void main(String [] args)
	{
		P26_CopyOfComplexList  test = new P26_CopyOfComplexList ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int n=5;
		ComplexNode [] complexNodeArray = new ComplexNode[n];
		for(int i =0 ; i<n;i++)
			complexNodeArray[i] = new ComplexNode(i);
		for(int i = 0;i<n-1;i++)
			complexNodeArray[i].next = complexNodeArray[i+1] ;
		complexNodeArray[0].sibling = complexNodeArray[2];
		complexNodeArray[1].sibling = complexNodeArray[4];
		complexNodeArray[3].sibling = complexNodeArray[1];
		//complexNodeArray[0].sibling = complexNodeArray[2];
		//complexNodeArray[0].sibling = complexNodeArray[2];
		test.copy(complexNodeArray[0]);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		//one node
		ComplexNode oneNode = new ComplexNode();
		oneNode.sibling = oneNode;
		test.copy(oneNode);
		
		//exception test		
		System.out.println("\nException Test:");
		//null
		test.copy(null);
	}
	*/
}
