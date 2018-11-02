
public class BinaryHeap{
	int size;
	int[] arr;

	public BinaryHeap(){
		size=0;
		arr = new int[10];
	}

	public void add(int num){

		if(arr.length==size){
			grow();
		}

		arr[size++]=num;
		int child = size-1;
		int parent = (child-1)/2;
		while(child>0 && arr[child]<arr[parent]){
			swap(parent, child);
			child=parent;
			parent=(child-1)/2;
		}
	}

	public int remove(){
		if(size==0){
			throw new IllegalStateException("Array is Empty.");
		}

		int temp=arr[0];
		arr[0]=arr[size-1];
		size--;
		shiftdown(0);
		return temp;
	}

	public void swap(int parent, int child){
		int temp = arr[parent];
		arr[parent] = arr[child];
		arr[child] = temp;

	}

	public void shiftdown(int parent){
		if(parent>=size || parent*2+1>=size){
			return;
		}

		int child = parent*2+1;
		if(arr[child+1]<arr[child])
			child++;
		if(arr[parent]>arr[child]){
			swap(parent, child);
			shiftdown(child);
		}
	}

	public void grow(){
		int[] newArr = new int[arr.length * 2];
		for(int i=0; i<arr.length; i++){
			newArr[i]=arr[i];
		}

		arr=newArr;
	}
}


