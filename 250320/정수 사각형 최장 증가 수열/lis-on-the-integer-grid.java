import java.io.*;
import java.util.*;

public class Main {
    static int MAX_N = 500;
    static int N;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] dp = new int[MAX_N][MAX_N];

    static class Pair implements Comparable<Pair> {
        int r, c;
        int num;

        public Pair(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }

        @Override
        public int compareTo(Pair p) {
            return this.num - p.num;
        }
    }

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        StringTokenizer st;
        int num;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                num =  Integer.parseInt(st.nextToken());
                grid[i][j] = num;
                dp[i][j] = 1;
                pq.add(new Pair(i, j, num));
            }
        }

        int[] drs = new int[] {0, 0, 1, -1};
        int[] dcs = new int[] {1, -1, 0, 0};
        int newR, newC;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            for (int i = 0; i < 4; i++) {
                newR = p.r + drs[i];
                newC = p.c + dcs[i];
                if (inRange(newR, newC) && grid[p.r][p.c] < grid[newR][newC]) {
                    dp[newR][newC] = Math.max(dp[newR][newC], dp[p.r][p.c] + 1);
                }
            }
        } 

        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        System.out.println(maxLen);
        
    }
}