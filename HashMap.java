/*
  Design HashMap without using library functions.

  Design a hash map without using the built-in libraries. We only need to cater integer keys and integer values in the hash map. 
  Return NULL if the key doesn’t exist.

It should support the following three primary functions of a hash map:

Put(key, value): This function inserts a key and value pair into the hash map. If the key is already present in the map, then the value is updated. Otherwise, it is added to the bucket.

Get(key): This function returns the value to which the key is mapped. It returns 
−
1
−1
, if no mapping for the key exists.

Remove(key): This function removes the key and its mapped value.

*/

/* Online Java Compiler and Editor */

import java.util.*;


public class MyHashMap {

    public class Bucket {
        List<List<Integer>> buckets;

        Bucket() {
            buckets = new ArrayList<>();
        }

        void update(int key, int val) {
            boolean found = false;
            for (int i = 0 ; i < buckets.size(); i++) {
                if (buckets.get(i).get(0) == key) {
                    buckets.get(i).add(1, val);
                    found = true;
                    break;
                }
            }

            if (!found) {
                buckets.add(Arrays.asList(key, val));
            }
        }

        int getValue (int key) {
            for (int i = 0 ; i < buckets.size(); i++) {
                if (buckets.get(i).get(0) == key) {
                    return buckets.get(i).get(1);
                }
            }

            return -1;
        }

        void remove(int key) {
            for (int i = 0 ; i < buckets.size(); i++) {
                if (buckets.get(i).get(0) == key) {
                    buckets.remove(i);
                }
            }
        }
    }

    List<Bucket> hashMap;
    int space;

    public MyHashMap(int keySpace) {
        this.space = keySpace;
        hashMap = new ArrayList<>(Collections.nCopies(this.space, new Bucket()));
    }

    public void put(int key, int value) {
        int hash = key % this.space;
        hashMap.get(hash).update(key, value);
    }

    public int get(int key) {
        int hash = key % this.space;
        return hashMap.get(hash).getValue(key);
    }

    public void remove(int key) {
        int hash = key % this.space;
        hashMap.get(hash).remove(key);
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap(2);
        hashMap.put(4, 4);
        hashMap.put(6, 5);
        hashMap.put(3, 8);

        List<Bucket> map = hashMap.hashMap;

        System.out.println(map.get(0).buckets.get(0));
        System.out.println(map.get(0).buckets.get(1));
        System.out.println(map.get(0).buckets.get(2));
        
        hashMap.remove(6);
        
         System.out.println(map.get(1).buckets.get(0));
        System.out.println(map.get(1).buckets.get(1));
        //System.out.println(map.get(1).buckets.get(2));
        
        
       


    }
}
