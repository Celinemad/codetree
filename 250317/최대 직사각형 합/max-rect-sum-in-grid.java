import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N+1][N+1];
        int[][] prefixSum = new int[N+1][N+1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + grid[i][j];
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int sum;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int r = 0; i+r <= N; r++) {
                    for (int c = 0; j+c <= N; c++) {
                        sum = prefixSum[i+r][j+c] - prefixSum[i+r][c] - prefixSum[r][j+c] + prefixSum[r][c];
                        maxSum = Math.max(sum, maxSum);
                    }
                }
            }
        }
        System.out.println(maxSum);
    }
}