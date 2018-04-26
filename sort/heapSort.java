package sort;

//ToDo:Add discription
public class heapSort{
    
    //Heap Sort
    public static void heapify(int [] heap, int index){
        int largest;
        index = index + 1;
        int left = (index * 2 <= heap.length) ? (index * 2 - 1) : index-1;
        int right = ((index * 2 + 1) <= heap.length) ? (index * 2) : index-1;
        index = index -1;
        if(heap[left] > heap[index]){
            largest = left;
        }
        else
            largest = index;
        if(heap[right] > heap[largest]){
            largest = right;
        }
        if(largest == index) return;
        helper.swap(heap,index,largest);
        heapify(heap, largest);
    }

    public static void buildMaxHeap(int[] heap){
        int index = heap.length/2;
        for(int i = index; i>=0; i--){
            heapify(heap,i);
        }
    }
    public static void sort(int [] a){
        if(a.length <= 1) return;
        int size = a.length;
        int[] copy = new int[size];
        for(int j = 0; j<a.length; j++){
            copy[j] = a[j];
        }
        buildMaxHeap(copy);
        for(int i = copy.length-1; i >=0; i--){
            a[i] = copy[0];
            helper.swap(copy,i,0);
            //ToDo:find a better alternative to setting it to min value
            //Possibly remove and reduce size by 1
            copy[i] = Integer.MIN_VALUE;
            heapify(copy,0);
        }
    }
}