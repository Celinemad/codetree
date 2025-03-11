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

        int n1 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashSet<Integer> hs1 = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            int num = Integer.parseInt(st.nextToken());
            hs1.add(num);
        }

        int n2 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n2];
        HashSet<Integer> hs2 = new HashSet<>();
        for (int i = 0; i < n2; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            hs2.add(num);
        }

        for (int elem : arr) {
            if (hs1.contains(elem)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }
}