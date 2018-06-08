import java.util.Arrays;

public class ArrayList{

    private final int defaultCapacity = 16;
    private final int resizeFactor = 2;

    private int size;
    private int capacity;
    private Object[] arr;

    public ArrayList(){
        size = 0;
        capacity = defaultCapacity;
        arr = new Object[defaultCapacity];
    }

    public ArrayList(int initialCapacity){
        size = 0;
        capacity = initialCapacity;
        arr = new Object[initialCapacity];
    }

    public void add(Object item){
        if(isFull()){
            resize();
        }
        arr[size] = item;
        size++;
    }

    public void add(int index, Object item){
        if(isFull()){
            resize();
        }
        Object[] tempArr = new Object[capacity];
        System.arraycopy(arr, index, tempArr, 0, size - index);
        arr[index] = item;
        System.arraycopy(tempArr, 0, arr, index + 1, size - index);
        size++;
    }

    public void clear(){
        arr = new Object[defaultCapacity];
    }

    public Object clone(){
        Object[] shallowCp = arr;
        return shallowCp;
    }

    public boolean contains(Object o){
        for(Object i : arr){
            if(i.equals(o)){
                return true;
            }
        }
        return false;
    }
    
    public void ensureCapacity(int minCapacity){
        resize(minCapacity);
    }

    public Object get(int i){
        return arr[i];
    }

    public int indexOf(Object o){
        for(int i = 0; i < size; i++){
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int lastIndexOf(Object o){
        for(int i = size -1; i >-1; i--){
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    public boolean remove(int i){
        System.arraycopy(arr, i+1, arr, i, size - i);
        size--;
        return true;
    }

    public boolean remove(Object o){
        for(int i = 0; i<size; i++){
            if(arr[i].equals(0)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    public Object set(int index, Object o){
        if(index < size){
            Object temp = arr[index];
            arr[index] = o;
            return temp;
        }
        return o;
    }

    public int size(){
        return size;
    }

    public void sort(){
        Arrays.sort(arr);
    }

    public Object[] toArray(){
        return arr;
    }

    public void trimToSize(){
        capacity = size;
        resize(capacity);   
    }

    private boolean isFull(){
        return size >= capacity;
    }

    private void resize(){
        int doubled = capacity * resizeFactor;
        resize(doubled);
    }
    
    private void resize(int newCapacity){
        capacity = newCapacity;
        Object[] newArr = new Object[capacity];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }
}