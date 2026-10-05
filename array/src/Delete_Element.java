/**
 Delete an element from any position from the given array

 Approach: Left Shift
 - Time Complexity: O(n)
 - Space Complexity: O(1)

 Approach: Overwrite
 - Time Complexity: O(n)
 - Space Complexity: O(1)
 **/

import java.util.Arrays;
import java.util.Scanner;

public class Delete_Element {
    public static int dltEleAtPos(int[] arr, int pos){
        // Approach: Left Shift

        if(pos<0 || pos>=arr.length) return -1;

        for(int i = pos; i < arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        return arr.length-1;



        /*
        // Approach: Overwrite

        // Copy all elements except deleted element
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(i != pos){
                arr[j] = arr[i];
                j++;
            }
        }
        return j;
        */
    }

    public static void display(int[] arr, int size) {
        System.out.print("New array: ");

        for(int i=0; i<size; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {34, 26, 19, 21, 49, 42};
        System.out.println("Array:" + Arrays.toString(arr));

        System.out.println("Enter position to delete element:");
        int pos = sc.nextInt();

        int size = dltEleAtPos(arr, pos);
        if(size == -1)
            System.out.println("Invalid position!");
        else{
            System.out.println("Deleted Element:" + Arrays.toString(arr));
            display(arr, size);
        }

        sc.close();
    }
}
