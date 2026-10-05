public class AVL {
    static class Node {
        int item, height;
        Node left, right;

        Node(int d) {
            item = d;
            height = 1;
        }
    }
    Node root;

    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int max(int a, int b) {
        return Math.max(a, b);
    }

    Node RotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node RotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalanceFactor(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    Node insertNode(Node node, int item) {
        if (node == null)
            return (new Node(item));

        if (item < node.item)
            node.left = insertNode(node.left, item);
        else if (item > node.item)
            node.right = insertNode(node.right, item);
        else
            return node;

        node.height = 1 + max(height(node.left), height(node.right));

        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (item < node.left.item)
                return RotateRight(node);
            else if (item > node.left.item) {
                node.left = RotateLeft(node.left);
                return RotateRight(node);
            }
        }

        if (balanceFactor < -1) {
            if (item > node.right.item)
                return RotateLeft(node);
            else if (item < node.right.item) {
                node.right = RotateRight(node.right);
                return RotateLeft(node);
            }
        }

        return node;
    }

    Node nodeWithMinimumValue(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    Node deleteNode(Node root, int item) {
        if (root == null)
            return root;

        if (item < root.item)
            root.left = deleteNode(root.left, item);
        else if (item > root.item)
            root.right = deleteNode(root.right, item);
        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;

                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node temp = nodeWithMinimumValue(root.right);
                root.item = temp.item;
                root.right = deleteNode(root.right, temp.item);
            }
        }

        if (root == null)
            return root;

        root.height = max(height(root.left), height(root.right)) + 1;

        int balanceFactor = getBalanceFactor(root);

        if (balanceFactor > 1) {
            if (getBalanceFactor(root.left) >= 0)
                return RotateRight(root);
            else {
                root.left = RotateLeft(root.left);
                return RotateRight(root);
            }
        }

        if (balanceFactor < -1) {
            if (getBalanceFactor(root.right) <= 0)
                return RotateLeft(root);
            else {
                root.right = RotateRight(root.right);
                return RotateLeft(root);
            }
        }

        return root;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.item + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void printTree(Node currPtr, boolean last) {
        if (currPtr != null) {
            System.out.print(currPtr.item + " ");
            printTree(currPtr.left, false);
            printTree(currPtr.right, true);
        }
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.root = tree.insertNode(tree.root, 40);
        tree.root = tree.insertNode(tree.root, 20);
        tree.root = tree.insertNode(tree.root, 10);

        System.out.println("\nAVL : ");

        tree.printTree(tree.root,true);
    }
}
