package src.Week7;

import java.util.Scanner;

public class QuickSortinPlace {
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.printf("%d ", num);
        }
        System.out.println("");
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int idMin = low;

        for (int i = low; i < high; ++i) {
            if (arr[i] < pivot) {
                swap(arr, i, idMin);
                ++idMin;
            }
        }
        swap(arr, idMin, high);
        return idMin;
    }

    private static void QuickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int id = partition(arr, low, high);
        printArray(arr);

        QuickSort(arr, low, id - 1);
        QuickSort(arr, id + 1, high);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named midterm.LinkedList.midterm.Hidx.midterm.Message.Solution. */
        Scanner scan = new Scanner(System.in);
        int arrLength = Integer.parseInt(scan.next());

        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; ++i) {
            arr[i] = scan.nextInt();
        }

        QuickSort(arr, 0, arrLength - 1);

    }
}
