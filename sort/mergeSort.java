package sort;

public class mergeSort{
    //Helper function for merge sort
    public static void merge(int[] a, int start, int mid, int end){
        int leftSize = mid - start + 1;
        int rightSize = end-mid;
        int[] left = new int[leftSize + 1];
        int[] right = new int[rightSize + 1];
        for(int i = 0; i< leftSize; i++){
            left[i] = a[start + i];
        }
        for(int j = 0; j< rightSize; j++){
            right[j] = a[mid+j + 1];
        }
        left[leftSize] = Integer.MAX_VALUE;
        right[rightSize] = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        for(int k = start; k <= end; k++){
            if(left[l] <= right[r]){
                a[k] = left[l];
                l++;
            }
            else{
                a[k] = right[r];
                r++;
            }
        }
    }

    /*Merge
    Time| Worst:O(nlgn), Average:O(nlgn)
    Space| n
    Notes| Merge sort splits an array in to two partions and sorts those halves
    The actual sorting occurs by creating two new arrays that are the partitions
    and recombining the sorted versions in order */
    public static void sort(int[] a, int l, int r){
        if(r>l){
            int split = (l+r)/2;
            sort(a,l,split);
            sort(a,split + 1,r);
            merge(a,l,split,r);
        }
    }

    public static void sort(int[] a){
        int l = 0;
        int r = a.length - 1;
        sort(a,l,r);
    }
}