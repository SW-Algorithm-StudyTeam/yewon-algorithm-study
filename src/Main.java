import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        
        // 구간합, 합 배열
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long arr[] = new long[N + 1]; // int 대신 long 형으로 선언하는 습관!
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        int a, b;
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	a = Integer.parseInt(st.nextToken());
        	b = Integer.parseInt(st.nextToken());
        	bw.write(String.valueOf(arr[b] - arr[a-1]));
        	bw.write(String.valueOf("\n"));
        }
        bw.flush();
    }
}