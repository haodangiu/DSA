package src.Week6;

import java.util.Scanner;

public class count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            cnt[arr[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (cnt[arr[i]] != 0) {
                System.out.print(cnt[arr[i]] + " ");
            }
            cnt[arr[i]] = 0;
        }
    }
}
