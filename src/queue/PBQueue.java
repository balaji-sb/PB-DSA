package queue;

public class PBQueue<T> {

    private static class Node<T> {

        Node<T> next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void enqueue(T t) {
        Node<T> newNode = new Node<>(t);

        if (isEmpty()) {
            head = tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public String printQueue() {
        StringBuilder value = new StringBuilder();
        if (isEmpty()) return value.toString();

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            value.append(currentNode.data);
            value.append(',');
            currentNode = currentNode.next;
        }
        value.append(currentNode.data);
        return value.toString();
    }


}
