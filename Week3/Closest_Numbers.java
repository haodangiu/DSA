package src;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Closest_Numbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] a = new int[n];
        for (int i = 0 ; i < n ; i++)
        {
            a[i] = input.nextInt();
        }
        Arrays.sort(a);
        int minn =  Integer.MAX_VALUE;
        int j = 0;
        for (int i = 1 ; i <  n ; i++){
            if (a[i] - a[i-1] <= minn)
            {
                    minn = a[i] - a[i-1];
            }
        }
        for ( int i = 0 ; i < n-1 ; i ++)
        {
            if (a[i] + minn == a[i+1]) System.out.print(a[i] + " " + a[i+1] + " ");
        }

    }
}