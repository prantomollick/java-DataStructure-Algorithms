package datastructure.linkedlist;

public class DoublyLinkedList<T> implements Iterable<T> {
        private int size = 0;
        private Node<T> head = null;
        private Node<T> tail = null;

        //Internal node class to represent data
        private static class Node<T> {
            private T data;
            private Node<T> prev, next;

            public Node(T data, Node<T> prev, Node<T> next) {
                this.data = data;
                this.prev = prev;
                this.next = next;
            }

            @Override
            public String toString() {
                return data.toString();
            }

        }


    // Empty this linked list, O(n)
    public void clear() {
        Node<T> trav = head;

        while (trav != null) {
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }

        head = tail = trav = null;
        size = 0;
    }


    //return the size of this linked List
    public int size() {
        return size;
    }


    //Is this linked list empty?

    public boolean isEmpty() {
        return size() == 0;     
    }

    //Add an element to the tail of the linked list, O(1)
    public void add(T elem) {
        addLast(elem);
    }


    //Add a node to the tail of the linked list, O(1)
    public void addLast(T elem) {
        if(isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }


    //Add an element to the beginning of this linked list, 
    public void addFirst(T elem) {
        if(isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }

        size++;

    }

    //Add an element at a specified index
    public void addAt(int index, T data) throws Exception {
        if(index < 0 || index > size) {
            throw new Exception("Index out of bounds");
        }

        if(index == 0) {
            addFirst(data);
            return;
        }

        if(index == size) {
            addLast(data);
            return;
        }


        Node<T> temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node<T> newNode = new Node<>(data, temp, temp.next);
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;

    }
    

    // Check the value of the first node if it exists, O(1)
    public T peekfirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    //check the value of the last node if it exists, O(1)
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    // Remove the first value at the head of the linked list, O(1)
    public T removeFirst() {
        //Cann't remove data from an empty list
        if (isEmpty()) throw new RuntimeException("Empty list");

        T data = head.data;
        head = head.next;
        --size;


        //if the list is empty set the tail to null
        if(isEmpty()) tail = null;

        //Do a memory cleanup of the previous node
        else head.prev = null;

        //Return the data that was at the first node we just removed
        return data;
    }



    //Remove the last value at the tail of the linked List, O(1)

    public T removeLast() {
        //Cann't remove data from an empty list
        if(isEmpty()) throw new RuntimeException("Empty List");

        //Extract the data at the tail and move
        // the tail pointer backwards one node
        T data = tail.data;
        tail = tail.prev;
        --size;


        //if the last is now empty set the head to null
        if(isEmpty()) head = null;
        
        //Do a memory cleanup of the previous node
        else tail.next = null;


        //Return the data that was in the last node we just removed;
        return data;
    }   

    // Remove an arbitrary node from the linked list, O(1)
    @SuppressWarnings("unused")
    private T remove(Node<T> node) {
        //if the node to remove is somewhere either at the
        //head or the taail handle those independently
        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();

        //Make the pointers of adjacent nodes skip over 'node'
        node.prev.next = node.next;
        node.next.prev = node.prev;

        //Temporarily store the data we want to return
        T data = node.data;

        //Memory cleanup 
        node.data = null;
        node = node.prev = node.next = null;
        --size;


        // Return the data in the node we just removed
        return data;
    }


    //Remove a node a particular index, O(n)
    public T removeAt(int index) {
        //if the index is out of bounds throw an exception
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");

        int i;
        Node<T> trav;

        //Search from the front of the list
        if(index < size/2) {
            for (i = 0, trav = head; i != index; i++) {
                trav = trav.next;
            }

        // Search from the back of the list
        }else {
            for (i = size - 1, trav = tail; i != index; i--) {
                trav = trav.prev;
            }
        }

        return remove(trav);
    }



    //remove a particular value in the linked list, O(n)
    public boolean remove(Object obj) {
        Node<T> trav = head;

        //Support searching for null
        if(obj == null) {
            for(trav = head; trav != null; trav = trav.next) {
                if(trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
            //search for non null object
        } else {
            for(trav = head; trav != null; trav = trav.next) {
                if(obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }

        return false;
    }


    //Find the index of a particular value in the linked list, O(n)
    public int indexOf(Object obj) {
        int index = 0;
        Node<T> trav = head;

        //Support searching for null
        if(obj == null) {
            for(; trav != null; trav = trav.next, index++) {
                if(trav.data == null) {
                    return index;
                }
            }

            //Search for non null object
        } else {
            for(; trav != null; trav = trav.next, index++) {
                if(obj.equals(trav.data)) {
                    return index;
                }
            }
        }

        return -1;
    }


    //check is a value is contained within the linked list
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }


    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head;


            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while(trav != null) {
            sb.append(trav.data);
            if(trav.next != null) {
                sb.append(", ");
            }
            trav = trav.next;
        }
        sb.append(" ]");

        return sb.toString();
    }
}
