package datastructures.binarySearchTree.doublyLinkedList;

public class doublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node (int value) {
            this.value = value;
        }
    }

    public doublyLinkedList (int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }


    public void printList () {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void getHead () {
        System.out.println("Head: " + head.value);
    }

    public void getTail () {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength () {
        System.out.println("Length: " + length);
    }

    public void append (int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast () {
        if (length == 0) return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public void prepend (int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst () {
        if (length == 0) return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get (int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        else {
            temp = tail;
            for (int i = length - 1; i > index ; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set (int index, int value) {
        if (index < 0 || index >= length) return false;
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert (int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;

        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;

        return true;
    }

    public Node remove (int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node temp = get(index);

        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;

        return temp;
    }

    public void swapFirstandLast () {
        if (length < 2) return;
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        if (length < 2) return;

        temp = tail;

        for (int i = 0; i < length; i++) {
            Node after = temp.next;
            temp.next = temp.prev;
            temp.prev = after;
            temp = after;
        }
    }

    public boolean isPalindrome () {
        if (length == 0) return true;

        Node t1 = head;
        Node t2 = tail;

        for (int i = 0; i < length / 2; i++) {
            if (t1.value == t2.value) {
                t1 = t1.next;
                t2 = t2.prev;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public void swapPairs () {
        if (head == null) return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        Node one = head;
        Node two = one.next;

        while (two != null) {
            prev.next = two;
            one.next = two.next;
            two.next = one;

            one.prev = two;
            two.prev = prev;
            prev = one;

            if (one.next != null) {
                one.next.prev = one;
                one = one.next;
            }
            two = one.next;
        }
        head = dummy.next;
        head.prev = null;
    }
}
