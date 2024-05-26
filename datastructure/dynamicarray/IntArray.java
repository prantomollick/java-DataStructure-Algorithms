package datastructure.dynamicarray;
import java.util.Arrays;
import java.util.Iterator;

public class IntArray implements Iterable<Integer> {
    private static final int DEFALUT_CAP = 1 << 3;

    public int[] arr;
    public int len = 0;
    private int capacity = 0;


    //Initialize the array with a default capcity
    public IntArray() {
        this(DEFALUT_CAP);
    }

    // Initialize the array with a certain capacity
    public IntArray(int capacity) {
        if(capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = new int[this.capacity];
    }


    //Given an array make it a dynamic array!
    public IntArray(int[] array) {
        if(array == null) throw new IllegalArgumentException("Array cannot be null");
        this.arr = Arrays.copyOf(array, array.length);
        this.capacity = this.len = array.length;
    }



    //Returns the size of the array
    public int size() {
        return len;
    }


    // Returns true/false on whether the array is empty
    public boolean isEmpty() {
        return len == 0;
    }


    //To get/set values without method call overhead you can do
    //array_obj.arr[index] instead, you can gain about 10x the speed!
    public int get(int index) {
        if(index < 0 || index >= len) throw new IndexOutOfBoundsException("Index: " + index + ", Size " + len);
        return arr[index];
    }

    public void set(int index, int elem) {
        if(index < 0 || index >= len) throw new IndexOutOfBoundsException("Index: " + index + ", Size " + len);
        arr[index] = elem;
    }


    //Add an element to this dynamic array 
    public void add(int elem) {
        // if(len == capacity) resize(capacity * 2);
        if(len + 1 > capacity) {
            if(capacity == 0) capacity = 1;
            else capacity *= 2;
            arr = Arrays.copyOf(arr, capacity);
        }

        arr[len++] = elem;
    }


    // Removes the element at the specified index in this list.
    // If possible, avoid calling this method as it take O(n) time
    // to remove an element (since you have to reconstruct the array!)

    public void removeAt(int rm_index) {
        if(rm_index < 0 || rm_index >= len) throw new IndexOutOfBoundsException("Index: " + rm_index + ", Size " + len);
        System.arraycopy(arr, rm_index + 1, arr, rm_index, len - rm_index - 1);
        --len;
        --capacity;
    }

    // Search and remove an element if it is found in the array
    // If possible, avoid calling this method as it take O(n) time
    public boolean remove(int elem) {
        for (int i = 0; i < len; i++) {
            if (arr[i] == elem) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }


    //Reverse the content of this array
    public void reverse() {
        for (int i = 0; i < len / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[len - i  - 1];
            arr[len - i - 1] = tmp;
        }
    }


    // Perform a binary search on this array to find an element in O(log(n)) time
    // Make sure this array is sorted! Returns a value < 0 if item is not found
    public int binarySearch(int key) {
        int index = Arrays.binarySearch(arr, 0, len, key);
        return index;
    }


    //sort this array;
    public void sort() {
        Arrays.sort(arr, 0, len);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = 0;

            public boolean hasNext() {
                return index < len;
            }

            public Integer next() {
                return arr[index++];
            }
            
            public void remove() {
                throw new UnsupportedOperationException("Unimplemented method 'remove'");
            }

        };
    }


    @Override
    public String toString() {
        if (len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++)sb.append(arr[i] + ", ");
            return sb.append(arr[len - 1] + "]").toString();
        }
    }


}