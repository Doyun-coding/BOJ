import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        for(int i = N; i >= 1; i--) {
            arr[i] = 1;
            for(int j = 1; j <= N; j++) {
                if(arr[j] == 0) {
                    bw.write(" ");
                }
                else {
                    bw.write("*");
                }

                if(j == N) {
                    bw.write("\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
