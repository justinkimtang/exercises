package sort;

public class selectionSort{
    /*selectionSort 
    Time| Worst:O(n^2), Average:O(n^2)
    Space| O(1)
    Notes| Selection sort finds the smallest element in an array and moves it to the front
    This repeats until the every element in the array has been moved and the array is sorted.*/
    public static void sort(int[] a){
        int sorted = 0;
        int len = a.length -1;
        while(sorted < len){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int i = sorted; i< len +1; i++){;
                if(a[i] <= min){
                    min = a[i];
                    index = i;
                }
            }
          helper.swap(a,sorted,index);
            sorted++;
        }
    }
}