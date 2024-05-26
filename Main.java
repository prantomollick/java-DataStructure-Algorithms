import datastructure.linkedlist.DoublyLinkedList;
import datastructure.stack.ArrayStack;
import datastructure.stack.IntStack;

public class Main {
    

    public static void main(String[] args ) {
        ArrayStack<String> stock = new ArrayStack<String>();

        

        stock.push("Rahim");
        stock.push("Kadher");
        stock.push("Salam");

        System.out.println(stock.peek());

    }

}

