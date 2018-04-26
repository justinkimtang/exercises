package sort;

public class cocktailSort{
   
    /*Cocktailsort 
    Time| Worst:O(n^2), Average:O(n^2)
    Space| O(1)
    Notes| Cocktailsort is another modified bubble sort, but in this case it is one moving from end to end.*/
    public static void sort(int[] a){
        if(a.length <= 1) return;
        int upperBound = a.length-1;
        int lowerBound = 0;
        boolean s = true;
        int i = 0;
        while(upperBound != lowerBound){
            if(i == lowerBound + 1){s = true;}
            if(s){
                while(i < upperBound){
                    if(a[i+1] < a[i]){
                        helper.swap(a,i+1,i);
                    }
                    i++;
                }
                upperBound--;
            }
            i = upperBound;
            s=false;
            if(!s){
                while(i > lowerBound){
                    if(a[i-1] > a[i]){
                        helper.swap(a,i-1,i);
                    }
                    i--;
                }
            }
            lowerBound++;
        }
    }
}