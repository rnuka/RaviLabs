package practice.coding.customDataStructures;

import java.io.Serializable;

/**
 * Created by rnuka on 1/12/17.
 */
public class HashMap<K,V> {

    static final int CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    Entry[] table;

    int size;

    int threshold;


    //Constructor
    public HashMap(){
        table = new Entry[CAPACITY];
    }

    //static supplemental hashcode function
    static int hash(int h){
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    //get
    public V get(K key){
        int hash = key.hashCode();
        Entry<K,V> head = table[hash];
        while(head != null){
            if(head.key == key){
                return head.value;
            }
                head = head.next;
        }
        return null;
    }

    //put
    public void put(K key, V value){

        if(key == null){
            return;
        }

        int hash = key.hashCode();

        Entry<K,V> head = table[hash];
        while(head != null){
            if(head.key == key){ //if key is present in linkedlist
                head.value = value;
            }
            head = head.next;
        }

        //if key is not present in linked list, then replace bucket index by new entry and link existing to bucket
        table[hash] = new Entry(key.hashCode(),key, value, table[hash]);
    }

    //size
    int size(){
        return size;
    }

    //isEmpty
    boolean isEmpty(){
        return size==0;
    }

    //contains
    boolean contains(K key){
        int hash = key.hashCode();
        if(table[hash] != null) {
            //loop through linkedlist and see if key exists
            Entry<K,V> head = table[hash];
            while (head != null) {
                if (head.key == key) {
                    return true;
                } else {
                    head = head.next;
                }
            }
        }
        return false;
    }






     class Entry<K,V>{
        K key;
        V value;
        int hash;
        Entry<K,V> next;

        Entry(int h, K k, V v, Entry<K,V> n){
            key = k;
            value = v;
            hash = h;
            next = n;
        }

        public boolean equals(Object o){
            Entry that = (Entry)o;
            if(this.key == that.key || this.key.equals(that.key)){
                return true;
            }
            return false;
        }

        public final int hashCode(){
            return (key == null ? 0 : key.hashCode())^(value == null ? 0 : value.hashCode());

        }
    }
}
