import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Main {

    private static TreeMap<Integer, Integer> tm = new TreeMap<>();

    private static StringBuilder sb = new StringBuilder();

    private static void add(int k, int v) {
        tm.put(k, v);
    }

    private static void remove(int k) {
        tm.remove(k);
    }

    private static void find(int k) {
        if (tm.containsKey(k)) {
            sb.append(tm.get(k));
        } else {
            sb.append("None");
        }
        sb.append("\n");
    }

    private static void printList() {
        Iterator<Entry<Integer, Integer>> it = tm.entrySet().iterator();
        if (!it.hasNext()) {
            sb.append("None").append("\n");
            return;
        }
        while (it.hasNext()) {
            Entry<Integer, Integer> entry = it.next();
            sb.append(entry.getValue() + " ");
        }
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // tm.put(6,2);
        // tm.put(5,2);
        // tm.put(2,1);

        // Iterator<Entry<Integer, Integer>> it = tm.entrySet().iterator();

        // while(it.hasNext()) {
        //     Entry<Integer, Integer> entry = it.next();
        //     System.out.println(entry.getKey() + " " + entry.getValue());
        // }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("add")) {
                int k = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                add(k, v);
            } else if (order.equals("remove")) {
                int k = Integer.parseInt(st.nextToken());
                remove(k);
            } else if (order.equals("find")) {
                int k = Integer.parseInt(st.nextToken());
                find(k);
            } else {
                printList();
            }
        }
        System.out.println(sb);
    }
}