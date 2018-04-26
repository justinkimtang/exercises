package sort;

public class bubbleSort{
   
    /*Bubble sort 
    Time| Worst:O(n^2), Average:O(n^2)
    Space| O(1)
    Notes| Bubble sort works by carrying the largest element in the array to the top.
    Larger elements are swapped upwards for smaller elements. After a number of iterations
    no swaps are longer required and the array is sorted.*/
    public static void sort(int[] a){
        int swap = -1;
        int end = a.length -1;
        while(swap != 0 && end >= 1){
            swap = 0;
            for(int i = 0; i< end; i++){
                if(a[i] > a[i+1]){
                   helper.swap(a,i,i+1);
                   swap++;
                }
            }
            end--;
        }
    }
}