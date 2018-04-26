package sort;

//ToDo:Add discription
public class countingSort{   
    //Counting Sort
    public static void sort(int[]a){
        if(a.length <=1) return;
        int min = helper.findMin(a);
        int max = helper.findMax(a);
        int[] range = new int[max - min + 1];
        for(int i = 0; i< a.length; i++){
            range[a[i] - min] += 1;
        }
        for(int j = 1; j<range.length; j++){
            range[j] = range[j] + range[j-1];
        }
        for(int k = range.length-1; k>0; k--){
            range[k] = range[k-1];
        }
        range[0] = 0;
        int[] result = new int[a.length];
        for(int l = 0; l< a.length; l++){
            result[range[a[l] - min]] = a[l];
            range[a[l] -min]++;
        }
        for(int n =0; n<a.length; n++){
            a[n] = result[n];
        }
    }
}