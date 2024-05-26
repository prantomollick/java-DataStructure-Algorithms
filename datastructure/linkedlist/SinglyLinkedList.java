package datastructure.linkedlist;

public class SinglyLinkedList {


    //Inner Class to represent a node in the linekd List
    private static class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node in the list

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    private Node head; // Reference to the first node (head) of the list

    // Constructor to initialize an empty linked list
    public SinglyLinkedList() {
        head = null;
    }

    // Method to insert a new node at the beginning of the list
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head; //New Node points to the current head
        head = newNode; //New Node becomes the new head
    }

    //Method to insert a new node at the end of the list
    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            //If the list is empty, the new node becomes the head
            head = newNode;
            return;
        }

        Node current = head;

        while(current.next != null) {
            //Traverse the list to find the last node
            current = current.next;
        }
        current.next = newNode;

    }


    //Insert
    public void insert(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }


    //Method to insert a new Node at a specific Position
    public void insertAtPosition(int data, int position) {
        if(position < 1) {
            System.out.println("Invalid position. Position must be greater than or equal to 1.");;
            return;
        }

        if(position == 1) {
            //Insert at head if position is 1;
            insertAtHead(data);
            return;
        }


        Node newNode = new Node(data);
        Node current = head;
        int count = 1;

        while (count < position - 1 && current.next != null) {
            current = current.next;
            count++;
        }

        if(count == position - 1) {
            newNode.next = current.next;
            current.next = newNode;
        } else {
            System.out.println("Invalid position. Position exceds the list size.");
        }

    }


    //Method to delete a node with the given data
    public void delete(int key) {
        if(head == null) return; //If the list is empty, return

        //Handle case where the head needs to be deleted
        if(head.data == key) {
            head = head.next;
            return;
        }



        Node current = head;
        Node previous = null; //Reference to the previous node

        while (current != null && current.data != key) {
            previous = current;
            current = current.next;
        }

        if(current == null) {
            //Key not found in the list
            return;
        }


        //Update the 'next' pointer of the previous node to skip the current node
        previous.next = current.next;
    }


    //Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null"); //Mark the end of the list
    }

}
