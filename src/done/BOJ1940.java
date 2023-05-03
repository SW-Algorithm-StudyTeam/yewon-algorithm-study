package done;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // 이 문제를 보고 어떻게 투 포인터를 떠올리지? 이걸 어떻게 생각하지?
        // 많이 풀다보면..
        // 흠! 이 데이터들이 유니크하고? 한 번 쓰면 없어지는 데이터네?
        // 얘네를 두 개를 어떻게 뽑아서 값이 나오게 하지?
        // 어떻게 빨리 찾지?.. 같은 생각을 하다보면 언젠가는 자연스럽게 떠오를 거예요
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        long arr[] = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 투 포인터 문제는 거의..
        // 정렬을 해야하거나! 정렬이 된 채로 주어지거나!
        
        int i, j, cnt = 0;
        i = 0;
        j = N - 1;
        while (i < j) {
        	// ..아.
        	// 두 개의 재료만 사용하는 구나
        	if (arr[i] + arr[j] < M) i++;
        	else if (arr[i] + arr[j] > M) j--;
        	else {
        		cnt++;
        		i++;
        		j--;
        	}
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}