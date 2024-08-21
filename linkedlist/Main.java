package datastructures.binarySearchTree.linkedlist;

public class Main {

    public static void main(String[] args) {

        LinkedList list1 = new LinkedList(1);
        list1.appendList(2);
        list1.appendList(3);
        list1.appendList(4);
        list1.appendList(5);


        list1.printList();

        list1.reverseBetween(2, 4);

        list1.printList();
    }

}
