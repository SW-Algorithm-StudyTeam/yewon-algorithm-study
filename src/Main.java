import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        * 미로 찾기
        *
        * '1'로 표현된 칸으로 이어진 길..
        * (1, 1)에서 (N, M)까지 가는 최단거리 얼마일까?
        *
        * DFS, BFS 모두 사용 가능해요
        * 근데? 최단거리 문제에서는 BFS가 유리합니다
        * BFS는, 해당 깊이에서 갈 수 있는 노드 탐색을 마친 후 다음 깊이로 넘어가기 때문에..
        * BFS로 목적지에 도달하는 경로 찾았다? 찾는 순간 그 경로가 바로 최단경로 인거예요
        * */

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken(); // 한 줄 통째로 받아와서
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1)); // 하나씩 끊어서 숫자 넣을게요
            }
        }
        BFS(0, 0);
        System.out.println(A[N-1][M-1]);

        br.close();
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            // 더이상 BFS를 할 수 없게 될 때까지
            int now[] = queue.poll();
            for (int k = 0; k < 4; k++) {
                // 상하좌우 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (A[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // *핵심*
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}