//import java.util.Scanner;
//
//public class three_sum {
//    public static int check(int[] a, int l, int r, int u) {
//
//        while (l <= r) {
//            int mid = (l + r) / 2;
//            if (a[mid] == u) return a[mid];
//            else {
//                if (a[mid] < u) l = mid + 1;
//                else r = mid - 1;
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int[] a = new int[100];
//        for (int i = 0; i < n; i++)
//            a[i] = input.nextInt();
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                int u = -(a[i] + a[j]);
//
//                int ans = check(a, 0, n - 1, u);
//                System.out.println(a[i] + ' ' + a[j] + ' ' + ans);
//
//            }
//        }
//    }
//}
