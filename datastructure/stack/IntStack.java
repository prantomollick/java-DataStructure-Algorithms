/**
 * This file contains an implementation of an integer only stack which is extremely quick and 
 * lightwight. In terms of performance it can outperform java.util.ArrayDeque (Java's fastest stack implementation)
 * 
 */

package datastructure.stack;

public class IntStack implements Stack<Integer> {
    private int[] arr;
    private int pos = 0;

    //MaxSize is that maximum number of items
    // that can be in the queue at any given time
    public IntStack(int maxSize) {
        arr = new int[maxSize];
    }


    // Returns the number of elements insize the stack
    public int size() {
        return pos;
    }


    //Returns true/false on whether the stack is empty
    public boolean isEmpty() {
        return pos == 0;
    }


    //Returns the element at the top of the stack
    @Override
    public Integer peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[pos - 1];
    }

    //Add an element to the top of the stack
    @Override
    public void push(Integer value) {
        arr[pos++] = value;
    }


    //make sure you check that the stack is not empty befor calling pop
    @Override
    public Integer pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[--pos];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Stack: [");
        for (int i = 0; i < pos - 1; i++) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[pos-1] + "]");
        return sb.toString();
    }

}
