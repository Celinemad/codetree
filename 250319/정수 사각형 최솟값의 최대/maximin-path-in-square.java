import java.io.*;
import java.util.*;

public class Main {

    static int MAX_N = 100;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] dp = new int[MAX_N][MAX_N];
    static int N;

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

        dp[0][0] = grid[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][0], grid[i][0]);
            dp[0][i] = Math.min(dp[0][i-1], grid[0][i]);
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = Math.min(dp[i][j], grid[i][j]);
            }
        }

        System.out.println(dp[N-1][N-1]);

    }
}