import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    static int binary_search(int num) {
        int left = 0;
        int right = N - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == num) {
                return mid + 1;
            }

            if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());

            int answer = binary_search(num);
            System.out.println(answer);
        }    
    }
}