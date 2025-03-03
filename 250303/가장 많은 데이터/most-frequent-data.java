import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxCnt= 0, cnt = 0;
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String color = br.readLine();

            if (hashmap.containsKey(color)) {
                cnt = hashmap.get(color) + 1;
            } else {
                cnt = 1;
            }

            hashmap.put(color, cnt);
            maxCnt = Math.max(cnt, maxCnt);
        }
        System.out.println(maxCnt);
    }
}