import java.io.*;
import java.util.*;

// 0 : 이동 가능
// 1 : 이동 불가능

class Pair {
    int r, c, time;
    public Pair(int r, int c, int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }

    @Override
    public String toString() {
        return "(" + r + ", " + c + ")";
    }
}

public class Main {
    static int N, K;
    static int[][] grid;
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;


    static Pair start, end;

    static List<Pair> walls = new ArrayList<>();

    static Queue<Pair> q = new LinkedList<>();

    static void initialize() {
        // q에 출발점 넣어주기
        q.add(start);
        // visited 초기화
        visited = new boolean[N][N];
    }

    static int[] drs = new int[] {1, -1, 0, 0};
    static int[] dcs = new int[] {0, 0, 1, -1};

    static int bfs() {
        int new_r, new_c;
        int minTime = Integer.MAX_VALUE;

        while (!q.isEmpty()){
            Pair curr = q.poll();
            // System.out.println(curr);

            if (curr.r == end.r && curr.c == end.c) {
                minTime = curr.time;
                break;
            }

            for (int i = 0; i < 4; i++) {
                new_r = curr.r + drs[i];
                new_c = curr.c + dcs[i];

                if (canGo(new_r, new_c)) {
                    q.add(new Pair(new_r, new_c, curr.time + 1));
                    visited[new_r][new_c] = true;
                }
            }

        }

        return minTime;
    }

    static boolean canGo(int r, int c) {
        return inRange(r, c) && !visited[r][c] && grid[r][c] == 0;
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    static void choose(int cnt, int startIdx) {
        if (cnt == K + 1) {
            initialize();
            int result = bfs();
            answer = Math.min(result, answer);
            // System.out.println("finished choosing: " + result);
            return;
        }

        for (int i = startIdx; i < walls.size(); i++) {
            Pair wall = walls.get(i);
            grid[wall.r][wall.c] = 0;
            // System.out.println("chosen wall: " + wall.toString());
            choose(cnt + 1, i + 1);
            grid[wall.r][wall.c] = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    // System.out.println("!!!!!");
                    walls.add(new Pair(i, j, 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        start = new Pair(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

        st = new StringTokenizer(br.readLine());
        end = new Pair(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

        // System.out.println(walls.size());
        choose(1, 0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}