package done;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ12891 {
	static int checkArr[];
	static int myArr[];
	static int checkSecret;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // 슬라이딩 윈도우 알고리즘 -> 로직 간단해요! 응용이 중요.. 시간 복잡도도 좋거든요 O(n)
        // 범위를 지정 하고
        // 범위 유지한 채로 움직여요(투 포인터랑 다르죠)
        // 투 포인터랑 비슷한데? 자자 감 잡아보자구요
        // 양 끝 두 개의 데이터만 넣고 빼고 해주면 되는데..
        
        // 부분문자열의 길이 4
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;
        
        checkArr = new int[4]; // 문제의 조건
        myArr = new int[4]; // 현재 상태 배열
        char arr[] = new char[N];
        checkSecret = 0; // 조건 체크하면서, 조건에 부합하면 ++! 얘가 4가 되면? 올바른 문자열 인거겠죠
        
        arr = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
        	checkArr[i] = Integer.parseInt(st.nextToken());
        	if (checkArr[i] == 0) {
        		// 네 개를 만족해야 하는데, 이게 0이라는 건? 이미 만족을 했다는 뜻
        		checkSecret++;
        	}
        }
        
        for (int i = 0; i < M; i++) { // 문자열 처음 받을 때 세팅
        	Add(arr[i]);
        }
        
        if (checkSecret == 4) result++; // 첫 문자열 부터 만족할 수도 있으니까
        
        // 슬라이딩 윈도우
        for (int i = M; i < N; i++) {
        	int j = i - M; // i: 맨 오른쪽, j: 맨 왼쪽
        	Add(arr[i]); // 들어갈 때는, i만 들어가면 되죠?
        	Remove(arr[j]);
        	if (checkSecret == 4) result++; // 첫 문자열 부터 만족할 수도 있으니까
        }
        bw.write(String.valueOf(result));
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void Add(char c) {
    	switch (c) {
    	case 'A':
    		myArr[0]++;
    		if (myArr[0] == checkArr[0]) checkSecret++;
    		break;
    	case 'C':
    		myArr[1]++;
    		if (myArr[1] == checkArr[1]) checkSecret++;
    		break;
    	case 'G':
    		myArr[2]++;
    		if (myArr[2] == checkArr[2]) checkSecret++;
    		break;
    	case 'T':
    		myArr[3]++;
    		if (myArr[3] == checkArr[3]) checkSecret++;
    		break;
    	}
    }
    
    static void Remove(char c) {
    	switch (c) {
    	case 'A':
    		if (myArr[0] == checkArr[0]) checkSecret--; // 먼저 확인을 하고
    		myArr[0]--; // 빼줌
    		break;
    	case 'C':
    		if (myArr[1] == checkArr[1]) checkSecret--;
    		myArr[1]--;
    		break;
    	case 'G':
    		if (myArr[2] == checkArr[2]) checkSecret--;
    		myArr[2]--;
    		break;
    	case 'T':
    		if (myArr[3] == checkArr[3]) checkSecret--;
    		myArr[3]--;
    		break;
    	}
    }
}