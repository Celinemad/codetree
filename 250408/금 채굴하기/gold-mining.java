import java.io.*;
import java.lang.*;

public class Main {
    static int N, M;
    static int[][] grid;

    static int run(int r, int c, int k) {
        int goldCnt = 0;
        for (int i = -k; i <= k; i++) {
            int diff = k - Math.abs(i);

            for (int j = -diff; j <= diff; j++) {
                if (grid[r+i][c+j] == 1) {
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
                    cost = i ^ 2 + (i+1) ^ 2;
                    if (cost <= goldCnt * M) {
                        maxGoldCnt = Math.max(maxGoldCnt, goldCnt);
                    }
                }
            }
        }

        System.out.println(maxGoldCnt);
    }
}