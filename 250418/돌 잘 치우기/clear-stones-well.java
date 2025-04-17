import java.io.*;
import java.util.*;

public class Main {

    static int N, K, M;
    static int[][] grid;
    static boolean[][] visited;
    static int answer = -1;
    static int totalRocks = 0;

    static int[] drs = new int[] {1, -1, 0, 0};
    static int[] dcs = new int[] {0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();

    static List<int[]> rocks = new ArrayList<>();

    static void choose(int cnt, int startIdx) {
        if (cnt == M+1) {
            answer = Math.max(answer, bfs());
            // System.out.println("chosen");
            return;
        }

        for (int i = startIdx; i < totalRocks; i++) {
            int[] rock = rocks.get(i);
            grid[rock[0]][rock[1]] = 0;
            // System.out.println("(" + rock[0] +", " + rock[1] + ")");
            choose(cnt+1, i+1);
            grid[rock[0]][rock[1]] = 1;
        }
    }

    static int bfs() {
        int cnt = 0;

        int new_r, new_c;
        while (!q.isEmpty()) {
            int[] currPoint = q.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                new_r = currPoint[0] + drs[i];
                new_c = currPoint[1] + dcs[i];
                if (canGo(new_r, new_c)) {
                    visited[new_r][new_c] = true;
                    q.add(new int[] {new_r, new_c});
                }
            }
            
        }

        return cnt;
    }

    static boolean canGo(int r, int c) {
        return inRange(r, c) && !visited[r][c] && grid[r][c] == 0;
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    rocks.add(new int[] {i, j});
                    totalRocks++;
                }
            }
        }
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int[] start = new int[2];
            start[0] = Integer.parseInt(st.nextToken())-1;
            start[1] = Integer.parseInt(st.nextToken())-1;
            q.add(start);

            visited[start[0]][start[1]] = true;
        }

        choose(1, 0);

        System.out.println(answer);
    }
}