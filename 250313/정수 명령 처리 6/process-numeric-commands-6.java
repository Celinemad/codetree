import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            
            if (order.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                pq.add(-value);
            } else if (order.equals("pop")) {
                sb.append(-pq.poll()).append("\n");
            } else if (order.equals("size")) {
                sb.append(pq.size()).append("\n");
            } else if (order.equals("empty")) {
                if (pq.isEmpty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else {
                sb.append(-pq.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}