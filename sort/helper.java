package sort;
public class helper{
        //Helper Functions for various sorts
        public static void swap(int[] a, int index1, int index2) {
            int temp = a[index1];
            a[index1] = a[index2];
            a[index2] = temp;
        }
    
        public static int findMin(int[]a){
            int min = a[0];
            for(int i = 0; i<a.length; i++){
                if(a[i]<min) min = a[i];
            }
            return min;
        }
    
        public static int findMax(int[]a){
            int max = a[0];
            for(int i = 0; i<a.length; i++){
                if(a[i]>max) max = a[i];
            }
            return max;
        }
}