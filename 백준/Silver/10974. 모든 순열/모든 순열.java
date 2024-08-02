import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static boolean[] visited;

    static void backTracking(int[] arr, int depth) throws IOException {
        if(depth > N) {
            for(int i = 1; i <= N; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                backTracking(arr, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        visited = new boolean[N+1];
        backTracking(arr, 1);

        bw.flush();
        bw.close();
    }
}
