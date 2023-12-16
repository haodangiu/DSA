package src.Week12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class ReachandLibraries {
    static long bfs(int s, int c_lib, int c_road, List<List<Integer>> newEdges, int[] connected) {
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(s);

        int count = 0;
        while (!bfs.isEmpty()) {
            int u = bfs.remove();
            ++count;
            List<Integer> edge = newEdges.get(u);
            for (int v : edge) {
                if (connected[v] == 0) {
                    connected[v] = connected[u];
                    bfs.add(v);
                }
            }
        }
        return (long) Math.min(c_lib, c_road) * (count - 1) + (long) c_lib;
    }

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here

        List<List<Integer>> newEdges = new ArrayList<>();
        int[] connected = new int[n];
        int countConnected = 0;

        for (int i = 0; i < n; ++i) {
            newEdges.add(new ArrayList<>());
            connected[i] = 0;
        }

        for (List<Integer> edge : cities) {
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            newEdges.get(u).add(v);
            newEdges.get(v).add(u);
        }

        long result = 0;
        for (int i = 0; i < n; ++i) {
            if (connected[i] == 0) {
                connected[i] = ++countConnected;
                result += bfs(i, c_lib, c_road, newEdges, connected);
            }
        }

        return result;
    }

}
