package src;

import java.util.Scanner;

public class yearChaos {
    public static void minimumBribes(int[] queue) {
        int bribes = 0;

        for (int i = queue.length - 1; i >= 0; i--) {
            if (queue[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, queue[i] - 2); j < i; j++) {
                if (queue[j] > queue[i]) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        while (q != 0)
        {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0 ; i < n ; i++)
            {
                a[i] = sc.nextInt();
            }
            minimumBribes(a);
            q--;
        }
    }
}
