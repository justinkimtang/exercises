import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class largestPrime{
    static List<Integer> factorList = new ArrayList<Integer>();
    public static void getPrimeFactors(long n){
        if(isPrime(n)){
            factorList.add((int)n);
            return;
        }
        for(int i=2; i<n; i++){
            if(n % i == 0){
                getPrimeFactors(n/i);
                getPrimeFactors(i);
                break;
            }
        }
    }
    public static boolean isPrime(long n){
        if(n==1 || n==2 || n==3) return true;
        if(n % 2 == 0) return false;
        for(int i = 3; i<n; i+=2){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static long getlargestPrime(List<Integer> primeList){
        long result = 0;
        for(int i = 0; i<primeList.size(); i++){
            if(primeList.get(i) > result)
                result = primeList.get(i);
        }
        return result;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        getPrimeFactors(in.nextLong());
        System.out.println("The largest prime factor is: " + getlargestPrime(factorList));
        in.close();
    }
}