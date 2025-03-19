import java.io.*;
import java.util.*;

public class Main {
    static int MAX_INT = 100;
    static int N;
    static int[][] grid = new int[MAX_INT][MAX_INT];
    static int[][] dp = new int[MAX_INT][MAX_INT];

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

        dp[0][N-1] = grid[0][N-1];
        for (int i = 1; i < N; i++) {
            dp[i][N-1] = dp[i-1][N-1] + grid[i][N-1];
            dp[0][N-1-i] = dp[0][N-i] + grid[0][N-1-i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = N-2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j+1]) + grid[i][j];
            }
        }

        System.out.println(dp[N-1][0]);
    }
}