import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static int N, M;

    static int[][] grid;
    static int[][] step;

    static Queue<Pair> q;

    public static class Pair {
        int r;
        int c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        step = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q = new LinkedList<>();

        bfs();
        if (step[N-1][M-1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(step[N-1][M-1]);
        }

    }

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    public static boolean canGo(int r, int c) {
        return inRange(r, c) && step[r][c] == 0 && grid[r][c] == 1;
    }

    public static void push(int r, int c, int s) {
        step[r][c] = s;
        q.add(new Pair(r, c));
    }

    public static void bfs() {
        int[] dr = new int[]{1, 0, -1, 0};
        int[] dc = new int[]{0, 1, 0, -1}; 

        push(0, 0, 0);

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.r, c = curr.c, s = step[r][c];

            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                if (canGo(newR, newC)) {
                    push(newR, newC, s + 1);
                }
            }
        }
    }
}