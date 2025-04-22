import java.io.*;
import java.util.*;

public class Main {
    static int N;
    // static int[] nums;
    static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    
        // nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int cost = 0;
        while(true) {
            if (pq.size() == 1) break;

            int num1 = pq.poll();
            int num2 = pq.poll();

            pq.add(num1 + num2);
            cost += (num1 + num2);
        }

        System.out.println(cost);
    }
}