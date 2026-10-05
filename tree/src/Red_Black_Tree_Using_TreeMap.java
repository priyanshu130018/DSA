/**
 Approach: Red Black Tree Using built-in Class TreeMap

 Time Complexity:
 - add() / put()   : O(log n)
 - remove()        : O(log n)
 - get()           : O(log n)
 - firstKey()      : O(log n)
 - lastKey()       : O(log n)
 - size
 - isEmpty

 Space Complexity: O(n)
 */

import java.util.TreeMap;

public class Red_Black_Tree_Using_TreeMap {
    public static void main(String[] args) {

        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(50, "A");
        map.put(30, "B");
        map.put(70, "C");
        map.put(20, "D");
        System.out.println(map);

        System.out.println("Value of 30: " + map.get(30));
        System.out.println("First Key: " + map.firstKey());
        System.out.println("Last Key: " + map.lastKey());
        map.remove(20);
        System.out.println(map);
    }
}
