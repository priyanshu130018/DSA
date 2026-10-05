/**
 Height of Binary Tree
 Maximum Depth of Binary Tree

 Approach: DFS + Recursion
 - Time Complexity: O(n)
 - Space Complexity: O(h)
 where
 h = height of tree
 */
public class BinaryTree_Height {

    public Node root;
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Approach: DFS + Recursion
    public static int height(Node root) {

        if (root == null) return 0;

        return 1 + Math.max(
                height(root.left),
                height(root.right)
        );
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

        BinaryTree_Height b = new BinaryTree_Height();

        b.add(10);
        b.add(5);
        b.add(15);
        b.add(3);
        b.add(7);
        b.add(12);
        b.add(20);

        int res = height(b.root);
        System.out.println("Height: " + res);
    }
}


