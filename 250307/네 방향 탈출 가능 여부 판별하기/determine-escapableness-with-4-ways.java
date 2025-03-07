import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] grid;
    private static boolean[][] visited;

    public static class Pair {
        int r;
        int c;
        
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static Queue<Pair> q;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q = new LinkedList<>();
        bfs();
        if (visited[N-1][M-1]) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean inRange(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    private static boolean canGo(int r, int c) {
        return inRange(r, c) && !visited[r][c] && grid[r][c]==1;
    }

    private static void push(int r, int c) {
        visited[r][c] = true;
        q.add(new Pair(r, c));
    }

    private static void bfs() {
        
        int[] dr = new int[]{1, 0, -1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        push(0, 0);

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.r, c = curr.c;
            // System.out.println(r + ", " + c);

            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];

                if (canGo(newR, newC)) {
                    push(newR, newC);
                }
            }
        }

    }
}