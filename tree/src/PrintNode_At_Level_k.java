/**
 Print the nodes at level k of Binary Tree

 Approach: DFS + Recursion
 - Time Complexity: O(n)
 - Space Complexity: O(h)
 where
 h = height of tree
 */
public class PrintNode_At_Level_k {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Approach: DFS + Recursion
    public static void printLevel(Node root, int k) {

        if (root == null) return;

        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }

        printLevel(root.left, k - 1);
        printLevel(root.right, k - 1);
    }

    public static void main(String[] args) {

        Node root = new Node(10);

        root.left = new Node(5);
        root.right = new Node(15);

        root.left.left = new Node(3);
        root.left.right = new Node(7);

        root.right.left = new Node(12);
        root.right.right = new Node(20);

        int k = 2;
        System.out.print("Nodes at level " + k + ": ");
        printLevel(root, k);
    }
}