// heap is complete binary tree
public class HeapMax {

	int [] heap ;
	long maxsize;
	int size;
	public HeapMax(int maxsize)
	{
		if(maxsize<=0)
		{
			System.out.println("The size of heap is illegal! maxsize= "+maxsize);
			return;
		}
		this.size=0;
		this.maxsize = maxsize;
		this.heap = new int[maxsize+1];
		this.heap[0]= Integer.MAX_VALUE;
	}
	public int getLeftChild(int position)
	{
		return 2*position;
	}
	public int getRightChild(int position)
	{
		return 2*position+1;
	}
	public int getParent(int position)
	{
		return position/2;
	}
	public boolean isLeaf(int position)
	{
		return (position>size/2)&&(position<=size);
	}
	
	public void add(int element)
	{
		if(maxsize == size)
		{
			System.out.println("The heap is FULL! Cann't add any element. maxsize = "+maxsize);
			return;
		}
		size++;
		heap[size] = element;
		// heap shift up to keep max heap features;
		int current = size;
		while(heap[current]>heap[getParent(current)])
		{
			swap(current,getParent(current));
			current = getParent(current);
		}
		
	}
	public int removeMax()
	{
		if(size==0)
		{
			System.out.println("The heap is EMPTY! Cann't remove any element.");
			return -1;
		}
		swap(1,size);
		size--;
		//heap shift down to keep max heap features
		if(size!=0)
			heapShiftDown(1);
		return heap[size+1];
	}
	private void heapShiftDown(int position) {
		// TODO Auto-generated method stub
		int biggestChild;
		while(!isLeaf(position)){
			biggestChild= getLeftChild(position);
			if(biggestChild <size && (heap[biggestChild]<heap[getRightChild(position)]))
				biggestChild = getRightChild(position);
			if(heap[position]>= heap[biggestChild]) //end 
				return;
			swap(position,biggestChild);
			position = biggestChild;
		}
	}

	public void swap(int i, int j)
	{
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public void display()
	{
		if (heap!= null &&heap.length>0){
		System.out.println("The Max Heap has "+size+" elsements:");
		for(int k=1;k<heap.length;k++)
		{
			System.out.print(heap[k]+" ");
		}
		System.out.println();
		}
	}
	public int peekMax()
	{
		if(size!=0)
			return heap[1];
		else
		{
			System.out.println("The heap is EMPTY!");
			return -1;
		}
	}
    public static void main(String args[])  
    {  
    	int n = 6;
        HeapMax hm = new HeapMax(n);  
        for(int i =1;i<2*n;i++)
        	hm.add(i);  
        hm.display(); 
        for(int i =0;i<2*n;i++)
        	System.out.print(hm.removeMax()+" ");
        System.out.println() ;
          
    }  
}
