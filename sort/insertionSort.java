package sort;

public class insertionSort{

     /*Insertion sort 
    Time| Worst:O(n^2), Average:O(n^2)
    Space| O(1)
    Notes| In insertion sort we have two partions of an array, the sorted and the unsorted.
    To begin the item at index 0 is labeld as sorted and the rest of the array is unsorted.
    To sort the algorithm add elements one at a time to the sorted portion of the array.
    Once inside the sorted portion the new insertion is swapped downward until its place is found.*/
    public static void sort(int[] a){
        for(int i = 1; i<a.length; i++){
            int k = a[i];
            int j = i-1;
            while(j >=0  && a[j] > k){
                a[j+1] = a[j];
                j=j-1;
                a[j+1] = k;
            }
        }
    }
}