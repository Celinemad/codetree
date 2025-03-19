import java.io.*;
import java.util.*;

public class Main {

    static int MAX_N = 1000;
    static int[] dp = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }

        System.out.println(dp[N]);
    }
}