import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String order;
        int K, num;
        for (int i = 0; i < T; i++) {
            
            K = Integer.parseInt(br.readLine());
            
            TreeSet<Integer> ts = new TreeSet<>();

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                order = st.nextToken();
                num = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {
                    ts.add(num);
                } else if (!ts.isEmpty() && order.equals("D")) {
                    if (num == 1) {
                        ts.remove(ts.last());
                    } else {
                        ts.remove(ts.first());
                    }
                }
            }
            
            if (ts.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(ts.last()).append(" ").append(ts.first());
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}