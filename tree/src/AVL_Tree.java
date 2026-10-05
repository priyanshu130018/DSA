/**
 Approach: AVL Tree

 Time Complexity:
 - insert()          : O(log n)
 - search()          : O(log n)
 - delete()          : O(log n)

 - findMin()         : O(log n)
 - findMax()         : O(log n)

 - preorder()        : O(n)
 - inorder()         : O(n)
 - postorder()       : O(n)
 - levelOrder()      : O(n)

 Space Complexity: O(n)
 */

import java.util.*;

public class AVL_Tree {

    public static class Node {
        int data;
        int height;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    private Node root;

    public AVL_Tree() {
        root = null;
    }

    // Check Empty
    public boolean isEmpty() {
        return root == null;
    }

    // Height
    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Balance Factor
    private int getBalance(Node node) {

        if (node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

    // Right Rotation
    private Node rightRotate(Node y) {

        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left Rotation
    private Node leftRotate(Node x) {

        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert
    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {

        if (node == null)
            return new Node(data);

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // LL Case
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);

        // RR Case
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);

        // LR Case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL Case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
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

    // Inorder
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {

        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Preorder
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node) {

        if (node == null)
            return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder
    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node) {

        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Find Minimum Node
    private Node minNode(Node node) {

        while (node.left != null)
            node = node.left;

        return node;
    }

    // Delete
    public void delete(int data) {

        if (isEmpty())
            throw new NoSuchElementException("Tree is empty!");

        root = delete(root, data);
    }

    private Node delete(Node node, int data) {

        if (node == null)
            throw new NoSuchElementException("Node not found!");

        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {

            // One child or no child
            if (node.left == null || node.right == null) {

                Node temp;

                if (node.left != null)
                    temp = node.left;
                else
                    temp = node.right;

                if (temp == null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {

                // Two children
                Node temp = minNode(node.right);

                node.data = temp.data;

                node.right = delete(node.right, temp.data);
            }
        }

        if (node == null)
            return null;

        // Update Height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // LL
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);

        // LR
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RR
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);

        // RL
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Find Minimum
    public int findMin() {

        if (isEmpty())
            throw new NoSuchElementException("Tree is empty!");

        return minNode(root).data;
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

    public static void main(String[] args) {

        AVL_Tree tree = new AVL_Tree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();

        System.out.print("Level Order: ");
        tree.levelOrder();

        System.out.println("Minimum: " + tree.findMin());

        System.out.println("Maximum: " + tree.findMax());

        System.out.println("Search 25: " + tree.search(25));

        tree.delete(40);

        System.out.print("After Deleting 40: ");
        tree.inorder();

        System.out.println("Is Empty: " + tree.isEmpty());
    }
}