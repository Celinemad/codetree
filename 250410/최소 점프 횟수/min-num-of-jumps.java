import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int minCnt = Integer.MAX_VALUE;
    
    static void backtrack(int idx, int cnt) {
        if (idx == N-1) {
            minCnt = Math.min(minCnt, cnt);
            return;
        } else if (idx > N-1) {
            return;
        }

        // System.out.printf("idx: %d, cnt: %d \n", idx, cnt);
        for (int i = 1; i <= arr[idx]; i++) {
            backtrack(idx + i, cnt + 1);
         // System.out.println(i);
            // backtrack(idx - i, cnt - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0);

        if (minCnt == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCnt);
        }
    }
}