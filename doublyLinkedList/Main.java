package datastructures.binarySearchTree.doublyLinkedList;

public class Main {
    public static void main(String[] args) {

        doublyLinkedList dll = new doublyLinkedList(1);

        dll.append(2);
        dll.append(3);
        dll.append(4);

        dll.printList();

        dll.swapPairs();

        dll.printList();
    }
}
