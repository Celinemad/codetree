import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {

    static int N;
    static int MAX_N = 300;
    static int[][] grid = new int[MAX_N+1][MAX_N+1];
    static int[][] prefix_sum = new int[MAX_N+1][MAX_N+1];
    static int[] dp = new int[MAX_N+1];
    
    public static int getMaxArea(int r1, int r2){
        int area;
        for (int c = 1; c <= N; c++) {
            area = prefix_sum[r2][c] - prefix_sum[r1-1][c] - prefix_sum[r2][c-1] + prefix_sum[r1-1][c-1];
            dp[c] = Math.max(area, area + dp[c-1]);
        }

        int maxArea = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            maxArea = Math.max(maxArea, dp[i]);
        }

        return maxArea;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // prefix sum
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefix_sum[i][j] = prefix_sum[i-1][j] + prefix_sum[i][j-1] - prefix_sum[i-1][j-1] + grid[i][j];
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                ans = Math.max(ans, getMaxArea(i, j)) ;
            }
        }

        System.out.println(ans);

    }
}