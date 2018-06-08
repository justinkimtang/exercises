//Custom implemntation of string builder in java
public class StringBuilder{
    private final int resizeFactor = 2;
    private final int DEFAULT_SIZE = 16;

    private char[] str;
    private int capacity;
    private int size;

    public StringBuilder(){
        str = new char[DEFAULT_SIZE];
        capacity = DEFAULT_SIZE;
        size = 0;
    }

    public StringBuilder(char[] s){
        str = s;
        capacity = s.length * resizeFactor;
        size = s.length;
    }

    public StringBuilder(int initialCapcity){
        str = new char[initialCapcity];
        capacity = initialCapcity;
        size = 0;
    }

    public StringBuilder(String s){
        str = s.toCharArray();
        capacity = s.length() * resizeFactor;
        size = s.length();
    }

    public void append(String s){
        char[] sArr = s.toCharArray();
        append(sArr);
    }

    public void append(char[] s){
        size = size + s.length;
        if(isFilled()){
            resize();
        }
        System.arraycopy(s, 0, str, size, s.length);
    }

    public void append(char c){
        if(isFilled()){
            resize();
        }
        str[size] = c;
        size++;
    }

    public int capacity(){
        return capacity;
    }

    public char charAt(int index){
        if(index < size){
            return str[index];
        }
        return str[capacity -1];
    }

    public StringBuilder delete(int start, int end){
        if(!validRange(start,end)){
            return new StringBuilder(str);
        }
        int count = end - start;
        StringBuilder temp = new StringBuilder(capacity);
        System.arraycopy(str, 0, temp.str, 0, start);
        System.arraycopy(str, end + 1, temp.str, start, size - end);
        temp.size = size - count;
        return temp;
    }

    private boolean validRange(int start, int end){
        if(start < 0 || end > size || end < start ){
            return false;
        }
        return true;
    }

    public StringBuilder deleteCharAt(int index){
        return delete(index,index);
    }

    public void ensureCapacity(int minCapacity){
        if(capacity < minCapacity){
            capacity = minCapacity;
            char[] temp = new char[capacity];
            System.arraycopy(str, 0, temp, 0, size);
            str = temp;
        }
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin){
        int len = srcEnd - srcBegin;
        System.arraycopy(str, srcBegin, dst, dstBegin, len);
    }

    public int indexOf(String subStr){
        for(int i = 0; i< size; i++){
            if(str[i] == subStr.charAt(0)){
                if(subStringFound(i,subStr)){
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean subStringFound(int index, String subString){
        char[] subChar = subString.toCharArray();
        for(int i = 0; i< subChar.length; i++){
            if(str[index + i] != subChar[i]){
                return false;
            }
        }
        return true;
    }

    public StringBuilder insert(int offset, char c){
        char[] temp = new char[size - offset];
        System.arraycopy(str, offset, temp, 0, size - offset);
        str[offset] = c;
        System.arraycopy(temp, 0, str ,offset + 1, size - offset);
        size++;
        return new StringBuilder(str);

    }

    public StringBuilder insert(int offset, char[] s){
        char[] temp = new char[size - offset];
        System.arraycopy(str, offset, temp, 0, size - offset);
        System.arraycopy(s, 0, str, offset, s.length);
        System.arraycopy(temp, 0, str ,offset + s.length, size - offset);
        size += s.length;
        return new StringBuilder(str);
    }

    public StringBuilder insert(int offset, String s){
        char[] c = s.toCharArray();
        return insert(offset, c);
    }

    public int lastIndexOf(String s){
        for(int i = size -1 ; i > -1; i--){
            if(str[i] == s.charAt(0)){
                if(subStringFound(i,s)){
                    return i;
                }
            }
        }
        return -1;
    }

    public int length(){
        return size;
    }

    public StringBuilder replace(int start, int end, String s){
        StringBuilder myString = new StringBuilder(str);
        myString.delete(start, end);
        myString.insert(start,s);
        myString.size = size - (end-start) + s.length();
        return myString;
    }

    public StringBuilder reverse(){
        StringBuilder temp = new StringBuilder(capacity);
        for(int i = size -1; i > -1; i--){
            temp.str[(size-1) -i] = str[i];
        }
        temp.size = size;
        return temp;
    }

    public void setCharAt(int index, char ch){
        str[index] = ch;
    }

    public void setLength(int newLength){
        size = newLength;
    }

    public String substring(int start, int end){
        StringBuilder s = new StringBuilder(str);
        char[] result = new char[s.size];
        s.getChars(start, end, result, 0);
        return result.toString();
    }

    public String toString(){
        StringBuilder s = new StringBuilder(str);
        char[] result = new char[s.size];
        s.getChars(0, size, result, 0);
        return result.toString();
    }

    public void trimToSize(){
        StringBuilder s = new StringBuilder(str);
        char[] result = new char[size];
        s.getChars(0,size,result,0);
        str = result;
        capacity = size;
    }
    private boolean isFilled(){
        return size == capacity;
    }

    private void resize(){
        capacity = capacity * resizeFactor;
        char[] newArr = new char[capacity];
        System.arraycopy(str, 0, newArr, 0, size);
        str = newArr;
    }
}