import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int MIN_VAL = 1;
    static int MAX_VAL = 100;

    static int[][] grid = new int[MAX_VAL][MAX_VAL];
    static int[][] tempGrid = new int[MAX_VAL][MAX_VAL];
    static int[][] maxDP = new int[MAX_VAL][MAX_VAL];

    static int[] drs = new int[] {-1, 0};
    static int[] dcs = new int[] {0, -1};

    public static void initialize(int lowerbound) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] < lowerbound) {
                    tempGrid[i][j] = Integer.MAX_VALUE;
                } else {
                    tempGrid[i][j] = grid[i][j];
                }
            }
        }

        maxDP[0][0] = tempGrid[0][0];
        for (int i = 1; i < N; i++) {
            maxDP[i][0] = Math.max(tempGrid[i][0], maxDP[i-1][0]);
            maxDP[0][i] = Math.max(tempGrid[0][i], maxDP[0][i-1]);
        }
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

        int answer = Integer.MAX_VALUE;
        for (int lowerbound = 1; lowerbound <= 100 ; lowerbound++) {

            initialize(lowerbound);

            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    maxDP[i][j] = Math.max(
                        Math.min(maxDP[i-1][j], maxDP[i][j-1]),
                        tempGrid[i][j]
                    );
                }
            }

            if (maxDP[N-1][N-1] == Integer.MAX_VALUE) continue;

            answer = Math.min(answer, maxDP[N-1][N-1] - lowerbound);

            // print
            // System.out.println("lowerbound: " + lowerbound);
            // for (int i = 0; i < N; i++) {
            //     for (int j = 0; j < N; j++) {
            //         if (maxDP[i][j] == Integer.MAX_VALUE) {
            //             System.out.print("M ");
            //         } else {
            //             System.out.print(maxDP[i][j] + " ");
            //         }
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }

        System.out.println(answer);
    }
}