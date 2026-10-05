/**
 Approach: Red Black Tree Using built-in Class TreeSet

 Time Complexity:
 - add() / put()   : O(log n)
 - remove()        : O(log n)
 - contains()        : O(log n)
 - first()         : O(log n)
 - last()          : O(log n)
 - size
 - isEmpty

 Space Complexity: O(n)
 */

import java.util.TreeSet;

public class Red_Black_Tree_Using_TreeSet {
    public static void main(String[] args) {

        TreeSet<Integer> tree = new TreeSet<>();

        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);
        System.out.println(tree);

        System.out.println("Contains 40: " + tree.contains(40));
        System.out.println("Minimum: " + tree.first());
        System.out.println("Maximum: " + tree.last());
        tree.remove(30);
        System.out.println("After Delete: " + tree);
        System.out.println("Size: " + tree.size());
        System.out.println("Is Empty: " + tree.isEmpty());
    }

}
