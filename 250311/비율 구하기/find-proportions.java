import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double N = Double.parseDouble(br.readLine());

        TreeMap<String, Integer> tm = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String color = br.readLine();
            if (tm.containsKey(color)) {
                tm.put(color, tm.get(color) + 1);
            } else {
                tm.put(color, 1);
            }
        }

        Iterator<Entry<String, Integer>> it = tm.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            String portion = String.format("%.4f", entry.getValue()/N*100);
            sb.append(entry.getKey()).append(" ").append(portion).append("\n");
        }

        System.out.println(sb);
    }
}