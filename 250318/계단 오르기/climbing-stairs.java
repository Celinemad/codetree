import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (i == 2 || i == 3) {
                dp[i] = 1;
            } else {
                dp[i] =  dp[i-3] + dp[i-2];
            }
        }

        int result = dp[N] % 10007;
        
        System.out.println(result);
    }
}