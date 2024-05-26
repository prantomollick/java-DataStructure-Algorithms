import datastructure.linkedlist.DoublyLinkedList;

public class Main {
    

    public static void main(String[] args ) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();


        //Insert nodes
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // System.out.println(list.toString());
        System.out.println(list.size());
        
        java.util.Iterator<Integer> nextItem = list.iterator();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(nextItem.next());
        }

    }

}

