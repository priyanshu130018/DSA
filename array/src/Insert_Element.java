/**
 Insert an element at the given position in an array

 Approach: Segment Copying
 - Time Complexity: O(n)
 - Space Complexity: O(n)

 Approach: Brute Force
 - Time Complexity: O(n)
 - Space Complexity: O(n)
 **/

import java.util.Arrays;

public class Insert_Element {

    public static int[] insertEleAtPos(int[] arr, int pos, int ele){
        // Approach: Segment Copying

        int[] newArr = new int[arr.length + 1];

        if (pos < 0 || pos > arr.length)
            return null;

        System.arraycopy(arr, 0, newArr, 0, pos);

        newArr[pos] = ele;

        System.arraycopy(arr, pos, newArr, pos + 1, arr.length - pos);

        return newArr;


        /*
        // Approach: Brute Force

        if(pos<0 || pos>arr.length) return null;

        int[] newArr = new int[arr.length + 1];

        for(int i = 0, j = 0; i<newArr.length; i++) {
            if (i == pos) {
                newArr[i] = ele;
            }
            else {
                newArr[i] = arr[j++];
            }
        }
        return newArr;
        */
    }
    public static void main(String[] args) {

        int[] arr = {34, 26, 19, 21, 49, 42};
        System.out.println("Array:" + Arrays.toString(arr));

        int pos = 3;
        int ele = 8;

        int[] res = insertEleAtPos(arr, pos, ele);
        System.out.println("New array: " + Arrays.toString(res));
    }
}
