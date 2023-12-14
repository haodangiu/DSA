//import edu.princeton.cs.algs4.*;
//public class UFClient {
//    public static void main(String[] args) {
//        int N = StdIn.readInt();
//        UF uf = new UF(N);
//        int ans = 0;
//        int[] a = new int[1000];
//        for (int i = 0; i < N ; i++)
//        {
//            a[i] = i;
//        }
//        for (int i = 0; i < N ; i++) {
//            while (!StdIn.isEmpty()) {
//                int p = StdIn.readInt();
//                int q = StdIn.readInt();
//                if (!uf.connected(p, q)) {
//                    uf.union(p, q);
//                    ans++;
//                }
//            }
//        }
//        for (int i = 0 ; i < N ; i++)
//        {
//            System.out.println(a[i]);
//        }
//    }
//}
//
