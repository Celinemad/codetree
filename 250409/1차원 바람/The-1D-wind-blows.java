import java.util.*;
import java.io.*;

public class Main {

    static int N, M, Q;
    static int[][] grid;
    static int r;
    static String d;

    static void shiftLeft(int row) {
        int temp = grid[row][0];
        for (int i = 0; i < M-1; i++) {
            grid[row][i] = grid[row][i+1];
        }
        grid[row][M-1]= temp;
    }

    static void shiftRight(int row) {
        int temp = grid[row][M-1];
        for (int i = M-1; i >= 1; i--) {
            grid[row][i] = grid[row][i-1];
        }
        grid[row][0] = temp;
    }

    static boolean isSpreadable(int row1, int row2) {
        for (int i = 0; i < M; i++) {
            if (grid[row1][i] == grid[row2][i]) {
                return true;
            }
        }
        return false;
    }

    static void spread(int row, String shiftDir, int spreadDir) {
        int dir = shiftDir.equals("L") ? 1 : 0;
        int spreadRow = row + spreadDir;
        int prevRow = row;
        while (spreadRow >= 0 && spreadRow < N) {
            if (!isSpreadable(prevRow, spreadRow)) {
                // System.out.println("not spreadable!!, row: " +row + ", spreadRow: " + spreadRow);
                return;
            }

            if (dir == 0) {
                // System.out.println("spreadRow: "+ spreadRow + ", shiftDir: " + dir);
                shiftLeft(spreadRow);
                dir = 1;                
            } else {
                // System.out.println("spreadRow: "+ spreadRow + ", shiftDir: " + dir);
                shiftRight(spreadRow);
                dir = 0;
            }


            prevRow = spreadRow;
            spreadRow += spreadDir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            d = st.nextToken();

            // System.out.println("row: " + r + ", d: " + d);

            if (d.equals("L")) {
                shiftRight(r-1);
                d = "R";
            } else {
                shiftLeft(r-1);
                d = "L";
            }

            // upward
            // System.out.println("upward");
            spread(r-1, d, -1);


            // downward
            // System.out.println("downward");
            spread(r-1, d, 1);

        }

        for (int k = 0; k < N; k++) {
            for (int j = 0; j < M; j++) {
                System.out.print(grid[k][j] + " ");
            }
            System.out.println();
        }
    }
}