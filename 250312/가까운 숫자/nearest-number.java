import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> line = new TreeSet<>();
        TreeSet<Integer> space = new TreeSet<>();
        line.add(0);

        int minSpace = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            line.add(num);
            
            if (line.higher(num) != null) {
                minSpace = Math.min(minSpace, line.higher(num) - num);
            } 
            if (line.lower(num) != null) {
                minSpace = Math.min(minSpace, num - line.lower(num));
            }
            if (minSpace != Integer.MAX_VALUE) {
                space.add(minSpace);
            }

            System.out.println(space.first());
        }

    }
}