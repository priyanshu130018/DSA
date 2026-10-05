/**
 Approach: Binary Search Tree (BST)

 Time Complexity:
 - insert()
   - Average       : O(log n)
   - Worst         : O(n)
 - search()
   - Average       : O(log n)
   - Worst         : O(n)
 - delete()
   - Average       : O(log n)
   - Worst         : O(n)

 - findMin()
   - Average       : O(log n)
   - Worst         : O(n)
 - findMax()
   - Average       : O(log n)
   - Worst         : O(n)

 - inorder()       : O(n)
 - preorder()      : O(n)
 - postorder()     : O(n)
 - levelOrder()    : O(n)

 - height()        : O(n)

 Space Complexity: O(n)
 */

import java.util.*;

public class Binary_Search_Tree {

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

    public Binary_Search_Tree() {
        root = null;
    }

    // Check Empty
    public boolean isEmpty() {
        return root == null;
    }

    // Insert
    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {

        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    // Search
    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(Node node, int key) {

        if (node == null)
            return false;

        if (key == node.data)
            return true;

        if (key < node.data)
            return search(node.left, key);

        return search(node.right, key);
    }

    // Find Minimum
    public int findMin() {

        if (isEmpty())
            throw new NoSuchElementException("Tree is empty!");

        Node current = root;

        while (current.left != null)
            current = current.left;

        return current.data;
    }

    // Find Maximum
    public int findMax() {

        if (isEmpty())
            throw new NoSuchElementException("Tree is empty!");

        Node current = root;

        while (current.right != null)
            current = current.right;

        return current.data;
    }

    // Inorder Traversal
    public void inorder() {
        inorder(root);
        System.out.println();
    }
    private void inorder(Node node) {

        if (node == null) return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Preorder Traversal
    public void preorder() {
        preorder(root);
        System.out.println();
    }
    private void preorder(Node node) {

        if (node == null) return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder Traversal
    public void postorder() {
        postorder(root);
        System.out.println();
    }
    private void postorder(Node node) {

        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Level Order Traversal
    public void levelOrder() {

        if (root == null)
            return;

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

        System.out.println();
    }

    // Delete
    public void delete(int data) {

        if (isEmpty()) {
            throw new NoSuchElementException("Tree is empty!");
        }

        root = delete(root, data);
    }

    private Node delete(Node node, int data) {

        if (node == null) {
            throw new NoSuchElementException("Node not found!");
        }

        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {

            // Case 1: No Child
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: One Child
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            // Case 3: Two Children
            Node successor = findMinNode(node.right);

            node.data = successor.data;

            node.right = delete(node.right, successor.data);
        }

        return node;
    }

    // Find Minimum Node
    private Node findMinNode(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // Height
    public int height() {
        return height(root);
    }

    private int height(Node node) {

        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        Binary_Search_Tree bst = new Binary_Search_Tree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.print("Inorder: ");
        bst.inorder();

        System.out.print("Preorder: ");
        bst.preorder();

        System.out.print("Postorder: ");
        bst.postorder();

        System.out.print("Level Order: ");
        bst.levelOrder();

        System.out.println("Minimum: " + bst.findMin());
        System.out.println("Maximum: " + bst.findMax());
        System.out.println("Height: " + bst.height());
        System.out.println("Search 40: " + bst.search(40));

        bst.delete(20);
        System.out.print("After Deleting 20: ");
        bst.inorder();

        bst.delete(30);
        System.out.print("After Deleting 30: ");
        bst.inorder();

        bst.delete(50);
        System.out.print("After Deleting 50: ");
        bst.inorder();

        System.out.println("Is Empty: " + bst.isEmpty());
    }
}