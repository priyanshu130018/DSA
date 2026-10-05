/**
 Preorder, Inorder, Postorder traversal of Binary tree

 Approach: DFS + Recursion
 - Time Complexity: O(n)
 - Auxiliary Space: O(h)
 - Space Complexity: O(n + h) = O(n)
 where
 h = height of tree

 Level Order traversal of Binary tree

 Approach: BFS + Queue
 - Time Complexity: O(n)
 - Auxiliary Space: O(w)
 - Space Complexity = O(n + w) = O(n)
 where
 w = width of tree
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree_Traversal {

    public Node root;
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // PREORDER: Root -> Left -> Right
    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }
    private static void preorder(Node root, List<Integer> result) {
        if (root == null) return;

        result.add(root.data);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    // INORDER: Left -> Root -> Right
    public static List<Integer> inorder(Node root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    private static void inorder(Node root, List<Integer> result) {
        if (root == null) return;

        inorder(root.left, result);
        result.add(root.data);
        inorder(root.right, result);
    }


    // POSTORDER: Left -> Right -> Root
    public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    private static void postorder(Node root, List<Integer> result) {
        if (root == null) return;

        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.data);
    }


    // Level Order
    public static List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> level = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Node current = queue.poll();
                level.add(current.data);

                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);
            }

            result.add(level);
        }
        return result;
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

        BinaryTree_Traversal b = new BinaryTree_Traversal();

        b.add(10);
        b.add(5);
        b.add(15);
        b.add(3);
        b.add(7);
        b.add(12);
        b.add(20);

        System.out.println("Preorder: " + preorder(b.root));

        System.out.println("Inorder: " + inorder(b.root));

        System.out.println("Postorder: " + postorder(b.root));

        List<List<Integer>> res = levelOrder(b.root);
        System.out.println("Level order: " + res);
    }
}
