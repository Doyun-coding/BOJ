import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static StringBuilder sb;
    static int K;
    static int[] arr;
    static boolean[] visited;

    static void backTracking(int depth, int[] backArr, int pre) {
        if(depth > 6) {
            for(int i = 1; i <= 6; i++) {
                sb.append(backArr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = pre+1; i <= K; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backArr[depth] = arr[i];
                backTracking(depth+1, backArr, i);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if(K == 0) break;

            arr = new int[K+1];
            for(int i = 1; i <= K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] backArr = new int[7];
            visited = new boolean[K+1];

            backTracking(1, backArr, 0);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

}
