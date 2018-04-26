package sort;

public class combSort{
    /*comb sort (modified bubble)
    Time| Worst:O(n^2), Average:O(n^2)
    Space| O(1)
    Notes| Comb sort is bubble sort but comparison of values happen at a gap distance, the gap gets smaller and smaller each iteration*/
    public static void sort(int[] a){
        if(a.length <= 1) return;
        int gap = a.length-1;
        float shrink = 1.3f;
        boolean sorted = false;
        while(!sorted){
            int newGap = (int)Math.floor(gap/shrink);
            gap = newGap != 0 ? newGap : 1;
            if(gap > 1) sorted = false;
            if(gap == 1) sorted = true;
            int i = 0;
            while(i + gap < a.length){
                if(a[i+gap] < a[i]){
                    helper.swap(a,i,i+gap);
                    sorted = false;
                }
                i=i+1;
            }
        }
    }
}