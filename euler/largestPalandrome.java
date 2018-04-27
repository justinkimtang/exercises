import java.util.*;
import java.lang.*;
import java.io.*;
public class largestPalandrome{

    public static int getLargestPalandrome(int factorMin, int factorMax){
        int maxPalindrome = factorMax * factorMax;
        int minPalindrome = factorMin * factorMin;
        int len = Integer.toString(maxPalindrome).length()/2 + 1;
        boolean isEven = Integer.toString(maxPalindrome).length() % 2 == 0;

        int testPal = getMaxPalandrome(len, isEven);
        while(testPal > maxPalindrome){
            testPal = nextLargestPalandrome(testPal, len, isEven);
        }

        while(testPal > minPalindrome){
            if(findFactors(testPal,factorMin,factorMax) > 0){
                return testPal;
            }
            testPal = nextLargestPalandrome(testPal, len, isEven);
        }
        return -1;
    }

    public static int findFactors(int n,int min, int max){
        for(int i = min; i<=max; i++){
            if(n % i == 0 && (n % (n/i) == 0)){
                if(inRange(n/i, min, max)){
                    System.out.println(i);
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean inRange(int n, int min, int max){
        if(n >= min && n <= max){
            return true;
        }
        return false;
    }
    public static int getMaxPalandrome(int len,boolean isEven){
        String pal = "";
        for(int i = 0; i<len; i++){
            pal += "9";
        }
        String androme = new StringBuilder(pal).reverse().toString();
        return isEven ? Integer.valueOf(pal.substring(0,pal.length()-1) + androme.substring(1)) : Integer.valueOf(pal + androme.substring(1));
    }

    public static int nextLargestPalandrome(int n, int len, boolean isEven){
        String oldPalandome = Integer.toString(n);
        String tempPal = "";
        for(int i = 0; i<len; i++){
            tempPal = tempPal + Character.toString(oldPalandome.charAt(i));
        }
        String newPal = isEven ? Integer.toString(Integer.valueOf(tempPal) - 10) : Integer.toString(Integer.valueOf(tempPal) - 1);
        String newAndrome = new StringBuilder(newPal).reverse().toString();
        return isEven ? Integer.valueOf(newPal.substring(0,newPal.length()-1) + newAndrome.substring(1)) : Integer.valueOf(newPal.substring(0,newPal.length()-1) + newAndrome);
    }


    public static void main(String[] args){
        System.out.println(getLargestPalandrome(100, 999));
    }
    
}