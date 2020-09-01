package queue;

public class PBQueueCheck {

    public static void main(String[] args) {
        PBQueue<Integer> ids = new PBQueue<>();
        ids.enqueue(10);
        ids.enqueue(20);
        ids.enqueue(30);
        ids.enqueue(40);

        ids.dequeue();
        ids.enqueue(50);
        ids.dequeue();

        System.out.println(ids.printQueue());
    }

}
