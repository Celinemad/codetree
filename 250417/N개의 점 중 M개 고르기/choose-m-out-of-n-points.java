import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Point[] points;

    static int minMaxDiff = Integer.MAX_VALUE;
    static int maxDiff = 0;
    static Point[] selected;
    static Point[] twoPoints = new Point[2];
    
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "(" + r + ", " + c + ")";
        }
    }

    static void calculateDiff(int cnt, int startIdx) {

        if (cnt == 3) {
            // System.out.println(Arrays.toString(twoPoints));
            
            Point point1 = twoPoints[0];
            Point point2 = twoPoints[1];

            int diff = (int)(Math.pow(point1.r - point2.r, 2) + Math.pow(point1.c - point2.c, 2));
            maxDiff = Math.max(diff, maxDiff);
            // System.out.println(maxDiff);
            return;
        }

        for (int i = startIdx; i < M; i++) {
            twoPoints[cnt-1] = selected[i];
            calculateDiff(cnt + 1, i+1);
        }
    }

    static void backtrack(int cnt, int startIdx) {
        if (cnt == M + 1) {
            // System.out.println(Arrays.toString(selected));
            maxDiff = 0;
            calculateDiff(1, 0);
            minMaxDiff = Math.min(maxDiff, minMaxDiff);
            return;
        }

        if (startIdx == N) {
            return;
        }
        
        for (int i = startIdx; i < N; i++) {
            selected[cnt-1] = points[i];
            backtrack(cnt+1, i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        points = new Point[N];
        selected  = new Point[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        backtrack(1, 0);
        System.out.println(minMaxDiff);
    }
}