package datastructure.queue;

/**
 * A queue implementation using a linked list
 * 
 * @param <T> the type of elements in the queue
 * 
 */

public class LinkedQueue<T> implements Iterable<T>, Queue<T> {
    private java.util.LinkedList<T> list = new java.util.LinkedList<T>(); 

    /**
     * Constructs an empty queue
     */
    public LinkedQueue() {}
    

    
    /**
     * Constructs an queue with the given element as the first element.
     * 
     * @param firstElem the first element of the queue
     */
    public LinkedQueue(T firstElem) {
        offer(firstElem);
    }


    /**
     * Returns the number of elements of the queue.
     * 
     * @return the number of elements in the queue
     */

    public int size() {
        return list.size();
    }

    /**
     * Returns true if the queue is empty, flase otherwise
     * 
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }


    /**
     * Returns the element at the front of the queue without removing it.
     * 
     * @return the element at the front of the queue
     * @throws RuntimeException if the queue is empty
     */
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return list.getFirst();
    }

    /**
     * Removes and return the element at the front of the queue
     * @return the element at the front of the queue
     * @throws RuntimeException if the queue is empty
     */

    public T poll() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return list.removeFirst();
    }


    /**
     * add the given element to the rear of the queue.
     *  
     * @param elem the element to add to the queue
     */
    public void offer(T elem) {
        list.addLast(elem);
    }

    /**
     * Returns an iterator over the elements in the queue
     * 
     * @return an iterator over the element in the queue
     */

    @Override
    public java.util.Iterator<T> iterator() {
        return list.iterator();
    }

    
}
