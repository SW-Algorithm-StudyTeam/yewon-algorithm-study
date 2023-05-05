import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
        	// 우선순위 어떻게 커스터마이징 해볼게요 with 람다식
        	// Comparator
        	// compare return이..
        	// - 양수 -> 첫 번째 매개변수가 더 큰 값으로 판단
        	// - 0 -> 같은 값으로 판단
        	// - 음수 -> 첫 번째 매개변수가 더 작은 값으로 판단
        	
        	int first_abs = Math.abs(o1);
        	int second_abs = Math.abs(o2);
        	if (first_abs == second_abs) { // 절대값이 같은 경우, 음수 우선
        		return o1 > o2 ? 1 : -1;
        	}
        	return first_abs - second_abs; // 절대값이 작은 데이터 우선..
        	// heap 생각해요
        });
        for (int i = 0; i < N; i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	if (tmp == 0) {
        		if (myQueue.isEmpty()) {
        			System.out.println("0");
        		}
        		else {
        			System.out.println(myQueue.poll());
        		}
        	}
        	else {
        		myQueue.add(tmp);
        	}
        }
        br.close();
    }
}