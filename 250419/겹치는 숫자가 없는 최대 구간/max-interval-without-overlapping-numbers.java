import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr, cntArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        cntArr = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int j = 0;
        int len = 0;
        int maxLen = -1;
        for (int i = 0; i < N; i++) {

            while (j < N) {
                if (cntArr[arr[j]] >= 1) {
                    break;
                }
                cntArr[arr[j]] += 1;
                j++;
                len++;
            }

            maxLen = Math.max(maxLen, len);

            len--;
            cntArr[arr[i]] -= 1;
        }

        System.out.println(maxLen);
    }
}