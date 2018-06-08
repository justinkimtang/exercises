import java.util.Set;
import java.util.HashSet;

//Hashtable using inner linkedlist class hashnode
public class HashTable <K,V>{
    public class hashNode<K,V>{
        private K key;
        private V value;
        private hashNode<K,V> next;
    
        public hashNode(){}
        public hashNode(K key, V value){
            this.key = key;
            this.value = value;
            next = null;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
        public void setKey(K key){
            this.key = key;
        }
        public void setValue(V value){
            this.value = value;
        }
        public boolean hasNext(){
            return next != null;
        }
        public hashNode<K,V> getNext(){
            return next;
        }
        public void setNext(hashNode<K,V> next){
            this.next = next;
        }
    }
    private hashNode<K,V>[] table;
    private int capacity;
    private int size;
    
    private final double overfilled = .75;
    private final int DEFAULT_CAPACITY = 16;
    private final int resizeFactor = 2;
    private final int primeFactor = 163; //TODO: Find an efficent value

    public HashTable(){
        table = new hashNode[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    public HashTable(int initalCapacity){
        table = new hashNode[initalCapacity];
        capacity = initalCapacity;
        size = 0;
    }

    public void clear(){
        hashNode<K,V>[] newTable = new hashNode[capacity];
        table = newTable;
    }

    public Object clone(){
        HashTable<K,V> cp = new HashTable<K,V>();
        cp.size = size;
        cp.capacity = capacity;
        cp.table = table;
        return cp;
    }

    public boolean containsValue(Object value){
        for(int i = 0; i<size; i++){
            hashNode<K,V> ptr = table[i];
            do{
                if(ptr.getValue().equals(value)){
                    return true;
                }
                ptr = ptr.getNext();
            }
            while(table[i].hasNext());
        }
        return false;
    }

    public boolean containsKey(Object key){
        for(int i = 0; i<size; i++){
            hashNode<K,V> ptr = table[i];
            do{
                if(ptr.getKey().equals(key)){
                    return true;
                }
                ptr = ptr.getNext();
            }
            while(table[i].hasNext());
        }
        return false;
    }

    public Set<hashNode<K,V>> entrySet(){
        Set s = new HashSet<hashNode<K,V>>();
        for(int i = 0; i<size; i++){
            hashNode<K,V> ptr = table[i];
            do{
                if(ptr != null){
                     s.add(ptr);
                }
                ptr = ptr.getNext();
            }
            while(table[i].hasNext());
        }
        return s;
    }

    public V get(K key){
        int bucket = Math.abs(key.hashCode() * primeFactor % capacity);
        if(table[bucket] == null){
            return null;
        }
        for(hashNode<K,V> i = table[bucket]; i != null; i=i.next){
            if(i.getKey() == key){
                return i.getValue();
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return size <= 0;
    }

    public Set<K> keySet(){
        Set s = new HashSet<K>();
        for(int i = 0; i<size; i++){
            hashNode<K,V> ptr = table[i];
            do{
                if(ptr != null){
                     s.add(ptr.getKey());
                }
                ptr = ptr.getNext();
            }
            while(table[i].hasNext());
        }
        return s;
    }

    public boolean put(K key, V value){
        int newSize = this.size + 1;
        if(newSize >= (double)capacity * overfilled){
            resize();
        }
        int bucket = Math.abs(key.hashCode() * primeFactor % capacity);
        if(table[bucket] == null){
            table[bucket] = new hashNode(key,value);
            size +=1;
            return true;
        }
        for(hashNode<K,V> i = table[bucket]; i!=null; i = i.next){
            if(i.getKey() == key){
                i.setValue(value);
                return true;
            }
            else if(!i.hasNext()){
                i.setNext(new hashNode(key,value));
                size += 1;
                return true;
            }
        }
        return false;
    }

    protected void rehash(){
        resize();
    }

    public V remove(K key){
        if(isEmpty()){return null;}
        int bucket = Math.abs(key.hashCode() * primeFactor % capacity);
        if(table[bucket] == null){
            return null;
        }
        hashNode<K,V> prev = new hashNode();
        for(hashNode<K,V> i = table[bucket]; i != null; i=i.next){
            if(i.getKey() == key){
                prev.next = i.next;
                return i.getValue();
            }
            prev = i;
        }
        return null;
    }

    public int size(){
        return size;
    }

    private void resize(){
        capacity = capacity * resizeFactor;
        hashNode[] newArray = new hashNode[capacity];
        for(int i = 0; i<capacity/resizeFactor; i++){
            for(hashNode<K,V> j = table[i]; j!=null; j=j.next){
                int bucket = Math.abs(j.getKey().hashCode() * primeFactor % capacity);
                if(newArray[bucket] == null){
                    newArray[bucket] = j;
                    newArray[bucket].setNext(null);
                }
                for(hashNode<K,V> k = newArray[bucket]; k!=null; k = k.next){
                     if(k.getKey() == j.getKey()){
                        k.setValue(j.getValue());
                    }
                     else if(!k.hasNext()){
                        k.next = j;
                        k.next.next.setNext(null);
                    }
                }
            }
        }
        table = newArray;
    }
}