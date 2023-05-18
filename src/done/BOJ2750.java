package done;
import java.io.*;

public class BOJ2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 수 정렬하기
        // Array.sort() 말고, 버블정렬을 직접 사용해 봅시다..
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 0; i < N - 1; i++) {
        	for (int j = 0; j < N - 1 - i; j++) {
        		if (arr[j] > arr[j+1]) {
        			int tmp = arr[j];
        			arr[j] = arr[j+1];
        			arr[j+1] = tmp;
        		}
        	}
        }
        
        for (int i = 0; i < N; i++) {
        	bw.write(String.valueOf(arr[i]));
        	bw.write(String.valueOf("\n"));
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}