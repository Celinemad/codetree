import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int num;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int[] prefixSum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j+i <= N; j++) {
                if (prefixSum[j+i] - prefixSum[j] == K) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}