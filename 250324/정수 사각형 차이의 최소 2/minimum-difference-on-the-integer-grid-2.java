import java.io.*;
import java.util.*;

public class Main {

    public static class Diff {
        int minVal;
        int maxVal;
        int minDiff;

        public Diff(int minVal, int maxVal) {
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.minDiff = maxVal - minVal;
        }
    }

    static int N;
    static int MIN_VAL = 1;
    static int MAX_VAL = 100;

    static int[][] grid = new int[MAX_VAL][MAX_VAL];
    static Diff[][] dp = new Diff[MAX_VAL][MAX_VAL];

    static int[] drs = new int[] {-1, 0};
    static int[] dcs = new int[] {0, -1};

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static Diff findMinDiff(int r, int c) {
        // System.out.println("[findMinDiff] r: " + r + ", c: " + c);
        if (dp[r][c] != null) {
            return dp[r][c];
        }

        int prevR, prevC, minVal, maxVal;
        Diff best = new Diff(MIN_VAL-1, MAX_VAL+1);
        for (int i = 0; i < 2; i++) {
            prevR = r + drs[i];
            prevC = c + dcs[i];
            
            // System.out.println("prev: (" + prevR + ", " + prevC + ")");

            if (inRange(prevR, prevC)) {
                Diff prevDiff = findMinDiff(prevR, prevC);
                Diff currDiff;
                if (grid[r][c] < prevDiff.minVal) {
                    currDiff = new Diff(grid[r][c], prevDiff.maxVal);
                } else if (prevDiff.maxVal < grid[r][c]) {
                    currDiff = new Diff(prevDiff.minVal, grid[r][c]);
                } else {
                    currDiff = prevDiff;
                }

                if (currDiff.minDiff < best.minDiff) {
                    best = currDiff;
                }
            }
        }
        // System.out.println("best: (" + r + ", " + c + ") => min: " + best.minVal + ", max: " + best.maxVal + ", minDiff: " + best.minDiff);
        return dp[r][c] = best;
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
        dp[0][0] = new Diff(grid[0][0], grid[0][0]);
        int answer = findMinDiff(N-1, N-1).minDiff;
        System.out.println(answer);
    }
} 