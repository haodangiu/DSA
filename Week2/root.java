import java.util.Scanner;

public class root {
    public static int[] root = new int[1000];

    public static int getRoot(int x) {
        if (root[x] < 0) return x;
        return (root[x] = getRoot(root[x]));

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int ans = n;
        for (int i = 1; i <= n; i++) {
            root[i] = -1;
        }
        int dem = 0;

        while (input.hasNext()) {
            int x = input.nextInt();
            int y = input.nextInt();
            dem ++;
            root[x] = getRoot(x);
            root[y] = getRoot(y);
            if (  x != y) {

                ans--;
                if (root[x] < root[y])
                {
                    root[x] += root[y];
                    root[y] = x;
                }
                else
                {
                    root[y] += root[x];
                    root[x] = y;
                }
                if (ans == 1)
                {
                    System.out.println(dem);
                    break;
                }

            }
        }
        if (ans != 1) System.out.println("FAIL");


    }

}
