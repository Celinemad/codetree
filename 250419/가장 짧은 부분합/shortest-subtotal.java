import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;

    static int run() {
        int minLength = 100001;

        int sum = 0;
        int j = 0;
        int length = 0;
        for (int i = 0; i < N; i++) {
            while (sum < S && j < N) {
                sum += arr[j];
                length++;
                j++;
            }

            if (sum >= S) {
                minLength = Math.min(length, minLength);
            }

            sum -= arr[i];
            length--;
        }

        if (minLength == 100001) {
            return -1;
        }

        return minLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = run();
        System.out.println(result);
    }
}