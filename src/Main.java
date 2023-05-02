import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 투 포인터를 이용해..
        // 시작 인덱스, 종료 인덱스를 이용
        // 아~ 시작 인덱스 값 vs 종료 인덱스 값 비교해
        // sum < 종.값 -> 종.인 한 칸 이동
        // sum == 종.값 -> 찾았다! count++
        // sum > 종.값 -> 시.인 한 칸 이동.. 뭔지 알겠죠?
        
        int N = Integer.parseInt(br.readLine());
        int start, end, cnt, sum = 1;
        start = 1; // index 0 무시하고, index가 곧 값인 것으로 다룰게요
        end = 1;
        cnt = 1; // 자기 자신 하나로 이루어진 경우의 수 미리 저장
        while(end != N) {
        	if (sum < N) {
        		end++;
        		sum += end;
        	}
        	else if (sum == N) {
        		cnt++;
        		end++;
        		sum += end;
        	}
        	else {
        		// sum > N
        		sum -= start;
        		start++;
        	}
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}