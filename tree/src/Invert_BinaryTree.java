/**
 Invert Binary Tree

 Approach 1: DFS + Recursion
 - Time Complexity: O(n)
 - Space Complexity = O(h)

 Approach 2: DFS + Stack
 - Time Complexity: O(n)
 - Space Complexity = O(h)

 Approach 3: BFS + Queue
 - Time Complexity: O(n)
 - Space Complexity = O(w)

 where
 h = height of tree
 w = width of tree
 */

import java.util.*;

public class Invert_BinaryTree {

    public Node root;
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node invertTree(Node root) {
        // Approach 1: DFS + Recursion

        if (root == null) return null;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;


        /*
        //  Approach 2: BFS + Queue

        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            // Swap left and right
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null)
                queue.offer(current.left);

            if (current.right != null)
                queue.offer(current.right);
        }

        return root;



        //  Approach 3: DFS + Stack
        if(root == null) return null;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            for (int i = 0; i < stack.size(); i++) {

                Node curr = stack.pop();

                Node temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;

                if (curr.left != null)
                    stack.push(curr.left);

                if (curr.right != null)
                    stack.push(curr.right);
            }
        }
        return root;
        */
    }

    // level order traversal
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

        Invert_BinaryTree b = new Invert_BinaryTree();

        b.add(10);
        b.add(5);
        b.add(15);
        b.add(3);
        b.add(7);
        b.add(12);
        b.add(20);

        Node result = invertTree(b.root);
        System.out.println("Inverted Binary Tree: " + levelOrder(result));

    }
}
