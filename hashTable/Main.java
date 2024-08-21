package datastructures.hashTable;

public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable();

        ht.set("Virtus", 18);
        ht.set("Ecosport", 8);
        ht.set("Polo", 10);
        ht.set("Polo GT", 12);
        ht.set("Endeavour", 40);
        ht.set("Innova", 30);

        ht.printTable();

        System.out.println(ht.getKeys());
    }
}
