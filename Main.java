import datastructure.linkedlist.DoublyLinkedList;
import datastructure.stack.ArrayStack;
import datastructure.stack.IntStack;

public class Main {
    

    public static void main(String[] args ) {
        ArrayStack<int[]> stock = new ArrayStack<int[]>();

        int[] arr = {1, 2, 3};

        stock.push(arr);

        System.out.println(stock.peek());

    }

}

