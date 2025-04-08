import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static int N, M;
    static int[][] grid;

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
    static int run(int r, int c, int k) {
        int goldCnt = 0;
        for (int i = -k; i <= k; i++) {
            int diff = k - Math.abs(i);

            for (int j = -diff; j <= diff; j++) {
                if (inRange(r+i, c+j) && grid[r+i][c+j] == 1) {
                    goldCnt++;
                }
            }
        }

        return goldCnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int goldCnt, cost;
        int maxGoldCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    goldCnt = run(j, k, i);
                    cost =(int)(Math.pow(i, 2) + Math.pow(i+1, 2));
                    // System.out.printf("K: {%d} , const: {%d}\n", i, cost);
                    if (cost <= goldCnt * M) {
                        maxGoldCnt = Math.max(maxGoldCnt, goldCnt);
                    }
                }
            }
        }

        System.out.println(maxGoldCnt);
    }
}