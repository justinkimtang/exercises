package sort;

//ToDo:Add better discription and implement random pivot
public class quickSort{
    
    //Helper Function for quickSort
    public static int partition(int[] a, int start, int end){
        int pivot = a[end];
        int wall = start;
        for(int i = start; i < end; i++){
            if(a[i] <= pivot){
                helper.swap(a,wall,i);
                wall++;
            }
        }
        helper.swap(a,wall,end);
        return wall;
    }

    /*Quick sort 
    Time| Worst:O(n^2), Average:O(nlgn)
    Space| O(1)
    Notes| Quick sort works but it sucks to implement this thing requires a lot of detail in index managment*/
    public static void sort(int[] a, int start, int end){
        if(start < end){
            int part = partition(a,start,end);
            sort(a,start,part-1);
            sort(a,part+1,end);
        }
    }

    public static void sort(int[] a) {
        int start = 0;
        int end = a.length -1;
        sort(a,start,end);
    }
}