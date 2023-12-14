package src.Week5;

import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0 ; i < n ; i++)
        {
            a[i] = sc.nextInt();
        }
        int minn = a[0];
        for (int i = 1 ; i < n ; i++)
        {
            if (a[i] < minn)
            {
                int tmp = a[i];
                a[i] = minn;
                //minn = tmp;
                minn = a[i];
            }
        }
        for (Integer i : a)
        {
            System.out.print(i +  " ");
        }
    }
}
