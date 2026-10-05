import java.util.Arrays;

public class BigO {

    // Time Complexity = O(1)
    public static int getFirstElement(int[] arr) {
        return arr[0];
    }


    // Time Complexity = O(log(n))
    public static int binarySearch(int[] arr, int target) {
        int low=0;
        int high=arr.length-1;

        while (low <= high) {
            // int mid = (low + high) / 2; -> generate overflow
            int mid = low + (high-low)/ 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid+1; // right
            else high = mid-1; // left
        }
        return -1;
    }


    // Time Complexity = O(n)
    public static int linearSearch(int[] arr, int target) {
        for(int i : arr) {
            if(arr[i] == target) return i;
        }
        return -1;
    }



    // Time Complexity = O(n.log(n))
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right-left)/2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid-left+1;
        int n2 = right-mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i=0; i<n1; i++) L[i] = arr[left+i];
        for (int j=0; j<n2; j++) R[j] = arr[mid+j+1];

        int i=0, j=0, k=left;
        while (i<n1 && j<n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i<n1) arr[k++] = L[i++];
        while (j<n2) arr[k++] = R[j++];
    }



    // Time Complexity = O(n²)
    public static void printPairs(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                System.out.println(arr[i] + "," + arr[j]);
            }
        }
    }

    // Time Complexity = O(n^3)
    public static void printTriplets(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                for(int k=0; k<arr.length; k++) {
                    System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
                }
            }
        }
    }

    // Time Complexity = O(2^n)
    public static int fibonacci(int n) {
        if (n<=1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }


    // Time Complexity = O(n!)
    public static void printPermutations(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i=0; i < str.length(); i++) {
            char current = str.charAt(i);
            // remove current character
            String remaining = str.substring(0, i) + str.substring(i+1);
            printPermutations(remaining, ans + current);
        }
    }




    // main function
    public static void main(String[] args) {
        System.out.println("Time Complexity: ");

        int[] arr = {4, 5, 2};

        int r1 = getFirstElement(arr);
        System.out.println(r1);

        Arrays.sort(arr);
        int r2 = binarySearch(arr, 5);
        System.out.println(r2);

        int r3 = linearSearch(arr,2);
        System.out.println(r3);

        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After sort:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        BigO.printPairs(arr);

        BigO.printTriplets(arr);

        System.out.println("Fibonacci(5): " + fibonacci(5));

        printPermutations("ABC", "");
    }
}