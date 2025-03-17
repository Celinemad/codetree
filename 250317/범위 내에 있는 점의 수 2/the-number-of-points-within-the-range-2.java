import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000000 + 1];
        int[] prefixSum = new int[1000000 + 1];
        st = new StringTokenizer(br.readLine());
        int idx;
        for (int i = 0; i < N; i++) {
            idx = Integer.parseInt(st.nextToken());
            arr[idx] = 1;
        }
        for (int i = 0; i <= 1000000; i++) {
            if (i == 0) prefixSum[i] = arr[i];
            else prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();
        int start, end;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            sb.append(prefixSum[end] - prefixSum[start - 1]).append("\n"); 
        }

        System.out.println(sb);
    }
}