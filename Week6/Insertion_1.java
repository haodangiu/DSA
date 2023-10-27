package src.Week6;

import java.util.Scanner;

public class Insertion_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int ans = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > ans) {
                a[i + 1] = a[i];
                for (int j = 0; j < n; j++) {
                    System.out.print(a[j] + " ");
                }
                System.out.println();
            } else {
                a[i + 1] = ans;
                for (int j = 0; j < n; j++) {
                    System.out.print(a[j] + " ");
                }
                System.out.println();
                break;
            }

        }
        if (a[0] > ans) {
            a[0] = ans;
            for (int j = 0; j < n; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();

        }

    }
}
