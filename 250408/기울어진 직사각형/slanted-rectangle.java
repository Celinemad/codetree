import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] grid;

    static int[] drs = new int[] {-1, -1, 1, 1};
    static int[] dcs = new int[] {1, -1, -1, 1};

    static int run(int r, int c, int len) {
        int orgR = r;
        int orgC = c;
        int maxScore = 0;
        int score = 0;
        
        if (r - len < 0) {
            return 0;
        }

        for (int i = 1; i < len; i++) {
            score = 0;

            if (orgC + i > N-1 || orgC - (len - i) < 0) {
                continue;
            }

            for (int j = 1; j <= i; j++) {
                // 우상향
                r += drs[0];
                c += dcs[0];
                score += grid[r][c];
            }
            
            for (int k = 1; k <= len - i; k++) {
                // 좌상향
                r += drs[1];
                c += dcs[1];
                score += grid[r][c];
            }

            for (int j = 1; j <= i; j++) {
                // 좌하향
                r += drs[2];
                c += dcs[2];
                score += grid[r][c];
            }
            
            for (int k = 1; k <= len - i; k++) {
                // 우하향
                r += drs[3];
                c += dcs[3];
                score += grid[r][c];
            }

            maxScore = Math.max(maxScore, score);
        }
        
        return maxScore;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int maxScore = 0;
        for (int len = 2; len <= N-1; len++) { // 두 변 길이의 합
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maxScore = run(i, j, len);
                    answer = Math.max(maxScore, answer);
                }
            }
        }

        System.out.println(answer);
    }
}