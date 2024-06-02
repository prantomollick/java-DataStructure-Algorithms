package datastructure.queue;

/**
 * An implementation of a queue using an array.
 * This implementation uses a circular array to avoid the need for shifting elements when dequeuing.
 * @param <T> the type of elements in the queue
 */


public class ArrayQueue<T> implements Queue<T>  {
    private Object[] data;
    private int front, rear;


    /**
     * Constructs a new ArrayQueue with the specified capacity
     * The maximum size of the queue is `capacity - 1`
     * @param capatiy the initial capacity of the queue
     */

    public ArrayQueue(int capatiy) {
        // ArrayQueue maximum size is data.length - 1
        data = new Object[capatiy + 1];
        front = 0;
        rear = 0;
    }

    /**
     * Inserts an element at rear of the queue.
     * if the queue is full, a `RuntimeException` is thrown
     * @param elem the element to be inserted
     */

    @Override
    public void offer(T elem) {
        if (isFull()) throw new RuntimeException("Queue is full");
        data[rear++] = elem;
        rear = adjustIndex(rear, data.length);

    }

    /**
     * Retrives and removes the head of the queue.
     * if the queue is empty, a `RuntimeException` is thrown
     * @return the head of the queue
    */

    @SuppressWarnings("unchecked")
    @Override
    public T poll() {
        if(isEmpty()) throw new RuntimeException("Queue is empty!");
        front = adjustIndex(front, data.length);
        return (T) data[front++];
    }

    /**
     * Retrives, but does not remove, the head of the queue. 
     * if the queue empty, a `RuntimeException` is thrown
     * @return the head of the queue
     */

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        front  = adjustIndex(front, data.length);
        return (T) data[front];
    }

    /**
     * Returns the number of elements in the queue.
     * @return the size of the queue
     */

    @Override
    public int size() {
        return adjustIndex(rear + data.length - front, data.length);
    }


    /**
     * Returns `true` if the queue is empty, `false` otherwise
     * @return `true` if the queue is full, `false` otherwise
     */

    @Override
    public boolean isEmpty() {
        return rear == front;
    }


    /**
     * Returns `true` if the queue is full, `false` otherwise
     * @return `true` if the queue is full, `false` otherwise
     */
    public boolean isFull() {
        return (front + data.length - rear) % data.length == 1;
    }


    /**
     * Asjusts an index to be within bounds of the array.
     * @param index the index to adjust
     * @param size the size of the array
     * @return the adjusted index
     */

    private int adjustIndex(int index, int size) {
        return index >= size ? index - size : index;
    }
    
}
