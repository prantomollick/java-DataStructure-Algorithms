package datastructure.priorityqueue;

import java.util.List;

public class BinayHeapQuickRemovals<T extends Comparable<T>> {
    
    //A dynamic list to track the elements inside the heap
    private List<T> heap = null;


    /**
     * This map keeps track of the possible indices a particular
     * node value is found in the heap. having this mapping lets
     * us have O(long(n)) removals and O(1) element containment check
     * at the cost of some additional space and minor overhead
     */


}
