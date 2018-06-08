import java.util.HashSet;
import java.util.Arrays;

//My solutions to the exercises
public class solutions{
    public solutions(){}
    public boolean isUnique1(String s){
        HashSet<Character> charSet = new HashSet<Character>();
        for(int i = 0; i< s.length(); i++){
            if(charSet.contains(s.charAt(i))){
                return false;
            }
            else{
                charSet.add(s.charAt(i));
            }
        }
        return true;
    }

    public boolean isUnique2(String s){
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        for(int i = 0; i< s.length()-1; i++){
            if(charArr[i] == charArr[i+1]){
                return false;
            }
        }
        return true;
    }

    public boolean checkPermutaion(String s1, String s2){
        if(s1.length()!= s2.length()){
            return false;
        }
        char[] charArr1 = s1.toCharArray();
        char[] charArr2 = s2.toCharArray();
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
        for(int i = 0; i<s1.length(); i++){
            if(charArr1[i] != charArr2[i]){
                return false;
            }
        }
        return true;
    }

    public String URLify(char[] c, int length){
        String replacement = "%20";
        StringBuilder s = new StringBuilder();
        for(int i = 0; i<length; i++){
            if(c[i] == ' '){
                s.append(replacement);
            }
            else{
                s.append(c[i]);
            }
        }
        return s.toString();
    }

    public boolean palindromePermutation(String s){
        HashSet<Character> charSet = new HashSet<Character>();
        for(int i = 0; i< s.length(); i++){
            if(charSet.contains(s.charAt(i))){
                charSet.remove(s.charAt(i));
            }
            else{
                charSet.add(s.charAt(i));
            }
        }
        return charSet.size() <= 1;
    }

    public boolean oneAway(String s1, String s2){
        String longer = s1.length() > s2.length() ? s1 : s2;
        String shorter = s2.length() < s1.length() ? s2 : s1;
        
        if(longer.length() - shorter.length() > 1){
            return false;
        }
        int numDiff = 0;
        if(longer.length() > shorter.length()){
            int i = 0;
            int j = 0;
            while(j < shorter.length() && i < longer.length()){
                if(longer.charAt(i) != shorter.charAt(j)){
                    i++;
                    numDiff++;
                }
                else{
                    i++;
                    j++;
                }
            }
        }
        else{
            for(int k = 0; k< longer.length(); k++){
                if(longer.charAt(k) != shorter.charAt(k)){
                    numDiff++;
                }
            }
        }
            boolean result = numDiff <=1;
        return result;
    }
    
    public String stringCompression(String s1){
        char[] c1 = s1.toCharArray();
        char current = c1[0];

        int j = 0;
        StringBuilder result = new StringBuilder();
        while(j < c1.length){
            int count = 0;
            while(c1[j] == current){
                count++;
                j++;
            }
            result.append(current);
            result.append(Integer.toString(count));
        }
        return result.toString();
    }

    public int[][] rotateMatrix(int[][] image){
        int[][] newImage = new int[image[0].length][image.length];
        for(int x = 0; x< image[0].length; x++){
            for(int y = 0; y<image.length; y++){
                newImage[x][y] = image[(image.length-1) - y][x];
            }
        }
        return newImage;
    }

    public int[][] zeroMatrix(int[][] matrix){
        HashSet<Integer> row = new HashSet<Integer>();
        HashSet<Integer> column = new HashSet<Integer>();
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    column.add(j);
                }
                if(row.contains(i) || column.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    
    public boolean StringRotation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        int ptr1 = 0;
        int ptr2 = 0;
        int count = 0;
        for(int i = 0; i<s1.length(); i++){
            if(ptr2 == s1.length()){
                ptr2 = 0;
            }
            while(ptr2 < s1.length() && s1.charAt(ptr1) == s2.charAt(ptr2)){
                ptr1++;
                ptr2++;
                count++;
            }
        }
        return count == s1.length();
    }
    
    
}