import linkedlist.SinglyLinkedList;

public class Main {
    

    public static void main(String[] args ) {
        SinglyLinkedList list = new SinglyLinkedList();


        //Insert nodes
        list.insertAtHead(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtTail(40);

        list.insertAtPosition(15, 2);
        
        
        
        //print the list
        System.out.println("Orginal list:");
        list.printList();

        list.delete(20);

         // Print the list after deletion
         System.out.println("\nList after deleting 20:");
         list.printList(); 
    }

}

