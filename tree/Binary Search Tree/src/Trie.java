/**
 Approach: Trie (Prefix Tree)

 Time Complexity:
 - insert()      : O(L)
 - search()      : O(L)
 - startsWith()  : O(L)
 - delete()      : O(L)
 - display()     : O(n)
 L = Length of the word

 Space Complexity: O(26 × Number of Nodes)
 */

import java.util.*;

public class Trie {

    class TrieNode {

        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Check Empty
    public boolean isEmpty() {

        for (TrieNode child : root.children) {
            if (child != null)
                return false;
        }

        return true;
    }

    // Insert
    public void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    // Search
    public boolean search(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return current.isEndOfWord;
    }

    // Starts With
    public boolean startsWith(String prefix) {

        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return true;
    }

    // Display All Words
    public void display() {
        display(root, "");
    }

    private void display(TrieNode node, String word) {

        if (node.isEndOfWord) {
            System.out.println(word);
        }

        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {

                char ch = (char) (i + 'a');

                display(node.children[i], word + ch);
            }
        }
    }

    // Delete
    public void delete(String word) {

        if (!search(word)) {
            throw new NoSuchElementException("Word not found!");
        }

        delete(root, word, 0);
    }

    private boolean delete(TrieNode node, String word, int depth) {

        if (node == null)
            return false;

        // Reached end of word
        if (depth == word.length()) {

            node.isEndOfWord = false;

            // If node has no children, delete it
            return hasNoChildren(node);
        }

        int index = word.charAt(depth) - 'a';

        if (delete(node.children[index], word, depth + 1)) {

            node.children[index] = null;

            return !node.isEndOfWord && hasNoChildren(node);
        }

        return false;
    }

    // Check if node has children
    private boolean hasNoChildren(TrieNode node) {

        for (TrieNode child : node.children) {
            if (child != null)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("cat");
        trie.insert("car");
        trie.insert("care");
        trie.insert("dog");
        trie.insert("door");
        trie.insert("doll");

        System.out.println("Search cat : " + trie.search("cat"));
        System.out.println("Search cow : " + trie.search("cow"));

        System.out.println("StartsWith ca : " + trie.startsWith("ca"));
        System.out.println("StartsWith do : " + trie.startsWith("do"));
        System.out.println("StartsWith ap : " + trie.startsWith("ap"));

        System.out.println("\nWords in Trie:");
        trie.display();

        trie.delete("care");

        System.out.println("\nAfter deleting 'care':");
        trie.display();

        System.out.println("\nSearch care : " + trie.search("care"));
        System.out.println("Search car : " + trie.search("car"));

        System.out.println("\nIs Empty: " + trie.isEmpty());
    }
}