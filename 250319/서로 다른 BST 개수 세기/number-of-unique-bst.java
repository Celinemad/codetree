import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        if (N >= 3) {
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i-1] * 2;
                for (int j = 1; j <= i-2; j++) {
                    dp[i] += dp[j] * dp[i-j-1];
                }
            }
        }

        System.out.println(dp[N]);
    }
}