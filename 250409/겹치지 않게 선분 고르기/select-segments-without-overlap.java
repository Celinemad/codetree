import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Point> pointList;
    static List<Point> selected;
    static int maxCnt = 0;

    public static class Point {
        int l;
        int r;
        boolean selected;

        public Point(int l, int r) {
            this.l = l;
            this.r = r;
            this.selected = true;
        }
        
        public Point unselect() {
            this.selected = false;
            return this;
        }
        public Point select() {
            this.selected = true;
            return this;
        }

        public String toString() {
            return "l: " + this.l + ", r: " + this.r + ", selected: " + this.selected;
        }
    }

    static void run(int idx){
        if (idx == N) {
            // for (Point p : selected) {
            //     System.out.print(p.toString() + " | ");
            // }
            int currCnt = checkPossibleAndAddLength();
            // System.out.println(" => cnt: " + currCnt);
            // System.out.println();
            maxCnt = Math.max(currCnt, maxCnt);
            return;
        }

        selected.add(pointList.get(idx).select());
        run(idx + 1);
        selected.remove(idx);

        selected.add(pointList.get(idx).unselect());
        run(idx + 1);
        selected.remove(idx);
        return;

    }

    static int checkPossibleAndAddLength() {
        
        boolean[] visited = new boolean[1001];
        int cnt = 0;

        for (Point p : selected) {
            if (p.selected == true) {
                for (int i = p.l; i <= p.r; i++) {
                    if (visited[i] == true) {
                        return 0;
                    }
                    visited[i] = true;
                }
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pointList = new ArrayList<>();
        selected = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            Point point = new Point(l, r);
            pointList.add(point);
        }
        
        run(0);

        System.out.println(maxCnt);
    }
}