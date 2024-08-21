package datastructures.binarySearchTree.linkedlist;

import java.util.HashSet;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node (int value) {
            this.value = value;
        }
    }

    public LinkedList (int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList () {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
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

    public void appendList (int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prepend (int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (length == 0)
            tail = newNode;
        length++;
    }

    public Node removeLast () {
        if (length == 0) return null;
        Node pre = head;
        Node temp = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node removeFirst () {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get (int index) {
        if (index < 0 || index >= length)
            return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set (int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert (int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            appendList(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove (int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse () {
        Node temp = head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after = temp.next;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode () {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean hasLoop () {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public Node findKthFromEnd (int k) {
        Node one = head;
        Node two = head;

        for (int i = 0; i < k; i++) {
            if (two != null) {
                two = two.next;
            }
            else {
                return null;
            }
        }

        while (two != null) {
            one = one.next;
            two = two.next;
        }

        return one;
    }

    public void partitionList (int x) {
        if (head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            }
            else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;

        head = dummy1.next;
    }

    public void removeDuplicates () {
        HashSet<Integer> h = new HashSet<Integer>();
        Node current = head;
        Node prev = head;

        while (current != null) {
            if (h.isEmpty()) {
                h.add(current.value);
                current = current.next;
            }
            else if(!h.contains(current.value)) {
                h.add(current.value);
                prev = current;
                current = current.next;
            }
            else {
                prev.next = current.next;
                current.next = null;
                current = prev.next;
            }
        }
    }

    public int binaryToDecimal () {
      int num = 0;
      Node temp = head;
      while (temp != null) {
          num = num * 2 + temp.value;
          temp = temp.next;
      }
      return num;
    }

    public void reverseBetween (int start, int end) {
        if (head == null) return;

        Node dummy = new Node(0);
        dummy.next= head;
        Node prev = dummy;

        for (int i = 0; i < start; i++) {
            prev = prev.next;
        }

        Node current = prev.next;

        for (int i = 0; i < end - start; i++) {
            Node nodetoBeExtracted = current.next;
            current.next = nodetoBeExtracted.next;
            nodetoBeExtracted.next = prev.next;
            prev.next = nodetoBeExtracted;
        }

        head = dummy.next;
    }
}
