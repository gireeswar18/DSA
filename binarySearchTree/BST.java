package datastructures.binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST {

    Node root;


    static class Node {
        int val;
        Node left;
        Node right;

        Node() {

        }
        Node(int val) {
            this.val = val;
        }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public boolean add(int val) {
        if (root == null) {
            root = new Node(val);
            return true;
        }

        Node node = new Node(val);
        Node temp = root;

        while (true) {

            if (temp.val > val) {
                if (temp.left == null) {
                    temp.left = node;
                    return true;
                }
                temp = temp.left;
            }
            else if (temp.val < val) {
                if (temp.right == null) {
                    temp.right = node;
                    return true;
                }
                temp = temp.right;
            }
            else {
                return false;
            }
        }

    }

    public void bfs() {

        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        Node current = root;

        queue.add(current);

        while (!queue.isEmpty()) {

            current = queue.poll();
            res.add(current.val);

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);

        }

        System.out.println(res);

    }

    public void dfsPreOrder() {

        ArrayList<Integer> res = new ArrayList<>();

        class Traverse {

            Traverse(Node current) {
                res.add(current.val);

                if (current.left != null)
                    new Traverse(current.left);

                if (current.right != null)
                    new Traverse(current.right);
            }

        }

        new Traverse(root);

        System.out.println(res);
    }

    public boolean isBalanced(Node root) {
        if (root == null) return true;

        int res = findHeight(root);

        return res != -1;
    }

    public int findHeight(Node curr) {

        if (curr == null) return 0;

        int left = findHeight(curr.left);
        int right = findHeight(curr.right);

        if (Math.abs(left - right) > 1 || left == -1 || right == -1)
            return -1;

        return Math.max(left, right) + 1;
    }

    public int minDepth(Node root) {

        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {

           int size = queue.size();

           while (size-- != 0) {

               Node curr = queue.poll();

               if (curr.left == null && curr.right == null) return level;

               if (curr.left != null) {
                   queue.add(curr.left);
               }
               else {
                   queue.add(curr.right);
               }
           }

            level++;
        }

        return level;

    }


}
