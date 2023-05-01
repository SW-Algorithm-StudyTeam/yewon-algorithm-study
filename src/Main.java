import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        double sum = 0;
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            sum += arr[i] / arr[N - 1] * 100;
        }

        bw.write(String.valueOf(sum / N));
        bw.flush();
    }
}