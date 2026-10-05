/**
 Diameter of Binary Tree
 Diameter: It is the longest path between any two nodes

 Approach: DFS + Recursion
 - Time Complexity: O(n)
 - Space Complexity: O(h)
 */
public class BinaryTree_Diameter {

    public static Node root;
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Approach: DFS + Recursion
    public static int diameter(Node root) {
        int[] diameter = new int[1];

        height(root, diameter);

        return diameter[0];
    }

    private static int height(Node root, int[] diameter) {

        if (root == null) return 0;

        int leftHeight = height(root.left, diameter);
        int rightHeight = height(root.right, diameter);

        // Diameter passing through current node
        diameter[0] = Math.max(
                diameter[0],
                leftHeight + rightHeight
        );

        return 1 + Math.max(leftHeight, rightHeight);
    }

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

        BinaryTree_Diameter b = new BinaryTree_Diameter();

        b.add(10);
        b.add(5);
        b.add(15);
        b.add(3);
        b.add(7);
        b.add(12);
        b.add(20);

        System.out.println("Diameter: " + diameter(root));
    }
}
