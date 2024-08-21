package datastructures.binarySearchTree.classes;

public class Main {
    public static void main(String[] args) {

        Cookie one = new Cookie("Red");
        Cookie two = new Cookie("Blue");

        one.setColor("White");

        System.out.println(one.getColor());
        System.out.println(two.getColor());
    }
}
