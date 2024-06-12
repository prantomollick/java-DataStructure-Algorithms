package datastructure.priorityqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PQueue <T extends Comparable<T>> {
    //The number of elements currently inside the heap
    private int heapSize = 0;

    // The internal capacity of the heap
    private int heapCapacity = 0;

    //A dynamic list to track the elements inside the  heap
    private List<T> heap = null;

    /**
     * This map keeps track of the possible indices a particular 
     * node value is found in the heap. Having this mapping lets
     * us have O(log(n)) removals and O(1) element containment check
     * at the cost of some additional space and minor overhead
     */
    private Map <T, TreeSet<Integer>> map = new HashMap<>();


    // Construct and initially empty priority queue
    public PQueue() {
        this(1);
    }


    //Contruct a priority queue with an initial capacity
    public PQueue(int sz) {
        heap = new ArrayList<>(sz);
    }


    public PQueue(T[] elems) {
        heapSize = heapCapacity = elems.length;
        heap = new ArrayList<>(heapCapacity);

        //place all element in heap
        for( int i = 0; i < heapSize; i++) {
            mapAdd(elems[i], i);
            heap.add(elems[i]);
        }

        //Heapify Process, O(n)

        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) sink(i);
    }


    //priority queue construction, O(nlog(n))
    public PQueue(Collection <T> elems) {
        this(elems.size());
        for(T elem : elems) add(elem);
    }


    //Returns true/false depending on if the priority queue is empty
    public boolean isEmpty() {
        return heapSize == 0;
    }


    //Clears everything inside the heap, O(n)
    public void clear() {
        for (int i = 0; i < heapCapacity; i++) {
            heap.set(i, null);
        }

        heapSize = 0;
        map.clear();
    }


    //Return the size of the heap
    public int size() {
        return heapSize;
    }


    /**
     * Returns the value of the element with the lowest
     * priority in this priority queue, if the priority
     * queue is empty null is returned
     * 
     */

     public T peek() {
        if(isEmpty()) return null;
        return heap.get(0);
    }

    //Removes the root of the heap, O(log(n))
    public T poll() {
        return removeAt(0);
    }

    // Rest if an element is in heap, O(1)
     
    public boolean contains(T elem) {
        //Map looking to check containment, O(1)
        if(elem == null) return false;
        return map.containsKey(elem);

        //Linear scan to check containment, O(n)
        // for(int i = 0; i < heapSize; i++) {
        //     if(heap.get(i).equals(elem)) 
        //         return true;
            
        // }
        // return false;
    }


    //Adds an element to the priority queue
    //Element must not be null, O(log(n))
    public void add(T elem) {
        if(elem == null) throw new IllegalArgumentException();

        if(heapSize < heapCapacity) {
            heap.set(heapSize, elem);
        } else {
            heap.add(elem);
            heapCapacity++;
        }

        mapAdd(elem, heapSize);
        swim(heapSize);
        heapSize++;
    }


    //Tests if the value of node i <= node j
    // this method assums i & j are valid indices, O(1)
    private boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }


    //Bottom up node swim, O(log(n))
    private void swim(int k) {
        //Grab the index of the next parent node WRT to k
        int parentIdx = (k - 1) / 2;

        /**
         * Keep swimming while we have not reached the
         * root and while we're less than our parent
         */

        while (k > 0 && less(k, parentIdx)) {
            
            //exchange k with the parent
            swap(parentIdx, k);
            k = parentIdx;

            //Grab the index of the next parent Node WRT to k
            parentIdx = (k-1) / 2;
         }

    }


    //Top down node sink, O(log(n))
    private void sink(int k) {
        while (true) {
            int left = (2 * k) + 1; //left node
            int right = (2 * k) + 2; // right node
            int smallest = left;

            /**
             * Find which is smaller left or right
             * if right is smaller set smallest to be right
             */

             if(right < heapSize && less(right, smallest)) smallest = right;

             //Stop if we're outside the bounds of the tree
             //or stop early if we cannot sink k anymore
             if(left >= heapSize || less(k, smallest)) break;

             //Move down the tree following the smallest node
             swap(smallest, k);
             k = smallest;
        }
    }


    //Swap two nodes. Assumes i & j are valid, O(1)
    private void swap(int i, int j) {
        T i_elem = heap.get(i);
        T j_elem = heap.get(j);

        heap.set(i, j_elem);
        heap.set(j, i_elem);

        mapSwap(i_elem, j_elem, i, j);
    }



    //Removes a particular element in the heap, O(log(n))
    public boolean remove(T element) {
        if(element == null) return false;

        //Linear removal via search, O(n)
        // for(int i = 0; i < heapSize; i++) {
        //     if(element.equals(heap.get(i))) {
        //         removeAt(i);
        //         return true;
        //     }
        // }

        //Logrithmic removal with map, O(log(n))
        Integer index = mapGet(element);
        if(index != null) removeAt(index);
        return index != null;

    }

    //Removes a node at perticular index, O(log(n))
    private T removeAt(int i) {
        if(isEmpty()) return null;

        heapSize--; 
        T removed_data = heap.get(i);
        swap(i, heapSize);

        //obliterate the value
        heap.set(heapSize, null);
        mapRemove(removed_data, heapSize);

        //Remove last element
        if(i == heapSize) return removed_data;

        T elem = heap.get(i);

        //Try sinking element
        sink(i);

        //if Sinking did not work try swimming
        if(heap.get(i).equals(elem)) 
            swim(i);
        
        return removed_data;

    }

    /**
     * Recursively checks if this heap is a min heap
     * This method is just for testing purposes to make
     * sure the heap invariant is still being maintained
     * callled this method with k=0 to start at the root
     */

    public boolean isMinheap(int k) {
        //if we are outside the bounds of the heap return true
        if(k >= heapSize) return true;

        int left = 2 * k + 1;
        int right = 2 * k + 2;

        /**
         *make sure that the current node k is less than
         *both of its children left, and right if they exist 
         *return false otherwise to indicate an invalid heap
        */

        if(left < heapSize && !less(k, left)) return false;
        if(right < heapSize && !less(k, right)) return false;

        //Recurse on both children to make sure they're also valid heap
        return isMinheap(left) && isMinheap(right);

    }

    //Add a node value and it's index to the map
    private void mapAdd(T value, int index) {
        TreeSet <Integer> set = map.get(value);
        //new value being inserted in map
        if(set ==null) {
            set = new TreeSet<>();
            set.add(index);
            map.put(value, set);
            //value already exists in map
        } else set.add(index);
    }


    //Removes the index at a given value, O(log(n))
    private void mapRemove(T value, int index) {
        TreeSet <Integer> set = map.get(value);
        set.remove(index); // Treesets take O(log(n)) removal time
        if(set.size() == 0) map.remove(value);
    }


    //Extract an index position for the given value
    //Note: if a value exists multiple times in the heap the highest
    //index is returned (this has arbitrarily been chosen)
    private Integer mapGet(T value) {
        TreeSet <Integer> set = map.get(value);
        if(set != null) return set.last();
        return null;
    }


    // Exchange the index of two nodes internally within the heap
    private void mapSwap(T val1, T val2, int val1Index, int val2Index) {
        Set<Integer> set1 = map.get(val1);
        Set<Integer> set2 = map.get(val2);

        set1.remove(val1Index);
        set2.remove(val2Index);

        set1.add(val2Index);
        set2.add(val1Index);
    }

    @Override public String toString() {
        return heap.toString();
    }


}
