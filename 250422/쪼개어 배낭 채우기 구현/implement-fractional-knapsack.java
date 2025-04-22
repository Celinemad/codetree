import java.io.*;
import java.util.*;
import java.lang.*;

class Jewerl implements Comparable<Jewerl> {
    int weight;
    int price;
    double value;

    public Jewerl(int weight, int price) {
        this.weight = weight;
        this.price = price;
        this.value = (double) price / weight;
    }

    @Override
    public int compareTo(Jewerl o) {
        if (this.value - o.value < 0) return 1;
        else return -1;
    }

    @Override
    public String toString() {
        return "value: " + value;
    }
}

public class Main {
    static int N, M;
    static List<Jewerl> jewerls = new ArrayList<>(); 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int weight, price;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weight = Integer.parseInt(st.nextToken());
            price = Integer.parseInt(st.nextToken());
            jewerls.add(new Jewerl(weight, price));
        }
        
        Collections.sort(jewerls);

        double totalValue = 0;
        for (Jewerl jewerl : jewerls) {
            if (jewerl.weight < K) {
                totalValue += (double) jewerl.price;
                K -= jewerl.weight;
            } else {
                totalValue += jewerl.value * K;
                break;
            }
        }

        System.out.println(totalValue);
        
    }
}