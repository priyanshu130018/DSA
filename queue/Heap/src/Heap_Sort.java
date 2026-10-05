/**
 Approach: Heap Sort

 Time Complexity:
 - buildHeap() : O(n)
 - heapSort()  : O(n log n)

 Space Complexity: O(1) (In-place)
 */

public class Heap_Sort {

    // Heap Sort
    public void heapSort(int[] arr) {

        int n = arr.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {

            swap(arr, 0, i);

            heapify(arr, i, 0);
        }
    }

    // Heapify
    private void heapify(int[] arr, int size, int root) {

        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != root) {
            swap(arr, root, largest);
            heapify(arr, size, largest);
        }
    }

    // Swap
    private void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Display
    public void display(int[] arr) {

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Heap_Sort hs = new Heap_Sort();

        int[] arr = {40, 10, 30, 20, 50, 5};

        System.out.print("Original Array: ");
        hs.display(arr);

        hs.heapSort(arr);

        System.out.print("Sorted Array: ");
        hs.display(arr);
    }
}