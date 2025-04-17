import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    static int[] numArr;
    static StringBuilder sb = new StringBuilder();

    static void choose(int idx) {
        if (idx == N) {
            for (int num : numArr) {
                sb.append(num).append(" ");
            }
            System.out.println(sb);
            sb.setLength(0);
            return;
        }

        for (int i = 1; i <= K; i++) {
            numArr[idx] = i;
            choose(idx + 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        numArr = new int[N];

        choose(0);
    }
}