import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] prefixSum = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + grid[i][j];
            }
        }

        int maxSum = 0;
        for (int i = 0; i + K <= N; i++) {
            for (int j = 0; j + K <= N; j++) {
                maxSum = Math.max(maxSum, prefixSum[i+K][j+K] - prefixSum[i][j+K] - prefixSum[i+K][j] + prefixSum[i][j]);
            }
        }
        System.out.println(maxSum);
    }
}