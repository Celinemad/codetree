import java.util.*;
import java.io.*;

public class Main {
    static HashMap<Integer, Integer> hashmap = new HashMap<>();

    private static void add(int k, int v) {
        hashmap.put(k, v);
    }

    private static void remove(int k) {
        hashmap.remove(k);
    }

    private static int find(int k) {
        // if (hashmap.containsKey(k)) {
        //     return hashmap.get(k);
        // }
        // else return 0;
        return hashmap.containsKey(k)? hashmap.get(k) : 0;
    }
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                int k = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                add(k, v);
            } else if (command.equals("remove")) {
                int k = Integer.parseInt(st.nextToken());
                remove(k);
            } else {
                int k = Integer.parseInt(st.nextToken());
                int value = find(k);
                if (value == 0) System.out.println("None");
                else System.out.println(value);
            }
        }


    }
}