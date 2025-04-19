import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] aArr, bArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        aArr = new int[N];
        bArr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0, j = 0;
        boolean isSequential = false;
        while (i < N) {

            if (aArr[i] == bArr[j]) {
                j++;
            }
            
            if (j == M) {
                isSequential = true;
                break;
            }

            i++;
        }

        if (isSequential) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}