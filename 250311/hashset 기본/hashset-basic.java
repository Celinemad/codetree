import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        HashSet<Integer> hm = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if (order.equals("add")) {
                hm.add(value);
            } else if (order.equals("remove")) {
                hm.remove(value);
            } else {
                sb.append(hm.contains(value)).append("\n");
            }
        }
        System.out.println(sb);
    }
}