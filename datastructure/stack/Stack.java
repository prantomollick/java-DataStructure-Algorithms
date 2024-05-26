package datastructure.stack;

public interface Stack<T> {
    //Return the number of elements in the stack
    public int size();

    //Return if the stack is empty
    public boolean isEmpty();

    //push the element into the stack
    public void push(T elem);

    //pop the element off the stack
    public T pop();

    public T peek();
}