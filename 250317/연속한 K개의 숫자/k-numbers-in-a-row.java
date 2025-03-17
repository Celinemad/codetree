import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = 1;
        }

        int idx;
        for (int i = 0; i < B; i++) {
            idx = Integer.parseInt(br.readLine());
            arr[idx] = 0;
        }

        int[] prefixSum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        int maxLen = -1;
        for (int i = 0; i + K <= N; i++) {
            maxLen = Math.max(maxLen, prefixSum[i+K] - prefixSum[i]);
        }

        System.out.println(K - maxLen);
    }
}