package stack;

public class PBStack<T> {

    private static class Node<T> {
        Node<T> next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private int size;

    public void push(T t) {

        Node<T> newNode = new Node<>(t);

        if (isEmpty()) {
            head = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }


    public T pop() {
        if (isEmpty()) return null;
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public String printStack() {
        if (isEmpty()) return "";
        StringBuilder builder = new StringBuilder();
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            builder.append(currentNode.data);
            //builder.append(",");
            currentNode = currentNode.next;
        }
        builder.append(currentNode.data);
        return builder.toString();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null || size <= 0;
    }

}
