/**
 Check if two binary tree are same or not

 Approach: DFS + Recursion
 - Time Complexity: O(n)
 - Space Complexity = O(h)
 where
 h = height of tree
 */

import java.util.*;

public class Check_Same_Tree {

    public Node root;
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean checkSameTree(Node r1, Node r2) {
        // Approach: DFS + Recursion

        if (r1 == null && r2 == null) return true;

        if (r1 == null || r2 == null) return false;

        if (r1.data != r2.data)
            return false;

        return checkSameTree(r1.left, r2.left)
                && checkSameTree(r1.right, r2.right);
    }


    // add
    public void add(int data) {
        root = add(root, data);
    }

    private Node add(Node root, int data) {

        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = add(root.left, data);
        else
            root.right = add(root.right, data);

        return root;
    }


    public static void main(String[] args) {

        Check_Same_Tree b1 = new Check_Same_Tree();
        Check_Same_Tree b2 = new Check_Same_Tree();

        b1.add(10);
        b1.add(5);
        b1.add(15);
        b1.add(3);
        b1.add(7);
        b1.add(12);
        b1.add(20);

        b2.add(10);
        b2.add(5);
        b2.add(15);
        b2.add(3);
        b2.add(7);
        b2.add(12);
        b2.add(20);

        if (checkSameTree(b1.root, b2.root))
            System.out.println("Same Tree");
        else
            System.out.println("Different Tree");

    }
}

