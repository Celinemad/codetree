import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        TreeSet<Integer> ts = new TreeSet<>();

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                ts.add(num);
            } else if (order.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                ts.remove(num);
            } else if (order.equals("find")) {
                int num = Integer.parseInt(st.nextToken());
                if (ts.contains(num)) {
                    sb.append("true");
                } else {
                    sb.append("false");
                }
                sb.append("\n");
            } else if (order.equals("lower_bound")) {
                int num = Integer.parseInt(st.nextToken());
                if (ts.ceiling(num) != null) {
                    sb.append(ts.ceiling(num)).append("\n");    
                } else {
                    sb.append("None").append("\n");
                }
            } else if (order.equals("upper_bound")) {
                int num = Integer.parseInt(st.nextToken());
                if (ts.higher(num) != null) {
                    sb.append(ts.higher(num)).append("\n");    
                } else {
                    sb.append("None").append("\n");
                }
            } else if (order.equals("largest")) {
                if (ts.isEmpty()) {
                    sb.append("None").append("\n");
                } else {
                    sb.append(ts.last()).append("\n");
                }
            } else {
                if (ts.isEmpty()) {
                    sb.append("None").append("\n");
                } else {
                    sb.append(ts.first()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}