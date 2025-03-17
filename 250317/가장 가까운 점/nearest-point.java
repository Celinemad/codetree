import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.io.InputStreamReader;
import java.lang.Math;

class Pair implements Comparable<Pair> {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        int dist = (this.x + this.y) - (p.x + p.y);
        if (dist != 0) 
            return dist;
        else if (this.x != p.x) {
            return this.x - p.x;
        } else {
            return this.y - p.y;
        }
    }

    public Pair plus() {
        this.x += 2;
        this.y += 2;
        return this;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int x, y;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            pq.add(new Pair(x, y));
        }

        for (int i = 0; i < M; i++) {
            Pair changedPair = pq.poll().plus();
            pq.add(changedPair);
        }

        System.out.println(pq.poll());
    }
}