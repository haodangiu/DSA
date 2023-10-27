import java.util.Scanner;

public class Insertion_2 {
    public static void sort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                    printarr(a, n);
                    System.out.println();

                } else {
//                    printarr(a, n);
//                    System.out.println();
                    break;
                }
            }
        }

    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    private static void exch(int[] a, int x, int y) {
        int swap = a[x];
        a[x] = a[y];
        a[y] = swap;
    }

    public static void printarr(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[100];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        sort(a, n);
    }
}
