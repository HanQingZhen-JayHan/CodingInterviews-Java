
public class BinaryNode {
	int value;
	BinaryNode left;
	BinaryNode right;
	
	public BinaryNode()
	{
		this.value = 0;
		this.left   = null;
	    this.right = null;
	}
	public BinaryNode(int v)
	{
		this();
		this.value = v;
	}
	public BinaryNode(int v, BinaryNode left, BinaryNode right)
	{
		this.value = v;
		this.left   = left;
	    this.right = right;
	}
	
	public String toString()
	{
		return value+" ";
	}
}
