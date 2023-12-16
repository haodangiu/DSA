package src.Week12;

import java.util.Scanner;

class Cell {
    public int r, c;

    public Cell(int i, int j) {
        r = i;
        c = j;
    }
}

public class ConnectCells {

    static int[][] grid;
    static boolean[][] visited;
    static int N, M;

    public static int[] Row = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] Col = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static boolean inGrid(int x, int y) {
        if ((x >= 0 && x < N) && (y >= 0 && y < M)) return true;
        return false;
    }

    static int count_connected(int row, int col) {
        int cnt = 1;
        visited[row][col] = true;
        for (int i = 0; i < 8; i++) {
            int n_row = row + Row[i];
            int n_col = col + Col[i];
            if (inGrid(n_row,n_col) && visited[n_row][n_col] == false && grid[n_row][n_col] == 1)
                cnt += count_connected(n_row,n_col);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);

    }
}