package linkedlist;

import exception.PBException;

public class PBLinkedList<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T t) {
            this.data = t;
        }

    }

    private Node<T> head;
    private Node<T> tail;

    private int size = 0;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Add to front on  linked list
     *
     * @param t
     */
    public void addToFront(T t) {

        Node<T> newNode = new Node<>(t);

        // To check if linkedlist is empty
        if (head == null) {
            head = tail = newNode;
            size++;
            //System.out.println("Added to empty linked list successfully");
            return;
        }

        //To add and point to currenthead
        newNode.next = head;

        //assign newnode to head
        head = newNode;
        size++;
//        System.out.println("Added to linked list successfully");
    }


    /**
     * Insert the element in the last of linkedlist
     *
     * @param t
     */

    public void insertLast(T t) {
        Node<T> newNode = new Node<>(t);

        if (tail == null) {
            head = tail = newNode;
            size++;
            //  System.out.println("Insert head successfully");
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
        //System.out.println("Insert successfully");
    }

    /**
     * Add the element in the last place of the list ( Brute force method)
     *
     * @param t
     */
    public void addToLast(T t) {

        Node<T> newNode = new Node<>(t);

        if (head == null) {
            head = newNode;
            size++;
//            System.out.println("Added to end of linked list successfully");
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        //tail = currentNode;
        size++;
//        System.out.println("Added into Last of linked list successfully");
    }


    /**
     * To get the first element from the linked list
     *
     * @return
     */
    public T getFirst() throws PBException {
        if (head == null) throw new PBException("Oops..Linkedlist is empty");
        System.out.println("Head is " + head.data);
        return head.data;
    }


    /**
     * To get the last element from linked list using tail
     *
     * @return
     * @throws PBException
     */

    public T getTail() throws PBException {
        if (tail == null) throw new PBException("Oops..Linkedlist is empty");
        System.out.println("Tail is " + tail.data);
        return tail.data;
    }

    /**
     * To get the last data from linked list
     *
     * @return
     */
    public T getLast() throws PBException {

        //to check if head is null
        if (head == null) throw new PBException("Ohh man..! Linked list is empty..!");

        Node<T> current = head;
        //Navigate up to the last node & check next node is null
        while (current.next != null) {
            current = current.next;
        }
//        System.out.println("Tail is " + current.data);
        return current.data;
    }


    public void deleteElement(T t) {
        if (head == null) {
            System.out.println("Ooops.. List is empty");
            return;
        }
        //to check delete element is first one

        if (head.data == t) {
            head = head.next;
            System.out.println("Delete from head successfully");
            size--;
            return;
        }

        //to delete somewhere of the list

        Node<T> currentNode = head;
        while (currentNode != null && currentNode.data != t) {
            currentNode = currentNode.next;
        }
        if (currentNode == null) {
            System.out.println("Delete Element is not found");
            return;
        }

        if (currentNode == tail) {
            currentNode.next = null;
            tail = currentNode;
            size--;
            System.out.println("Delete Tail Successfully");
            return;
        }
        System.out.println("Delete Element is " + currentNode.data);
        currentNode.next = currentNode.next.next;
        //System.out.println("Delete Element is "+currentNode.next);.println("Delete from list successfully");
        size--;
    }


    public void clearItems() {
        head = null;
        size = 0;
    }

    public void removeElement(T t) {

        // To check if it is head
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == t) {
            System.out.println("Delete head value -> done" + head.data);
            head = head.next;
            size--;
            return;
        }
        // To check if it is in between of list

        Node<T> currentNode = head;
        boolean isElementFound = false;
        while (currentNode.next != null) {
            if (currentNode.next.data == t) {
                isElementFound = true;
                System.out.println("Delete value -> done" + currentNode.next.data);
                currentNode.next = currentNode.next.next;
                break;
            }
            currentNode = currentNode.next;
        }

        if (currentNode.next == null) {
            tail = currentNode;
        }

        if (!isElementFound) {
            System.out.println("Element not found..Not able to delete..!");
            return;
        }

//        currentNode = currentNode.next;

        size--;

    }

    public void printAll() {
        if (size > 0) {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                System.out.println(currentNode.data + ",");
                currentNode = currentNode.next;
            }
            System.out.println(currentNode.data + ",");
        }

    }

}
