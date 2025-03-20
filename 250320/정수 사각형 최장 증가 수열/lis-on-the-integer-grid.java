import java.io.*;
import java.util.*;

public class Main {
    static int MAX_N = 500;
    static int N;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] dp = new int[MAX_N][MAX_N];

    static int[] drs = new int[] {0, 0, 1, -1};
    static int[] dcs = new int[] {1, -1, 0, 0};
    static int findMax(int r, int c) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int best = 1;
        int newR, newC;
        for (int i = 0; i < 4; i++) {
            newR = r + drs[i];
            newC = c + dcs[i];
            if (inRange(newR, newC) && grid[newR][newC] < grid[r][c]) {
                best = Math.max(best, findMax(newR, newC) + 1);
            }
        }

        return best;
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = findMax(i, j);
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        System.out.println(maxLen);
    }
}