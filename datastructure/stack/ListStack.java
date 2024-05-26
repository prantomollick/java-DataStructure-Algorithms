package datastructure.stack;

public class ListStack<T> implements Iterable<T>, Stack<T> {
    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

    //Create an empty stack with default constructor method
    public ListStack() {}

    //Create a stack with an initial element
    public ListStack(T firstElem) {
        push(firstElem);
    }

    //Return the number of element in the stack
    public int size() {
        return list.size();
    }

    //Check if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }


    //push an element into the stack
    public void push(T elem) {
        list.addFirst(elem);
    }


    //Pop an element off the stack 
    //throws an error is the stack is empty
    public T pop() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return list.removeLast();
    }


    //Peek the top of the stack without removing an element
    //throws an exception if the stack is empty
    public T peek() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }

        return list.peekLast();
    }


    //Searches for the element starting from top of the stack
    // returns -1 if the element is not present in the stack

    public int search(T elem) {
        return list.indexOf(elem);
    }

    //Allow users to iterate through the stack using an iterator
    @Override
    public java.util.Iterator<T> iterator() {
        return list.iterator();
    }

}
