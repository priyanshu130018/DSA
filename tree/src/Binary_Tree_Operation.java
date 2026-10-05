/***
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
 ***/

import java.util.*;

public class Binary_Tree_Operation {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }

    public static TreeNode buildTreeLevelOrder(Scanner sc) {
        System.out.print("Enter root value: ");
        int rootVal = sc.nextInt();
        if (rootVal == -1)
            return null;

        TreeNode root = new TreeNode(rootVal);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            System.out.print("Enter left child of " + current.val + ": ");
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                current.left = new TreeNode(leftVal);
                queue.offer(current.left);
            }

            System.out.print("Enter right child of " + current.val + ": ");
            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                current.right = new TreeNode(rightVal);
                queue.offer(current.right);
            }
        }
        return root;
    }
    // Insert
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            System.out.println("Tree is empty. Create a root first!");
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp.left == null) {
                temp.left = new TreeNode(val);
                break;
            } else {
                q.offer(temp.left);
            }

            if (temp.right == null) {
                temp.right = new TreeNode(val);
                break;
            } else {
                q.offer(temp.right);
            }
        }
        return root;
    }

    // Delete
    public static TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            return (root.val == key) ? null : root;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode target = null, temp = null, parentOfDeepest = null;
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.val == key)
                target = temp;

            if (temp.left != null) {
                parentOfDeepest = temp;
                q.offer(temp.left);
            }
            if (temp.right != null) {
                parentOfDeepest = temp;
                q.offer(temp.right);
            }
        }

        if (target != null) {
            target.val = temp.val;
            if (parentOfDeepest.right == temp)
                parentOfDeepest.right = null;
            else
                parentOfDeepest.left = null;
        }
        return root;
    }


    // Search
    public static boolean search(TreeNode root, int key) {
        if(root==null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp.val==key) return true;
            if (temp.left != null) q.offer(temp.left);
            if (temp.right != null) q.offer(temp.right);
        }
        return false;
    }
    // Inorder Traversal
    public static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Level Order Traversal
    public static void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) q.offer(temp.left);
            if (temp.right != null) q.offer(temp.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("===Build Binary Tree Order===");
        TreeNode root = buildTreeLevelOrder(sc);

        // Inorder
        System.out.print("\nInorder:");
        inorder(root);

        // Level Order Traversal
        System.out.print("\nLevel Order Traversal:");
        levelOrder(root);

        // Search
        System.out.print("\nEnter value to search:");
        int searchVal=sc.nextInt();
        System.out.print(search(root, searchVal) ?"Found!" : "Not found!");


        // Insert
        System.out.print("\nEnter value to insert:");
        int insertVal=sc.nextInt();
        System.out.print("\nLevel Order after insertion:");
        insert(root, insertVal);

        // Delete
        System.out.print("\nEnter value to delete:");
        int deleteVal=sc.nextInt();
        System.out.print("\nLevel Order after deletion:");
        delete(root, deleteVal);

        sc.close();
    }
}