import java.util.ArrayList;
import java.util.List;


public class P62_SerializeBinaryTree {
	private static int index =0;
	public String serialization(BinaryTree tree)
	{
		if(tree == null ||tree.root== null)
		{
			System.out.println("NULL Exception!");
			return null;
		}
		StringBuilder Strtree =new StringBuilder();
		//Pre order traversal
		serializeRecursion(tree.root,Strtree);
		System.out.println("Serialization: "+Strtree);
		return Strtree.toString();
	}
	private void serializeRecursion(BinaryNode root, StringBuilder strtree) {
		// TODO Auto-generated method stub
		if(root == null)
		{
			strtree.append("$,");
			return ;
		}
		strtree.append(root.value).append(",");
		serializeRecursion(root.left,strtree);
		serializeRecursion(root.right,strtree);
	}
	public BinaryNode Deserialization(String StrSerialization)
	{
		if(StrSerialization == null || StrSerialization.length()<=0)
		{
			System.out.println("NULL or EMPTY excetion!");
			return null;
		}
		int index =0;
		List<String> list = new ArrayList<String>();
		while (index<StrSerialization.length())
		{
			int offset = index;
			while(offset<StrSerialization.length() && StrSerialization.charAt(offset)!=',')
			{
				offset++;
			} 
			list.add(StrSerialization.substring(index, offset));
			index = offset+1;
		}
		P62_SerializeBinaryTree.index =0;
		BinaryNode root =DeserializationRecursion(list);
		return root;
	}
	private void preOrder_recursion(BinaryNode root)
	{
		if(root == null)
			return ;
		System.out.print(root.toString());
		preOrder_recursion(root.left);
		preOrder_recursion(root.right);
	}
	private BinaryNode DeserializationRecursion(List<String> strList)
	{
		if( P62_SerializeBinaryTree.index >= strList.size()||strList.get(P62_SerializeBinaryTree.index).equals("$")){
			P62_SerializeBinaryTree.index++;
			return null;
		}
		BinaryNode root= new BinaryNode(Integer.valueOf(strList.get(P62_SerializeBinaryTree.index++ )));
		root.left   = DeserializationRecursion(strList);
		root.right = DeserializationRecursion(strList);
		   return root;
	}
	public static void main(String [] args)
	{

		P62_SerializeBinaryTree  test = new P62_SerializeBinaryTree ();
		//test
		//founction test
        System.out.println("Founction Test:");
        int [] pre1 ={1,2,3};
        int [] in1 = {2,1,3};
        BinaryTree tree1 = new BinaryTree (pre1,in1);
		tree1.preOrder();
		test.preOrder_recursion(test.Deserialization(test.serialization(tree1)));
		System.out.println();
		int [] pre ={1,2,4,8,9,5,10,11,3,6,12,13,7,14,15};
		int [] in = {8,4,9,2,10,5,11,1,12,6,13,3,14,7,15};
		BinaryTree tree = new BinaryTree (pre,in);
		tree.preOrder();
		test.preOrder_recursion(test.Deserialization(test.serialization(tree)));
		System.out.println();
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		//root
		int [] pre_a1 ={1};
		int [] in_a1 = {1};
		BinaryTree treeA1 = new BinaryTree (pre_a1,in_a1);
		treeA1.preOrder();
		test.preOrder_recursion(test.Deserialization(test.serialization(treeA1)));
		System.out.println();
		//only left child
		int [] preLeft ={5,4,3,2,1};
		int [] inLeft ={1,2,3,4,5};
		BinaryTree treeLeft = new BinaryTree (preLeft,inLeft);
		treeLeft.preOrder();
		test.preOrder_recursion(test.Deserialization(test.serialization(treeLeft)));
		System.out.println();
		//only right child
		int [] preRight ={1,2,3,4,5};
		int [] inRight ={1,2,3,4,5};
		BinaryTree treeRight = new BinaryTree (preRight,inRight);
		treeRight.preOrder();
		test.preOrder_recursion(test.Deserialization(test.serialization(treeRight)));
		System.out.println();
		
		//exception test		
		System.out.println("\nException Test:");
		//tree.preOrder();
		test.preOrder_recursion(test.Deserialization(test.serialization(null)));
		System.out.println();
	}
}