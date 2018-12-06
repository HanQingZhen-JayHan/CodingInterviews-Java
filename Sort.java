
public class Sort {
	
	//1.INSERTION SORT
	//1) straight insertion sort  (stable)
	//Time complexity : O(n*n)   Space complexity : O(1)
	public void straightInertionSort(int [] array)
	{
		if(array != null && array.length>0)
		{
			for(int i = 1;i<array.length;i++)
			{
				int temp = array[i];
				int j = 0;
				for(j = i-1; j>=0 && temp <array[j];j--)//front i th is sorted members
					array[j+1] = array[j];
				array[j+1]  = temp; //the right position
			}
				
		}
	}
	//2)  shell sort  (unstable)
	//Time complexity : O(n*logn*logn)   Space complexity : O(1)
	public void shellSort(int [] array)
	{
		if(array != null && array.length>0)
		{
			for(int delta = array.length/2;delta>0;delta /=2)  // delta increment 
				for(int i = delta;i<array.length;i++)               //group
				{
					int temp = array[i],j;
					for(j = i-delta;j>=0 &&temp<array[j];j-=delta)//from end
						array[j+delta]= array[j];
					array[j+delta] = temp; //insert
				}
		}
	}
	//2.SWAP SORT
	//1) bubble sort  (stable)
	//Time complexity : O(n*n)   Space complexity : O(1)
	public void bubbleSort(int [] array)
	{
		boolean exchange = true;
		if(array != null && array.length>0)
		{
			for(int i =1; exchange && i<array.length;i++)
			{
				exchange = true;
				for(int j=0;j<array.length-i;j++)
					if(array[j]>array[j+1]) //neighbor members swap
					{
						int temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
						exchange = true;
					}
			}
		}
	}
	//2) quick sort  (unstable) partition
	//Time complexity : O(n*logn)   Space complexity : O(1)
	public void quickSort(int [] array)
	{
		if(array != null && array.length>0)
		{
			int start = 0;
			int end = array.length-1;
			quickSortRecursion(array,start,end);
		}
	}
		private void quickSortRecursion(int[] array, int start, int end) {
			// TODO Auto-generated method stub
			if(end < start)
				return;
			int target = array[start];
			int index_start = start;
			int index_end  = end;
			while(index_end!=index_start)
			{
				while(index_end>index_start && target <= array[index_end]) // fill the hole（target）
					index_end--;
				if(index_end > index_start){
					array[index_start] = array[index_end];
					index_start++;
				}
				while(index_end >index_start && target >= array[index_start]) //fill the hole (index_end)
					index_start++;
				if(index_end > index_start){
					array[index_end] = array[index_start];
					index_end--;
				}
			}
			array[index_start] = target;    //find the right position
			quickSortRecursion(array,start,index_start-1);
			quickSortRecursion(array,index_start+1,end);
		}
		//3.SELECT SORT
		//1) straight select sort  (stable)
		//Time complexity : O(n*n)   Space complexity : O(1)
		public void straightSelectSort(int [] array)
		{
			if(array != null && array.length>0)
			{
				for(int i = 0 ;i<array.length -1;i++)
				{
					int min = i;   //storage index
					for(int j = i+1;j<array.length;j++)
						if(array[j]<array[min]) //challenge
							min = j;
					if(min != i)
					{
						int temp = array[min];
						array[min] = array[i];
						array[i]= temp;
					}
				}
			}
		}	
		//2) heap sort  (unstable)
		//Time complexity : O(n*logn)   Space complexity : O(1)
		public void heapSort(int [] array)
		{
			if(array != null && array.length>0 )
			{
				for(int i = (array.length/2) -1;i>=0;i--)//generate heap  [0,array.lengt/2] are not leafs,[array.lengt/2 -1, array.length-1] are leafs
					adjustHeap(array,i,array.length-1);
				for(int j = array.length-1;j>0;j--)
				{
					int temp = array[0];
					array[0] = array[j];
					array[j] = temp;
					adjustHeap(array,0,j-1);//select biggest and put in last every time
				}
			}
		}	
	private void adjustHeap(int[] array, int start, int end) {
			// TODO Auto-generated method stub
			int root = start; //root begin 0
			int leftChild = 2*root+1;// left is 1
			int rightChild = 2*root+2;// right is 2
			int target  = array[root];
			while(leftChild<=end)
			{
				int index = leftChild;
				if(leftChild<end && array[leftChild]<array[rightChild])//select big child
					index = rightChild;
				if(target<array[index])
				{
					array[root] = array[index];  //select bigger in root
					root = index;
					leftChild = 2*root+1;
					rightChild = 2*root+2;
				}
				else break;
			}
			array[root]=target;
		}
	//4.MERGE SORT
	//1) merge sort  (stable) //down to top
	//Time complexity : O(n*logn)   Space complexity : O(n)
	public void mergeSort(int [] array)
	{
		if(array != null && array.length>0)
		{
			//down to up 
				mergeDown2Up(array);
			
			//recursion solution up to down
			//System.out.println("Recursion Solution:");
			//mergeSortRecursion(array,0,array.length);
		}
	}	
	
	
	private void mergeDown2Up(int[] array) {
		// TODO Auto-generated method stub
		int n=1;
		while(n<array.length){
			int start = 0;
		for(start = 0;start+2*n< array.length;start +=2*n)
			merge(array,start,start+n,start+2*n);
		if(n+start<array.length)
			merge(array,start,start+n,array.length);
		n *=2;
		}
	}
	private void merge(int[] array, int start, int mid, int end) {
		// TODO Auto-generated method stub
		if(end>start){
		int length = end-start;
		int [] temp = new int[length];
		
		int index = 0;
		int index1 = start;
		int index2 = mid;
		while(index1<mid && index2<end)
		{
			if(array[index1]<array[index2])
				temp[index++] = array[index1++];
			else
				temp[index++] = array[index2++];
		}
		while(index1<mid)
			temp[index++] = array[index1++];
		while(index2<end)
			temp[index++] = array[index2++];
		for(int i = 0 ;i<length;i++)
		{
			array[start+i]=temp[i];
		}
		}
	}
	//2) recursion implement
	//top to down
	public void mergeSortRecursion(int[] array,int start,int end)
	{
		if(end>start+1)
		{
			int mid = (start+end)>>1;
		//System.out.println("start:"+start+", mid:"+mid+", end:"+end);
		mergeSortRecursion(array,start,mid);
		mergeSortRecursion(array,mid,end);
		merge(array,start,mid,end);
		}
	}
	public void printArray(int [] array)
	{
		if(array!= null && array.length>0){
		System.out.print("The array: [ ");
		for(int k:array)
			System.out.print(k+" ");
		System.out.println("]");
		}
	}
	
	
	public static void main(String [] args)
	{

		Sort  test = new Sort ();
		//test
		//founction test
		System.out.println("Founction Test:");
		int [] array = {9,-4,7,4,0,1,2,10,6};
		test.mergeSort(array);
		test.printArray(array);
		
		//boundary test		
		System.out.println("\nBoundary Test:");
		int [] arrayDescending = {11,10,9,8,7,6,5,4,3,2,1};
		//test.mergeSort(arrayDescending);
		test.heapSort(arrayDescending);
		test.printArray(arrayDescending);
		int [] arrayAcending  = {1,2,3,4,5,6,7,8,9,10,11};
		test.heapSort(arrayAcending);
		//test.mergeSort(arrayAcending);
		test.printArray(arrayAcending);
		int []arrayOne = {1};
		test.mergeSort(arrayOne);
		test.printArray(arrayOne);
		
		//exception test		
		System.out.println("\nException Test:");
		test.mergeSort(null);
		test.printArray(null);
	}

}
/*
按平均时间将排序分为四类：

（1）平方阶(O(n2))排序
    　一般称为简单排序，例如直接插入、直接选择和冒泡排序；

（2）线性对数阶(O(nlgn))排序
    　如快速、堆和归并排序；

（3）O(n1+￡)阶排序
    　￡是介于0和1之间的常数，即0<￡<1，如希尔排序；

（4）线性阶(O(n))排序
    　如桶、箱和基数排序。

各种排序方法比较

     简单排序中直接插入最好，快速排序最快，当文件为正序时，直接插入和冒泡均最佳。

影响排序效果的因素

    　因为不同的排序方法适应不同的应用环境和要求，所以选择合适的排序方法应综合考虑下列因素：
　　①待排序的记录数目n；
　　②记录的大小(规模)；
　　③关键字的结构及其初始状态；
　　④对稳定性的要求；
　　⑤语言工具的条件；
　　⑥存储结构；
　　⑦时间和辅助空间复杂度等。

不同条件下，排序方法的选择

(1)若n较小(如n≤50)，可采用直接插入或直接选择排序。
    当记录规模较小时，直接插入排序较好；否则因为直接选择移动的记录数少于直接插人，应选直接选择排序为宜。
(2)若文件初始状态基本有序(指正序)，则应选用直接插人、冒泡或随机的快速排序为宜；
(3)若n较大，则应采用时间复杂度为O(nlgn)的排序方法：快速排序、堆排序或归并排序。
    快速排序是目前基于比较的内部排序中被认为是最好的方法，当待排序的关键字是随机分布时，快速排序的平均时间最短；
    堆排序所需的辅助空间少于快速排序，并且不会出现快速排序可能出现的最坏情况。这两种排序都是不稳定的。
    若要求排序稳定，则可选用归并排序。但本章介绍的从单个记录起进行两两归并的  排序算法并不值得提倡，
    通常可以将它和直接插入排序结合在一起使用。先利用直接插入排序求得较长的有序子文件，然后再两两归并之。
    因为直接插入排序是稳定的，所以改进后的归并排序仍是稳定的
*/