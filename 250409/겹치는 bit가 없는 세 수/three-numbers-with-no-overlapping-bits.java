import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1; j < n-1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (((arr[i] & arr[j]) == 0) && ((arr[j] & arr[k]) == 0) && ((arr[k] & arr[i]) == 0)) {
                        maxSum = Math.max(maxSum, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }
        
        System.out.println(maxSum);
    }
}