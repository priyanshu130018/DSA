/**
 Approach: Binary Tree

 Time Complexity:
 - insert()          : O(n)
 - delete()          : O(n)
 - search()          : O(n)

 - preorder()        : O(n)
 - inorder()         : O(n)
 - postorder()       : O(n)
 - levelOrder()      : O(n)

 - height()          : O(n)
 - countNodes()      : O(n)
 - countLeafNodes()  : O(n)

 Space Complexity: O(n)
 */

import java.util.*;

public class Binary_Tree {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;

    public Binary_Tree() {
        root = null;
    }

    // Check Empty
    public boolean isEmpty() {
        return root == null;
    }

    // Insert (Level Order)
    public void insert(int data) {

        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            if (current.left == null) {
                current.left = newNode;
                return;
            }
            else {
                queue.offer(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                return;
            }
            else {
                queue.offer(current.right);
            }
        }
    }

    // Search
    public boolean search(int key) {

        if (root == null) return false;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node current = queue.poll();
            if (current.data == key) {
                return true;
            }

            if (current.left != null)
                queue.offer(current.left);

            if (current.right != null)
                queue.offer(current.right);
        }

        return false;
    }

    // Preorder Traversal (Root -> Left -> Right)
    public void preorder() {
        preorder(root);
    }

    private void preorder(Node node) {

        if (node == null) return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder Traversal (Left -> Root -> Right)
    public void inorder() {
        inorder(root);
    }
    private void inorder(Node node) {

        if (node == null) return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Postorder Traversal (Left -> Right -> Root)
    public void postorder() {
        postorder(root);
    }
    private void postorder(Node node) {

        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Level Order Traversal
    public void levelOrder() {

        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null)
                queue.offer(current.left);

            if (current.right != null)
                queue.offer(current.right);
        }

    }

    // Height of Tree
    public int height() {
        return height(root);
    }
    private int height(Node node) {

        if (node == null) return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Count Total Nodes
    public int countNodes() {
        return countNodes(root);
    }
    private int countNodes(Node node) {

        if (node == null) return 0;

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Count Leaf Nodes
    public int countLeafNodes() {
        return countLeafNodes(root);
    }

    private int countLeafNodes(Node node) {

        if (node == null) return 0;

        if (node.left == null && node.right == null) return 1;

        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    // Delete Node
    public void delete(int key) {

        if (root == null) {
            throw new NoSuchElementException("Tree is empty!");
        }

        // Only root node exists
        if (root.left == null && root.right == null) {
            if (root.data == key) {
                root = null;
                return;
            }
            throw new NoSuchElementException("Node not found!");
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        Node target = null;
        Node current = null;
        Node last = null;

        while (!queue.isEmpty()) {

            current = queue.poll();

            if (current.data == key)
                target = current;

            if (current.left != null) {
                last = current.left;
                queue.offer(current.left);
            }

            if (current.right != null) {
                last = current.right;
                queue.offer(current.right);
            }
        }

        if (target == null) {
            throw new NoSuchElementException("Node not found!");
        }

        target.data = last.data;
        deleteDeepest(last);
    }

    // Delete Deepest Node
    private void deleteDeepest(Node deepest) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            if (current.left != null) {

                if (current.left == deepest) {
                    current.left = null;
                    return;
                }

                queue.offer(current.left);
            }

            if (current.right != null) {

                if (current.right == deepest) {
                    current.right = null;
                    return;
                }

                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("\nInorder: ");
        tree.inorder();

        System.out.print("\nPostorder: ");
        tree.postorder();

        System.out.print("\nLevel Order: ");
        tree.levelOrder();

        System.out.println("\nHeight: " + tree.height());
        System.out.println("Total Nodes: " + tree.countNodes());
        System.out.println("Leaf Nodes: " + tree.countLeafNodes());
        System.out.println("Search 50: " + tree.search(50));

        tree.delete(30);
        System.out.print("Level Order After Delete: ");
        tree.levelOrder();
    }
}