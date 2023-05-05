import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>(N);
        for (int i = N; i > 0; i--) {
        	q.add(i); // 4, 3, 2, 1 ..
        }
        
        while (q.size() > 1) {
        	q.removeLast(); // 432
        	int tmp = q.peekLast(); // 2
        	q.addFirst(tmp); // 2432
        	q.removeLast(); // 243
        }
        System.out.println(q.peek());
        br.close();
    }
}