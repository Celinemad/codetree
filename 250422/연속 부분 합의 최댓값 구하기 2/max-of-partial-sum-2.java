import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums, sums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        sums = new int[N];
        sums[0] = nums[0];
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i < N; i++) {
            if (sums[i-1] < 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = sums[i-1] + nums[i];
            }
            answer = Math.max(answer, sums[i]);
        }
        System.out.println(answer);
    }
}