package sort;
import java.io.*;
import java.util.*;

public class test{

    private static List<int[]> getTestArrays(){
        //This will be a list of all the int[] .sort will be tested on
        List<int[]> testList = new ArrayList<int[]>();

        //Some basic test cases
        int[] t0 = new int[0];
        int[] t1 = new int[]{2736,1927,1,511,324,2854,7,867,4,234,342};
        int[] t2 = new int[]{-3543,345,76647,734,-243,5667,7684,-4435435,43,435,8780043,-67886,7612,378,6712,-37786,4537,711,4,-5,677,5,0,-898};
        int[] t3 = new int[]{516515,89,-6212,554,88,4455,-2114,489,5454,21218,48974,0162165,-54548,-8897,123,258,62,5,879,-7897,4,212,-321,8,7,4,654,21656,-84,546,23,2,1,-45478,0,21,320,6,-3260,54,20059,100,1,-12,56,532,468,951,205,898,472,213};
        int[] t4 = new int[]{0,78,454,32,955,32,71,32,8,1,232,98,320,238,989,4,5,71,32,8,1,232,98,454,32,955,32,71,32};

        testList.add(t0);
        testList.add(t1);
        testList.add(t2);
        testList.add(t3);
        testList.add(t4);

        //Extra test cases that can be defined in customTest.txt
        File custom = new File("./sort/customTest.txt");
        if(custom.length() > 0){
            try{
                Scanner in = new Scanner(custom);
                int numTest = in.nextInt();
                for(int i=0; i<numTest; i++){
                    int size = in.nextInt();
                    int[] tc = new int[size];
                    for(int j = 0; j<size; j++){
                        tc[j] = in.nextInt();
                    }
                    testList.add(tc);
                }
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
        return testList;
    }
    public static List<Class> getSortingMethods(){
        List<Class> sortingList = new ArrayList<Class>();
        sortingList.add(bubbleSort.class);
        sortingList.add(cocktailSort.class);
        sortingList.add(combSort.class);
        sortingList.add(countingSort.class);
        sortingList.add(heapSort.class);
        sortingList.add(insertionSort.class);
        sortingList.add(mergeSort.class);
        sortingList.add(quickSort.class);
        sortingList.add(selectionSort.class);
        //sortingList.add(shellSort.class);
        //sortingList.add(bucketSort.class);
        //sortingList.add(radixSort.class);
        return sortingList;
    }

    public static void runTest(List<int[]> testList, List<Class> sortingList) throws Exception{
        Class classType = testList.get(0).getClass();
        for(Class algo : sortingList){
            boolean passed = true;
            try{
                for(int[] arr : testList){
                    int size = arr.length;
                    int[] sorted = new int[size];
                    System.arraycopy(arr,0,sorted,0,size);
                    Arrays.sort(sorted);
                    algo.getMethod("sort",classType).invoke(algo.newInstance(),arr);
                    if(!Arrays.equals(arr,sorted)){
                        passed = false;
                        System.out.println("Error: Array was not properly sorted");
                        System.out.println("    " + algo.getName().substring(5));
                        System.out.println("        " + "Result: " + Arrays.toString(arr));
                        System.out.println("        " + "Sorted:" + Arrays.toString(sorted));
                        break;
                    }
                }
            }
            catch(NoSuchMethodException | IllegalAccessException e){
                e.printStackTrace();
            }
            if(passed) System.out.println("Passed: " + algo.getName().substring(5));
        }
    }
    public static void main(String[] args){
        List<int[]> test = getTestArrays();
        List<Class> algoritms = getSortingMethods();
        try{
            runTest(test,algoritms);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}