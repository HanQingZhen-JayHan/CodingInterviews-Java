public class HeapMin {  
    private int[] heap;  
    private long maxSize;  
    private int size;  
  // public boolean full;
   //public boolean empty;
  
    public HeapMin(int maxSize) {  
    	if(maxSize<1)
    	{
    		System.out.println("The size of heap is illegal! maxSize = "+maxSize);
    		return;
    	}
        this.maxSize = maxSize;  
        this.heap = new int[maxSize+1];  
        this.size = 0;  
        heap[0] = Integer.MIN_VALUE;  
    }  
  private int getParent(int position)
  	{
	  return position/2;
  	}
  private int getLeftChild(int position)
  	{
	  return 2*position;
  	}
  private int getRightChild(int position)
  	{
	  return 2*position+1;
  	}
  private boolean isLeaf(int position)
  {
	  return (position> size/2) && (position<=size);
  }
  public void add(int data){
	  if(size == maxSize)
	  {
		  System.out.println("The heap is full, can not inseart any data! maxSize = "+maxSize);
		  return;
	  }
	 heap[++size]=data;
	 // shift up
	 int currentPosition = size;
	 int parentPosition  = getParent(currentPosition);
	 while(heap[currentPosition]<heap[parentPosition])
	 {
		 swap(currentPosition, parentPosition);
		 currentPosition = parentPosition;
		 parentPosition  = getParent(currentPosition);
	 }
  }
  public int removeMin()
  {
	  if(size<1)
	  {
		  System.out.println("Heap is empty!");
		  return -1;
	  }
	  int min = heap[1];
	  heap[1] = heap[size];
	  size--;
	  if(size<=1)
		  return min;
	  int currentPosition =1;
	  int smallChild=0;
	  //shift down
	  while( !isLeaf(currentPosition) )
	  {
		  smallChild = getLeftChild(currentPosition);
		  if(getRightChild(currentPosition)<size && heap[smallChild]>heap[getRightChild(currentPosition)])
			  smallChild = getRightChild(currentPosition);
		  if(heap[currentPosition]<=heap[smallChild] )
			  return min;
		  swap(smallChild,currentPosition);
		  currentPosition =  smallChild;

	  }
	  return min;
  }
  void swap(int i , int j)
  {
	  int temp = heap[i];
	  heap[i] = heap[j];
	  heap[j] = temp;
  }
  public int peekMin()
  {
	  if(size<1)
	  {
		  System.out.println("Heap is empty!");
		  return -1;
	  }
	  return heap[1];
  }
	public void display()
	{
		if (heap!= null &&heap.length>1){
		System.out.println("The Min Heap has "+size+" elsements:");
		for(int k=1;k<heap.length;k++)
		{
			System.out.print(heap[k]+" ");
		}
		System.out.println();
		}
	}
    public static void main(String args[])  
    {  
    	int n = 6;
        HeapMin hm = new HeapMin(n);  
        for(int i =n;i>-n;i--)
        	hm.add(i);  
        hm.display(); 
        for(int i =0;i<2*n;i++)
        	System.out.print(hm.removeMin()+" ");
        System.out.println() ;
          
    }  
}
