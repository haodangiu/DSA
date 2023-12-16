package src;

import java.util.Scanner;

public class Sherlock_and_Array {
    public static boolean check(int[] a,int sum)
    {
        int sumleft = 0;
        for (int i = 1 ; i< a.length; i++)
        {
            sumleft += a[i-1];
            if (sumleft ==(sum - sumleft - a[i]))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t != 0) {
            int n = input.nextInt();
            int[] a = new int[n+1];
            a[0] = 0;
            int sum = 0;
            for (int i = 1; i <= n ; i ++)
            {
                a[i] = input.nextInt();
                sum+=a[i];
            }
            if (check(a ,sum)) System.out.println("yes");
            else System.out.println("No");


        }


    }

}
