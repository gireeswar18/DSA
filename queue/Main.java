package datastructures.binarySearchTree.queue;

public class Main {
    public static void main(String[] args) {

        Queue q = new Queue(1);

        q.enqueue(2);
        q.enqueue(3);

        System.out.println(q.dequeue().value);
        System.out.println(q.dequeue().value);
        System.out.println(q.dequeue().value);
        System.out.println(q.dequeue());

        q.printQueue();
    }
}
