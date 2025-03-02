import java.util.*;
import java.io.*;

public class Main {
    private static Stack<Integer> stack;
    static void push(int num) {
        stack.push(num);
    }
    static int pop() {
        return stack.pop();
    }
    static int size() {
        return stack.size();
    }
    static int empty() {
        if (stack.isEmpty()) return 1;
        return 0;
    }
    static int top() {
        return stack.peek();
    }

    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();

        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        stack = new Stack<>();

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
                System.out.println(top());
            }
        }
    }
}