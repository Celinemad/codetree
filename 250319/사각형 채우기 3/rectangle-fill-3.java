import java.io.*;
import java.util.*;

public class Main {

    static int MAX_N = 1000;
    static int[] dp = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;
        dp[3] = 22;

        for (int i = 5; i <= N; i++) {
            dp[i] = (2 * dp[i-1] + dp[i-2] * 3 + dp[i-3] * 2 + dp[i-4] * 2) % 1000000007;
        }

        System.out.println(dp[N]);
    }
}