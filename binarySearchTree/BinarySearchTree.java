package datastructures.binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return true;
        }
        Node temp = root;
        while (true) {
            if (temp.value == node.value) return false;

            if (node.value < temp.value) {
                if (temp.left == null) {
                    temp.left = node;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;

        while (temp != null) {
            if (temp.value == value) return true;
            if (value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (currentNode.value < value)
            return rContains(currentNode.right, value);
        else
            return rContains(currentNode.left, value);
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value)
            currentNode.left = rInsert(currentNode.left, value);
        else
            currentNode.right = rInsert(currentNode.right, value);

        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        rInsert(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {

        if (currentNode == null) return null;

        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        }
        // if equal
        else {
            // if leaf node
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            }
            // if node has only right node
            else if (currentNode.left == null) {
                currentNode = currentNode.right;
            }
            // if node has only left node
            else if (currentNode.right == null) {
                currentNode = currentNode.left;
            }
            else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }

        return currentNode;
    }

    public void deleteNode(int value) {
        if (root == null) return;
        deleteNode(root, value);
    }

    private int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public ArrayList<Integer> bfs()
    {
        Node current = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        queue.add(current);

        while (!queue.isEmpty())
        {
            current = queue.remove();

            result.add(current.value);

            if (current.left != null)
            {
                queue.add(current.left);
            }
            if (current.right != null)
            {
                queue.add(current.right);
            }
        }

        return result;
    }

    public ArrayList<Integer> dfsPreorder()
    {
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse {
            Traverse(Node curr)
            {
                result.add(curr.value);
                if (curr.left != null)
                {
                    new Traverse(curr.left);
                }
                if (curr.right != null)
                {
                    new Traverse(curr.right);
                }
            }
        }

        new Traverse(root);
        return result;
    }

    public ArrayList<Integer> dfsPostorder()
    {
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse {
            Traverse(Node curr)
            {
                if (curr.left != null)
                {
                    new Traverse(curr.left);
                }
                if (curr.right != null)
                {
                    new Traverse(curr.right);
                }
                result.add(curr.value);
            }
        }

        new Traverse(root);

        return result;
    }

    public ArrayList<Integer> dfsInorder()
    {
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse {
            Traverse(Node curr)
            {
                if (curr.left != null)
                {
                    new Traverse(curr.left);
                }
                result.add(curr.value);
                if (curr.right != null)
                {
                    new Traverse(curr.right);
                }
            }
        }

        new Traverse(root);

        return result;
    }
}
