import java.io.*;
import java.util.*;

/**
* 0 : 이동할 수 있는 칸
* 1 : 벽이 있어 이동할 수 없는 곳
* 2 : 사람 서있음
* 3 : 비를 피할 수 있는 공간
*
* - 한 칸 움직이는데 1초 소요.
*/

class Pair {
    int r;
    int c;
    int time;

    public Pair(int r, int c, int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }

    @Override
    public String toString() {
        return "(" + r + ", " + c + "), time: " + time; 
    }
}

public class Main {
    static int N, H, M;
    static int[][] grid;
    static boolean[][] visited;
    static int[][] answer;
    
    // 사람이 있는 위치를 담은 리스트
    static List<Pair> people = new ArrayList<>();

    // bfs에서 사용하는  큐
    static Queue<Pair> q = new LinkedList<>();

    static int[] drs = new int[] {1, -1, 0, 0};
    static int[] dcs = new int[] {0, 0, 1, -1};

    static void bfs(Pair person) {
        int new_r, new_c;

        q.add(person);

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            visited[curr.r][curr.c] = true;

            if (grid[curr.r][curr.c] == 3) {
                answer[person.r][person.c] = curr.time;
                break;
            }

            for (int i = 0; i < 4; i++) {
                new_r = curr.r + drs[i];
                new_c = curr.c + dcs[i];
                if (canGo(new_r, new_c)) {
                    q.add(new Pair(new_r, new_c, curr.time + 1));
                    // System.out.println("New pair: (" + new_r + ", " + new_c + ")");
                }
            }
        }

        if (answer[person.r][person.c] == 0) {
            answer[person.r][person.c] = -1;
        }
    }

    static boolean canGo(int r, int c) {
        return inRange(r, c) && !visited[r][c] && grid[r][c] != 1;
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        grid = new int[N][N];
        answer = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                // 사람이면 people에 추가
                if (grid[i][j] == 2) {
                    people.add(new Pair(i, j, 0));
                }
            }
        }

        // 사람 한명당 bfs 시행
        for (Pair person : people) {
            // System.out.println("Person bfs start: " + person);
            q = new LinkedList<>();
            visited = new boolean[N][N];
            bfs(person);
        }

        for (int[] arr : answer){
            for (int elem : arr) {
                System.out.printf("%d ", elem);
            }
            System.out.println();
        }
    }
}