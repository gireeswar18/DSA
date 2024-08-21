package datastructures.hashTable;

import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;

        Node (String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable () {
        dataMap = new Node[size];
    }

    public void printTable () {
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            System.out.print(i + ": {");
            while (temp != null) {
                System.out.print(temp.key + ": " + temp.value + ", ");
                temp = temp.next;
            }
            System.out.println("}");
        }
    }

    public int hash (String key) {
        char[] arr = key.toCharArray();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int ascii = arr[i];
            index = (index + ascii * 23) % dataMap.length;
        }
        return index;
    }

    public void set (String key, int value) {
        int index = hash(key);
        Node node = new Node(key, value);

        if (dataMap[index] == null) {
            dataMap[index] = node;
        }
        else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public int get (String key) {
        int index = hash(key);
        if (dataMap[index] == null) return 0;

        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key == key) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList<String> getKeys() {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            if (dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    arr.add(temp.key);
                    temp = temp.next;
                }
            }
        }
        return arr;
    }
}
