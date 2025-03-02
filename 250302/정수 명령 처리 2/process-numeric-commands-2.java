import java.util.*;
import java.io.*;

public class Main {
    static Queue<Integer> queue;
    static void push(int num) {
        queue.add(num);
    }
    static int pop() {
        return queue.poll();
    }
    static int size() {
        return queue.size();
    }
    static int empty() {
        if (queue.isEmpty()) return 1;
        return 0;
    }
    static int front() {
        return queue.peek();
    }
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                push(num);
            } else if (command.equals("pop")) {
                System.out.println(pop());
            } else if (command.equals("size")) {
                System.out.println(size());
            } else if (command.equals("empty")) {
                System.out.println(empty());
            } else {
                System.out.println(front());
            }
        }
    }
}