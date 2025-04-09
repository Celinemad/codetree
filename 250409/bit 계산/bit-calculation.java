import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int q = Integer.parseInt(br.readLine());

        String order;
        int value;
        int set = 0;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();
            if (order.equals("add")) {
                value = Integer.parseInt(st.nextToken());
                set = set | (1 << value);
            } else if (order.equals("delete")) {
                value = Integer.parseInt(st.nextToken());
                set -= set & (1 << value);
            } else if (order.equals("print")) {
                value = Integer.parseInt(st.nextToken());
                if (((set >> value) & 1) == 1) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (order.equals("toggle")) {
                value = Integer.parseInt(st.nextToken());
                set = set ^ (1 << value);
            } else {
                set = 0;
            }
        }

    }
}