package done;
import java.io.*;
import java.util.Stack;

public class BOJ1874 {
	static int checkArr[];
	static int myArr[];
	static int checkSecret;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	arr[i] = tmp;
        }
        
        int num = 1;
        boolean result = true;
        Stack<Integer> s = new Stack<>();
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < N; i++) {
        	int tmp = arr[i];
        	if (arr[i] >= num) {
        		while (arr[i] >= num) {
        			s.push(num++);
        			bf.append("+\n");
        		}
        		s.pop();
        		bf.append("-\n");
        	}
        	else {
        		int n = s.pop();
        		if (n > tmp) {
        			System.out.println("NO");
        			result = false;
        			break;
        		}
        		else {
        			bf.append("-\n");
        		}
        	}
        }
        if (result) System.out.println(bf.toString());
        
        br.close();
    }
}