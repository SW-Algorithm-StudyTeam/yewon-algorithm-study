import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean visited[];
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        DFS가 몇 번 돌아야 모든 노드를 탐색하게 되는지 구하는 문제

        입력 데이터들로, 인접리스트를 사용해서 DFS를 재현해보는 게 중요하겠네요

        (중요) 문제에 방향이 주어지지 않음 -> 양방향 이구나..
        3에서 4로 갈 수 있다면
        4에서도 3으로 갈 수 있는 것

        (중요) 방문 배열이 모두 T가 됐다? -> 현재 주어진 그래프의 모든 노드들을 탐색했다
        */

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1]; // 방문 배열
        arr = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e); // 양방향 이니까, 둘 다 add
            arr[e].add(s);
        }

        int cnt = 0;
        for (int i = 1; i < n+1; i++) {
            if (!visited[i]) {
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);

        br.close();
    }

    private static void DFS(int v) {
        if (visited[v]) {
            // 현재 노드가 방문 노드 이면~
            return; // 더이상 탐색하지 않음
        }
        visited[v] = true; // 방문 했어요
        for (int i : arr[v]) {
            if (!visited[i]) {
                // 아직 탐색하지 않은 노드가 있다면
                DFS(i);
            }
        }
    }
}