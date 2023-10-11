/*
 * INSTRUCTION:
 *     This is a Java starting code for hw5_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw5_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: Main_hw5_2.java
 * Abstract: mergesort: https://www.geeksforgeeks.org/merge-sort/#
 *          quicksort: https://www.geeksforgeeks.org/java-program-for-quicksort/#
 *          print time it takes to mergesort and quicksort
 * Name: Kenneth Ao
 * Date: 10/10/2023
 */

import java.util.*;

class Main
{
    public static void printArray(int[] array) {
                //print array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int partition(int arr[], int low, int high)
    {
        //https://www.geeksforgeeks.org/java-program-for-quicksort/#

        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void quickSort(int arr[], int low, int high)
    {
        //https://www.geeksforgeeks.org/java-program-for-quicksort/#

        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    public static void merge(int arr[], int l, int m, int r)
    {
        //https://www.geeksforgeeks.org/merge-sort/#
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void mergeSort(int arr[], int l, int r)
    {
        //https://www.geeksforgeeks.org/merge-sort/#
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input size: ");

        int size = scanner.nextInt();
        scanner.close();

        int[] mergeSortArray = new int[size];
        int[] quickSortArray = new int[size];

        Random random = new Random();

        for (int i = 0; i < mergeSortArray.length; i++) {
            int randomNumber = random.nextInt(size);
            mergeSortArray[i] = randomNumber;
            quickSortArray[i] = randomNumber;
        }


        System.out.println("===================== Execution Time ====================");

        //merge sort
        double mergeSortStart = System.nanoTime();
        mergeSort(mergeSortArray, 0, (mergeSortArray.length - 1));
        double mergeSortEnd = System.nanoTime();
        double mergeSortTotal = (mergeSortEnd - mergeSortStart) / 1000000;
        System.out.println("Merge sort: " + mergeSortTotal + " milliseconds");

        double quickSortStart = System.nanoTime();
        quickSort(quickSortArray, 0, quickSortArray.length-1);
        double quickSortEnd = System.nanoTime();
        double quickSortTotal = (quickSortEnd - quickSortStart) / 1000000;
        System.out.println("Quick sort: " + quickSortTotal + " milliseconds");

        System.out.println("=========================================================");
//        printArray(dataArray);
    }
}

