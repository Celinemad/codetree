import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] grid;
    static int[][] dp;

    static int[] drs = new int[] {0, 0, 1, -1};
    static int[] dcs = new int[] {1, -1, 0, 0};

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static int findMax(int r, int c) {
        // System.out.println("[findMax] ("+r + ", " + c + ")"); 
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int max = 1;
        for (int i = 0; i < 4; i++) {
            int prevR = r + drs[i];
            int prevC = c + dcs[i];
            // System.out.println("curr: ("+r + ", " + c + ") | prev: (" + prevR + ", " + prevC + ")");
            if (inRange(prevR, prevC) && grid[r][c] > grid[prevR][prevC]) {
                max = Math.max(findMax(prevR, prevC) + 1, max);
                // System.out.println("prev: (" + prevR + ", " + prevC + ") => " + max);
            }
        }
        
        return dp[r][c] = max;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        dp = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(findMax(i, j), answer);
            }
        }

        // System.out.println(findMax(1, 0));
        // dp[1][0] = findMax(1, 0);
        // System.out.println(dp[1][0] + 1);
        // System.out.println(findMax(2, 0));
        
        System.out.println(answer);
    }
}