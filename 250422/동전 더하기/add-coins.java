import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = N-1; i >= 0; i--) {
            answer += K / coins[i];
            K %= coins[i];
        }

        System.out.println(answer);
    }
}